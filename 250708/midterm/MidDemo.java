package midterm;

class Shape {
    Shape(String msg) {
        System.out.println("shap 생성자B" + msg);
    }
}

class Rectangle extends Shape {
    Rectangle(String msg) {
        super(msg); // *추가해야 함
        System.out.println("Rectangle 생성자" + msg);
    }
}

public class MidDemo {
    public static void main(String[] args) {
        Rectangle r = new Rectangle("EWHA");
    }
}
