<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="../assets/plugins/summernote-master/summernote.css" rel="stylesheet" type="text/css"/>
<link href="../assets/plugins/summernote-master/summernote-bs2.css" rel="stylesheet" type="text/css"/>
<link href="../assets/plugins/summernote-master/summernote-bs3.css" rel="stylesheet" type="text/css"/>
<link href="../assets/css/modern.min.css" rel="stylesheet" type="text/css"/>

<%@ include file="../header.jsp" %>
    <div class="page-inner">
                <div id="main-wrapper">
                    <div class="row m-t-md">
                        <div class="col-md-12">
                            <div class="row mailbox-header">
                                <div class="col-md-2">
                                    <a href="inbox.html" class="btn btn-success btn-block">Back to Inbox</a>
                                </div>
                                <div class="col-md-6">
                                    <h2>Compose</h2>
                                </div>
                                <div class="col-md-4">
                                    <div class="compose-options">
                                        <div class="pull-right">
                                            <a href="inbox.html" class="btn btn-default"><i class="fa fa-file-text-o m-r-xs"></i>Draft</a>
                                            <a href="inbox.html" class="btn btn-danger"><i class="fa fa-trash m-r-xs"></i>Discard</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <ul class="list-unstyled mailbox-nav">
                                <li><a href="inbox.html"><i class="fa fa-inbox"></i>Inbox <span class="badge badge-success pull-right">4</span></a></li>
                                <li><a href="#"><i class="fa fa-sign-out"></i>Sent</a></li>
                                <li><a href="#"><i class="fa fa-file-text-o"></i>Draft</a></li>
                                <li><a href="#"><i class="fa fa-exclamation-circle"></i>Spam</a></li>
                                <li><a href="#"><i class="fa fa-trash"></i>Trash</a></li>
                            </ul>
                        </div>
                        <div class="col-md-10">
                            <div class="mailbox-content">
                                <div class="compose-body">
                                    <form class="form-horizontal"  id = "sending"  method = "post" action = "send">
                                        <div class="form-group">
                                            <label for="to" class="col-sm-2 control-label">To</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="to" name = "mto" value = "${to}">
                                                <input type="hidden"  name = "mfrom" value="test">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="subject" class="col-sm-2 control-label">Subject</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="subject" name = "mtitle">
                                            </div>
                                        </div>
                                        
                                </div>
                                <div class="compose-message">
                                    <div class="summernote">
                                    <textarea class="form-control"  name="mcontent"  id="text" rows="30"  style="resize:none;"></textarea>
                                    </div>
                                </div>
                                </form>
                                <div class="compose-options">
                                    <div class="pull-right">
                                        <button class="btn btn-success" id = "btnSend"><i class="fa fa-send m-r-xs"></i>Send</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                                    
                        
                    </div><!-- Row -->
                </div><!-- Main Wrapper -->


<%@ include file="../footer.jsp" %>
<!-- <script src="../assets/plugins/summernote-master/summernote.min.js"></script>   -->
<!-- <script src="../assets/plugins/summernote-master/summernote.js"></script> -->
<!-- <script src="../assets/js/pages/compose.js"></script>      -->

<script>
$(document).ready(function(){
	    $("#messageActive").attr("class","active");
		$("#btnSend").on("click", function(event){
			event.preventDefault();
			var suc = $("#text").val($("#text").val().replace(/\n/g, "<br>"));
			console.log(suc);
			
			$("#sending").submit();
			
		});
		
	
	
	
// 	var but = $(".note-view").context.all[903].childNodes[1];		// codeview 버튼 
// 	console.log($(".note-view").context.all[903].childNodes[1].outerHTML);
	
// 	addJavascript('../assets/plugins/summernote-master/summernote.js')
	
// 		$("#send").on("click" , function (event) {
// 			console.log($('.note-editable')[0].textContent);			// 그냥 일반 텍스트 창에 있는걸 긁어온다.
// 				console.log("send button click");
// 				console.log(but);
// 				console.log("----------commands------------")
// 				console.log(commands());
// 			console.log("trigger click1")
// 			$(but).trigger('click');
// 			console.log("trigger click2")
// // 				$("#sendForm").append("<input type='hidden' name='mfrom' value='admin'> ");
// // 				$("#sendForm").append("<input type='hidden' name='mcontent' value='"+content+"'>");
// // 				$("#sendForm").submit();
// 			console.log("-----------------------------------");
// 		    console.log(suc);
// 			});
	
	
});
</script>
	
	 
          
          


