

var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var data = {
            originalUrl: $('#originalUrl').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/url',
            dataType: 'json',
            contentType:'application/json; charset=UTF-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('shortUrl 생성하였습니다');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();