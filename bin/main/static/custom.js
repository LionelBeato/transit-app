let map; 
function initMap(){

    map = new google.maps.Map(document.getElementById('map'), {
        center: { lat: parseFloat(busLocation[0].LATITUDE), lng: parseFloat(busLocation[0].LONGITUDE)},
        zoom: 15,
        scrollwheel: false, 
    });

    for (let i = 0; i < busLocation.length; i++){
        let marker = new google.maps.Marker({
            position: {lat: parseFloat(busLocation[i].LATITUDE), lng: parseFloat(busLocation[i].LONGITUDE)},
            map:map, 
        })
    }

}