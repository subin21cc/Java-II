package sec02;

public class Executive extends Manager {
    private int stokOption;

    // 생성자 메서드
    public Executive(String name, int salary, int bonus, int stokOption) {
        super(name, salary, bonus);
        this.stokOption = stokOption;
    }

    // 스톡 옵션을 반환한다
    public int getStokOption() {
        return stokOption;
    }

    // 급여를 올린다
    public int raiseSalary() {
        int result = salary + (int)(salary * 0.1);
        return result;
    }

    // 객체의 현 상태를 반환한다
    public String showInfo() {
        String result = super.showInfo();
        result += "\n스톡 옵션: " + stokOption + "\n";
        return result;
    }
}
