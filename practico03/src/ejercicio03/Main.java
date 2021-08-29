package ejercicio03;

public class Main {

    public static void main(String[] args) {
        Point a = new Point(-1, -1);
        Point b = new Point(0, 0);
        Point c = new Point(2, 3);
        Rectangle one = new Rectangle(a, b);
        Rectangle two = new Rectangle(b, c);
        Rectangle three = new Rectangle(a, c);
        print(one);
        print(two);
        print(three);
        three.move(+1, -1);
        print(three);
        System.out.println(one.compareTo(two));
        System.out.println(two.compareTo(three));
        System.out.println(three.compareTo(one));
    }

    private static void print(Rectangle r) {
        System.out.println(r.toString());
        System.out.println("Area:" + r.getArea());
        System.out.println("Sideways:" + r.isSideways());
        System.out.println("Square:" + r.isSquare());
        System.out.println("TSL:" + r.getTopSideLength());
    }
}
