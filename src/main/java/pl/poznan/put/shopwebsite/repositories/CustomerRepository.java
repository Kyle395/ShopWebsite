package pl.poznan.put.shopwebsite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.poznan.put.shopwebsite.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
