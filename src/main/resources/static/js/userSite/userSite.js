let currentSite = 0;

function orderContent(orderList) {
    let content = document.getElementById('orderTable');
    let dataHtml = '';
    if (orderList.length > 0) {
        dataHtml+=`<table><thead><tr><th>Numer zamówienia</th><th>Data złożenia zamówienia</th>` +
            `<th> Wartość zamówienia</th></tr></thead><tbody>`;
        for (let order of orderList) {
            dataHtml+=`<tr><td><a href="/orders/details?id=${order.id}">${order.id}</a></td><td>${order.createdAt}</td><td>${order.total}</td></tr>`;
        }
        dataHtml+=`</tbody></table>`;
    } else {
        dataHtml+="<p style=\"font-size:32px; margin: auto; max-width: 1000px;\">Brak zamówień.</p>";
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
        orderContent(data);
    },
    error: function (xhr, status, error) {
        alert("coś się zjebało, kod błędu: " + status);
    }
});
