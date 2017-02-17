<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
            <div class="page-inner">
                <div id="main-wrapper">
                    <div class="row m-t-md">
                        <div class="col-md-12">
                            <div class="row mailbox-header">
                                <div class="col-md-2">
                                    <a  class="btn btn-success btn-block" id='register'>메세지 보내기</a>
                                </div>
                                <div class="col-md-6">
                                    <h2>메세지 뷰</h2>
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
                                <li><a href="inbox.html"><i class="fa fa-inbox"></i>메일함 <span class="badge badge-success pull-right"></span></a></li>
                               <!--  <li><a href="#"><i class="fa fa-sign-out"></i>Sent</a></li>
                                <li><a href="#"><i class="fa fa-trash"></i>Trash</a></li> -->
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
                               
                               
                               
                                <div class="message-attachments">
                                   
                                   
<!--                                     <div class="message-attachment"> -->
<!--                                         <a href="#"> -->
<!--                                             <div class="attachment-content"> -->
<!--                                                 <img src="assets/images/attachment1.jpg" alt=""  id = "adimg"> -->
<!--                                             </div> -->
                                            
<!--                                             <div class="attachment-info"> -->
<%--                                                 <p>${filename[0]}</p> --%>
<!--                                                 <span>444 KB</span> -->
<!--                                             </div> -->
                                            
<!--                                         </a> -->
<!--                                     </div> -->
                                    
<!--                                     <div class="message-attachment"> -->
<!--                                         <a href="#"> -->
<!--                                             <div class="attachment-content"> -->
<!--                                                 <img src="assets/images/attachment2.jpg" alt=""> -->
<!--                                             </div> -->
<!--                                             <div class="attachment-info"> -->
<!--                                                 <p>Attachment2.jpg</p> -->
<!--                                                 <span>548 KB</span> -->
<!--                                             </div> -->
<!--                                         </a> -->
<!--                                     </div> -->
                                    
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
                                   <a class="btn btn-default"><i class="fa fa-reply m-r-xs"></i>뒤로가기</a> 
                                   <a class="btn btn-default"><i class="fa fa-trash m-r-xs"></i>삭제</a>
                                    
                                </div>
                            </div>
                        </div>
                    </div><!-- Row -->
                </div><!-- Main Wrapper -->
               

<%@include file="footer.jsp" %>
<script src="https://www.gstatic.com/firebasejs/3.6.9/firebase.js"></script>


<script type="text/javascript">
$(document).ready(function() {
	
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
	    
	    
	    
	    
	    // download   이미지명을 불러와서 넣기만 하면 된다. 
	    // 여러개를 불러올수있으니까 for문을 돌려서 append 해야한다. 
	    
	    //변수에 for문으로 계속 돌리면서 던진다. 
	    // 아래 에서는 append로 추가한다.
	    
	    var list = [<c:forEach items="${filename}" var="i">"${i}",</c:forEach>];
	    console.log(list);

	    for(var i = 0 ; i < list.length; i++){
    	var meta = new Array();
	    	// Create a reference to the file whose metadata we want to retrieve
	    	var forestRef = downloadRef.child(list[i]);

	    	// Get metadata properties
	    	forestRef.getMetadata().then(function(metadata) {
				console.log(metadata);
				console.log("size : " + metadata.size);
				console.log("name : " + metadata.name);
				console.log("url : " + metadata.downloadURLs[0]);
				
					
// 				metaData.push(metadata.size);
				meta.push({"size":metadata.size, "name":metadata.name, "url" : metadata.downloadURLs[0]});
				console.log("실시간 metaData 길이 : " + meta.length);
	    	console.log(meta);
	    	}).catch(function(error) {
	    	  // Uh-oh, an error occurred!
	    	});
	    }

	    
	    
	    var please = setInterval(function (){
	    	if(list.length == meta.length){
// 				    		clearInterval(this);
				    for(var i = 0 ; i < list.length; i++){
				    	console.log("그림 뿌리기 시작할거임.......................")
				    	console.log("list : " + list[i]);
				    var currentURL = downloadRef.child(list[i]);
				    
				    var currentWhat = list[i];
				    var currentSub = currentWhat.substr(currentWhat.length - 3,3);
				    
				    
				    currentURL.getDownloadURL().then(function (url) {
				    	console.log("url : " + url);
			// 	        $("#adimg").attr("src" , url);
							var name = meta.filter(function(item){
								return item.url == url
							});
								
							if(currentSub == "jpg" && "png"){
				        $(".message-attachments").append('<div class="message-attachment"><a href="#"><div class="attachment-content">'
			                         + '<img src=' + url + ' alt=""  id = "adimg" width="100px" height="300px">  </div>   <div class="attachment-info">'
			                       + '<p>' +name[0].name+'</p>'
			                        + '<span> ' + name[0].size + '</span>'
			                    +'</div></a> </div>')
							}
							else{
								console.log("video 할거임 ......");
								
								 $(".message-attachments").append('<video controls src ='+url+' height = "500px" width = "500px"></video>');

							}
				    }).c5ratch(function(error) {
				        switch (error.code) {
				            case 'storage/object_not_found':
				                console.log("not found");
				                break;
			
				            case 'storage/unauthorized':
				                console.log("not auth");
				                break;
			
				            case 'storage/canceled':
				                console.log("canceled...");
				                break;
			
				            case 'storage/unknown':
				                console.log("unknown..");
				                break;
				        }
				    });
				
				    }
				    clearInterval(please);
				    	}else{
				    		console.log("사진 없어요 .....................");
				    	}
	    },1000);
// 	    }
	    
	    
	    
	
			$("#messageActive").attr("class","active");
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