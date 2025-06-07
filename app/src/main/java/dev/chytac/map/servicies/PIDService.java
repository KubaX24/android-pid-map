package dev.chytac.map.servicies;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import dev.chytac.map.Env;
import dev.chytac.map.entities.LineEntity;
import dev.chytac.map.entities.StationEntity;
import dev.chytac.map.entities.StopGroupResponse;
import dev.chytac.map.entities.TransitData;

public class PIDService {

    private static final String PID_API_URL = "https://api.golemio.cz/v2";
    private static final String STATIONS_URL = "https://data.pid.cz/stops/json/stops.json";

    private static final String TOKEN = Env.PID_API_TOKEN;

    public List<StationEntity> getStation() throws IOException {
        List<StationEntity> stations = new ArrayList<>();

        try (BufferedReader in = apiRequest(STATIONS_URL, false)) {
            StopGroupResponse stopGroupResponse = objectFromRequest(in, StopGroupResponse.class);

            for (StopGroupResponse.StopGroup stopGroup : stopGroupResponse.getStopGroups()) {
                for (StopGroupResponse.StopGroup.Stop stop : stopGroup.getStops()) {
                    String gtsIds = stop.getId();
                    if (!stop.getGtfsIds().isEmpty())
                        gtsIds = stop.getGtfsIds().get(0);

                    StationEntity station = new StationEntity(
                            gtsIds,
                            stop.getAltIdosName(),
                            stop.getPlatform(),
                            stop.getLat(),
                            stop.getLon(),
                            stopGroup.getCis(),
                            stop.getMainTrafficType()
                    );

                    stations.add(station);
                }
            }
        }

        return stations;
    }

    public List<LineEntity> getLines(String stationId) throws IOException {
        List<LineEntity> lines = new ArrayList<>();

        try (BufferedReader in = apiRequest(PID_API_URL + "/pid/departureboards?ids=" + stationId + "&limit=20", true)) {
            TransitData transitData = objectFromRequest(in, TransitData.class);

            for (TransitData.Departure departure : transitData.getDepartures()) {
                OffsetDateTime offsetDateTime = OffsetDateTime.parse(departure.getDeparture_timestamp().getScheduled());

                String lineType;
                switch (departure.getRoute().getType()) {
                    case 0:
                        lineType = "tram";
                        break;
                    case 1:
                        lineType = "metro";
                        break;
                    case 2:
                        lineType = "train";
                        break;
                    case 3:
                        lineType = "bus";
                        break;
                    case 4:
                        lineType = "ferry";
                        break;
                    case 7:
                        lineType = "trolleybus";
                        break;
                    default:
                        lineType = "other";
                        break;
                }

                LineEntity line = new LineEntity(
                        departure.getRoute().getShort_name(),
                        departure.getTrip().getHeadsign(),
                        offsetDateTime.toLocalDateTime(),
                        departure.getDelay().getMinutes(),
                        lineType
                );

                lines.add(line);
            }
        }

        return lines;
    }

    private BufferedReader apiRequest(String requestUrl, boolean needAuth) throws IOException {
        URL url = new URL(requestUrl);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");

        request.setRequestProperty("Content-Type", "application/json; charset=utf-8");

        if (needAuth)
            request.setRequestProperty("X-Access-Token", TOKEN);

        request.setRequestProperty("User-Agent", "SchoolApplication/v1");
        request.setRequestProperty("Accept", "application/json");

        return new BufferedReader(new InputStreamReader(request.getInputStream()));
    }

    private <T> T objectFromRequest(BufferedReader in, Class<T> clazz) throws IOException {
        StringBuffer response = new StringBuffer();

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        Gson gson = new Gson();
        return gson.fromJson(response.toString(), clazz);
    }
}
