<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<style>
.col-centered{
   float: none;
   margin: auto;
   text-align: center;
   }
</style>



            
         <div class="page-inner">

          
             <div id="main-wrapper">
	                  <div class="row">  
                    	<div class="col-sm-12 col-lg-6">
                           <div class="panel panel-white" style="height: 275px">
                                <div class="panel-heading">
                                    <div class="panel-title">실험중인 광고이름</div>
                                </div>
                                <div class="panel-body">
                                	
                           		<blockquote>
                           			<p>ClIENT  : ${adVO.ad_title }</p>
                           			<p>SERVICE : ${adVO.category } </p>
                           			<p>D A T E : <fmt:formatDate value="${adVO.start_duration }" pattern="yyyy-MM-dd "/> ~ <fmt:formatDate value="${adVO.end_duration }" pattern="yyyy-MM-dd "/></p>
                           			<p>CONTENT : ${adVO.ad_content } ${deviceVO }</p>
                           	
                           		</blockquote>
                                </div>
                            </div> 
                          </div>  
                            <div class="col-sm-12 col-lg-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h4 class="panel-title">사용중인 기기</h4>
                                    <div class="panel-control">
                                        <a href="javascript:void(0);" data-toggle="tooltip" data-placement="top" title="Reload" class="panel-reload"><i class="icon-reload"></i></a>
                                    </div>
                                </div>
                                   <div class="panel-body">
                                                <div class="timeline-item-post">
                                                    <div id="map-canvas" style="height: 200px; width: 100%;"></div>
                                                </div>
                                </div>
                            </div>
                          </div>
                        </div>
                        
                       <div class="row">
                    	<div class="col-sm-12 col-lg-6">
                    		 <div class="panel panel-white">
	                            <div class="visitors-chart">
                                            <div class="panel-heading">
                                                <h4 class="panel-title">기간 별 본 닝겐 수</h4>
                                            </div>
                                         <div class="panel-body">
                                    <div>
                                        <canvas id="chart1" height="150"></canvas>
                                    </div>
                                 </div>
                              </div>
	                    	</div>
	                    </div>
	                    <div class="col-sm-12 col-lg-6">
                    		 <div class="panel panel-white">
	                            <div class="visitors-chart">
                                   <div class="panel-heading">
                                      <h4 class="panel-title">기간 별 본 닝겐 수</h4>
                                  </div>
                                <div class="panel-body">
	                                <div>
	                                   <canvas id="chart2" height="150"></canvas>
	                                </div>
                              </div>
                            </div>
	                      </div>
	                    </div>     
                      </div> 
                      
                    
         	               <div class="row">
                        	 <div class="col-sm-12 col-lg-6">
                              <div class="profile-timeline">
                                <ul class="list-unstyled">
                                    <li class="timeline-item">
                                        <div class="panel panel-white" style="height: 475px;">
                                        <div class="panel-heading">
                                                <h4 class="panel-title">동영상</h4>
                                            </div>
                                            <div class="panel-body col-centered">
                           					   <video width="480" height="360" controls>
												  <source src="assets/images/ad/${adVO.ad_video }.mp4" type="video/mp4">
												  <source src="assets/images/ad/Anger_School violence.ogg" type="video/ogg">
  											   </video>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-12 col-lg-6">
                            <div class="profile-timeline">
                                <ul class="list-unstyled">
                                    <li class="timeline-item">
                                        <div class="panel panel-white" style="height: 475px;">
                                        <div class="panel-heading">
                                                <h4 class="panel-title">포스터</h4>
                                            </div>
                                            <div class="panel-body col-centered">
                                              <img src ="assets/images/ad/${adVO.ad_image}.png" style="height: 400px">
                                       		 </div>
                                       		 </div>
                                    </li>
                                </ul>
                            </div>
                            </div>
                        </div>
                    </div>
              
                
                  
     
              
		
    </body>
    <%@include file="footer.jsp"%>
        <!-- Javascripts -->
       	<script src="assets/plugins/chartsjs/Chart.min.js"></script>
        <script src="assets/js/pages/charts-chartjs.js"></script>  
      	<script src="assets/js/pages/profile.js"></script>
        <script>
  
 		var map;
 		
		function initMap() {
 			map = new google.maps.Map(document.getElementById('map-canvas'), {
 				center : {
 					lat : 37.494505,
 					lng : 127.028022
 				},
 				zoom : 8
 			});
 		<c:forEach items="${deviceVO}" var="device">
 		var marker${device.dano} = new google.maps.Marker({
 			position : {
 				lat : ${device.lat},
 				lng : ${device.lng}
 			},
 			map : map,
 			title : '${device.dano}'
 		});
 		openInfo(marker${device.dano});

 		</c:forEach>
 		};
 		function openInfo(markerName) {
 			console.log(markerName.title);
 			var contentString = '<div><a href="'+markerName.title+'">'+markerName.title+'</a></div>';
 			var infowindow = new google.maps.InfoWindow({
 				content : contentString
 			});
 			markerName.addListener('click', function() {
 				infowindow.open(map, markerName);
 			});
 		}
 		function makeMarker(name, markerLat, markerLng, markerTitle) {
 			var name = new google.maps.Marker({
 				position : {
 					lat : markerLat,
 					lng : markerLng
 				},
 				map : map,
 				title : markerTitle,
 			});
 		}

 		
 		$(document).ready(function(){
			
         $("body").attr("class","page-header-fixed page-sidebar-fixed");
         $("main").attr("class","page-content content-wrap full-height");
 
         

		});
        </script>
       	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCgODk3nW5Qg39325e8Tp1KAcoUCG5coaA&callback=initMap"  async defer></script>
        
</html>