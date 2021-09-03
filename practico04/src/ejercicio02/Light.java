package ejercicio02;

public class Light {

    private Boolean on = Boolean.FALSE;

    public void turnOn() {
        on = Boolean.TRUE;
        System.out.println("Light's up!");
    }

    public void turnOff() {
        on = Boolean.TRUE;
        System.out.println("Cast a shadow in my direction.");
    }
}
