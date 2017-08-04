
$(function () {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});
//не працює

$('#AllProd').click(function () {
    $("#convert").empty();
    $.ajax({
        url: '/findAllProd',
        type: 'get',
        contentType: 'application/json',
        success: function (result) {
            $(result).each(function () {
                $("#convert").append($('<p/>', {text: `${this.prodname} ${this.proddescription}`}));
            });

        },
        error: function () {
            console.log("error");
        }

    })


});

$("#save").click(function () {
    var username = $("#name").val();
    var password = $("#pass").val();
    var email = $("#mail").val();
    var phonenumber = $("#numb").val();
    var obj = {username: username, password: password, email: email, phonenumber: phonenumber};
    var jsonObj = JSON.stringify(obj);

    $.ajax({
        url: '/saveUserRest',
        type: "post",
        contentType: "application/json",
        data: jsonObj,
        success: function () {
            alert("User save")
        },
        error: function () {
            alert("User dont save ");
        }
    });

    });

$("#show").click(function(){
    $(".qw").style()
});