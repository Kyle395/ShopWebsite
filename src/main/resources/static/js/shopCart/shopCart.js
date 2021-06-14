let currentSite = 0;
function cartChange(id, quantity) {
    $.ajax({
        url: "/cart/change",
        method: "POST",
        timeout: "3000",
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

function cartRemove(id) {
    $.ajax({
        url: "/cart/remove",
        method: "POST",
        timeout: "3000",
        data: {
            id : id
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

function submitOrder() {
    $.ajax({
        url: "/orders/submit",
        method: "POST",
        timeout: "3000",
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

function cartContent(cartDto) {
    let content = document.getElementById('cartTable');
    let dataHtml = '';
    if (cartDto.cartList.length > 0) {
        dataHtml+=`<table><thead><tr><th>Produkt</th><th>Cena</th>` +
            `<th>Ilość</th><th>Suma</th><th></th></tr></thead><tbody>`;
        for (let product of cartDto.cartList) {
            let selectHtml = `<select onchange="cartChange(${product.id}, this.value)">`;
            for (let i =1; i<=9; i++) {
                selectHtml+= `<option${product.quantity === i ? ' selected' : ''}>`+ i +'</option>';
            }
            selectHtml+='</select>';
            dataHtml+=`<tr><td><a href="/productSite?id=${product.id}">${product.name}</a></td><td>${product.price}</td>
                    <td>${selectHtml}</td><td>${product.total}</td><td>
                    <div class="button" style="background-color: #45a321; color: white;" 
                    onclick="cartRemove(${product.id})">Usuń</div>
                    </td></tr>`;

        }
        dataHtml+=` <tr><th>Całkowita kwota</th><td></td><td></td>
                     <th>${cartDto.total}</th><td></td></tr>`;

        dataHtml+=` <tr></tr><tr style="background-color: white"><td class="invisible"></td><td class="invisible"></td><td class="invisible"></td>
                    <td class="invisible"><div class="button" style="background-color: #45a321; color: white;font-weight: bold; padding-left: 5px;" 
                    onclick="submitOrder()">Złóż zamówienie</div</td></tr></tbody></table>`;
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
            cartContent(data);
        },
        error: function (xhr, status, error) {
            alert("Kod błędu: " + status);
        }
    });
}

updateCart();