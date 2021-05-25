
function submitChangePassword() {
    $.ajax({
        url: "/account/changeaddress",
        method: "POST",
        timeout: "3000",
        data: {
            newAddress: $("#newAddress1").val(),
            newAddressRepeat: $("#newAddress2").val()
        },
        dataType: "json",
        success: function (data, status, xhr) {
            if (data.status != "OK") {
                alert(data.status);
            }
            else alert("Poprawnie zmieniono adres email!");
        },
        error: function (xhr, status, error) {
            alert(status);
        }
    });
}