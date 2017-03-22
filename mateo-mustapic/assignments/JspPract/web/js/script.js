/**
 * Created by Mateo on 3/20/2017.
 */
$(document).ready(function () {
    /* Call from Java ArrayList -*/
        $.ajax({
            type:'GET',
            url:'/players?action=list',
            headers: {
                Accept: "application/json; charset=utf-8",
                "Content-Type" : "application/json; charset=utf-8"
            },
            success: function (result) {
                var listPlayers = $.parseJSON(result);
                var buffer = [];
                for(var i=0; i<listPlayers.length; i++){
                    var test1 = listPlayers;
                    var row = [];
                    row.push('<tr>');
                    row.push('<td>' + test1[i].id + '</td>');
                    row.push('<td>' + test1[i].name + '</td>');
                    row.push('<td>' + test1[i].position + '</td>');
                    row.push('<tr/>');
                    buffer.push(row.join(''));
                }
                $('table tbody').html(buffer.join(''));
            }
        });
});