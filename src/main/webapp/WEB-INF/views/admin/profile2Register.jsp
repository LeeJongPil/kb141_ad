<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
            <div class="page-inner">
<!--                 <div class="page-title">
                    <h3>Alerts</h3>
                    <div class="page-breadcrumb">
                        <ol class="breadcrumb">
                            <li><a href="index.html">Home</a></li>
                            <li><a href="#">UI Kits</a></li>
                            <li class="active">Alerts</li>
                        </ol>
                    </div>
                </div> -->
               <div id="main-wrapper">

		<!-- Main content -->
		<section class="content">
		<div class="row">
			<div class="col-md-8 col-md-offset-2"> 
			<form method="post" id="inputForm" action="profile2Register"  enctype="multipart/form-data">
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label">종류</label>  
				  <select id="category" name="category" class="form-control">
				      <option value="A">A</option>
				      <option value="B">B</option>
				      <option value="C">C</option>
				      <option value="D">D</option>
				    </select>
					<span class="help-block">광고의 종류를 선택하세요</span>  
				</div>
			
				<div class="form-group">
				  <label class=" control-label" >광고주아이디</label>  
				  <input id="cid" name="cid" type="text" placeholder="광고주아이디"  class="form-control">
					<span class="help-block">광고주의 이름을 입력하세요</span>  
				</div>
				
				<div class="form-group">
				  <label class=" control-label" >광고명</label>  
				  <input id="ad_title" name="ad_title" type="text" placeholder="광고명"  class="form-control">
					<span class="help-block">광고의 정식 명칭을 입력하세요</span>  
				</div>
				
				<div class="form-group">
				  <label class=" control-label" >광고 설명</label>  
					<textarea rows="10" name="ad_content" id="ad_content" class="form-control" ></textarea>				  
				</div>
				
				<div class="form-group">
				  <label class=" control-label" >목표감정</label>  
				  <select id="target_emotions" name="target_emotions" class="form-control">
				      <option value="happiness">행복</option>
				      <option value="anger">화남</option>
				      <option value="sadness">슬픔</option>
				      <option value="neutral">평온</option>
				      <option value="surprise">놀람</option>
				      <option value="fear">두려움</option>
				      <option value="contempt">경멸</option>
				      <option value="disgust">혐오</option>
				      
				    </select>
					<span class="help-block">목표감정를 선택하세요</span>  
				</div>
				
				<div class="form-group">
				  <label class=" control-label" >목표지역</label>  
				  <select id="target_area" name="target_area" class="form-control">
				      <option value="seoul">서울</option>
				      <option value="incheon">인천</option>
				      <option value="daejeon">대전</option>
				      <option value="daegu">대구</option>
				      <option value="busan">부산</option>
				      <option value="gwangju">광주</option>
				      <option value="ulsan">울산</option>
				      <option value="sejong">세종</option>
				      
				    </select>
					<span class="help-block">목표지역를 선택하세요</span>  
				</div>
				
				<div class="form-group">
				  <label class=" control-label" >상태 코드</label>  
				  <select id="permission" name="permission" class="form-control">
				      <option value="false">거부</option>
				      <option value="ture">승인</option>
				    </select>
					<span class="help-block">상태코드를 선택하세요</span>  
				</div>
				
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label">광고시작 일자</label>  
				  <input id="start_duration" name="start_duration" type="date" placeholder="2017-01-01" class="form-control" required="" >
				</div>
				<!-- Text input-->
				<div class="form-group">
				  <label class=" control-label" >광고종료 일자</label>  
				  <input id="end_duration" name="end_duration" type="date" placeholder="2017-01-01"  class="form-control" required="">
				</div>
				<div class="form-group">
				  <label class=" control-label" >광고이미지</label>  
				  <input id="image" type="file" placeholder="광고이미지"  class="form-control" value="ad_image" name="ad_image">
					<span class="help-block">광고의 이미지을 넣어주세요</span>  
				</div>
				
				<div class="form-group">
				  <label class=" control-label" >광고동영상</label>  
				  <input id="video" type="file" placeholder="광고동영상"  class="form-control" value="ad_video" name="ad_video">
					<span class="help-block">광고의 동영상을 넣어주세요</span>  
				</div> 
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }" />
				</form>
				
		<!-- 		<form method="post" id="upload" action="profile2RegisterUpload" enctype=multipart/form-data>
				</form> -->
				<div class="pull-right">
				<button type="button" class="btn btn-success" id="btnRegister">Register</button>
				<a href="list"><button type="button" class="btn btn-warning" id="btnCancel" >Cancel</button></a>
				</div>
				
			</div>
		</div>
		</section>
                    </div>
            
            <%@include file="footer.jsp"%>
            <script src="https://www.gstatic.com/firebasejs/3.6.9/firebase.js"></script>
   		<script>
   		$("#profileActive").attr("class","active");	
   		$(document).ready(function () {
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
   			
   			
		 	$("#btnRegister").on("click", function () {
 	   		$("#ad_content").val($("#ad_content").val().replace(/\n/g, "<br>"));
 	   		
 	   		var image = $("#image")[0].files;
 	   		var video = $("#video")[0].files;
 	   		console.log(video);
 	   		console.log(image);
			for(var i = 0 ; i < image.length ; i ++){
				/* $("<input type='hidden' name='imagenames' value='"+ image[i].name+"'>").appendTo("#sending"); */ 
				var uploadURL = uploadRef.child("AD_File/" + image[i].name);
			    var uploadTask = uploadURL.put(image[i]); 
			    
			    uploadTask.on('state_changed', function(snapshot){
			            // Observe state change events such as progress, pause, and resume
			            // See below for more detail
			        }, function(error) {
			            // Handle unsuccessful uploads
			        }, function() {
			            // Handle successful uploads on complete
			            // For instance, get the download URL: https://firebasestorage.googleapis.com/...
			            var downloadURL = uploadTask.snapshot.downloadURL;
			            
			       });
			}
			var video = $("#video")[0].files;
			for(var i = 0 ; i < video.length ; i ++){
				/* $("<input type='hidden' name='videonames' value='"+ video[i].name+"'>").appendTo("#sending"); */ 
				var uploadURL = uploadRef.child("AD_File/" + video[i].name);
			    var uploadTask = uploadURL.put(video[i]); 
			    
			    uploadTask.on('state_changed', function(snapshot){
			            // Observe state change events such as progress, pause, and resume
			            // See below for more detail
			        }, function(error) {
			            // Handle unsuccessful uploads
			        }, function() {
			            // Handle successful uploads on complete
			            // For instance, get the download URL: https://firebasestorage.googleapis.com/...
			            var downloadURL = uploadTask.snapshot.downloadURL;
			 	   		
			            
			            setInterval(function (){
			            $("#inputForm").attr("method","post").submit();  
			            },3000);
			           
			       });
			}
			
			
		 	});
   		});
		</script>
    </body>
</html>