let orderList = [
    { id: 1, date: "22-04-2020", total: 420.50 }
];

window.onload = () => {
    orderContent(orderList);
}

function orderContent(orderList) {
    let content = document.getElementById('orderTable');
    let dataHtml = '';
    if (orderList.length > 0) {
        alert("Kurła cuś zamówiłeś kierowniku");
        dataHtml+=`<table><tr><td>ID zamówienia</td><td>Data złożenia zamówienia</td>` +
            `<td>Wartość zamówienia</td></tr>`;
        for (let order of orderList) {
            dataHtml+=`<tr><td>${order.id}</td><td>${order.date}</td><td>${order.total}</td></tr>`;
        }
        dataHtml+=`</table>`;
    } else {
        alert("Kurła kierowniku pusta lista zamówień");
        dataHtml+="<p style=\"font-size:32px;\">Brak zamówień.</p>";
    }
    console.log(dataHtml);
    content.innerHTML = dataHtml;
}
