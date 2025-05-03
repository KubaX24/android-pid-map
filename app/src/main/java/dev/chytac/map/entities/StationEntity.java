package dev.chytac.map.entities;

public class StationEntity {

    String id;
    String name;
    String platform;
    double lat;
    double lng;
    int cis;
    String type;

    public StationEntity(String id, String name, String platform, double lat, double lng, int cis, String type) {
        this.id = id;
        this.name = name;
        this.platform = platform;
        this.lat = lat;
        this.lng = lng;
        this.cis = cis;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getCis() {
        return cis;
    }

    public void setCis(int cis) {
        this.cis = cis;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
