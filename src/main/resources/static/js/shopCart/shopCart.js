let currentSite = 0;
function cartChange(id, quantity) {
    $.ajax({
        url: "/cart/change",
        method: "POST",
        timeout: "3000",
        dataType: "json",
        data: {
            id : id,
            quantity : quantity
        },
        success: function (data, status, xhr) {
            console.log(data);
            updateCart();
        },
        error: function (xhr, status, error) {
            updateCart();
            alert("Kod błędu: " + status);
        }
    });
}

function cartContent(cartList) {
    let content = document.getElementById('cartTable');
    let dataHtml = '';
    let totalSum = 0;
    if (cartList.length > 0) {
        dataHtml+=`<table><thead><tr><th>Produkt</th><th>Cena</th>` +
            `<th>Ilość</th><th>Suma</th></tr></thead><tbody>`;
        //TODO usuwanie
        for (let product of cartList) {
            let selectHtml = `<select onchange="cartChange(${product.id}, this.value)">`;
            for (let i =1; i<=9; i++) {
                selectHtml+= `<option${product.quantity === i ? ' selected' : ''}>`+ i +'</option>';
            }
            selectHtml+='</select>';
            let totalHtml = product.quantity * product.price;
            totalSum+=totalHtml;
            dataHtml+=`<tr><td><a href="/produckSite?id=${product.id}">${product.name}</a></td><td>${product.price}</td>
                    <td>${selectHtml}</td><td>${totalHtml}</td></tr>`;
        }
        dataHtml+=` <tr><th>Całkowita kwota</th><td></td><td></td>
                     <th>${totalSum}</th></tr></tbody></table>`;
    } else {
        dataHtml+="<p style=\"font-size:32px; margin: auto; max-width: 1000px;\">Brak produktów w koszyku.</p>";
    }
    console.log(dataHtml);
    content.innerHTML = dataHtml;
}

function updateCart() {
    $.ajax({
        url: "/cart/get",
        method: "GET",
        timeout: "3000",
        contentType: "application/json",
        dataType: "json",
        success: function (data, status, xhr) {
            console.log(data);
            cartContent([]);
        },
        error: function (xhr, status, error) {
            alert("Kod błędu: " + status);
        }
    });
}

updateCart();