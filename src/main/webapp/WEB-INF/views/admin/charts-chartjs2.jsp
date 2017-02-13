<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                                    <form action="#" method="GET">
                                        <div class="input-group">
                                            <input type="text" name="search" class="form-control input-search" placeholder="Search...">
                                            <span class="input-group-btn">
                                                <button class="btn btn-success" type="button"><i class="fa fa-search"></i></button>
                                            </span>
                                        </div><!-- Input Group -->
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div><!-- Row -->
                    <div class="row">
                        <div class="col-md-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Line Chart</h3>
                                </div>
                                <div class="panel-body">
                                    <div>
                                        <canvas id="chart1" height="150"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Bar Chart</h3>
                                </div>
                                <div class="panel-body">
                                    <div>
                                        <canvas id="chart2" height="150"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!-- Row -->
                    <div class="row">
                        <div class="col-md-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Pie Chart</h3>
                                </div>
                                <div class="panel-body">
                                    <div>
                                        <canvas id="chart3" height="150"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Doughnut Chart</h3>
                                </div>
                                <div class="panel-body">
                                    <div>
                                        <canvas id="chart4" height="150"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!-- Row -->
                    <div class="row">
                        <div class="col-md-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Polar Area Chart</h3>
                                </div>
                                <div class="panel-body">
                                    <div>
                                        <canvas id="chart5" height="150"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="panel panel-white">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Radar Chart</h3>
                                </div>
                                <div class="panel-body">
                                    <div>
                                        <canvas id="chart6" height="150"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!-- Row -->
                </div><!-- Main Wrapper -->
<!--                 <div class="page-footer">
                    <p class="no-s">2017 &copy; AD by KB141.</p>
                </div>
            </div>Page Inner
        </main>Page Content -->
      
	<%@include file="footer.jsp"%>
	
		<script>
		$("#chartActive").attr("class","active");
		</script>
        <!-- Javascripts -->
        <script src="/assets/plugins/chartsjs/Chart.min.js"></script>
        <script src="/assets/js/pages/charts-chartjs.js"></script>
        
    </body>
</html>