<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                                    <div class="panel-title col-sm-12 col-lg-6">광고주님들 명단</div>       
                                    <div class="row col-righted">
                             	<div class="col-sm-12 col-lg-6">
				                    <a href="profile2Register.html" type="button"
				                     class="btn btn-warning btn-rounded">생성</a>
				                 		   </div>
				                    	</div>
                               		 </div>
                                <div class="panel-body">
                                    <div class="team col-md-6">
                                        <div class="team-member">
                                           <div class="online on"></div>
                                            <img src="assets/images/avatar1.png" alt="">
                                        </div>
                                        </div>
                                        <blockquote class="blockquote-reverse text-right col-md-6">
                                     	   <ul class="list-inline">
                                     	   <dl><h4><dt>광고주님들 / ${clientVO.size()} 명</dt><dt> 광고들 /  ${adVO.size() } 개 </dt><dt>영상갯수 / ${adVO.size() } 개</dt>
                                		</h4></dl>
                                   			
                                			</blockquote>
                                </div>
                            </div> 
                            
                            <div class="profile-timeline">
                                <ul class="list-unstyled">
                                    <li class="timeline-item">
                                        <div class="panel panel-white">
                                        <c:forEach var="adVO" items="${adVO }">
                                            <div class="panel-body">
                                                 <a href="profile2.html?adno=${adVO.adno }"><div class="timeline-item-header well">
                                                    <img src="http://localhost:8081/admin/viewfile?fileName=${adVO.ad_image}" alt="">
                                                    
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
        <script>
        $("#profileActive").attr("class","active");	
        $(document).ready(function() {
            console.log( "ready!" );
            
            
        });
        </script>
    </body>
</html>