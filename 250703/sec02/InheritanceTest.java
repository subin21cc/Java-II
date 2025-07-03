package sec02;

public class InheritanceTest {
    public static void main(String[] args) {
        // 객체들을 생성한다
        Employee emp = new Employee("김이화", 100000);
        Manager mng = new Manager("박이화", 200000, 50000);
        Executive exe = new Executive("양이화", 400000, 100000, 100000);

        // 각 객체의 급여를 올린다
        emp.raiseSalary();
        mng.raiseSalary();
        exe.raiseSalary();

        // 결과를 출력한다
        System.out.println("===Employee(직원)===");
        System.out.println(emp.showInfo());
        System.out.println();

        System.out.println("===Manager(매니저)===");
        System.out.println(mng.showInfo());
        System.out.println();

        System.out.println("===Executive(임원)===");
        System.out.println(exe.showInfo());
        System.out.println();
    }
}
