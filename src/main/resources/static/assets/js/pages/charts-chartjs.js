$( document ).ready(function() {
	var sih = 4;
    var ctx1 = document.getElementById("chartGenderView").getContext("2d");
    var data1 = [
    	{
            value: 200,
            color:	"#f56954",
            highlight: "#F7AA9F",
            label: "Female"
        },
    	{
			value:	300,
			color: 	"#3c8dbc",
			highlight: "#7BABC7",
			label: "Male"
		}
    		
    ];
    
    function jpa(){
    	console.log("IT IS REAL?");
    }
    
    var myDoughnutChart = new Chart(ctx1).Doughnut(data1,{
        segmentShowStroke : true,
        segmentStrokeColor : "#fff",
        segmentStrokeWidth : 2,
        animationSteps : 100,
        animationEasing : "easeOutBounce",
        animateRotate : true,
        animateScale : false,
        responsive: true
    });
	
    var ctx2 = document.getElementById("chartAreaView").getContext("2d");
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
	var chart2 = new Chart(ctx2).Bar(data2, {
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
	});
    
    var ctx3 = document.getElementById("chartDateView").getContext("2d");
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
    var chart3 = new Chart(ctx3).Line(data3, {
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
    });
    
    var ctx4 = document.getElementById("chartAgeView").getContext("2d");
    var data4 = {
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
	var chart4 = new Chart(ctx4).Bar(data4, {
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
    	});
    
    var ctx5 = document.getElementById("chartTimeView").getContext("2d");
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
    var chart5 = new Chart(ctx5).Line(data5, {
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
        });
    
    var ctx6 = document.getElementById("chartAgeEmotion").getContext("2d");
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
	var chart6 = new Chart(ctx6).Bar(data6, {
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
    	});
    
    var ctx7 = document.getElementById("chartAgeGenderWatchtime").getContext("2d");
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
	var chart7 = new Chart(ctx7).Bar(data7, {
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
    	});
    
    
    var ctx8 = document.getElementById("chartEmotion").getContext("2d");
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
	var myRadarChart = new Chart(ctx8).Radar(data8, {
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
	});
    
    
});