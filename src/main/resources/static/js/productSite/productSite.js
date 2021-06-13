function addToCart(id) {
    $.ajax({
        url: "/cart/add",
        method: "POST",
        timeout: "3000",
        data: {
            id : id,
            quantity : 1
        },
        success: function (data, status, xhr) {
            alert("sukces");
        },
        error: function (xhr, status, error) {
            alert(status + " " + error);
        }
    });
}

