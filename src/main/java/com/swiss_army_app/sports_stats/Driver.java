package com.swiss_army_app.sports_stats;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// template class for the current top driver
@JsonIgnoreProperties(ignoreUnknown = true)
public class Driver {
    @JsonProperty("driver")
    private DriverInfo driverInfo;
    @JsonProperty("team")
    private DriverTeam driverTeam;
    private int position;
    private int points;
    private int wins;

    // getters and setters
    public DriverInfo getDriverInfo() {return driverInfo;}
    public void setDriverInfo(DriverInfo driverInfo) {this.driverInfo = driverInfo;}

    public DriverTeam getDriverTeam() {return driverTeam;}
    public void setDriverTeam(DriverTeam driverTeam) {this.driverTeam = driverTeam;}

    public int getPosition() {return position;}
    public void setPosition(int position) {this.position = position;}

    public int getPoints() {return points;}
    public void setPoints(int points) {this.points = points;}

    public int getWins() {return wins;}
    public void setWins(int wins) {this.wins = wins;}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DriverInfo {
        private String name;
        private String image;
        private int number;

        // getters and setters
        public String getName() {return name;}
        public void setName(String name) {this.name = name;}

        public String getImage() {return image;}
        public void setImage(String image) {this.image = image;}

        public int getNumber() {return number;}
        public void setNumber(int number) {this.number = number;}
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DriverTeam {
        private String name;

        // getter and setter
        public String getName() {return name;}
        public void setName(String name) {this.name = name;}
    }
}
