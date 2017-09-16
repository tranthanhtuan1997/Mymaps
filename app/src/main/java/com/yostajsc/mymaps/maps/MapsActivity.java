package com.yostajsc.mymaps.maps;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.yostajsc.mymaps.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        initMapSetting();
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(21.4561997, 105.638867);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Cổng Trời, Tam Đảo"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng hoDa= new LatLng(10.8831827,106.7923195);
        mMap.addMarker(new MarkerOptions().position(hoDa).title("Maker in Hồ Đá, Dĩ An"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hoDa));

        LatLng NhaTrang= new LatLng(12.2594346,109.1064145);
        mMap.addMarker(new MarkerOptions().position(NhaTrang).title("Maker in Nha Trang"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(NhaTrang));

        LatLng CaMau= new LatLng(8.6069285,104.7185358);
        mMap.addMarker(new MarkerOptions().position(CaMau).title("Maker in Ca Mau"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CaMau));

        // vẽ đoạn thẳng từ lating tới lating
        mMap.addPolyline(new PolylineOptions().add(sydney,NhaTrang,hoDa,CaMau).color(Color.RED).width(5.0f));
        mMap.addPolyline(new PolylineOptions().add(sydney,CaMau).color(Color.RED).width(5.0f));

        //nói tất cả các điểm lại
        mMap.addPolygon(new PolygonOptions().add(sydney,NhaTrang,hoDa,CaMau).fillColor(Color.GREEN));

    }

    void initMapSetting(){
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);

        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setScrollGesturesEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);
    }
}
