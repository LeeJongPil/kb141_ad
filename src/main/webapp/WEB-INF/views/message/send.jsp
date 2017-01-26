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
                                    <h2>Send Message</h2>
                                </div>
                                <div class="col-md-4">
                                </div>
                            </div>
                        </div>
                      
                        <div class="col-md-2">
                            <ul class="list-unstyled mailbox-nav">
                                <li><a href="inbox.html"><i class="fa fa-inbox"></i>Inbox <span class="badge badge-success pull-right">4</span></a></li>
                                <li><a href="#"><i class="fa fa-sign-out"></i>Sent</a></li>
                                <li><a href="#"><i class="fa fa-trash"></i>Trash</a></li>
                            </ul>
                        </div>
                        <div class="col-md-10">
                            <div class="mailbox-content">
                                <div class="compose-body">
                                    <form class="form-horizontal" action="send" method="post" id="sendForm">
                                        <div class="form-group">
                                            <label for="to" class="col-sm-2 control-label">To</label>
                                            <div class="col-sm-10">
                                            	
                                                <input type="text" class="form-control" id="to"  name="mto" value="${to== null ?  ' ' :  to }">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="subject" class="col-sm-2 control-label">Subject</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="subject" name="mtitle">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="compose-message">
                                    <div class="summernote"></div>
                                <div class="compose-options">
                                    <div class="pull-right">
                                        <a class="btn btn-success" id="send"><i class="fa fa-send m-r-xs"></i>Send</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!-- Row -->
               </div>
            </div>
   </div><!-- Main Wrapper -->


<%@ include file="../footer.jsp" %>
<script src="../assets/plugins/summernote-master/summernote.min.js"></script>  
<script src="../assets/plugins/summernote-master/summernote.js"></script>
<script src="../assets/js/pages/compose.js"></script>     
<script>
$(document).ready(function(){
			$("#send").on("click" , function (event) {

				var content = $('.note-editable')[0].textContent;
				
				$("#sendForm").append("<input type='hidden' name='mfrom' value='admin'> ");
				$("#sendForm").append("<input type='hidden' name='mcontent' value='"+content+"'>");
				$("#sendForm").submit();
			});

});





</script>
          

