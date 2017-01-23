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
                                    <p class="no-s">Simple, clean and engaging charts for designers and developers.</p>
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
<script src="assets/plugins/chartsjs/Chart.min.js" ></script>
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
    var data2 = {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [
            {
                label: "My First dataset",
                fillColor: "rgba(220,220,220,0.2)",
                strokeColor: "rgba(220,220,220,1)",
                pointColor: "rgba(220,220,220,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(220,220,220,1)",
                data: [65, 59, 80, 81, 56, 55, 40]
            },
            {
                label: "My Second dataset",
                fillColor: "rgba(34,186,160,0.2)",
                strokeColor: "rgba(34,186,160,1)",
                pointColor: "rgba(34,186,160,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(18,175,203,1)",
                data: [28, 48, 40, 19, 86, 27, 90]
            }
        ]
    };

	// Date / View
    var data3 = {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [
            {
                label: "My First dataset",
                fillColor: "rgba(220,220,220,0.2)",
                strokeColor: "rgba(220,220,220,1)",
                pointColor: "rgba(220,220,220,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(220,220,220,1)",
                data: [65, 59, 80, 81, 56, 55, 40]
            },
            {
                label: "My Second dataset",
                fillColor: "rgba(34,186,160,0.2)",
                strokeColor: "rgba(34,186,160,1)",
                pointColor: "rgba(34,186,160,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(18,175,203,1)",
                data: [28, 48, 40, 19, 86, 27, 90]
            }
        ]
    };

	// Age / View
    var data4 = {
            labels: ["10대", "20대", "30대", "40대", "50대", "60대", "70대"],
            datasets: [
//                 {
//                     label: "My First dataset",
//                     fillColor: "rgba(220,220,220,0.2)",
//                     strokeColor: "rgba(220,220,220,1)",
//                     pointColor: "rgba(220,220,220,1)",
//                     pointStrokeColor: "#fff",
//                     pointHighlightFill: "#fff",
//                     pointHighlightStroke: "rgba(220,220,220,1)",
//                     data: [65, 59, 80, 81, 56, 55, 40]
//                 },
                {
                    label: "My Second dataset",
                    fillColor: "rgba(34,186,160,0.2)",
                    strokeColor: "rgba(34,186,160,1)",
                    pointColor: "rgba(34,186,160,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(18,175,203,1)",
                    data: ${[data.view_age[0],data.view_age[1],data.view_age[2],
                    	data.view_age[3],data.view_age[4],data.view_age[5],
                    		data.view_age[6]]}
                }
            ]
        };

	// Time / View
    var data5 = {
            labels: ["January", "February", "March", "April", "May", "June", "July"],
            datasets: [
                {
                    label: "My First dataset",
                    fillColor: "rgba(220,220,220,0.2)",
                    strokeColor: "rgba(220,220,220,1)",
                    pointColor: "rgba(220,220,220,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(220,220,220,1)",
                    data: [65, 59, 80, 81, 56, 55, 40]
                },
                {
                    label: "My Second dataset",
                    fillColor: "rgba(34,186,160,0.2)",
                    strokeColor: "rgba(34,186,160,1)",
                    pointColor: "rgba(34,186,160,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(18,175,203,1)",
                    data: [28, 48, 40, 19, 86, 27, 90]
                }
            ]
        };

	// Age / Emotion
    var data6 = {
            labels: ["January", "February", "March", "April", "May", "June", "July"],
            datasets: [
                {
                    label: "My First dataset",
                    fillColor: "rgba(220,220,220,0.2)",
                    strokeColor: "rgba(220,220,220,1)",
                    pointColor: "rgba(220,220,220,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(220,220,220,1)",
                    data: [65, 59, 80, 81, 56, 55, 40]
                },
                {
                    label: "My Second dataset",
                    fillColor: "rgba(34,186,160,0.2)",
                    strokeColor: "rgba(34,186,160,1)",
                    pointColor: "rgba(34,186,160,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(18,175,203,1)",
                    data: [28, 48, 40, 19, 86, 27, 90]
                }
            ]
        };

	// Age, Gender / Watch Time
    var data7 = {
            labels: ["January", "February", "March", "April", "May", "June", "July"],
            datasets: [
                {
                    label: "My First dataset",
                    fillColor: "rgba(220,220,220,0.2)",
                    strokeColor: "rgba(220,220,220,1)",
                    pointColor: "rgba(220,220,220,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(220,220,220,1)",
                    data: [65, 59, 80, 81, 56, 55, 40]
                },
                {
                    label: "My Second dataset",
                    fillColor: "rgba(34,186,160,0.2)",
                    strokeColor: "rgba(34,186,160,1)",
                    pointColor: "rgba(34,186,160,1)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(18,175,203,1)",
                    data: [28, 48, 40, 19, 86, 27, 90]
                }
            ]
        };

	// Change Emotion
	var data8 = {
		labels: ["Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running"],
		datasets: [{
			label: "My First dataset",
			fillColor: "rgba(220,220,220,0.2)",
			strokeColor: "rgba(220,220,220,1)",
			pointColor: "rgba(220,220,220,1)",
			pointStrokeColor: "#fff",
			pointHighlightFill: "#fff",
			pointHighlightStroke: "rgba(220,220,220,1)",
			data: [65, 59, 90, 81, 56, 55, 40]
		},
		{
			label: "My Second dataset",
			fillColor: "rgba(18,175,203,0.2)",
			strokeColor: "rgba(18,175,203,1)",
			pointColor: "rgba(18,175,203,1)",
			pointStrokeColor: "#fff",
			pointHighlightFill: "#fff",
			pointHighlightStroke: "rgba(151,187,205,1)",
			data: [28, 48, 40, 19, 96, 27, 100]
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
			barShowStroke : true,
			barStrokeWidth : 2,
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
	var chart7 = new Chart(ctx7).Bar(data7, barAttribute);
	var chart8 = new Chart(ctx8).Radar(data8, radarAttribute);
	    
});


</script>
        
</body>
</html>