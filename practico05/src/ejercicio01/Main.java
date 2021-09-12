package ejercicio01;

public class Main {

    public static void main(String[] args) {
        Stack s1 = new Stack();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        System.out.println(s1);
        s1.pop();
        System.out.println(s1);
        System.out.println(s1.top());
        s1.pop();
        s1.pop();
        s1.pop();
        System.out.println(s1);
        System.out.println(s1.top());
        s1.push(1);
        s1.push(2);
        s1.push(3);
        Stack s2 = s1.copy();
        s2.pop();
        s2.push(4);
        System.out.println(s2);
        Stack s3 = s1.reverse();
        s3.push(0);
        System.out.println(s3);
        System.out.println(s1);
    }
}
