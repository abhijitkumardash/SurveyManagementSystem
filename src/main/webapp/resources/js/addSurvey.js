$(document).ready(function(){
	
//	$('#survey-create').click(function(){
//		var surveyTitle=$('#survey-title').val();
//		if(surveyTitle!=="" && surveyTitle!=null){
//			//alert(surveyTitle);
//			$.ajax({  
//			     type : "POST",   
//			     url : "saveSurveyTitle",   
//			     data : "surveyTitle=" + surveyTitle,  
//			     success : function(response) {  
//			     alert(response);  
//			    
//			     window.location.href = "addQuestion"; 
//			     },  
//			     error : function(e) {  
//			    //alert('Error: ' + e);   
//			     }  
//			    });  
//		}
//		else{
//			$('.error-msg').html("Survey Title Shouldnt be empty");
//		}
//		
//	});
//	
	//empties the error msg on key press in the input field
	$('input').focus(function () {
	    $('p').html("");
	});
	
});