package sec02;

public class Polygon {
    String shape;
    int width;
    int height;
    double area;

    double getArea(int width, int height) {

    }

    double getArea(int width) {

    }
    double getTriangleArea() {
        System.out.println("Triangle");
        this.shape = "Triangle";
        this.width = width;
        this.height = height;
        this.area = (width * height) / 2;
        return area;
    }

    double getRectangleArea() {
        this.shape = "Rectangle";
        this.width = width;
        this.height = height;
        area = width * height;
        return area;
    }

    double getSquareArea() {
        this.shape = "Square";
        this.width = width;
        this.height = height;
        area = width * height;
        return area;
    }
}