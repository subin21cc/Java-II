package sec01;
// 도형-정사각형, 원, 직사각형...
// 부모클래스=상위클래스=기저클래스=슈퍼클래스 (*)
class Shape {
    String name;

    Shape(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
    /*
    void showInfo() {
        System.out.println("name: " + name);
    }
    */
}

// 자식클래스=하위클래스=파생클래스
class Square extends Shape {
    int width;

    Square(String name, int width) {
        super(name);
        this.width = width;
    }

    public String toString() {
        String result;
        result = super.toString();
        result += width; // result = result + width;
        return result;
    }
    /*
    void showInfo() {
//        System.out.println("name: " + name);
        super.showInfo();
        System.out.println("width: " + width);
    }
     */
}
public class ShapeTest {
    public static void main(String[] args) {
        // 자식객체생성
        Square s1 = new Square("pizza", 20);
//        s1.showInfo();

    }
}
