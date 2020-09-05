package avaj.main.aircraft;

public class Coordinates {
    private Integer longitude;
    private Integer latitude;
    private Integer height;

    protected Coordinates(Integer longitude, Integer latitude, Integer height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public Integer getHeight() {
        return height;
    }
}
