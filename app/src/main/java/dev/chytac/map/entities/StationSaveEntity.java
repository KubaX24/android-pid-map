package dev.chytac.map.entities;

import java.time.LocalDate;
import java.util.List;

public class StationSaveEntity {

    LocalDate timestamp;
    List<StationEntity> stations;

    public StationSaveEntity(LocalDate timestamp, List<StationEntity> stations) {
        this.timestamp = timestamp;
        this.stations = stations;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public List<StationEntity> getStations() {
        return stations;
    }

    public void setStations(List<StationEntity> stations) {
        this.stations = stations;
    }
}
