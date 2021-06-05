let currentSite = 0;

function cartContent(cartList) {
    let content = document.getElementById('cartTable');
    let dataHtml = '';
    if (cartList.length > 0) {
        dataHtml+=`<table><thead><tr><th>Produkt</th><th>Cena</th>` +
            `<th>Ilość</th><th>Suma</th></tr></thead><tbody>`;
        for (let product of cartList) {
            // TODO dodać link do produktu
            dataHtml+=`<tr><td><a href="/userSite/orderDetails?id=${product.id}">${product.name}</a></td><td>${product.price}</td>
                        <td>${product.quantity}</td><td>${product.total}</td></tr>`;
        }
        // dataHtml+=` <tr><th>Całkowita kwota</th><td></td><td></td>
        //             <th th:text="${orderDetails.getTotal()}"></th></tr></tbody></table>`;
    } else {
        dataHtml+="<p style=\"font-size:32px; margin: auto; max-width: 1000px;\">Brak produktów w koszyku.</p>";
    }
    console.log(dataHtml);
    content.innerHTML = dataHtml;
}

$.ajax({
    url: "/cart/get",
    method: "GET",
    timeout: "3000",
    contentType: "application/json",
    dataType: "json",
    success: function (data, status, xhr) {
        console.log(data);
        cartContent(data);
    },
    error: function (xhr, status, error) {
        alert("Kod błędu: " + status);
    }
});