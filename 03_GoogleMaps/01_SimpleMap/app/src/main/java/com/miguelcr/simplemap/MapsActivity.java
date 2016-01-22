package com.miguelcr.simplemap;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.SphericalUtil;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    int counter = 1;
    LatLng lastPosition = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        // Wait to the map
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Event when user click on map
        mMap.setOnMapClickListener(this);

        // Type Map
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Different settings
        UiSettings settings = mMap.getUiSettings();
        settings.setZoomControlsEnabled(true);
        settings.setCompassEnabled(true);


        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(37.403957,-5.984155);


        mMap.addMarker(new MarkerOptions()
                        .position(sydney)
                        .title("You're here")
                        .snippet("37.403957,-5.984155")
                        .draggable(true)
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onMapClick(LatLng newPosition) {
        Marker myMarker = mMap.addMarker(new MarkerOptions()
                        .position(newPosition)
                        .title("Marker "+counter)
                        .snippet(newPosition.latitude+","+newPosition.longitude)
        );

        // If lastPostion is not equal null, whe can calculate
        // the distance
        if(lastPosition!=null) {
            double distance = SphericalUtil.computeDistanceBetween(lastPosition,newPosition);
            Toast.makeText(this,"Distance: "+Math.round(distance/1000)+" kilometers",Toast.LENGTH_SHORT).show();

            // Instantiates a new Polyline object and adds points to define a rectangle
            PolylineOptions rectOptions = new PolylineOptions()
                    .add(lastPosition)
                    .add(newPosition)
                    .color(Color.BLUE)
                    .width(3);

            Polyline polyline = mMap.addPolyline(rectOptions);

        }

        // We save this position like the lastPosition
        lastPosition = newPosition;

        myMarker.showInfoWindow();
        counter++;
    }

}
