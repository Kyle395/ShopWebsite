//modals
function turnLoginOn()
{
    var loginModal = document.getElementById('loginModal');
    loginModal.classList.add('is-active')
}

function turnLoginOff()
{
    var loginModal = document.getElementById('loginModal');
    loginModal.classList.remove('is-active')
}

function submitLogin() {
    $.ajax({
        url: "/account/login",
        type: "POST",
        timeout: "3000",
        data: {
            login: document.getElementById("username").value,
            password: document.getElementById("password").value
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
function submitLogout()
{
    $.ajax({
        url: "/account/logout",
        method: "GET",
        timeout: "3000",
        contentType: "application/json",
        dataType: "json",
        success: function (data, status, xhr) {
            if (data.status != "OK") {
                alert(data.status);
            }
            else window.location.reload(true);
        },
        error: function (xhr, status, error) {
            alert("Kod błędu: " + status);
        }
    });
}