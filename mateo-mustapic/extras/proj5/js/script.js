$(document).ready(function(){
	 $('button').click(function(){
        $('#welcome').hide(1000);
    });
	
	$('#tabs').tabs();

	var availableTags = [
      'Arsenal',
      'Angers',
      'Atalanta',
      'Bologna',
      'Chelsea',
      'Charlton',
      'Everton',
      'Fulham',
      'Guingamp',
      'Hamburg',
      'Juventus',
      'Lyon',
      'Manchester Utd',
      'Newcastle Utd',
      'Real Madrid',
      'Real Betis',
      'Sevilla',
      'Southampton'
    ];

    $( '#tags' ).autocomplete({
      source: availableTags
    });


    var json = [
    {'Club':'Chelsea','Code':'che','League':'bpl','Tableposition':'1'},
    {'Club':'Tottenham','Code':'tot','League':'bpl','Tableposition':'2'},
    {'Club':'Arsenal','Code':'ars','League':'bpl','Tableposition':'3'},
    {'Club':'Liverpool','Code':'liv','League':'bpl','Tableposition':'4'}
    ];
        
    var buffer = [];

    for (var i = 0; i < json.length; i++) {
    	var row = [];

    	row.push('<tr>');
    	row.push('<td>' + json[i].Club + '</td>');
    	row.push('<td>' + json[i].Code + '</td>');
    	row.push('<td>' + json[i].League + '</td>');
    	row.push('<td>' + json[i].Tableposition + '</td>');
    	row.push('<tr/>');

    	buffer.push(row.join(''));
    }

    $('table tbody').html(buffer.join(''));    

})


	

