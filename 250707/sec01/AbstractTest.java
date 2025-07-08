package sec01;

// 추상클래스 정의

abstract class Animal {
    // 변수
    String name;
    abstract void cry();
    void show() {

    }
}

class Tiger extends Animal {
    void cry() {
        System.out.println("Tiger cryr~");
    }
}

class Lion extends Animal {
    void cry() {
        System.out.println("Lion cry~");
    }
}

public class AbstractTest {
    public static void main(String[] args) {
        Animal[] list = {new Tiger(), new Lion()};
        for(Animal aa : list) {
            System.out.println(aa.name);
        }
    }
}
