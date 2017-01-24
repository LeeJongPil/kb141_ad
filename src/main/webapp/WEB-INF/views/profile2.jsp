<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>        
<style>
     .col-centered{
        float: none;
        margin: auto;}
        </style>
         <div class="page-inner" style="min-height:1361px !important">
               
                <div id="main-wrapper">
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
                           <div class="panel panel-white">
                                <div class="panel-heading">
                                    <div class="panel-title">실험중인 광고이름</div>
                                </div>
                                <div class="panel-body">
                                	
                           		<blockquote>
                           			<p>Client  : KitKat</p>
                           			<p>Service :공유 컨텐츠를 통한 브랜드 인게이지먼트 강화 및 파티키트 경품 제공을 통해 2차 바이럴 유도 및 브랜드 경험 제공 </p>
                           			<p>D A T E : October, 2016</p>
                           			<p>U R L   : https://github.com/LeeJongPil/kb141_ad</p>
                           		</blockquote>
                                </div>
                            </div> 
                          </div>  
                            <div class="col-sm-12 col-lg-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h4 class="panel-title">기기 관리</h4>
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
                              <div class="profile-timeline">
                                <ul class="list-unstyled">
                                    <li class="timeline-item">
                                        <div class="panel panel-white">
                                        <div class="panel-heading">
                                                <h4 class="panel-title">동영상</h4>
                                            </div>
                                            <div class="panel-body col-centered">
                           					   <video width="500" height="400" controls>
												  <source src="assets/images/ad/Anger_School violence.mp4" type="video/mp4">
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
                                        <div class="panel panel-white">
                                        <div class="panel-heading">
                                                <h4 class="panel-title">포스터</h4>
                                            </div>
                                            <div class="panel-body">
                                              <img src ="assets/images/ad/Anger_School violence.png" style="height: 400px">
                                       		 </div>
                                       		 </div>
                                    </li>
                                </ul>
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
<!--                 <div class="page-footer"> -->
<!--                      <p class="no-s">2017 &copy; AD by KB141.</p> -->
<!--                 </div> -->
<!--             </div>Page Inner -->
<!--         </main>Page Content -->
		<%@include file="footer.jsp"%>
        <!-- Javascripts -->
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCzjeZ1lORVesmjaaFu0EbYeTw84t1_nek"></script>
       	<script src="assets/js/pages/profile.js"></script>
       	<script src="assets/plugins/chartsjs/Chart.min.js"></script>
        <script src="assets/js/pages/charts-chartjs.js"></script>  
        <script>

        $( document ).ready(function() {	
        $("body").attr("class","page-header-fixed page-sidebar-fixed");
        $("main").attr("class","page-content content-wrap full-height");
        });
        
        </script>   
    </body>
</html>