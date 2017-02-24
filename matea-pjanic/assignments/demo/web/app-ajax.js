/**
 * Created by Matea Pjanic on 21/02/2017.
 */
$(document).ready(function() {

    $("#searchMusicForm").submit(function (e) {
        e.preventDefault();
    });

    $("#btn2").click(function() {
        var bend = $('#bend').val();
        $.ajax({
            url: '/InfoPath',
            data: {yourBend: bend},
            dataType: 'json',
            type: 'post',
            success: function(responseJson) {
                var count = Object.keys(responseJson).length;
                console.log(responseJson);
                console.log(count);
                var result = $('#result');
                if(count>1) {
                    result.append('<br>Bend: ' + responseJson.bendName + '<br>');
                    for (var i = 0; i < responseJson.albums.length; i++) {
                        result.append('Album: ' + responseJson.albums[i].albumName + '<br>');
                        for (var j = 0; j < responseJson.albums[i].songs.length; j++) {
                            result.append('Song: ' + responseJson.albums[i].songs[j].songName + '<br>');
                        }
                    }
                }
                else {
                    result.append('<br>' + responseJson.no);
                }
            }
        });
    });
});
