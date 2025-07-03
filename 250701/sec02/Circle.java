package sec02;

public class Circle {
    String name;
    int radius;

    double getArea() {
        double result;
        result = Math.PI * radius * radius;
        return result;
    }

    double getPerimeter() {
        double result;
        result = 2 * Math.PI * radius;
        return result;
    }

    void getPrint() {
        System.out.printf("%s의 면적은 %.1f, 둘레 길이는 %.1f\n", name, getArea(), getPerimeter());
    }
}