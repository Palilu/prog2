package ejercicio01;

public class Main {

    public static void main(String[] args) {
        Alarm alarm = new Alarm();
        alarm.check();
        alarm.setMovementDetected(Boolean.TRUE);
        alarm.check();
        alarm = new LightAlarm();
        alarm.check();
        alarm.setMovementDetected(Boolean.TRUE);
        alarm.check();
    }
}
