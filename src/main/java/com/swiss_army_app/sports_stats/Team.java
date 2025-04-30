package com.swiss_army_app.sports_stats;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// template class for teams (for the ranking graph)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
    private int position;
    private int points;
    private TeamInfo team; // need to declare the class for json mapping

    // getters and setters
    public int getPoints() {return points;}
    public void setPoints(int points) {this.points = points;}

    public int getPosition() {return position;}
    public void setPosition(int position) {this.position = position;}

    public TeamInfo getTeam() { return team; }
    public void setTeam(TeamInfo team) { this.team = team; }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TeamInfo {
        private String name;
        private String logo;

        // getters and setters
        public String getName() {return name;}
        public void setName(String name) {this.name = name;}

        public String getLogo() {return logo;}
        public void setLogo(String logo) {this.logo = logo;}
    }
}
