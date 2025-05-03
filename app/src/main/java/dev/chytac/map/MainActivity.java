package dev.chytac.map;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.maplibre.android.MapLibre;
import org.maplibre.android.maps.MapLibreMap;
import org.maplibre.android.maps.MapView;
import org.maplibre.android.maps.OnMapReadyCallback;

import dev.chytac.map.map.LocationPermission;
import dev.chytac.map.map.Map;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;

    private LocationPermission locationPermission;

    private Map map;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MapLibre.getInstance(this);

        this.getSupportActionBar().hide();

        LayoutInflater inflater = LayoutInflater.from(this);
        View rootView = inflater.inflate(R.layout.activity_main, null);
        setContentView(rootView);

        mapView = rootView.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this, R.style.BottomSheetTheme);
        View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.sheet_info, null);
        bottomSheetDialog.setContentView(sheetView);

        View loadingView = findViewById(R.id.loading_view);

        map = new Map(this, mapView, bottomSheetDialog, loadingView);

        locationPermission = new LocationPermission(this, mapView);
        locationPermission.checkPermissions();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        locationPermission.onRequestPermission(requestCode, permissions, grantResults);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onMapReady(@NonNull MapLibreMap maplibreMap) {
        map.onMapReady(maplibreMap);
    }
}