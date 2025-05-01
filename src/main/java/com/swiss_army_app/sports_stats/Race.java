package com.swiss_army_app.sports_stats;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// template class for the upcoming events
@JsonIgnoreProperties(ignoreUnknown = true)
public class Race {
    private Competition competition;
    private Circuit circuit;
    private String type;
    private String date;
    private String status;

    //getters and setters
    public Competition getCompetition() {return competition;}
    public void setCompetition(Competition competition) {this.competition = competition;}

    public Circuit getCircuit() {return circuit;}
    public void setCircuit(Circuit circuit) {this.circuit = circuit;}

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    // competition nested class for Jackson JSON reader
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Competition {
        private String name;

        public String getName() {return name;}
        public void setName(String name) {this.name = name;}
    }

    // circuit nested class for Jackson JSON reader
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Circuit {
        private String name;
        private String image;

        public String getName() {return name;}
        public void setName(String name) {this.name = name;}

        public String getImage() {return image;}
        public void setImage(String image) {this.image = image;}
    }

}
