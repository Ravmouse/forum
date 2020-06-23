let fileName;

/**
 * Проверка на то, чтобы все поля на форме были заполнены.
 * @returns {boolean}
 */
function validate() {
    let rsl = true;
    let elements = document.querySelectorAll('input, textarea');
    for (let i = 0; i < elements.length; i++) {
        if (elements[i].value === "") {
            rsl = false;
            alert('Вы не заполнили поле: ' + $(elements[i]).attr('name'));
            break;
        }
    }
    return rsl;
}

$('#btn_Upload').on("click", function () {
    let file = $('input[type=file]');
    if (file.val() === "") {
        alert("Вы не выбрали изображение!");
    } else {
        fileName = file.val().split('\\').pop();
        let form = $('#upload_File')[0];
        let data = new FormData(form);
        $.ajax({
            url: "./create",
            method: "post",
            enctype: "multipart/form-data",
            data: data,
            cache: false,
            processData: false,
            contentType: false,
            success: function (data) {
                let div_cont = $('.left');
                div_cont.empty();
                div_cont.append('<img src="./images/' + fileName + '" style="height: 100%; object-fit: contain">');
                $('#hid').val(fileName);
            }
        });
    }
});

$('#btn_Add').on("click", function () {
    if (validate()) {
        $('#upload_Form').submit();
    }
});