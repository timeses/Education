package core;

import java.util.List;

public class Line implements Comparable<Line> {
    private String number;
    private String name;
    private String color;
    private List<Station> stations;

    public Line(String number, String name, String color) {
        this.number = number;
        this.name = name;
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public List<Station> getStations() {
        return stations;
    }

    @Override
    public boolean equals(Object obj) {
        return compareTo((Line) obj) == 0;
    }

    @Override
    public int compareTo(Line o) {
        return 0;
    }
}