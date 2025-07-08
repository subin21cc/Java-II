package sec02;

abstract class Student {
    protected int type; // 학부생(1), 대학원생(2)
    protected String name; // 이름
    protected int score; // 점수
    protected String grade; // 학점

    // 생성자 정의
    public Student(String name) {
        this.name = name;
    }

    // 멤버변수에 대한 getter/setter 메소드 정의
    public void setType(int type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getGrade() {
        return grade;
    }

    // 추상 메소드: 학점을 계산한다
    public abstract void computeGrade();

    // 객체 현 상태 변환
    public String showinfo() {
        String result = "소속\t이름\t점수\t학점\n";
        if (type == 1) {
            result += "학부생";
        } else if (type == 2) {
            result += "대학원생";
        }
        result += "\t" + getName();
        result += "\t" + getScore();
        result += "\t" + getGrade();
        return result;
    }
}
