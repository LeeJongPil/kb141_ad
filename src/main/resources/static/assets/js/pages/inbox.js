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

     
     
     
//     if($('.check-mail-all')[0].checked == true){
//    	 for(var i = 0 ; i < $('.checkbox-mail').length ; i ++){
//			 $('.checkbox-mail')[i].checked=true;
//    	 }
//     }
//     else {
//    		 for(var i = 0 ; i < $('.checkbox-mail').length ; i ++){
//    			 $('.checkbox-mail')[i].checked=false;
//    		 }
//    	 }
     
//     $('.checkbox-mail').click();
 });
    
    $('.checkbox-mail').each(function() {
        $(this).click(function() {
            if($(this).closest('tr').hasClass("checked")){
                $(this).closest('tr').removeClass('checked');
                hiddenMailOptions();
            } else {
                $(this).closest('tr').addClass('checked');
                hiddenMailOptions();
            }
        });
    });
    
    $('.mailbox-content table tr td').not(":first-child").on('click', function(e) {
        console.log(e.currentTarget.parentNode.children[1].innerText);
    	e.stopPropagation();
        e.preventDefault();
    	var mno = e.currentTarget.parentNode.children[1].innerText;
		$("<form action='view'><input type='hidden' name='mno' value='"+mno+"'></form>").appendTo("body").submit();
    });


//    $("#delete").on('click', function(e){
//    	console.log(e);
//    	console.log($(".mailbox-content table tr"));
//    	
//    	var arr = [];
    	// 길이 - 1  시작은 1 부터 
//    	for(var i = 1 ; i < $(".mailbox-content table tr").length - 1;  i++){
//    		console.log($(".mailbox-content table tr")[i].childNodes[1].);
    
//    	}
//    	console.log($(".mailbox-content table tr")[i].childNodes[3].innerText);
    	
//    });

//    $('.checker span').on('click', function(e){
//    	var bool = $(e.currentTarget.attributes[0]).context.value;
//    	var arr = [];
//    	console.log(e);
//    	console.log(e.currentTarget);
    	
    	//    	if(bool == "checked"){
//    		arr.push($('.mailbox-content table tr td')[1].innerText);
//    		console.log("true");
//    	}	
//    	else{
//    		console.log(arr.indexOf(bool));
//    	}
//    	console.log(arr);
//    	console.log($(e.currentTarget.attributes[0]).context.value);
//    	console.log(bool.is("checked"));
//    	console.log(($(e.currentTarget.attributes[0]).context.value).is("checked"));
//    });
    
    
    

});
