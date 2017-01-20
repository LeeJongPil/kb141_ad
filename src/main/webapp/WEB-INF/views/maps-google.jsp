<%@include file="header.jsp"%>
            <div class="page-inner full-height">
                <div id="map-canvas" style="height: 100%; width: 100%;"></div>
<!--                 <div class="page-footer">
                       <p class="no-s">2017 &copy; AD by KB141.</p>
                </div>
            </div>Page Inner
        </main>Page Content -->
    
	<%@include file="footer.jsp"%>

        <!-- Javascripts -->
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCzjeZ1lORVesmjaaFu0EbYeTw84t1_nek"></script>
        <script src="assets/js/pages/maps-google.js"></script>
        <script>
        $( document ).ready(function() {	
        $("body").attr("class","page-header-fixed page-sidebar-fixed");
        $("main").attr("class","page-content content-wrap full-height");
        });
        </script>
    </body>
</html>