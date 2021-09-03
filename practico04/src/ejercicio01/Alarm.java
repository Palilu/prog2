package ejercicio01;

public class Alarm {

    private Boolean brokenGlass = Boolean.FALSE;
    private Boolean openDoor = Boolean.FALSE;
    private Boolean movementDetected = Boolean.FALSE;
    private Doorbell doorbell = new Doorbell();

    public void check() {
        if (brokenGlass || openDoor || movementDetected) {
            System.out.println("Alarm is on.");
            this.trigger();
        } else {
            System.out.println("Alarm is off.");
        }
    }

    protected void trigger() { doorbell.ring();
    }

    public Boolean getBrokenGlass() {
        return brokenGlass;
    }

    public void setBrokenGlass(Boolean brokenGlass) {
        this.brokenGlass = brokenGlass;
    }

    public Boolean getOpenDoor() {
        return openDoor;
    }

    public void setOpenDoor(Boolean openDoor) {
        this.openDoor = openDoor;
    }

    public Boolean getMovementDetected() {
        return movementDetected;
    }

    public void setMovementDetected(Boolean movementDetected) {
        this.movementDetected = movementDetected;
    }

    public Doorbell getDoorbell() {
        return doorbell;
    }

    public void setDoorbell(Doorbell doorbell) {
        this.doorbell = doorbell;
    }
}
