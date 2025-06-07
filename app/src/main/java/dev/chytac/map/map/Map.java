package dev.chytac.map.map;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.maplibre.android.camera.CameraPosition;
import org.maplibre.android.geometry.LatLng;
import org.maplibre.android.maps.MapLibreMap;
import org.maplibre.android.maps.MapView;
import org.maplibre.android.plugins.annotation.SymbolManager;
import org.maplibre.android.utils.BitmapUtils;

import java.util.List;

import dev.chytac.map.Env;
import dev.chytac.map.MainActivity;
import dev.chytac.map.R;
import dev.chytac.map.entities.StationEntity;
import dev.chytac.map.notification.NotificationAppManager;
import dev.chytac.map.servicies.PIDService;
import dev.chytac.map.servicies.StationService;
import dev.chytac.map.task.StationAsyncTask;

public class Map  {

    private static final String STYLE_URL = Env.MAPTILER_URL;

    private final MapView mapView;
    private final Context context;
    private final BottomSheetDialog bottomSheetDialog;

    private final StationService stationService;
    private final PIDService pidService;

    private final NotificationAppManager notificationManager;

    private final View loadingView;

    public Map(Context context, MapView mapView, BottomSheetDialog bottomSheetDialog, View loadingView, NotificationAppManager notificationManager) {
        this.context = context;
        this.mapView = mapView;
        this.bottomSheetDialog = bottomSheetDialog;
        this.loadingView = loadingView;

        this.notificationManager = notificationManager;

        this.pidService = new PIDService();
        this.stationService = new StationService(pidService, context);
    }

    public void onMapReady(@NonNull MapLibreMap mapLibreMap) {
        CurrentLocation currentLocation = new CurrentLocation(context, mapLibreMap);
        PointsManager pointsManager = new PointsManager(context, bottomSheetDialog, notificationManager);
        StationAsyncTask stationAsyncTask = new StationAsyncTask(stationService, mapView, mapLibreMap, pointsManager, loadingView);

        stationAsyncTask.execute();

        mapLibreMap.setStyle(STYLE_URL, style -> {
            Drawable busDrawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.bus, null);
            Drawable tramDrawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.tram, null);
            Drawable trainDrawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.train_s, null);
            Drawable metroDrawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.metro, null);
            Drawable pidDrawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.pid, null);

            currentLocation.locationStyle(style);

            style.addImage("marker-bus", BitmapUtils.getBitmapFromDrawable(busDrawable));
            style.addImage("marker-tram", BitmapUtils.getBitmapFromDrawable(tramDrawable));
            style.addImage("marker-train", BitmapUtils.getBitmapFromDrawable(trainDrawable));
            style.addImage("marker-metro", BitmapUtils.getBitmapFromDrawable(metroDrawable));
            style.addImage("marker-pid", BitmapUtils.getBitmapFromDrawable(pidDrawable));
        });

        mapLibreMap.setMinZoomPreference(13.0);
        mapLibreMap.setCameraPosition(new CameraPosition.Builder().target(new LatLng(0.0, 0.0)).zoom(14.0).build());
    }
}
