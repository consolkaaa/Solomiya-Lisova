package jsonparsing.dataclasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import jsonparsing.JsonParsing;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Standing {
    private String position;
    private String positionText;
    private String points;
    private String wins;
    @JsonProperty("Driver")
    private Driver driver;

    @JsonProperty("Constructors")
    private List<Constructors> constructors;

    public List<Constructors> getConstructors() {
        return constructors;
    }

    public void setConstructors(List<Constructors> constructors) {
        this.constructors = constructors;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionText() {
        return positionText;
    }

    public void setPositionText(String positionText) {
        this.positionText = positionText;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    @Override
    public String toString() {
        return "\nStanding{\n"
                + "position=\'" + position + "\', "
                + "positionText=\'" + positionText + "\', "
                + "points=\'" + points + "\', "
                + "wins=\'" + wins + "\', "
                + "\nDriver" + driver + ","
                + "\nConstructors" + constructors
                + "\n}";
    }
}
