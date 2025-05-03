package dev.chytac.map.task;

import android.os.AsyncTask;
import android.view.View;

import org.maplibre.android.maps.MapLibreMap;
import org.maplibre.android.maps.MapView;
import org.maplibre.android.plugins.annotation.SymbolManager;

import java.util.List;

import dev.chytac.map.entities.StationEntity;
import dev.chytac.map.map.PointsManager;
import dev.chytac.map.servicies.StationService;

public class StationAsyncTask extends AsyncTask<Void, Void, Void> {

    private final StationService stationService;
    private final MapView mapView;
    private final MapLibreMap mapLibreMap;
    private final PointsManager pointsManager;
    private final View loadingView;

    public StationAsyncTask(StationService stationService, MapView mapView, MapLibreMap mapLibreMap, PointsManager pointsManager, View loadingView) {
        this.stationService = stationService;
        this.mapView = mapView;
        this.mapLibreMap = mapLibreMap;
        this.pointsManager = pointsManager;
        this.loadingView = loadingView;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        stationService.loadStations();
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        mapLibreMap.getStyle(style -> {
            SymbolManager symbolManager = new SymbolManager(mapView, mapLibreMap, style);

            List<StationEntity> stations = stationService.getStation();
            stations.forEach(station -> symbolManager.create(pointsManager.drawStation(station)));

            symbolManager.addClickListener(pointsManager::onPointClick);
            loadingView.setVisibility(View.GONE);
        });
    }
}
