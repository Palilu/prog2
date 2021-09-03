package ejercicio02;

public class Main {

    public static void main(String[] args) {
        Sensor s1 = new Sensor("Kitchen");
        Sensor s2 = new Sensor("Living Room");
        Sensor s3 = new Sensor("Bedroom");
        Alarm alarm = new Alarm();
        alarm.addSensor(s1);
        alarm.addSensor(s2);
        alarm.addSensor(s3);
        alarm.check();
        alarm.getSensors().get(0).setActivated(Boolean.TRUE);
        alarm.getSensors().get(2).setActivated(Boolean.TRUE);
        alarm.check();
        alarm = new LightAlarm();
        alarm.addSensor(s1);
        alarm.addSensor(s2);
        alarm.addSensor(s3);
        alarm.check();
        alarm.getSensors().get(0).setActivated(Boolean.FALSE);
        alarm.getSensors().get(2).setActivated(Boolean.FALSE);
        alarm.check();
    }
}
