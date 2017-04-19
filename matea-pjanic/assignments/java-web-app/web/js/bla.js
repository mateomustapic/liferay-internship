/**
 * Created by Matea Pjanic on 28/02/2017.
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


});
