$(document).ready(function(){
		
	$("input:radio[type=radio]").click(function() {
	   var value = $(this).val();
	   console.log(value);
	});
	
});