package sec02;

public class Employee {
    protected String name;
    protected int salary;

    // 생성자 메서드
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    // 이름을 반환한다
    public String getName() {
        return name;
    }

    // 급여를 반환한다
    public int getSalary() {
        return salary;
    }

    // 급여를 올린다
    public int raiseSalary() {
        int result = salary + (int) (salary * 0.3);
        return result;
    }

    // 객체의 현 상태를 반환한다
    public String showInfo() {
        String result = "\n이름: " + name + "\n";
        result += "급여: " + salary + "\n";
        result += "인상된 급여: " + raiseSalary();
        return result;
    }
}
