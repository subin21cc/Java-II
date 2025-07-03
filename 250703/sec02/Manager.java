package sec02;

public class Manager extends Employee{
    protected int bonus;

    // 생성자 메서드
    public Manager(String name, int salary, int bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    // 보너스를 반환한다
    public int getBonus() {
        return bonus;
    }

    // 급여를 올린다
    public int raiseSalary() {
        int result = salary + (int)(salary * 0.2);
        return result;
    }

    // 객체의 현 상태를 반환한다
    public String showInfo() {
        String result = super.showInfo();
        result += "\n보너스: " + bonus;
        return result;
    }
}
