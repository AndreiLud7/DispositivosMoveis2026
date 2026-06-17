package com.example.gps;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.config.Configuration;


public class MainActivity extends AppCompatActivity {
    LocationManager locationManager;
    MapView map;
    TextView tv;
    Marker marcadordorPosicaoAtual;

    @SuppressLint("serviceCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textview);
        map = findViewById(R.id.map);

        Configuration.getInstance().setUserAgentValue(getPackageName());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mapInit();
        checklocationPermission();

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER ,0, 0,location -> {
            tv.setText("Latidude"+ location.getLatitude() + "longitude" +location.getLongitude() + "velocidade = " + location.getSpeed());

            showLocationonMap(location);

        });

    }
    public void checklocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
    }
        public void mapInit() {
            map.setMultiTouchControls(true);
            map.getController().setZoom(16.0);
            map.setTileSource(TileSourceFactory.MAPNIK);

        }

        public void showLocationonMap(Location location) {
            double latidude = location.getLatitude();
            double longitude = location.getLongitude();
            GeoPoint mlocation = new GeoPoint( latidude , longitude);
            map.getController().setCenter(mlocation);

            if(marcadordorPosicaoAtual == null){
                marcadordorPosicaoAtual = new Marker(map);
        }
            marcadordorPosicaoAtual.setPosition(mlocation);
            marcadordorPosicaoAtual.setTitle("minha localizacao");
            map.getOverlays().clear();
            map.getOverlays().add(marcadordorPosicaoAtual);

    }

}