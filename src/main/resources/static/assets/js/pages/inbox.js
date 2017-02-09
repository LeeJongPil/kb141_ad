$( document ).ready(function() {
    var hiddenMailOptions = function() {
        if($('.checkbox-mail:checked').length) {
            $('.mail-hidden-options').css('display', 'inline-block');
        } else {
            $('.mail-hidden-options').css('display', 'none');
        };
    };
    
    hiddenMailOptions();
    
    $('.check-mail-all').click(function (event) {
     console.log($('.check-mail-all')[0].checked);
//     console.log($('.checkbox-mail'));	// 0 ~ 11 , length = 12
//     console.log($('.checkbox-mail')[0].parentNode.hasClass("checked"));	// 0 ~ 11 , length = 12
     console.log($('.checkbox-mail')[1].parentNode);	// 0 ~ 11 , length = 12
     
     
     if($('.check-mail-all')[0].checked == true){
    	 for(var i = 0 ; i < $('.checkbox-mail').length ; i ++){
    		 $('.checkbox-mail')[i].checked=true;
    		 $('.checkbox-mail')[i].parentNode.className = "checked";
    		 $("#pagelist tr").addClass('checked');
    	 }
     }
     else {
    	 console.log($("#pagelist tr"));
    	 for(var i = 0 ; i < $('.checkbox-mail').length ; i ++){
    			 $('.checkbox-mail')[i].checked=false;
    			 $('.checkbox-mail')[i].parentNode.className = "";
    			 $("#pagelist tr").removeClass('checked');
    	 }
    }
     
  
 });
    
//    $(document).on('click', '.checkbox-mail tr td', $('.checkbox-mail').each(function() {
//        $(this).click(function() {
//            if($(this).closest('tr').hasClass("checked")){
//                $(this).closest('tr').removeClass('checked');
//                hiddenMailOptions();
//            } else {
//                $(this).closest('tr').addClass('checked');
//                hiddenMailOptions();
//            }
//        });
//    })); 
    
    
    
    $(document).on('click', ('.mailbox-content tr td input'), function(e) {
    		console.log(e);
    		if($(this).closest('tr').hasClass("checked")){
              $(this).closest('tr').removeClass('checked');
              hiddenMailOptions();
          } else {
              $(this).closest('tr').addClass('checked');
              hiddenMailOptions();
          }
    });
    

//    $(document).not(":first-child").on('click', ('.pagelist tr td'),function(e) {
//  $(document).on('click', '.mailbox-content table tr td:not(tdcheck)', function(e) {
//	  e.preventDefault();
//	console.log(e);
//    console.log(e.currentTarget.parentNode.children[1].innerText);
//	e.stopPropagation();
//    e.preventDefault();
//	var mno = e.currentTarget.parentNode.children[1].innerText;
//	$("<form action='view'><input type='hidden' name='mno' value='"+mno+"'></form>").appendTo("body").submit();
//});
    
    
    $(document).on('click',('.mailbox-content table tr td'), function(e) {
//    	console.log(e);
   
//        console.log(e.currentTarget.parentNode.children[1].innerText);
//    	e.stopPropagation();
//        e.preventDefault();
        console.log($(this).context.id);
        console.log($(this).context.parentNode.children[1].innerText);
        if($(this).context.id == 'tdcheck'){
        	console.log("Don't go viewPage");
        }
        else{
//        	console.log("Go viewPage");
			$("<form action='view'><input type='hidden' name='mno' value='"+$(this).context.parentNode.children[1].innerText+"'></form>").appendTo("body").submit();
        	
        }
        
        
//    	var mno = e.currentTarget.parentNode.children[1].innerText;
//		$("<form action='view'><input type='hidden' name='mno' value='"+mno+"'></form>").appendTo("body").submit();
    });
    
    
    
    
    
    
    
//    $('.mailbox-content table tr td').not(":first-child").on('click', function(e) {
//    	console.log(e);
//        console.log(e.currentTarget.parentNode.children[1].innerText);
//    	e.stopPropagation();
//        e.preventDefault();
//    	var mno = e.currentTarget.parentNode.children[1].innerText;
//		$("<form action='view'><input type='hidden' name='mno' value='"+mno+"'></form>").appendTo("body").submit();
//    });


    




    

});
