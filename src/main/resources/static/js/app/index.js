var main = {
    init: function () {
        var _this = this;
        $('#btn-convert').on('click', function () {
            _this.convert();
        })
    },

    convert: () => {
        var data = {
            rawUrl: $('#rawUrl').val(),
        }
        console.log(data);
        $.ajax({
            type: 'POST',
            url: '/api/url/short',
            // dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done((response) => {
            console.log(response);
            const template = "{{shorten}}"
            const rendered = Mustache.render(template, {shorten: response.toString()})
            document.getElementById('target').innerHTML = rendered
        }).fail((error) => {
            alert(JSON.stringify(error));
        });
    },
};

main.init()
