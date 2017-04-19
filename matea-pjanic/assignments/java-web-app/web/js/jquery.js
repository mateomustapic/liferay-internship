/**
 * Created by Matea Pjanic on 27/02/2017.
 */
$(document).ready(function() {


    $('#moreAdvL').click(function() {
        $('.moreAdvP').toggleClass('readMore');
        if ($(this).text() == 'read less')
        {
            $(this).text('read more');
        }
        else
        {
            $(this).text('read less');
        }
    });

    $('#moreCornL').click(function() {
        $('.moreCornP').toggleClass('readMore');
        if ($(this).text() == 'read less')
        {
            $(this).text('read more');
        }
        else
        {
            $(this).text('read less');
        }
    });

    $('#moreJohnL').click(function() {
        $('.moreJohnP').toggleClass('readMore');
        if ($(this).text() == 'read less')
        {
            $(this).text('read more');
        }
        else
        {
            $(this).text('read less');
        }
    });

    $("#searchMusicForm").submit(function (e) {
        e.preventDefault();
    });

    var options = {
        url: './../json/bends.json',
        getValue: "bendName",
        list: {
            showAnimation: {
                type: "fade",
                time: 400,
                callback: function() {}
            },

            hideAnimation: {
                type: "slide",
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
        $('#profileContent').hide();
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
                    result.append(`<br><h3>${responseJson.bendName}</h3><br><img src="${responseJson.image}"/><br>`);

                    for (var i = 0; i < responseJson.albums.length; i++) {
                        result.append(`<table class="table table-hover" id="album-${i}"></table>`);
                        var table = $(`#album-${i}`);
                        table.append(`<tr><th><h4>Album:${responseJson.albums[i].albumName}(${responseJson.albums[i].year})</h4></th></tr>`);
                        for (var j = 0; j < responseJson.albums[i].songs.length; j++) {
                            table.append(
                                `<tr>
                                    <td>
                                        <div class="song">
                                            <button class="addBtn" title="Add to playlist"><i class="fa fa-heart"></i></button>
                                            <button class="playBtn" title="Play"><i class="fa fa-play"></i></button>
                                            &nbsp;&nbsp;<p>${responseJson.albums[i].songs[j].songName}<p/>
                                            <audio class="audioPlayHide" controls>
                                                <source src="' + responseJson.albums[i].songs[j].mp3 + '" type="audio/mp3">
                                            </audio>
                                        </div>
                                        <div class="hideMessage">
                                            <br>
                                            <p class="hideP">song is added to your profile</p>
                                            <div class="buttons">
                                                <button class="undoBtn" title="Undo"><i class="fa fa-undo"></i></button>
                                                <button class="profileBtn" onclick='location.href="/RegistrationPath"' type="button" title="Visit profile"><i class="fa fa-home"></i></button>
                                                <button class="closeBtn" title="Close"><i class="fa fa-close"></i></button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>`);
                        }
                    }
                }
                else {
                    result.append('<br>' + responseJson.no + '<br>');
                }

                $('.addBtn').click(function() {
                    ($(this).parent().next()).addClass('showMessage');
                });

                $('.undoBtn').click(function() {
                    ($(this).parent().parent()).removeClass('showMessage').addClass('hideMessage');
                });

                $('.closeBtn').click(function() {
                    ($(this).parent().parent()).removeClass('showMessage').addClass('hideMessage');
                });

                $('.playBtn').click(function () {
                    ($(this).next().next().next()).addClass('audioPlayShow');
                    $(this).hide();
                });
            }
        });
        $('#search').val('');
    });

    $('.addBtn').click(function() {
        ($(this).parent().next()).addClass('showMessage');
    });
    $('.undoBtn').click(function() {
        ($(this).parent().parent()).removeClass('showMessage').addClass('hideMessage');
    });
    $('.closeBtn').click(function() {
        ($(this).parent().parent()).removeClass('showMessage').addClass('hideMessage');
    });
    $('.playBtn').click(function () {
        ($(this).next().next()).addClass('audioPlayShow');
        $(this).hide();
    });
    $('.removeBtn').click(function() {
        ($(this).parent()).remove();
    });


});

