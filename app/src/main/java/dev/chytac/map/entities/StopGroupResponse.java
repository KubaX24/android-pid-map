package dev.chytac.map.entities;

import java.util.List;

public class StopGroupResponse {
    private String generatedAt;
    private String dataFormatVersion;
    private List<StopGroup> stopGroups;

    // Getters and Setters

    public StopGroupResponse(String generatedAt, String dataFormatVersion, List<StopGroup> stopGroups) {
        this.generatedAt = generatedAt;
        this.dataFormatVersion = dataFormatVersion;
        this.stopGroups = stopGroups;
    }

    public String getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(String generatedAt) {
        this.generatedAt = generatedAt;
    }

    public String getDataFormatVersion() {
        return dataFormatVersion;
    }

    public void setDataFormatVersion(String dataFormatVersion) {
        this.dataFormatVersion = dataFormatVersion;
    }

    public List<StopGroup> getStopGroups() {
        return stopGroups;
    }

    public void setStopGroups(List<StopGroup> stopGroups) {
        this.stopGroups = stopGroups;
    }

    public static class StopGroup {
        private String name;
        private String districtCode;
        private int idosCategory;
        private String idosName;
        private String fullName;
        private String uniqueName;
        private int node;
        private int cis;
        private double avgLat;
        private double avgLon;
        private double avgJtskX;
        private double avgJtskY;
        private String municipality;
        private String mainTrafficType;
        private List<Stop> stops;

        public StopGroup(String name, String districtCode, int idosCategory, String idosName, String fullName, String uniqueName, int node, int cis, double avgLat, double avgLon, double avgJtskX, double avgJtskY, String municipality, String mainTrafficType, List<Stop> stops) {
            this.name = name;
            this.districtCode = districtCode;
            this.idosCategory = idosCategory;
            this.idosName = idosName;
            this.fullName = fullName;
            this.uniqueName = uniqueName;
            this.node = node;
            this.cis = cis;
            this.avgLat = avgLat;
            this.avgLon = avgLon;
            this.avgJtskX = avgJtskX;
            this.avgJtskY = avgJtskY;
            this.municipality = municipality;
            this.mainTrafficType = mainTrafficType;
            this.stops = stops;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDistrictCode() {
            return districtCode;
        }

        public void setDistrictCode(String districtCode) {
            this.districtCode = districtCode;
        }

        public int getIdosCategory() {
            return idosCategory;
        }

        public void setIdosCategory(int idosCategory) {
            this.idosCategory = idosCategory;
        }

        public String getIdosName() {
            return idosName;
        }

        public void setIdosName(String idosName) {
            this.idosName = idosName;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getUniqueName() {
            return uniqueName;
        }

        public void setUniqueName(String uniqueName) {
            this.uniqueName = uniqueName;
        }

        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public int getCis() {
            return cis;
        }

        public void setCis(int cis) {
            this.cis = cis;
        }

        public double getAvgLat() {
            return avgLat;
        }

        public void setAvgLat(double avgLat) {
            this.avgLat = avgLat;
        }

        public double getAvgLon() {
            return avgLon;
        }

        public void setAvgLon(double avgLon) {
            this.avgLon = avgLon;
        }

        public double getAvgJtskX() {
            return avgJtskX;
        }

        public void setAvgJtskX(double avgJtskX) {
            this.avgJtskX = avgJtskX;
        }

        public double getAvgJtskY() {
            return avgJtskY;
        }

        public void setAvgJtskY(double avgJtskY) {
            this.avgJtskY = avgJtskY;
        }

        public String getMunicipality() {
            return municipality;
        }

        public void setMunicipality(String municipality) {
            this.municipality = municipality;
        }

        public String getMainTrafficType() {
            return mainTrafficType;
        }

        public void setMainTrafficType(String mainTrafficType) {
            this.mainTrafficType = mainTrafficType;
        }

        public List<Stop> getStops() {
            return stops;
        }

        public void setStops(List<Stop> stops) {
            this.stops = stops;
        }

        // Getters and Setters
        public static class Stop {
            private String id;
            private String platform;
            private String altIdosName;
            private double lat;
            private double lon;
            private double jtskX;
            private double jtskY;
            private String zone;
            private String mainTrafficType;
            private String wheelchairAccess;
            private List<String> gtfsIds;
            private List<Line> lines;

            // Getters and Setters

            public Stop(String id, String platform, String altIdosName, double lat, double lon, double jtskX, double jtskY, String zone, String mainTrafficType, String wheelchairAccess, List<String> gtfsIds, List<Line> lines) {
                this.id = id;
                this.platform = platform;
                this.altIdosName = altIdosName;
                this.lat = lat;
                this.lon = lon;
                this.jtskX = jtskX;
                this.jtskY = jtskY;
                this.zone = zone;
                this.mainTrafficType = mainTrafficType;
                this.wheelchairAccess = wheelchairAccess;
                this.gtfsIds = gtfsIds;
                this.lines = lines;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPlatform() {
                return platform;
            }

            public void setPlatform(String platform) {
                this.platform = platform;
            }

            public String getAltIdosName() {
                return altIdosName;
            }

            public void setAltIdosName(String altIdosName) {
                this.altIdosName = altIdosName;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLon() {
                return lon;
            }

            public void setLon(double lon) {
                this.lon = lon;
            }

            public double getJtskX() {
                return jtskX;
            }

            public void setJtskX(double jtskX) {
                this.jtskX = jtskX;
            }

            public double getJtskY() {
                return jtskY;
            }

            public void setJtskY(double jtskY) {
                this.jtskY = jtskY;
            }

            public String getZone() {
                return zone;
            }

            public void setZone(String zone) {
                this.zone = zone;
            }

            public String getMainTrafficType() {
                return mainTrafficType;
            }

            public void setMainTrafficType(String mainTrafficType) {
                this.mainTrafficType = mainTrafficType;
            }

            public String getWheelchairAccess() {
                return wheelchairAccess;
            }

            public void setWheelchairAccess(String wheelchairAccess) {
                this.wheelchairAccess = wheelchairAccess;
            }

            public List<String> getGtfsIds() {
                return gtfsIds;
            }

            public void setGtfsIds(List<String> gtfsIds) {
                this.gtfsIds = gtfsIds;
            }

            public List<Line> getLines() {
                return lines;
            }

            public void setLines(List<Line> lines) {
                this.lines = lines;
            }

            public static class Line {
                private int id;
                private String name;
                private String type;
                private String direction;
                private String direction2; // Optional field, can be null
                private Boolean isNight;   // Optional field, can be null

                // Getters and Setters

                public Line(int id, String name, String type, String direction, String direction2, Boolean isNight) {
                    this.id = id;
                    this.name = name;
                    this.type = type;
                    this.direction = direction;
                    this.direction2 = direction2;
                    this.isNight = isNight;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getDirection() {
                    return direction;
                }

                public void setDirection(String direction) {
                    this.direction = direction;
                }

                public String getDirection2() {
                    return direction2;
                }

                public void setDirection2(String direction2) {
                    this.direction2 = direction2;
                }

                public Boolean getNight() {
                    return isNight;
                }

                public void setNight(Boolean night) {
                    isNight = night;
                }
            }
        }
    }
}
