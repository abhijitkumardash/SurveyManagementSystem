$(document).ready(function(){
		
	$("input:radio[name=group1]").click(function() {
	    var value = $(this).val();
	  
	    console.log(  $(this).attr("answerId"));
	});
});