package dev.chytac.map.map;

import android.Manifest;
import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.maplibre.android.geometry.LatLng;
import org.maplibre.android.plugins.annotation.Symbol;
import org.maplibre.android.plugins.annotation.SymbolManager;
import org.maplibre.android.plugins.annotation.SymbolOptions;

import dev.chytac.map.MainActivity;
import dev.chytac.map.R;
import dev.chytac.map.entities.StationEntity;

public class PointsManager {

    private final Context context;
    private final BottomSheetDialog bottomSheetDialog;

    public PointsManager(Context context, BottomSheetDialog bottomSheetDialog) {
        this.context = context;
        this.bottomSheetDialog = bottomSheetDialog;
    }

    public boolean onPointClick(Symbol symbol) {
        LinearLayout linearLayout = bottomSheetDialog.findViewById(R.id.info_view);

        Gson gson = new Gson();
        StationEntity station = gson.fromJson(symbol.getData(), StationEntity.class);

        for (int i = 0; i < 99; i++) {
            View line = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.mhd_layout, null);
            TextView lineId = line.findViewById(R.id.line_id);
            lineId.setOnClickListener(view -> {

            });

            TextView lineDelay = line.findViewById(R.id.line_delay);
            lineDelay.setText("+" + i);

            linearLayout.addView(line);
        }

        bottomSheetDialog.show();

        return true;
    }

    public SymbolOptions drawPoint() {
        Gson gson = new Gson();

        return new SymbolOptions()
                .withLatLng(new LatLng(50.04213381478982, 14.485641370470034))
                .withIconImage("marker-pin")
                .withIconAnchor("bottom");
    }

    public SymbolOptions drawStation(StationEntity station) {
        Gson gson = new Gson();

        return new SymbolOptions()
                .withLatLng(new LatLng(station.getLat(), station.getLng()))
                .withIconImage("marker-pin")
                .withIconAnchor("bottom")
                .withData(gson.toJsonTree(station));
    }
}
