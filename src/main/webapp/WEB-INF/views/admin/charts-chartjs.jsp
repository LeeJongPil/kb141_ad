<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

            <div class="page-inner" style="min-height:1361px !important">
                <div class="page-title">
                    <h3>Chart.js</h3>
                    <div class="page-breadcrumb">
                        <ol class="breadcrumb">
                            <li><a href="index.html">Home</a></li>
                            <li><a href="#">Charts</a></li>
                            <li class="active">Chart.js</li>
                        </ol>
                    </div>
                </div>
                <div id="main-wrapper">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-white">
                                <div class="panel-body">
                                    <p class="no-s">전체 광고 페이지입니다.</p>
                                </div>
                            </div>
                        </div>
                    </div><!-- Row -->
                    <div class="row">
                        <div class="col-md-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Gender / View</h3>
                                </div>
                                <div class="panel-body">
                                    <div>
                                        <canvas id="chartGenderView" height="150"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                         <div class="col-md-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Area / View</h3>
                                </div>
                                <div class="panel-body">
                                    <div>
                                        <canvas id="chartAreaView" height="150"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
					</div>
					 <div class="row">
					  <div class="col-md-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Date / View</h3>
                                </div>
                                <div class="panel-body">
                                    <div>
                                        <canvas id="chartDateView" height="150"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Age / View</h3>
                                </div>
                                <div class="panel-body">
                                    <div>
                                        <canvas id="chartAgeView" height="150"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
					</div>
					<div class="row">
					  <div class="col-md-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Time / View</h3>
                                </div>
                                <div class="panel-body">
                                    <div>
                                        <canvas id="chartTimeView" height="150"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Age / Emotion</h3>
                                </div>
                                <div class="panel-body">
                                    <div>
                                        <canvas id="chartAgeEmotion" height="150"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
					</div>
					<div class="row">
					  <div class="col-md-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Age, Gender / Watch Time</h3>
                                </div>
                                <div class="panel-body">
                                    <div>
                                        <canvas id="chartAgeGenderWatchtime" height="150"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Change Emotion</h3>
                                </div>
                                <div class="panel-body">
                                    <div>
                                        <canvas id="chartEmotion" height="150"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
					</div>
                </div><!-- Main Wrapper -->
	<%@include file="footer.jsp"%>
	
<!-- Javascripts -->
<script src="/assets/plugins/chartsjs/Chart.min.js" ></script>
<!-- <script src="assets/js/pages/charts-chartjs.js"></script> -->
<script>
$( document ).ready(function() {
	
	// Gender / View Chart
    var data1 = [
    	{
            value: ${data.male},
            color:	"#f56954",
            highlight: "#F7AA9F",
            label: "Female"
        },
    	{
			value:	${data.female},
			color: 	"#3c8dbc",
			highlight: "#7BABC7",
			label: "Male"
		}
    		
    ];
	
	// Area / View Chart
	var data2_labels = [<c:forEach items="${stategender}" var="i">"${i.city}",</c:forEach>]
	var data2_male = [<c:forEach items="${stategender}" var="i">"${i.log_area_male}",</c:forEach>]
	var data2_female = [<c:forEach items="${stategender}" var="i">"${i.log_area_female}",</c:forEach>]
	
    var data2 = {
        labels: data2_labels,
        datasets: [
            {
                label: "Male dataset",
                fillColor: "rgba(123,171,199,0.2)",
                strokeColor: "rgba(123,171,199,1)",
                pointColor: "rgba(123,171,199,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(123,171,199,1)",
                data: data2_male
            },
            {
                label: "Female dataset",
                fillColor: "rgba(247,170,159,0.2)",
                strokeColor: "rgba(247,170,159,1)",
                pointColor: "rgba(247,170,159,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(247,170,159,1)",
                data: data2_female
            }
        ]
    };

	// Date / View
	var data3_data = [<c:forEach items="${data.view_date}" var="i">${i},</c:forEach>];
	
    var data3 = {
        labels: ["어제", "이틀 전", "3일 전", "4일 전", "5일 전", "6일 전", "일주일 전"],
        datasets: [
            {
                label: "My Second dataset",
                fillColor: "rgba(34,186,160,0.2)",
                strokeColor: "rgba(34,186,160,1)",
                pointColor: "rgba(34,186,160,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(18,175,203,1)",
                data: data3_data
            }
        ]
    };

	// Age / View
	var data4_data = [<c:forEach items="${data.view_age}" var="i">${i},</c:forEach>];
    var data4 = {
            labels: ["10대", "20대", "30대", "40대", "50대", "60대", "70대"],
            datasets: [
                {
                    label: "My Second dataset",
                    fillColor: "rgba(34,186,160,0.2)",
                    strokeColor: "rgba(34,186,160,1)",
                    pointColor: "rgba(34,186,160,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(18,175,203,1)",
                    data: data4_data
                }
            ]
        };

	// Time / View
	
	var data5_labels = new Array();
	for(var i = 0 ; i < 24 ; i++){
		data5_labels.push(i + " 시");
	}
	var data5_data = [<c:forEach items="${data.view_time}" var="i">${i},</c:forEach>];
	
    var data5 = {
            labels: data5_labels,
            datasets: [
                {
                    label: "My Second dataset",
                    fillColor: "rgba(34,186,160,0.2)",
                    strokeColor: "rgba(34,186,160,1)",
                    pointColor: "rgba(34,186,160,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(18,175,203,1)",
                    data: data5_data
                }
            ]
        };

	// Age / Emotion
	var data6_male = [<c:forEach items="${data.emotion_positive_male}" var="i">${i},</c:forEach>];
	var data6_female = [<c:forEach items="${data.emotion_positive_female}" var="i">${i},</c:forEach>];
	
    var data6 = {
            labels: ["Anger", "Contempt", "Disgust", "Fear", "Happiness", "Neutral", "Sadness", "Surprise"],
            datasets: [
                {
                    label: "My First dataset",
                    fillColor: "rgba(123,171,199,0.2)",
                    strokeColor: "rgba(123,171,199,1)",
                    pointColor: "rgba(123,171,199,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(123,171,199,1)",
                    data: data6_male
                },
                {
                    label: "My Second dataset",
                    fillColor: "rgba(247,170,159,0.2)",
                    strokeColor: "rgba(247,170,159,1)",
                    pointColor: "rgba(247,170,159,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(247,170,159,1)",
                    data: data6_female
                }
            ]
        };

	// Age, Gender / Watch Time
	
	var data7_labels = new Array();
	for(var i = 0 ; i < 20 ; i ++) {
		data7_labels.push(i + 1);
	}
	
	var data7_male = [<c:forEach items="${data.view_watchtime_male}" var="i">${i},</c:forEach>];
	var data7_female = [<c:forEach items="${data.view_watchtime_female}" var="i">${i},</c:forEach>];
	
    var data7 = {
            labels:data7_labels,
            datasets: [
                {
                    label: "My First dataset",
                    fillColor: "rgba(123,171,199,0.2)",
                    strokeColor: "rgba(123,171,199,1)",
                    pointColor: "rgba(123,171,199,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(123,171,199,1)",
                    data: data7_male
                },
                {
                    label: "My Second dataset",
                    fillColor: "rgba(247,170,159,0.2)",
                    strokeColor: "rgba(247,170,159,1)",
                    pointColor: "rgba(247,170,159,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(247,170,159,1)",
                    data: data7_female
                }
            ]
        };

	// Change Emotion
	// anger contempt disgust fear happiness neutral sadness surprise
	var data8_negative =  [<c:forEach items="${data.emotion_negative}" var="i">${i},</c:forEach>];
	var data8_positive =  [<c:forEach items="${data.emotion_positive}" var="i">${i},</c:forEach>];
	
	var data8 = {
		labels: ["Anger", "Contempt", "Disgust", "Fear", "Happiness", "Neutral", "Sadness", "Surprise"],
		datasets: [{
			label: "My First dataset",
			fillColor: "rgba(220,220,220,0.2)",
			strokeColor: "rgba(220,220,220,1)",
			pointColor: "rgba(220,220,220,1)",
			pointStrokeColor: "#fff",
			pointHighlightFill: "#fff",
			pointHighlightStroke: "rgba(220,220,220,1)",
			data: data8_negative
		},
		{
			label: "My Second dataset",
			fillColor: "rgba(18,175,203,0.2)",
			strokeColor: "rgba(18,175,203,1)",
			pointColor: "rgba(18,175,203,1)",
			pointStrokeColor: "#fff",
			pointHighlightFill: "#fff",
			pointHighlightStroke: "rgba(151,187,205,1)",
			data: data8_positive
		}
		]};

	
	
	// CHART 생성
	var doughnutAttribute = {
	        segmentShowStroke : true,
	        segmentStrokeColor : "#fff",
	        segmentStrokeWidth : 2,
	        animationSteps : 100,
	        animationEasing : "easeOutBounce",
	        animateRotate : true,
	        animateScale : false,
	        responsive: true
	    };
	
	var barAttribute = {
			scaleBeginAtZero : true,
			scaleShowGridLines : true,
			scaleGridLineColor : "rgba(0,0,0,.05)",
			scaleGridLineWidth : 1,
			scaleShowHorizontalLines: true,
			scaleShowVerticalLines: true,
			scaleYaxesStacked : true,
			barShowStroke : true,
			barStrokeWidth : 1,
			barDatasetSpacing : 1,
			responsive: true
		};
	
	var lineAttribute = {
	        scaleShowGridLines : true,
	        scaleGridLineColor : "rgba(0,0,0,.05)",
	        scaleGridLineWidth : 1,
	        scaleShowHorizontalLines: true,
	        scaleShowVerticalLines: true,
	        bezierCurve : true,
	        bezierCurveTension : 0.4,
	        pointDot : true,
	        pointDotRadius : 4,
	        pointDotStrokeWidth : 1,
	        pointHitDetectionRadius : 20,
	        datasetStroke : true,
	        datasetStrokeWidth : 2,
	        datasetFill : true,
	        responsive: true
	    }

	
	var radarAttribute = {
			scaleShowLine : true,
			angleShowLineOut : true,
			scaleShowLabels : false,
			scaleBeginAtZero : true,
			angleLineColor : "rgba(0,0,0,.1)",
			angleLineWidth : 1,
			pointLabelFontFamily : "'Arial'",
			pointLabelFontStyle : "normal",
			pointLabelFontSize : 10,
			pointLabelFontColor : "#666",
			pointDot : true,
			pointDotRadius : 3,
			pointDotStrokeWidth : 1,
			pointHitDetectionRadius : 20,
			datasetStroke : true,
			datasetStrokeWidth : 2,
			datasetFill : true,
			responsive: true
		}
		
    var ctx1 = document.getElementById("chartGenderView").getContext("2d");
    var ctx2 = document.getElementById("chartAreaView").getContext("2d");
    var ctx3 = document.getElementById("chartDateView").getContext("2d");
    var ctx4 = document.getElementById("chartAgeView").getContext("2d");
    var ctx5 = document.getElementById("chartTimeView").getContext("2d");
    var ctx6 = document.getElementById("chartAgeEmotion").getContext("2d");
    var ctx7 = document.getElementById("chartAgeGenderWatchtime").getContext("2d");    
    var ctx8 = document.getElementById("chartEmotion").getContext("2d");
    
    var chart1 = new Chart(ctx1).Doughnut(data1,doughnutAttribute);
	var chart2 = new Chart(ctx2).Bar(data2, barAttribute);
    var chart3 = new Chart(ctx3).Line(data3, lineAttribute);
	var chart4 = new Chart(ctx4).Bar(data4, barAttribute);
    var chart5 = new Chart(ctx5).Line(data5, lineAttribute);
	var chart6 = new Chart(ctx6).Bar(data6,barAttribute);
	var chart7 = new Chart(ctx7).Line(data7, lineAttribute);
	var chart8 = new Chart(ctx8).Radar(data8, radarAttribute);
	    
});


</script>
        
</body>
</html>