package dev.chytac.map.task;

import android.os.AsyncTask;

import dev.chytac.map.servicies.StationService;

public class StationAsyncTask extends AsyncTask<Void, Void, Void> {

    private final StationService stationService;

    public StationAsyncTask(StationService stationService) {
        this.stationService = stationService;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        stationService.loadStations();

        return null;
    }
}
