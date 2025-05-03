package dev.chytac.map.entities;

import java.time.LocalDateTime;

public class LineEntity {

    String name;
    String finalStation;
    LocalDateTime departure;

    /**
     * in minutes
     */
    int delay;

    String type;

    public LineEntity(String name, String finalStation, LocalDateTime departure, int delay, String type) {
        this.name = name;
        this.finalStation = finalStation;
        this.departure = departure;
        this.delay = delay;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
