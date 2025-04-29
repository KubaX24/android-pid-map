package dev.chytac.map.map;

import android.widget.Toast;

import org.maplibre.android.location.permissions.PermissionsListener;
import org.maplibre.android.location.permissions.PermissionsManager;
import org.maplibre.android.maps.MapView;

import java.util.List;

import dev.chytac.map.MainActivity;

public class LocationPermission {

    private PermissionsManager permissionsManager = null;

    private final MainActivity mainActivity;
    private final MapView mapView;

    public LocationPermission(MainActivity mainActivity, MapView mapView) {
        this.mainActivity = mainActivity;
        this.mapView = mapView;
    }

    public void checkPermissions() {
        if (PermissionsManager.areLocationPermissionsGranted(mainActivity)) {
            mapView.getMapAsync(mainActivity);
        } else {
            permissionsManager = new PermissionsManager(new PermissionsListener() {
                @Override
                public void onExplanationNeeded(List<String> list) {
                    Toast.makeText(mainActivity,"You need to accept location permissions.", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onPermissionResult(boolean granted) {
                    if (granted) {
                        mapView.getMapAsync(mainActivity);
                    }
                }
            });

            permissionsManager.requestLocationPermissions(mainActivity);
        }
    }

    public void onRequestPermission(int requestCode, String[] permissions, int[] grantResults) {
        permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
