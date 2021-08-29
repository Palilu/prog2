package ejercicio01;

public class BodyMassIndex {
    private static final Double IN_SHAPE_MIN_BMI = 18.5;
    private static final Double IN_SHAPE_MAX_BMI = 25D;

    private Double value;

    public BodyMassIndex(Double weight, Double height) {
        this.value = calculateBodyMassIndex(weight, height);
    }

    private Double calculateBodyMassIndex(Double weight, Double height) {
        return weight / (height * height);
    }

    public  Boolean isInShape() {
        return value >= IN_SHAPE_MIN_BMI && value <= IN_SHAPE_MAX_BMI;
    }

    public Double getValue() {
        return value;
    }
}
