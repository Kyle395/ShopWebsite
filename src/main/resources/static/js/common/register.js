//modals
function turnRegisterOn()
{
    var loginModal = document.getElementById('registerModal');
    loginModal.classList.add('is-active')
}

function turnRegisterOff()
{
    var loginModal = document.getElementById('registerModal');
    loginModal.classList.remove('is-active')
}

function submitRegister() {
    $.ajax({
        url: "/account/register",
        type: "POST",
        timeout: "3000",
        data: {
            login: document.getElementById("usernameReg").value,
            newPassword: document.getElementById("passwordReg1").value,
            newPasswordRepeat: document.getElementById("passwordReg2").value,
            email: document.getElementById("mail").value
        },
        dataType: "json",
        success: function (data, status, xhr) {
            if (data.status != "OK") {
                alert(data.status);
            }
            else window.location.reload(true);


        },
        error: function (xhr, status, error) {
            alert(status);
        }
    });
}