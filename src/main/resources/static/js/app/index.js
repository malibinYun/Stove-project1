var main = {
    init: function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        })
    },

    convert: () => {
        var data = {
            rawUrl: $('#rawUrl').val(),
        }
        $.ajax({
            type: 'POST',
            url: '/api/url/short',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(() => {
            alert('글이 등록되었습니다.');
            window.location.href = "/";
        }).fail((error) => {
            alert(JSON.stringify(error));
        });
    },
};

main.init()