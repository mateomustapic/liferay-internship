$(function() {
	$("#myTable").Pagination({
		previousButtonClass: "btn btn-danger",
		nextButtonClass: "btn btn-danger"
	});
});

(function(){
        $('[data-toggle="tooltip"]').tooltip(); 
});

$(function(){
    $("#hide").click(function(){
        $("#myTable").fadeOut(1000, function(){
        	alert("The table is now hidden");
        }); 
    });
});

$(function(){
    $("#show").click(function(){
        $("#myTable").fadeIn(1000, function(){
        	alert("The table is now visible");
        });
    });
});

$(function(){
    $("#welcome").animate({
        width: '99%'
    });
});