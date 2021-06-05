package pl.poznan.put.shopwebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.poznan.put.shopwebsite.entities.Customer;
import pl.poznan.put.shopwebsite.repositories.CustomerRepository;

import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public Optional<Customer> authenticate(String login, String password) {
        Optional<Customer> targetCustomer = customerRepository.findById(login);

        if (targetCustomer.isEmpty()) {
            return Optional.empty();
        }

        String hashedPassword = hash(password);

        Customer customer = targetCustomer.get();
        if (!customer.getPassword().equals(hashedPassword)) {
            return Optional.empty();
        }

        return targetCustomer;
    }

    @Transactional
    public ChangePasswordResult changePassword(Customer customer, String currentPassword,
                                               String newPassword, String newPasswordRepeat) {
        if (!newPassword.equals(newPasswordRepeat)) {
            return ChangePasswordResult.PASSWORD_NOT_EQUAL;
        }

        String hashedPassword = hash(currentPassword);

        if (!customer.getPassword().equals(hashedPassword)) {
            return ChangePasswordResult.INVALID_DATA;
        }

        customer.setPassword(hashedPassword);
        customerRepository.saveAndFlush(customer);

        return ChangePasswordResult.OK;
    }

    @Transactional
    public RegisterResult register(String login,
                                   String newPassword, String newPasswordRepeat,
                                   String email) {
        if (!newPassword.equals(newPasswordRepeat)) {
            return RegisterResult.PASSWORD_NOT_EQUAL;
        }

        Optional<Customer> targetCustomer = customerRepository.findById(login);
        if (targetCustomer.isPresent()) {
            return RegisterResult.ALREADY_EXISTS;
        }

        Customer customer = new Customer();
        customer.setLogin(login);
        customer.setEmail(email);

        String hashedPassword = hash(newPassword);
        customer.setPassword(hashedPassword);

        customerRepository.saveAndFlush(customer);

        return RegisterResult.OK;
    }

    @Transactional
    public ChangeEmailResult changeEmail(Customer customer, String currentEmail,
                                            String newEmail, String newEmailRepeat) {
        if (!newEmail.equals(newEmailRepeat)) {
            return ChangeEmailResult.EMAIL_NOT_EQUAL;
        }

        if (!customer.getEmail().equals(currentEmail)) {
            return ChangeEmailResult.INVALID_DATA;
        }

        customer.setEmail(newEmail);
        customerRepository.saveAndFlush(customer);

        return ChangeEmailResult.OK;
    }

    private static String hash(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashed = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hashed);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public enum ChangePasswordResult {
        OK, INVALID_DATA, PASSWORD_NOT_EQUAL
    }

    public enum RegisterResult {
        OK, ALREADY_EXISTS, PASSWORD_NOT_EQUAL
    }

    public enum ChangeEmailResult {
        OK, INVALID_DATA, EMAIL_NOT_EQUAL
    }

}
