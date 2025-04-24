package dev.chytac.map.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;

import org.maplibre.android.location.LocationComponent;
import org.maplibre.android.location.LocationComponentActivationOptions;
import org.maplibre.android.location.LocationComponentOptions;
import org.maplibre.android.location.engine.LocationEngineRequest;
import org.maplibre.android.location.modes.CameraMode;
import org.maplibre.android.maps.MapLibreMap;
import org.maplibre.android.maps.MapView;
import org.maplibre.android.maps.Style;

public class CurrentLocation {

    private LocationComponent locationComponent = null;

    private final Context context;
    private final MapLibreMap mapLibreMap;

    public CurrentLocation(Context context, MapLibreMap mapLibreMap) {
        this.context = context;
        this.mapLibreMap = mapLibreMap;
    }

    @SuppressLint("MissingPermission")
    public void locationStyle(Style style) {
        locationComponent = mapLibreMap.getLocationComponent();

        LocationComponentOptions locationComponentOptions = LocationComponentOptions.builder(context).pulseEnabled(false).build();

        LocationComponentActivationOptions locationComponentActivationOptions = buildLocationComponentActivationOptions(style, locationComponentOptions);
        locationComponent.activateLocationComponent(locationComponentActivationOptions);
        locationComponent.setLocationComponentEnabled(true);
        locationComponent.setCameraMode(CameraMode.TRACKING);
    }

    private LocationComponentActivationOptions buildLocationComponentActivationOptions(Style style, LocationComponentOptions locationComponentOptions) {
        return LocationComponentActivationOptions
                .builder(context, style)
                .locationComponentOptions(locationComponentOptions)
                .useDefaultLocationEngine(true)
                .locationEngineRequest(
                        new LocationEngineRequest.Builder(750)
                                .setFastestInterval(750)
                                .setPriority(LocationEngineRequest.PRIORITY_HIGH_ACCURACY)
                                .build()
                )
                .build();
    }
}
