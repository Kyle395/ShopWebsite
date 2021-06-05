let currentSite = 0;

function cartContent(cartList) {
    let content = document.getElementById('cartTable');
    let dataHtml = '';
    if (cartList.length > 0) {
        dataHtml+=`<table><thead><tr><th>Produkt</th><th>Ilość</th>` +
            `<th>Cena</th><th>Suma</th></tr></thead><tbody>`;
        for (let product of cartList) {
            dataHtml+=`<tr><td><a href="/userSite/orderDetails?id=${product.id}">${product.getName()}</a></td><td>${product.getPrice()}</td>
                        <td>${product.getQuantity()}</td><td>${product.getTotal()}</td></tr>`;
        }
        dataHtml+=` <tr><th>Całkowita kwota</th><td></td><td></td>
                    <th th:text="${orderDetails.getTotal()}"></th></tr></tbody></table>`;
        dataHtml+=` <button class="button is-primary" style="background-color: #45a321" onclick="submitFinalize()">Złóż zamówienie</button>`;
    } else {
        dataHtml+="<p style=\"font-size:32px; margin: auto; max-width: 1000px;\">Brak produktów w koszyku.</p>";
    }
    console.log(dataHtml);
    content.innerHTML = dataHtml;
}

$.ajax({
    url: "/orders",
    method: "GET",
    timeout: "3000",
    contentType: "application/json",
    data: {
        pageNum: currentSite
    },
    dataType: "json",
    success: function (data, status, xhr) {
        console.log(data);
        cartContent([]);
    },
    error: function (xhr, status, error) {
        alert("Kod błędu: " + status);
    }
});