package dev.chytac.map.map;

import android.app.NotificationManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;

import org.maplibre.android.geometry.LatLng;
import org.maplibre.android.plugins.annotation.Symbol;
import org.maplibre.android.plugins.annotation.SymbolOptions;

import java.time.LocalDate;

import dev.chytac.map.R;
import dev.chytac.map.entities.StationEntity;
import dev.chytac.map.notification.NotificationAppManager;
import dev.chytac.map.task.DepartureAsyncTask;

public class PointsManager {

    private final Context context;
    private final BottomSheetDialog bottomSheetDialog;

    private final NotificationAppManager notificationManager;

    public PointsManager(Context context, BottomSheetDialog bottomSheetDialog, NotificationAppManager notificationManager) {
        this.context = context;
        this.bottomSheetDialog = bottomSheetDialog;
        this.notificationManager = notificationManager;
    }

    public boolean onPointClick(Symbol symbol) {
        Gson gson = new Gson();
        StationEntity station = gson.fromJson(symbol.getData(), StationEntity.class);

        TextView stationName = bottomSheetDialog.findViewById(R.id.station_name);
        stationName.setText(station.getName());

        LinearLayout linesLayout = bottomSheetDialog.findViewById(R.id.lines_view);
        linesLayout.removeAllViews();

        DepartureAsyncTask departureAsyncTask = new DepartureAsyncTask(station, linesLayout, context, notificationManager);
        departureAsyncTask.execute();

        bottomSheetDialog.show();

        return true;
    }

    public SymbolOptions drawStation(StationEntity station) {
        Gson gson = new Gson();
        String icon = "marker-pid";

        switch (station.getType()) {
            case "bus":
                icon = "marker-bus";
                break;
            case "tram":
                icon = "marker-tram";
                break;
            case "train":
                icon = "marker-train";
                break;
        }

        if (station.getType().contains("metro")) {
            icon = "marker-metro";
        }

        return new SymbolOptions()
                .withLatLng(new LatLng(station.getLat(), station.getLng()))
                .withIconImage(icon)
                .withIconAnchor("center")
                .withData(gson.toJsonTree(station));
    }
}
