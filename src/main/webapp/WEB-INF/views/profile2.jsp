<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>        
         <div class="page-inner" style="min-height:1361px !important">
                <div class="profile-cover">
                	<img src="assets/images/capture2.png" style="height: 335px"> 
	                    <div class="row">
	                        <div class="col-md-12 profile-info">
	                            <div class=" profile-info-value">
	                                <h3>1020명</h3>
	                                <p>오늘본 수</p>
	                            </div>
	                            <div class=" profile-info-value">
	                                <h3>강남구</h3>
	                                <p>장소</p>
	                            </div>
	                        </div>
	                    </div>
	                </div>
                <div id="main-wrapper">
                    <div class="row">
                    	<div class="col-md-6">
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
                        <div class="col-md-6">
                           <div class="panel panel-white">
                                <div class="panel-heading">
                                    <div class="panel-title">실험중인 광고이름</div>
                                </div>
                                <div class="panel-body">
                                	
                           		<blockquote>
                           			<p>Client  : KitKat</p>
                           			<p>Service : 12월 시즌이슈에 맞춰 친구와 함께 연말 홈파티를 즐길 수 있는 키트 제작. 친구와 함께 즐길 수 있는 키트를 신청하는 과정에서 친구에게 어울리는 애칭을 짓도록하여 친구의 애칭을 킷캣 키비쥬얼과 함께 공유하도록함. 공유 컨텐츠를 통한 브랜드 인게이지먼트 강화 및 파티키트 경품 제공을 통해 2차 바이럴 유도 및 브랜드 경험 제공 </p>
                           	
                           			<p>D A T E : October, 2016</p>
                           			<p>U R L   : https://github.com/LeeJongPil/kb141_ad</p>
                           		</blockquote>
                                </div>
                            </div> 
                          </div>  
                          </div>
                          <div class="row">  
                         
                            <div class="col-md-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h4 class="panel-title">기기 관리</h4>
                                    <div class="panel-control">
                                        <a href="javascript:void(0);" data-toggle="tooltip" data-placement="top" title="Reload" class="panel-reload"><i class="icon-reload"></i></a>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <div class="weather-widget">
                                        <div class="row">
                        <div class="panel panel-white">
                                            <div class="panel-body">
                                                <div class="timeline-item-header">
                                                    <p>기기 관리 <span><small>기기관리 현황</small></span></p>
                                                    <small>6 hours ago</small>
                                                </div>
                                                <div class="timeline-item-post">
                                                    <div id="map-canvas" style="height: 200px; width: 100%;"></div>
                                                </div>
                                            </div>
                                        </div>
                    
                                        </div>
                                    </div>
                                </div>
                            </div>
                          </div>
                          
                          <div class="col-md-6">
                            <div class="profile-timeline">
                                <ul class="list-unstyled">
                                    <li class="timeline-item">
                                        <div class="panel panel-white">
                                            <div class="panel-body">
                                                <div class="timeline-item-header well">
                                                    <img src="assets/images/avatar3.png" alt="">
                                                    <p>광고 리스트 <span>/ 광고 주제</span></p> <small>5 hours ago</small>
		                                                <div class="timeline-item-post">
		                                                    <p>Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam id dolor id nibh ultricies vehicula.</p>
		                                                </div>
                                                </div>
                                                
                                                 <div class="timeline-item-header well">
                                                    <img src="assets/images/avatar3.png" alt="">
                                                    <p>광고 리스트 <span>/ 광고 주제</span></p> <small>5 hours ago</small>
		                                                <div class="timeline-item-post">
		                                                    <p>Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam id dolor id nibh ultricies vehicula.</p>
		                                                </div>
                                                </div>
                                   
                                                                                     <div class="timeline-item-header">
                            
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
    </body>
</html>