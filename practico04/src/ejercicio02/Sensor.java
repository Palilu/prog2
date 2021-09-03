package ejercicio02;

public class Sensor {

    private String zone;
    private Boolean activated;

    public Sensor(String zone) {
        this.zone = zone;
        activated = false;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }
}
