let orderList = [];

orderList.push({ id:1, date:"22-04-21", total:420.50 }, { id:2, date:"21-04-21", total:50 });

window.onload = () => {
    orderContent(orderList);
}

function orderContent(orderList) {
    let content = document.getElementById('orderTable');
    let dataHtml = '';
    if (orderList.length > 0) {
        dataHtml+=`<table><thead><tr><th>Numer zamówienia</th><th>Data złożenia zamówienia</th>` +
            `<th> Wartość zamówienia</th></tr></thead><tbody>`;
        for (let order of orderList) {
            dataHtml+=`<tr><td>${order.id}</td><td>${order.date}</td><td>${order.total}</td></tr>`;
        }
        dataHtml+=`</tbody></table>`;
    } else {
        dataHtml+="<p style=\"font-size:32px; margin: auto; max-width: 1000px;\">Brak zamówień.</p>";
    }
    console.log(dataHtml);
    content.innerHTML = dataHtml;
}
