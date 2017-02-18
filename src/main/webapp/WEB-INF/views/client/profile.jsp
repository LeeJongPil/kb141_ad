<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
        <style>
        .col-centered{
        float: none;
        margin: auto;}
        .col-righted{
	float: none;
   	margin: auto;
   	text-align: right;
}   
        </style>
        
        
         <div class="page-inner">

          
                <div id="main-wrapper">
                   <div class="col-md-8 col-centered">
          
                      
                
                           <div class="panel panel-white">
                                <div class="panel-heading">
                                    <div class="panel-title col-sm-12 col-lg-6"><sec:authentication property="principal.username"/> 님</div>       
                                    <div class="row col-righted">
                             	<div class="col-sm-12 col-lg-6">
				                  
				                 		   </div>
				                    	</div>
                               		 </div>
                                <div class="panel-body">
                                    <div class="team col-md-6">
                                        <div class="team-member">
                                           <div class="online on"></div>
                                           
                                        </div>
                                        </div>
                                        <blockquote class="blockquote-reverse text-right col-md-6">
                                     	   <ul class="list-inline">
                                     	   <dl><h4><dt> 광고들 /  ${adVO.size() } 개 </dt><dt>영상갯수 / ${adVO.size() } 개</dt>
                                		</h4></dl>
                                   			
                                			</blockquote>
                                </div>
                            </div> 
                            
                            <div class="profile-timeline">
                                <ul class="list-unstyled">
                                    <li class="timeline-item">
                                        <div class="panel panel-white">
                                        <div class="panel-heading">광고 리스트</div>
                                        <c:forEach var="adVO" items="${adVO }">
                                            <div class="panel-body">
                                                 <a href="profile2.html?adno=${adVO.adno }">
                                                 <div class="timeline-item-header well" id="${adVO.ad_image }">
                                                    <%-- <img src="http://localhost:8081/client/viewfile?fileName=${adVO.ad_image}" alt=""> --%>
                                                    
                                                    <p>${adVO.ad_title }<span>/ ${adVO.category }</span></p> <small><fmt:formatDate value="${adVO.start_duration }" pattern="yyyy-MM-dd "/></small>
		                                                <div class="timeline-item-post">
		                                                    <p>${adVO.ad_content }</p>
		                                                </div>
                                                </div></a>
                         
                                        </div>
                                        </c:forEach>
                                        </div>
                                    </li>
                              
                         
                                </ul>
                            </div>
                         
                        </div>
                    </div>
                </div>

     
	
		<%@include file="footer.jsp"%>
        <!-- Javascripts -->
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCzjeZ1lORVesmjaaFu0EbYeTw84t1_nek"></script>
        <script src="/assets/js/pages/profile.js"></script>
        <script src="https://www.gstatic.com/firebasejs/3.6.9/firebase.js"></script>
        <script>
        $(document).ready(function() {
            console.log( "ready!" );
            $("#tabProfile").attr("class","active");
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
            
        	    var list = [ <c:forEach items="${adVO}" var="i"> "${i.ad_image}",</c:forEach>];
        	    console.log(list);
        	    var adList = new Array();
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
        				
        					
//         				metaData.push(metadata.size);
        				meta.push({"size":metadata.size, "name":metadata.name, "url" : metadata.downloadURLs[0]});
        				console.log("실시간 metaData 길이 : " + meta.length);
        	    		console.log(metadata.name);
        	    		adList.push(metadata.name);
        	    		console.log("뭐지이거 시발 왜안뜨니 :"+adList);
        	    		console.log("아이디 떠라떠라" + list);
     					
        	    	 
        	    	}).catch(function(error) {
        	    	  // Uh-oh, an error occurred!
        	    	});
        	    }
        	    
        	    var please = setInterval(function (){
        
        				  for (var x = 0; x < meta.length; x++) {
							console.log("메타데이터 :"+meta[x].name);
        				    
        			 	     for (var i = 0; i < list.length; i++) {
        			 	    	console.log("리스트 :"+ list[i]);
        			 	    	if(list[i] == (meta[x].name)){
        			 	    		console.log("나와라" +list[i]);
        			 	    		console.log(meta[x].url);
        			 	    		var id = document.getElementById(list[i]);
        			 	    		console.log(id);
        			 	    		 $(id).children().first().append('<img src=' + meta[x].url + ' alt="" >');     
        			 	    	}
							} 
        				  }     
        		 clearInterval(please);
        	    },3000);
        });
        </script>
    </body>
</html>