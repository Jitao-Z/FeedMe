package model;

public class Restaurant {
    private String name;
    private String location;

    public Restaurant(String n, String l) {
        this.name = n;
        if (l.equals("Vancouver") || l.equals("London") || l.equals("New York City")) {
            location = l;
        } else {
            location = "Invalid Location";
        }
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

}
