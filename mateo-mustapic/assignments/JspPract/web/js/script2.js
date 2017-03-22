/**
 * Created by Mateo on 3/20/2017.
 */
$(document).ready(function () {
    /*Calling data from external JSON file (players.json)*/
    var xmlhttp = new XMLHttpRequest(),
        json;
    xmlhttp.onreadystatechange = function () {
        if(xmlhttp.readyState === 4 && xmlhttp.status === 200){
            console.log('Working');
            json = JSON.parse(xmlhttp.responseText);

            var buffer = [];
            for(var i=0; i<json.length; i++) {
                var test1 = json;
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
    };
    xmlhttp.open('GET', '../js/players.json', true);
    xmlhttp.send();
});
