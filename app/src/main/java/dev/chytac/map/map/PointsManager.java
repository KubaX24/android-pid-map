package dev.chytac.map.map;

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

        TextView stationName = bottomSheetDialog.findViewById(R.id.station_name);
        stationName.setText(station.getName());

        for (int i = 0; i < 99; i++) {
            View line = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.mhd_layout, null);
            TextView lineId = line.findViewById(R.id.line_id);
            lineId.setOnClickListener(view -> {

            });

            TextView lineDelay = line.findViewById(R.id.line_delay);
            lineDelay.setText(LocalDate.now().toString());

            linearLayout.addView(line);
        }

        bottomSheetDialog.show();

        return true;
    }

    public SymbolOptions drawStation(StationEntity station) {
        Gson gson = new Gson();

        return new SymbolOptions()
                .withLatLng(new LatLng(station.getLat(), station.getLng()))
                .withIconImage("marker-bus")
                .withIconAnchor("center")
                .withData(gson.toJsonTree(station));
    }
}
