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
      <script src="assets/plugins/jquery/jquery-2.1.3.min.js"></script>
        <script>
        $( document ).ready(function() {
            function initialize() {
                var mapOptions = {
                    center: new google.maps.LatLng(37.494496,127.028014),
                    zoom: 15
                };
                var map = new google.maps.Map(document.getElementById('map-canvas'),  mapOptions); 
            }
            google.maps.event.addDomListener(window, 'load', initialize);
            

            
            
        });

        </script>

            
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
              
                
                  
     
              
		<%@include file="footer.jsp"%>
        <!-- Javascripts -->
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCzjeZ1lORVesmjaaFu0EbYeTw84t1_nek"></script>

       	<script src="assets/plugins/chartsjs/Chart.min.js"></script>
        <script src="assets/js/pages/charts-chartjs.js"></script>  
        <script>
		$(document).ready(function(){
			
         $("body").attr("class","page-header-fixed page-sidebar-fixed");
         $("main").attr("class","page-content content-wrap full-height");
 
		});
     
        	

            
        

        </script>   
    </body>
</html>