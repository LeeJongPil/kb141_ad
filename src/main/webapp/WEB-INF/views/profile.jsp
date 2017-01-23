<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <style>
        .col-centered{
        float: none;
        margin: auto;}
        </style>
        
        
         <div class="page-inner">

          
                <div id="main-wrapper">
                   <div class="col-md-8 col-centered">
                    <div class="row">
                    		
                           <div class="panel panel-white">
                        	<div class="row">
                        		
                                <div class="col-md-11 text-right"><p>광고주님들&emsp;광고들 &emsp; 영상 갯수 &emsp;</p>
                                <h3>1020명 &emsp;1780개  &emsp; 260개 &emsp;  </h3></div>
                          
                           </div>
 						</div>
                      
                
                           <div class="panel panel-white">
                                <div class="panel-heading">
                                    <div class="panel-title">광고주님들 명단</div>
                                </div>
                                <div class="panel-body">
                                    <div class="team">
                                        <div class="team-member">
                                           <div class="online on"></div>
                                            <img src="assets/images/avatar1.png" alt="">
                                        </div>
                                        
                                    </div>
                                </div>
                            </div> 
                            
                            <div class="profile-timeline">
                                <ul class="list-unstyled">
                                    <li class="timeline-item">
                                        <div class="panel panel-white">
                                        <c:forEach var="adVO" items="${adVO }">
                                            <div class="panel-body">
                                                 <a href="profile2.html?adno=${adVO.adno }"><div class="timeline-item-header well">
                                                    <img src="assets/images/ad/${adVO.ad_image}.png" alt="">
                                                    
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
        <script src="assets/js/pages/profile.js"></script>
        <script>
        $(document).ready(function() {
            console.log( "ready!" );
            
            
        });
        </script>
    </body>
</html>