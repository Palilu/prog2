package ejercicio03;

public class Rectangle {

    private Point a;
    private Point ba;
    private Point ab;
    private Point b;

    /**
     * Vamos a pedirle al usuario 2 puntos
     *
     *      A     BA
     *
     *      AB     B
     */
    public Rectangle(Point a, Point b) {
        this.a = a;
        this.b = b;
        init();
    }

    private void init() {
        this.ba = new Point(b.getX(), a.getY());
        this.ab = new Point(a.getX(), b.getY());
    }

    public void move(Integer xOffset, Integer yOffset) {
        a.move(xOffset, yOffset);
        b.move(xOffset, yOffset);
        init();
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public Double getArea() {
        return a.distanceTo(ba) * a.distanceTo(ab);
    }

    public int compareTo(Rectangle other) {
        return getArea().compareTo(other.getArea());
    }

    public Boolean isSquare() {
        return a.distanceTo(ba).equals(a.distanceTo(ab));
    }

    public Double getTopSideLength() {
        return a.distanceTo(ba);
    }

    public Boolean isSideways() {
        return a.distanceTo(ba) >= a.distanceTo(ab);
    }
}
