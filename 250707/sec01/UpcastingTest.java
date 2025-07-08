package sec01;
// 상속과 업캐스팅 활용
class Shape {
    String name;
}

class Square extends Shape {

}

class Rect extends Shape {

}

class Circle extends Shape {

}

public class UpcastingTest {
    public static void main(String[] args) {
        Square s = new Square();
//        Shape ss = new Square();
        Rect r = new Rect();
        Circle c = new Circle();
        // 부모 배열 생성
        Shape[] list = {s, r, c};
        for(Shape ss : list) {
            System.out.println(ss.name);
        }
    }
}
