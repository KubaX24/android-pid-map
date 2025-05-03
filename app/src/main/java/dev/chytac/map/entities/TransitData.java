package dev.chytac.map.entities;

import java.util.List;

public class TransitData {
    private List<Stop> stops;
    private List<Departure> departures;
    private List<InfoText> infotexts;

    public TransitData(List<Stop> stops, List<Departure> departures, List<InfoText> infotexts) {
        this.stops = stops;
        this.departures = departures;
        this.infotexts = infotexts;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    public List<Departure> getDepartures() {
        return departures;
    }

    public void setDepartures(List<Departure> departures) {
        this.departures = departures;
    }

    public List<InfoText> getInfotexts() {
        return infotexts;
    }

    public void setInfotexts(List<InfoText> infotexts) {
        this.infotexts = infotexts;
    }

    // Getters and Setters
    public static class Stop {
        private String level_id;
        private int location_type;
        private String parent_station;
        private String platform_code;
        private double stop_lat;
        private double stop_lon;
        private AswId asw_id;
        private String stop_id;
        private String stop_name;
        private int wheelchair_boarding;
        private String zone_id;

        // Getters and Setters


        public Stop(String level_id, int location_type, String parent_station, String platform_code, double stop_lat, double stop_lon, AswId asw_id, String stop_id, String stop_name, int wheelchair_boarding, String zone_id) {
            this.level_id = level_id;
            this.location_type = location_type;
            this.parent_station = parent_station;
            this.platform_code = platform_code;
            this.stop_lat = stop_lat;
            this.stop_lon = stop_lon;
            this.asw_id = asw_id;
            this.stop_id = stop_id;
            this.stop_name = stop_name;
            this.wheelchair_boarding = wheelchair_boarding;
            this.zone_id = zone_id;
        }

        public String getLevel_id() {
            return level_id;
        }

        public void setLevel_id(String level_id) {
            this.level_id = level_id;
        }

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

        public double getStop_lat() {
            return stop_lat;
        }

        public void setStop_lat(double stop_lat) {
            this.stop_lat = stop_lat;
        }

        public double getStop_lon() {
            return stop_lon;
        }

        public void setStop_lon(double stop_lon) {
            this.stop_lon = stop_lon;
        }

        public AswId getAsw_id() {
            return asw_id;
        }

        public void setAsw_id(AswId asw_id) {
            this.asw_id = asw_id;
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

        public static class AswId {
            private int node;
            private int stop;

            // Getters and Setters


            public AswId(int node, int stop) {
                this.node = node;
                this.stop = stop;
            }

            public int getNode() {
                return node;
            }

            public void setNode(int node) {
                this.node = node;
            }

            public int getStop() {
                return stop;
            }

            public void setStop(int stop) {
                this.stop = stop;
            }
        }

    }

    public static class Departure {
        private Timestamp arrival_timestamp;
        private Delay delay;
        private Timestamp departure_timestamp;
        private LastStop last_stop;
        private Route route;
        private StopInfo stop;
        private Trip trip;

        public Departure(Timestamp arrival_timestamp, Delay delay, Timestamp departure_timestamp, LastStop last_stop, Route route, StopInfo stop, Trip trip) {
            this.arrival_timestamp = arrival_timestamp;
            this.delay = delay;
            this.departure_timestamp = departure_timestamp;
            this.last_stop = last_stop;
            this.route = route;
            this.stop = stop;
            this.trip = trip;
        }

        public Timestamp getArrival_timestamp() {
            return arrival_timestamp;
        }

        public void setArrival_timestamp(Timestamp arrival_timestamp) {
            this.arrival_timestamp = arrival_timestamp;
        }

        public Delay getDelay() {
            return delay;
        }

        public void setDelay(Delay delay) {
            this.delay = delay;
        }

        public Timestamp getDeparture_timestamp() {
            return departure_timestamp;
        }

        public void setDeparture_timestamp(Timestamp departure_timestamp) {
            this.departure_timestamp = departure_timestamp;
        }

        public LastStop getLast_stop() {
            return last_stop;
        }

        public void setLast_stop(LastStop last_stop) {
            this.last_stop = last_stop;
        }

        public Route getRoute() {
            return route;
        }

        public void setRoute(Route route) {
            this.route = route;
        }

        public StopInfo getStop() {
            return stop;
        }

        public void setStop(StopInfo stop) {
            this.stop = stop;
        }

        public Trip getTrip() {
            return trip;
        }

        public void setTrip(Trip trip) {
            this.trip = trip;
        }

        // Getters and Setters
        public static class Timestamp {
            private String predicted;
            private String scheduled;
            private String minutes;

            // Getters and Setters

            public Timestamp(String predicted, String scheduled, String minutes) {
                this.predicted = predicted;
                this.scheduled = scheduled;
                this.minutes = minutes;
            }

            public String getPredicted() {
                return predicted;
            }

            public void setPredicted(String predicted) {
                this.predicted = predicted;
            }

            public String getScheduled() {
                return scheduled;
            }

            public void setScheduled(String scheduled) {
                this.scheduled = scheduled;
            }

            public String getMinutes() {
                return minutes;
            }

            public void setMinutes(String minutes) {
                this.minutes = minutes;
            }
        }

        public static class Delay {
            private boolean is_available;
            private int minutes;
            private int seconds;

            // Getters and Setters

            public Delay(boolean is_available, int minutes, int seconds) {
                this.is_available = is_available;
                this.minutes = minutes;
                this.seconds = seconds;
            }

            public boolean isIs_available() {
                return is_available;
            }

            public void setIs_available(boolean is_available) {
                this.is_available = is_available;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }
        }

        public static class LastStop {
            private String name;
            private String id;

            // Getters and Setters

            public LastStop(String name, String id) {
                this.name = name;
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class Route {
            private String short_name;
            private int type;
            private boolean is_night;
            private boolean is_regional;
            private boolean is_substitute_transport;

            // Getters and Setters

            public Route(String short_name, int type, boolean is_night, boolean is_regional, boolean is_substitute_transport) {
                this.short_name = short_name;
                this.type = type;
                this.is_night = is_night;
                this.is_regional = is_regional;
                this.is_substitute_transport = is_substitute_transport;
            }

            public String getShort_name() {
                return short_name;
            }

            public void setShort_name(String short_name) {
                this.short_name = short_name;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public boolean isIs_night() {
                return is_night;
            }

            public void setIs_night(boolean is_night) {
                this.is_night = is_night;
            }

            public boolean isIs_regional() {
                return is_regional;
            }

            public void setIs_regional(boolean is_regional) {
                this.is_regional = is_regional;
            }

            public boolean isIs_substitute_transport() {
                return is_substitute_transport;
            }

            public void setIs_substitute_transport(boolean is_substitute_transport) {
                this.is_substitute_transport = is_substitute_transport;
            }
        }

        public static class StopInfo {
            private String id;
            private String platform_code;

            // Getters and Setters

            public StopInfo(String id, String platform_code) {
                this.id = id;
                this.platform_code = platform_code;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPlatform_code() {
                return platform_code;
            }

            public void setPlatform_code(String platform_code) {
                this.platform_code = platform_code;
            }
        }

        public static class Trip {
            private String direction;
            private String headsign;
            private String id;
            private boolean is_at_stop;
            private boolean is_canceled;
            private boolean is_wheelchair_accessible;
            private boolean is_air_conditioned;
            private String short_name;

            // Getters and Setters


            public Trip(String direction, String headsign, String id, boolean is_at_stop, boolean is_canceled, boolean is_wheelchair_accessible, boolean is_air_conditioned, String short_name) {
                this.direction = direction;
                this.headsign = headsign;
                this.id = id;
                this.is_at_stop = is_at_stop;
                this.is_canceled = is_canceled;
                this.is_wheelchair_accessible = is_wheelchair_accessible;
                this.is_air_conditioned = is_air_conditioned;
                this.short_name = short_name;
            }

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }

            public String getHeadsign() {
                return headsign;
            }

            public void setHeadsign(String headsign) {
                this.headsign = headsign;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public boolean isIs_at_stop() {
                return is_at_stop;
            }

            public void setIs_at_stop(boolean is_at_stop) {
                this.is_at_stop = is_at_stop;
            }

            public boolean isIs_canceled() {
                return is_canceled;
            }

            public void setIs_canceled(boolean is_canceled) {
                this.is_canceled = is_canceled;
            }

            public boolean isIs_wheelchair_accessible() {
                return is_wheelchair_accessible;
            }

            public void setIs_wheelchair_accessible(boolean is_wheelchair_accessible) {
                this.is_wheelchair_accessible = is_wheelchair_accessible;
            }

            public boolean isIs_air_conditioned() {
                return is_air_conditioned;
            }

            public void setIs_air_conditioned(boolean is_air_conditioned) {
                this.is_air_conditioned = is_air_conditioned;
            }

            public String getShort_name() {
                return short_name;
            }

            public void setShort_name(String short_name) {
                this.short_name = short_name;
            }
        }
    }

    public static class InfoText {
        private String valid_from;
        private String valid_to;
        private String text;
        private String text_en;
        private String display_type;
        private List<String> related_stops;

        // Getters and Setters

        public InfoText(String valid_from, String valid_to, String text, String text_en, String display_type, List<String> related_stops) {
            this.valid_from = valid_from;
            this.valid_to = valid_to;
            this.text = text;
            this.text_en = text_en;
            this.display_type = display_type;
            this.related_stops = related_stops;
        }

        public String getValid_from() {
            return valid_from;
        }

        public void setValid_from(String valid_from) {
            this.valid_from = valid_from;
        }

        public String getValid_to() {
            return valid_to;
        }

        public void setValid_to(String valid_to) {
            this.valid_to = valid_to;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getText_en() {
            return text_en;
        }

        public void setText_en(String text_en) {
            this.text_en = text_en;
        }

        public String getDisplay_type() {
            return display_type;
        }

        public void setDisplay_type(String display_type) {
            this.display_type = display_type;
        }

        public List<String> getRelated_stops() {
            return related_stops;
        }

        public void setRelated_stops(List<String> related_stops) {
            this.related_stops = related_stops;
        }
    }
}
