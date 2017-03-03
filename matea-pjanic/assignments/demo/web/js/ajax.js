/**
 * Created by Matea Pjanic on 27/02/2017.
 */
$(document).ready(function() {

    $("#searchMusicForm").submit(function (e) {
        e.preventDefault();
    });

    var options = {
        url: './../json/bends.json',
        getValue: "bendName",
        list: {
            showAnimation: {
                type: "fade", //normal|slide|fade
                time: 400,
                callback: function() {}
            },

            hideAnimation: {
                type: "slide", //normal|slide|fade
                time: 400,
                callback: function() {}
            },
            match: {
                enabled: true
            }
        },
        theme: 'dark'
    };

    $("#search").easyAutocomplete(options);

    $("#searchBtn").click(function() {
        var search = $('#search').val();
        $('#content').hide();
        $('#joinContent').hide();
        $('#loginContent').hide();
        var result = $('.resultContainer');
        if (result) {
            result.text('');
        }
        $.ajax({
            url: '/SearchPath',
            data: {yourInput: search},
            dataType: 'json',
            type: 'post',
            success: function(responseJson) {
                var count = Object.keys(responseJson).length;
                console.log(responseJson);
                console.log(count);
                if(count>1) {
                    result.append('<br>' + responseJson.bendName + '<br>');
                    result.append('<br>' + responseJson.image + '<br><br>');
                    for (var i = 0; i < responseJson.albums.length; i++) {
                        result.append('Album: ' + responseJson.albums[i].albumName + '<br>');
                        result.append('Year: ' + responseJson.albums[i].year + '<br>');
                        for (var j = 0; j < responseJson.albums[i].songs.length; j++) {
                            result.append('Song: ' + responseJson.albums[i].songs[j].songName + '<br>');
                            result.append('Song length: ' + responseJson.albums[i].songs[j].songDuration + '<br>');
                        }
                        result.append('<br>');
                    }
                }
                else {
                    result.append('<br>' + responseJson.no);
                }
            }
        });
        $('#search').val('');
    });
});

