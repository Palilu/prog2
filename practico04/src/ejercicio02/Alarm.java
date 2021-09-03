package ejercicio02;

import java.util.ArrayList;
import java.util.List;

public class Alarm {

    private List<Sensor> sensors = new ArrayList<>();
    private Doorbell doorbell = new Doorbell();

    public void check() {
        if (sensors.stream().filter(Sensor::getActivated).findAny().isPresent()) {
            System.out.println("Alarm is on.");
            this.trigger();
        } else {
            System.out.println("Alarm is off.");
        }
    }

    protected void trigger() {
        sensors.stream()
                .filter(Sensor::getActivated)
                .map(sensor -> sensor.getZone() + " sensor is activated.")
                .forEach(message -> System.out.println(message));
        doorbell.ring();
    }

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public Doorbell getDoorbell() {
        return doorbell;
    }

    public void setDoorbell(Doorbell doorbell) {
        this.doorbell = doorbell;
    }
}
