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
            turnAddOn()
        },
        error: function (xhr, status, error) {
            alert(status + " " + error);
        }
    });
}

function turnAddOn()
{
    var addModal = document.getElementById('modalAdd');
    addModal.classList.add('is-active')
}

function turnAddOff()
{
    var addModal = document.getElementById('modalAdd');
    addModal.classList.remove('is-active')
}
