package dev.chytac.map.entities;

import java.time.LocalDateTime;

public class LineEntity {

    String id;
    String finalStation;
    LocalDateTime departure;

    /**
     * in minutes
     */
    int delay;

    public LineEntity(String id, String finalStation, LocalDateTime departure, int delay) {
        this.id = id;
        this.finalStation = finalStation;
        this.departure = departure;
        this.delay = delay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFinalStation() {
        return finalStation;
    }

    public void setFinalStation(String finalStation) {
        this.finalStation = finalStation;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
