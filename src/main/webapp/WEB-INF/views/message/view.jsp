<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
            <div class="page-inner">
                <div id="main-wrapper">
                    <div class="row m-t-md">
                        <div class="col-md-12">
                            <div class="row mailbox-header">
                                <div class="col-md-2">
                                    <a  class="btn btn-success btn-block" id='register'>Message Register</a>
                                </div>
                                <div class="col-md-6">
                                    <h2>View Message</h2>
                                </div>
                                <div class="col-md-4">
                                    <form action="#" method="GET">
                                        <div class="input-group">
                                            <input type="text" name="search" class="form-control input-search" placeholder="Search...">
                                            <span class="input-group-btn">
                                                <button class="btn btn-success" type="button"><i class="fa fa-search"></i></button>
                                            </span>
                                        </div><!-- Input Group -->
                                    </form>
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
                                <div class="message-header">
                                	<p class="message-date">   날짜 :  ${view.regdate}</p>
                                    <h2> 제목    :    ${view.mtitle}</h2>
                                </div>
                                <div class="message-sender">
                                    보낸 사람 : <p> ${view.mfrom}</p>
                                </div>
                                <div class="message-content">
                                    <h3> ${view.mcontent}</h3>
                                </div>
                               
                       <!--          <div class="message-attachments">
                                    <p><i class="fa fa-paperclip m-r-xs"></i>2 Attachments - <a href="#">View all</a> | <a href="#">Download all</a></p>
                                    <div class="message-attachment">
                                        <a href="#">
                                            <div class="attachment-content">
                                                <img src="assets/images/attachment1.jpg" alt="">
                                            </div>
                                            <div class="attachment-info">
                                                <p>Attachment1.jpg</p>
                                                <span>444 KB</span>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="message-attachment">
                                        <a href="#">
                                            <div class="attachment-content">
                                                <img src="assets/images/attachment2.jpg" alt="">
                                            </div>
                                            <div class="attachment-info">
                                                <p>Attachment2.jpg</p>
                                                <span>548 KB</span>
                                            </div>
                                        </a>
                                    </div>
                                </div> -->
                                <div class="message-options pull-right" id="control" >
                                   <a class="btn btn-default"><i class="fa fa-reply m-r-xs"></i>Reply</a> 
                                   <a class="btn btn-default"><i class="fa fa-trash m-r-xs"></i>Trash</a>
                                    
                                </div>
                            </div>
                        </div>
                    </div><!-- Row -->
                </div><!-- Main Wrapper -->
               

<%@include file="../footer.jsp" %>
<script type="text/javascript">
$(document).ready(function() {
	
			//view page open and immediately update state at the same time

			$.ajax({
					url :  "state",
					type : "post",
					data : {"mno" :  ${view.mno} , "checked" : "1"},
					success : function(event){
						console.log(event);
					}
			});
			
			// reply or delete 	
			$('#control > a').on("click"  , function(event) {
					var sender = $('.message-sender > p ')[0].innerText;
					console.log(event.currentTarget.text);
					
					var target = event.currentTarget.text;
						if(target== "Reply"){
							$("<form action='send' method='get'><input type='hidden' name='mfrom' value='"+sender+"'></form>").appendTo('body').submit();	
						}else if(target == "Delete"){
							$("<form action='state' method='post'><input type='hidden' name='mno' value='"+${view.mno}+"'><input type='hidden' name='checked' value='2'></form>").appendTo('body').submit();		
						}
			});	
			// send msg page called.. 
			$("#register").on("click" , function(){
				$("<form action='send' method='get'></form>").appendTo("body").submit();	
			});
});

</script>