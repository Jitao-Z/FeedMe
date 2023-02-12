package model;

public class Restaurant {
    private String name;
    private String location;

    public Restaurant(String n, String l) {
        this.name = n;
        this.location = l;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

}
