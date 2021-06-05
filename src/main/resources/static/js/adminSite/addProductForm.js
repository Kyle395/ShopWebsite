
function displayUploaded() {
    const fileInput = document.querySelector('#file-js-example input[type=file]');
    fileInput.onchange = () =>
    {
        if (fileInput.files.length > 0) {
            const fileName = document.querySelector('#file-js-example .file-name');
            fileName.textContent = fileInput.files[0].name;
        }
    }
}
function addProoduct() {
    var data = new FormData();
    jQuery.each(jQuery('#file')[0].files, function(i, file) {
        data.append('picture '+i, file);
    });
    alert(form_data);
    $.ajax({
        url: "/products/add",
        type: "POST",
        timeout: "3000",
        data: {
            name: document.getElementById("name").value,
            description: document.getElementById("describtion").value,
            subcategory: $('Categories').val,
            picture: data.picture
        },
        dataType: "json",
        cache: false,
        contentType: false,
        processData: false,
        success: function (data, status, xhr) {
            if (data.status != "OK") {
                alert(data.status);
            }
            else window.location.reload(true);


        },
        error: function (xhr, status, error) {
            alert(status);
        }
    });
}

