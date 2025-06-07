package dev.chytac.map.entities;

import java.time.LocalDate;
import java.util.List;

public class StationSaveEntity {

    String timestamp;
    List<StationEntity> stations;

    public StationSaveEntity(String timestamp, List<StationEntity> stations) {
        this.timestamp = timestamp;
        this.stations = stations;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<StationEntity> getStations() {
        return stations;
    }

    public void setStations(List<StationEntity> stations) {
        this.stations = stations;
    }
}
