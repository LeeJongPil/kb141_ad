<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="../assets/plugins/summernote-master/summernote.css" rel="stylesheet" type="text/css"/>
<link href="../assets/plugins/summernote-master/summernote-bs2.css" rel="stylesheet" type="text/css"/>
<link href="../assets/plugins/summernote-master/summernote-bs3.css" rel="stylesheet" type="text/css"/>
<link href="../assets/css/modern.min.css" rel="stylesheet" type="text/css"/>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ include file="header.jsp" %>
    <div class="page-inner">
                <div id="main-wrapper">
                    <div class="row m-t-md">
                        <div class="col-md-12">
                            <div class="row mailbox-header">
                                <div class="col-md-2">
                                    <a href="inbox.html" class="btn btn-success btn-block">뒤로가기</a>
                                </div>
                                <div class="col-md-6">
                                    <h2>메 일 함</h2>
                                </div>
                                <div class="col-md-4">
                                    <div class="compose-options">
                                        <div class="pull-right">
                                            <!-- <a href="inbox.html" class="btn btn-default"><i class="fa fa-file-text-o m-r-xs"></i>뒤로가기</a> -->
                                            <!-- <a href="inbox.html" class="btn btn-danger"><i class="fa fa-trash m-r-xs"></i>Discard</a> -->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <ul class="list-unstyled mailbox-nav">
                                <li><a href="inbox.html"><i class="fa fa-inbox"></i>메일함 <span class="badge badge-success pull-right"></span></a></li>
                                <!-- <li><a href="#"><i class="fa fa-sign-out"></i>Sent</a></li> -->
                            </ul>
                        </div>
                        <div class="col-md-10">
                            <div class="mailbox-content">
                                <div class="compose-body">
                                    <form class="form-horizontal"  id = "sending"  method = "post"  action = "send">
                                        <div class="form-group">
                                            <label for="to" class="col-sm-2 control-label">To</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control"  id="to" name = "mto"  >
                                                <input type="hidden"  name = "mfrom" value="<sec:authentication property="principal.username"/>">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="subject" class="col-sm-2 control-label">제목</label>
                                            <div class="col-sm-10">
                                                <input type="text"  class="form-control"  id="subject"  name ="mtitle">
                                            </div>
                                        </div>
 
                                      <div class="form-group">
                                        		<label for="file" class="col-sm-2 control-label"> File </label>  
											<div class="col-sm-10">
												<input type="file"  id="file" multiple="multiple">
											</div>                                        
                                        </div>
                                </div>
                                <div class="compose-message">
                                    <div class="summernote">
                                    <textarea class="form-control"  name="mcontent"  id="text" rows="30"  style="resize:none;"></textarea>
                                    </div>
                                </div>
                                <div class="compose-options">
                                    <div class="pull-right">
                                        <button class="btn btn-success" id = "btnSend"><i class="fa fa-send m-r-xs"></i>Send</button>
                                    </div>
                                </div>
                                <input
									type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
                                </form>
                                
                            </div>
                        </div>
                                    
                        
                    </div><!-- Row -->
                </div><!-- Main Wrapper -->


<%@ include file="footer.jsp" %>
<!-- <script src="../assets/plugins/summernote-master/summernote.min.js"></script>   -->
<!-- <script src="../assets/plugins/summernote-master/summernote.js"></script> -->
<!-- <script src="../assets/js/pages/compose.js"></script>      -->
<script src="https://www.gstatic.com/firebasejs/3.6.9/firebase.js"></script>
<script>
$(document).ready(function(){
		// settings config...
		var config = {
	        apiKey: "AIzaSyDHqc_8P_hEUTJ-kUvdgc8VAne1r36g0M8",
	        authDomain: "kb141-17d6a.firebaseapp.com",
	        databaseURL: "https://kb141-17d6a.firebaseio.com",
	        storageBucket: "kb141-17d6a.appspot.com",
	        messagingSenderId: "387641864580"
	    };
	    firebase.initializeApp(config);
	    var storage = firebase.storage();
	    var downloadRef =  storage.refFromURL("gs://kb141-17d6a.appspot.com/AD_File/");
	    var uploadRef = storage.ref();

	    // login
	    firebase.auth().signInWithEmailAndPassword("jk3a0123@gmail.com", "wjdwndud08").catch(function(error) {
	        // Handle Errors here.
	        console.log('error sign');
	        var errorCode = error.code;
	        var errorMessage = error.message;
	    });
	    
	    // checked login
	    firebase.auth().onAuthStateChanged(function(user) {
	        var currentUser = firebase.auth().currentUser;
	        if (currentUser) {
	            console.log(currentUser.uid);
	        } else {
	            console.log("no user");
	        }
	    });
	
	    $("#messageActive").attr("class","active");
		$("#btnSend").on("click", function(event){
			event.preventDefault();
			var suc = $("#text").val($("#text").val().replace(/\n/g, "<br>"));
			console.log(suc);
			var files = $("#file")[0].files;
			
			for(var i = 0 ; i < files.length ; i ++){
				$("<input type='hidden' name='filenames' value='"+ files[i].name+"'>").appendTo("#sending"); 
				var uploadURL = uploadRef.child("AD_File/" + files[i].name);
			    var uploadTask = uploadURL.put(files[i]); 
			    uploadTask.on('state_changed', function(snapshot){
			            // Observe state change events such as progress, pause, and resume
			            // See below for more detail
			        }, function(error) {
			            // Handle unsuccessful uploads
			        }, function() {
			            // Handle successful uploads on complete
			            // For instance, get the download URL: https://firebasestorage.googleapis.com/...
			            var downloadURL = uploadTask.snapshot.downloadURL;
			            $("#sending").submit();
			       });
			}
			
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
	 "${urlname}" == "/admin" ? $("#devicemanagement").show() : $("#devicemanagement").hide();
	 "${urlname}" == "/admin" ? $("#mapDropLink").show( : $("#mapDropLink").hide();
	
});
</script>
	
	 
          
          


