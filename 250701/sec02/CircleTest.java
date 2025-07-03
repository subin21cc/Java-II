package sec02;

public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.name = "자바피자";
        c1.radius = 10;
        c1.getPrint();

        Circle c2 = new Circle();
        c2.name = "도넛피자";
        c2.radius = 5;
        c2.getPrint();
    }
}