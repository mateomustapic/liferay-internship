$(document).ready(function(){
    /* New user to the list */
    function newUser(){
        $('#addButton').click(function(){
            var user = prompt("Enter your username : ");
            if (user != '') {
            $('#myUL').append('<li><a href="">' + user + '</a></li>');
                alert('user registered!');
            }
            else {
                alert('Please enter your username');
            }
        })
    }
    /* Search the list of users */
    function search(){
        var input, filter, li, ul, a, i;
        input = document.getElementById('input');
        filter = input.value.toUpperCase();
        ul = document.getElementById('myUL');
        li = document.getElementsByTagName('li');

        for(i = 0; i < li.length ; i++){
            a = li[i].getElementsByTagName('a')[0];
            if (a.innerHTML.toUpperCase().indexOf(filter) > -1){
                li[i].style.display = "";
            } else {
                li[i].style.display = 'none';
            }
        }
    }
    /* Sort the list of users */
    function sortUser(){
        $("#btnSortName").on("click", function () {
            $("#myUL").html(
                $("#myUL").children("li").sort(function (a, b) {
                    return $(a).text().toUpperCase().localeCompare($(b).text().toUpperCase());
                }) 
            ); 
        }); 
    };
    $(document).ready(newUser);
    $(document).ready(search);
    $(document).ready(sortUser);
})


