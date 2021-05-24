
function submitChangePassword() {
    $.ajax({
        url: "/account/changepassword",
        method: "POST",
        timeout: "3000",
        contentType: "application/json",
        data: {
            currentPassword: $("#oldPassword").val(),
            newPassword: $("#newPassword1").val(),
            newPasswordRepeat: $("#newPassword2").val()
        },
        dataType: "json",
        success: function (data, status, xhr) {
            if (data.status != "OK") {
                alert(data.status);
            }
            else alert("Poprawnie zmieniono hasło");
        },
        error: function (xhr, status, error) {
            alert(status);
        }
    });
}