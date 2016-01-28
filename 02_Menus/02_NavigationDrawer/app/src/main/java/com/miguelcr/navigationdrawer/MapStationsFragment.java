package com.miguelcr.navigationdrawer;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapStationsFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap map;
    MapView mapView;

    public MapStationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_map_stations, container, false);


        // Gets the MapView from the XML layout and creates it
        mapView = (MapView) v.findViewById(R.id.mapview);
        mapView.onCreate(savedInstanceState);

        // Gets to GoogleMap from the MapView and does initialization stuff
        mapView.getMapAsync(this);


        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        map = googleMap;

        List<Station> stations = new ArrayList<Station>();


        stations.add(new Station("Ciudad Expo", true, false, true, false, 1, R.drawable.bus,37.349044,-6.052067));
        stations.add(new Station("Cavaleri", false, false, false, false, 1, R.drawable.bus, 37.35329,-6.047084));
        stations.add(new Station("San Juan Alto", true, false, true, false, 1, R.drawable.bus, 37.36156,-6.038654));
        stations.add(new Station("San Juan Bajo", true, false, true, false, 1, R.drawable.bus, 37.366877,-6.025213));
        stations.add(new Station("Blas Infante", false, false, false, false, 2, R.drawable.bus, 37.373085,-6.010634));
        stations.add(new Station("Parque de los Principes", true, false, false, false, 2, R.drawable.bus, 37.376746,-6.004056));
        stations.add(new Station("Plaza de Cuba", false, false, false, false, 2, R.drawable.bus, 37.379097,-5.999723));
        stations.add(new Station("Puerta Jerez", false, false, false, false, 2, R.drawable.bus, 37.38191,-5.994083));
        stations.add(new Station("Prado de San Sebastian", true, true, false, false, 2, R.drawable.bus,37.380622,-5.987242 ));
        stations.add(new Station("San Bernardo", true, true, false, false, 2, R.drawable.bus, 37.378308,-5.97915));
        stations.add(new Station("Nervion", false, false, false, false, 2, R.drawable.bus, 37.382998,-5.974172));
        stations.add(new Station("Gran Plaza", true, false, false, false, 2, R.drawable.bus, 37.381552,-5.966663));
        stations.add(new Station("1 de Mayo", false, false, false, false, 2, R.drawable.bus, 37.380672,-5.955591));
        stations.add(new Station("Amate", false, false, false, false, 2, R.drawable.bus, 37.375743,-5.952756));
        stations.add(new Station("La Plata", false, false, false, false, 2, R.drawable.bus, 37.371373,-5.951593));
        stations.add(new Station("Cocheras", false, false, false, false, 2, R.drawable.bus, 37.36754,-5.950414));
        stations.add(new Station("Guadaira", false, false, false, false, 2, R.drawable.bus, 37.360194,-5.94617));
        stations.add(new Station("Pablo de Olavide", true, false, false, false, 3, R.drawable.bus, 37.353701,-5.942992));
        stations.add(new Station("Condequinto", false, false, true, false, 3, R.drawable.bus, 37.346398,-5.936302));
        stations.add(new Station("Montequinto", false, false, false, false, 3, R.drawable.bus, 37.342196,-5.934526));
        stations.add(new Station("Europa", false, false, false, false, 3, R.drawable.bus, 37.337521,-5.935105));
        stations.add(new Station("Olivar de Quintos", true, false, true, false, 2, R.drawable.bus, 37.328978,-5.938653));

        LatLng position = null;

        for(int i=0; i<stations.size(); i++) {
            Station currentStation = stations.get(i);

            int circleColor = Color.RED;
            switch (currentStation.getZone()) {
                case 1: circleColor = Color.RED; break;
                case 2: circleColor = Color.GREEN; break;
                case 3: circleColor = Color.YELLOW; break;
            }

            if(position!=null) {
                PolylineOptions rectOptions = new PolylineOptions()
                        .add(position)
                        .color(circleColor)
                        .add(new LatLng(currentStation.getLat(), currentStation.getLon())); // Closes the polyline.

                map.addPolyline(rectOptions);
            }

            position = new LatLng(currentStation.getLat(),currentStation.getLon());
            map.addMarker(new MarkerOptions().position(position).title(currentStation.getName()));



            CircleOptions circleOptions = new CircleOptions()
                    .center(position)
                    .strokeColor(circleColor)
                    .radius(50);

            Circle circle = map.addCircle(circleOptions);
        }


        // At the center map with the last station position
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 13));
    }


    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
