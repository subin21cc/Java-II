package sec01;
class Student {
    String name;
    int age;
    static int cnt;

    // 생성자
    Student() {
        cnt++;
    }
}

public class StudentTest {

    static int a, b;

    static void line() {
        System.out.println("+++++++++++++++++++");
    }

    public static void main(String[] args) {
        // 인스턴스 멤버
        Student s1 = new Student();
        Student s2 = new Student();
        System.out.println(Student.cnt);

        System.out.println(a);
        line();
    }
}
