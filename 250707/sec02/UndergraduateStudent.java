package sec02;

public class UndergraduateStudent extends Student{
    // 생성자
    public UndergraduateStudent(String name) {
        super(name);
        type = 1;
    }

    // 학점을 계산한다
    public void computeGrade() {
        if (score >= 70) {
            grade = "통과";
        }
        else {
            grade = "과락";
        }
    }
}
