package ejercicio03;

public class Point {

    private Integer x;
    private Integer y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public void move(Integer xOffset, Integer yOffset) {
        this.x += xOffset;
        this.y += yOffset;
    }

    public Double distanceTo(Point myPoint) {
        return Math.sqrt(Math.pow(x - myPoint.getX(), 2D) + Math.pow(y - myPoint.getY(), 2D));
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
