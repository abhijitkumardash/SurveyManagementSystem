$(document).ready(function(){
		
	$("input:radio[name=group1]").click(function() {
	    var value = $(this).val();
	  
	    alert(  $(this).attr("answerId"));
	});
});