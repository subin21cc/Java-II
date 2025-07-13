package midterm;

class Person {
    String name;
    String tel;

    Person(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    void show() {
        System.out.println("name: " + name);
        System.out.println("tel: " + tel);
    }
}

class Student extends Person {
    String dept;

    Student(String name, String tel, String dept) {
        super(name, tel);
        this.dept = dept;
    }

    void show() {
        super.show();
        System.out.println("dept: " + dept);
    }
}
public class Inherit {
    public static void main(String[] args) {
        String[] nameList = {"김이화", "나이화", "양이화"};
        String[] telList = {"010-", "010-", "010-"};
        String[] deptList = {"컴공과", "초등교육", "통계"};
        // 객체 배열 생성
        Student[] stuList = new Student[3];
        for (int i = 0; i < stuList.length; i++) {
            stuList[i] = new Student(nameList[i], telList[i], deptList[i]);
        }
        // 출력
        for (Student s : stuList) {
            System.out.println(s.name + "/" + s.tel + "/" + s.dept);
        }

    }
}
