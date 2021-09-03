package ejercicio02;

public class LightAlarm extends Alarm {

    private Light light = new Light();

    @Override
    public void trigger() {
        super.trigger();
        light.turnOn();
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }
}
