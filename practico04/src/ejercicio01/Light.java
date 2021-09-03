package ejercicio01;

public class Light {

    private Boolean on = Boolean.FALSE;

    public void turnOn() {
        this.on = Boolean.TRUE;
        System.out.println("Light's up!");
    }

    public void turnOff() {
        this.on = Boolean.FALSE;
        System.out.println("Cast a shadow in my direction.");
    }

    public Boolean getOn() {
        return on;
    }
}
