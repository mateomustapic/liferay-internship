/**
 * Created by Matea Pjanic on 21/02/2017.
 */
$(document).ready(function() {

    $("#requestForm").submit(function (e) {
        e.preventDefault();
    });


    $("#btn").click(function() {
        var bend = $('#bend').val();
        $.ajax({
            url: '/Infopath',
            data: {a: bend},
            // dataType: 'json',
            type: 'post',
            success: function(responseText) {
                $('#response').append('<p>You wrote: ' + bend + '</p>');
                $('#response').append('<p>but all I have (for now) is:<br> ' + responseText + '</p>');
            }
        });
    });
});
