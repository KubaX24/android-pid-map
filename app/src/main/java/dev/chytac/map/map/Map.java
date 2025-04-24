package dev.chytac.map.map;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.maplibre.android.camera.CameraPosition;
import org.maplibre.android.geometry.LatLng;
import org.maplibre.android.maps.MapLibreMap;
import org.maplibre.android.maps.MapView;
import org.maplibre.android.plugins.annotation.SymbolManager;
import org.maplibre.android.utils.BitmapUtils;

import dev.chytac.map.R;
import dev.chytac.map.entities.StationEntity;

public class Map  {

    private static final String STYLE_URL = "";

    private final MapView mapView;
    private final Context context;
    private final BottomSheetDialog bottomSheetDialog;

    public Map(Context context, MapView mapView, BottomSheetDialog bottomSheetDialog) {
        this.context = context;
        this.mapView = mapView;
        this.bottomSheetDialog = bottomSheetDialog;
    }

    public void onMapReady(@NonNull MapLibreMap mapLibreMap) {
        CurrentLocation currentLocation = new CurrentLocation(context, mapLibreMap);
        PointsManager pointsManager = new PointsManager(context, bottomSheetDialog);

        mapLibreMap.setStyle(STYLE_URL, style -> {
            Drawable pinDrawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.pin, null);

            currentLocation.locationStyle(style);

            style.addImage("marker-pin", BitmapUtils.getBitmapFromDrawable(pinDrawable));

            SymbolManager symbolManager = new SymbolManager(mapView, mapLibreMap, style);

            StationEntity station = new StationEntity("1s12d", 50.04213381478982, 14.485641370470034);
            symbolManager.create(pointsManager.drawStation(station));

            symbolManager.addClickListener(pointsManager::onPointClick);
        });

        mapLibreMap.setCameraPosition(new CameraPosition.Builder().target(new LatLng(0.0, 0.0)).zoom(14.0).build());
    }
}
