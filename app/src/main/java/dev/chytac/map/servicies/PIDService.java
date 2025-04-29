package dev.chytac.map.servicies;

import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import dev.chytac.map.entities.StationCollection;
import dev.chytac.map.entities.StationEntity;

public class PIDService {

    private static final String API_URL = "https://api.golemio.cz/v2";

    //TODO remove before push
    private static final String TOKEN = "";

    public List<StationEntity> getStation() throws IOException {
        String departureBoardUrl = "/gtfs/stops";

        List<StationEntity> stations = new ArrayList<>();

        try (BufferedReader in = apiRequest(departureBoardUrl)) {
            StringBuffer response = new StringBuffer();

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            Gson gson = new Gson();
            StationCollection stationCollection = gson.fromJson(response.toString(), StationCollection.class);

            Log.d("PIDService", "Loaded " + stationCollection.getFeatures().size() + " stations");

            for (StationCollection.Feature feature : stationCollection.getFeatures()) {
                if (feature.getProperties().getStop_name() == null)
                    continue;

                StationEntity station = new StationEntity(
                        feature.getProperties().getStop_id(),
                        feature.getProperties().getStop_name(),
                        feature.getProperties().getPlatform_code(),
                        feature.getGeometry().getCoordinates().get(1),
                        feature.getGeometry().getCoordinates().get(0)
                );

                stations.add(station);
            }
        }

        return stations;
    }

    private BufferedReader apiRequest(String requestUrl) throws IOException {
        URL url = new URL(API_URL + requestUrl);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");

        request.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        request.setRequestProperty("X-Access-Token", TOKEN);
        request.setRequestProperty("User-Agent", "SchoolApplication/v1");
        request.setRequestProperty("Accept", "application/json");

        return new BufferedReader(new InputStreamReader(request.getInputStream()));
    }
}
