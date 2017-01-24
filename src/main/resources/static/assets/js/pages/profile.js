$( document ).ready(function() {
    function initMap() {
        var mapOptions = {
            center: new google.maps.LatLng(37.494496,127.028014),
            zoom: 15
        };
        var map = new google.maps.Map(document.getElementById('map-canvas'),  mapOptions); 
    }
    google.maps.event.addDomListener(window, 'load', initMap);
    
});
