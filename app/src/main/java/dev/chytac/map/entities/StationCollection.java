package dev.chytac.map.entities;

import java.util.List;

// Root class for the JSON
public class StationCollection {
    private String type;
    private List<Feature> features;

    public StationCollection(String type, List<Feature> features) {
        this.type = type;
        this.features = features;
    }

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    // Class representing each feature in the "features" list
    public static class Feature {
        private String type;
        private Geometry geometry;
        private Properties properties;

        public Feature(String type, Geometry geometry, Properties properties) {
            this.type = type;
            this.geometry = geometry;
            this.properties = properties;
        }

        // Getters and Setters
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Geometry getGeometry() {
            return geometry;
        }

        public void setGeometry(Geometry geometry) {
            this.geometry = geometry;
        }

        public Properties getProperties() {
            return properties;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }

        // Class representing the "geometry" field
        public static class Geometry {
            private String type;
            private List<Double> coordinates;

            public Geometry(String type, List<Double> coordinates) {
                this.type = type;
                this.coordinates = coordinates;
            }

            // Getters and Setters
            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public List<Double> getCoordinates() {
                return coordinates;
            }

            public void setCoordinates(List<Double> coordinates) {
                this.coordinates = coordinates;
            }
        }

        // Class representing the "properties" field
        public static class Properties {
            private int location_type;
            private String parent_station;
            private String platform_code;
            private String stop_id;
            private String stop_name;
            private int wheelchair_boarding;
            private String zone_id;
            private String level_id;

            public Properties(int location_type, String parent_station, String platform_code, String stop_id, String stop_name, int wheelchair_boarding, String zone_id, String level_id) {
                this.location_type = location_type;
                this.parent_station = parent_station;
                this.platform_code = platform_code;
                this.stop_id = stop_id;
                this.stop_name = stop_name;
                this.wheelchair_boarding = wheelchair_boarding;
                this.zone_id = zone_id;
                this.level_id = level_id;
            }

            // Getters and Setters
            public int getLocation_type() {
                return location_type;
            }

            public void setLocation_type(int location_type) {
                this.location_type = location_type;
            }

            public String getParent_station() {
                return parent_station;
            }

            public void setParent_station(String parent_station) {
                this.parent_station = parent_station;
            }

            public String getPlatform_code() {
                return platform_code;
            }

            public void setPlatform_code(String platform_code) {
                this.platform_code = platform_code;
            }

            public String getStop_id() {
                return stop_id;
            }

            public void setStop_id(String stop_id) {
                this.stop_id = stop_id;
            }

            public String getStop_name() {
                return stop_name;
            }

            public void setStop_name(String stop_name) {
                this.stop_name = stop_name;
            }

            public int getWheelchair_boarding() {
                return wheelchair_boarding;
            }

            public void setWheelchair_boarding(int wheelchair_boarding) {
                this.wheelchair_boarding = wheelchair_boarding;
            }

            public String getZone_id() {
                return zone_id;
            }

            public void setZone_id(String zone_id) {
                this.zone_id = zone_id;
            }

            public String getLevel_id() {
                return level_id;
            }

            public void setLevel_id(String level_id) {
                this.level_id = level_id;
            }
        }
    }
}