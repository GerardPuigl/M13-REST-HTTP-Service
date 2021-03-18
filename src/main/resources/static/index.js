
    $(document).ready(function () {
        $('#newEmployee').submit(function (evento) {
            $.ajax({
                url: '/EmpleatList',
                type: 'POST',
                data: JSON.stringify({
                    "name": $('#name').val(),
                    "job": $('#job').val()
                }),
                processData: false,
                contentType: "application/json"
            })
            evento.preventDefault();
        });
    });