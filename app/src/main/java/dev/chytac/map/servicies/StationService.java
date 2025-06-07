package dev.chytac.map.servicies;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;

import dev.chytac.map.entities.StationEntity;
import dev.chytac.map.entities.StationSaveEntity;

public class StationService {

    private static final String TAG = "StationService";

    private final PIDService pidService;
    private final Context ctx;

    private final Gson gson;

    public StationService(PIDService pidService, Context ctx) {
        this.pidService = pidService;
        this.ctx = ctx;

        this.gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    }

    public void loadStations() {
        try {
            File dir = new File(ctx.getFilesDir(), "stations");
            if(!dir.exists()){
                Log.d(TAG, "Creating stations directory");
                dir.mkdir();
            }

            File stationFile = new File(dir, "stations.json");
            if (!stationFile.exists()) {
                Log.d(TAG, "Creating stations file");
                stationFile.createNewFile();
            } else {
                Log.d(TAG, "Reading stations file");
                String json = FileUtils.readFileToString(stationFile, StandardCharsets.UTF_8);
                Log.d(TAG, json);
                StationSaveEntity stationSave = gson.fromJson(json, StationSaveEntity.class);
                Log.d(TAG, "Loaded " + stationSave.getStations().size() + " stations | Last update:" + stationSave.getTimestamp());

                if (!LocalDate.parse(stationSave.getTimestamp()).isBefore(LocalDate.now())) {
                    return;
                }
            }

            Log.d(TAG, "Loading stations to local storage");

            try (FileWriter writer = new FileWriter(stationFile)) {
                StationSaveEntity newStationSave = new StationSaveEntity(LocalDate.now().toString(), pidService.getStation());
                writer.append(gson.toJson(newStationSave));

                writer.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<StationEntity> getStation() {
        try {
            File dir = new File(ctx.getFilesDir(), "stations");
            if(!dir.exists())
                return List.of();

            File stationFile = new File(dir, "stations.json");
            if(!stationFile.exists())
                return List.of();

            String json = FileUtils.readFileToString(stationFile, StandardCharsets.UTF_8);

            StationSaveEntity stations = gson.fromJson(json, StationSaveEntity.class);

            if (stations == null)
                return List.of();

            return stations.getStations();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
