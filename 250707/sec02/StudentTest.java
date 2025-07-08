package sec02;

import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String name;
        int score, type;

        while (true) {
            // 사용자로부터 필요한 데이터를 입력받는다
            System.out.print("학생유형(학부생=1, 대학원생=2)(종료=0): ");
            type = s.nextInt();
            if (type == 0) {
                break;
            } else if (type < 0 || type > 2) {
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
            } else {

                System.out.print("이름 입력: ");
                name = s.next();
                System.out.print("점수 입력: ");
                score = s.nextInt();
                UndergraduateStudent us = new UndergraduateStudent(name);
                GraduateStudent gs = new GraduateStudent(name);

                // 각 객체의 레벨, 점수, 학점을 계산 후 결과를 출력한다
                if (type == 0) {
                    break;
                } else if (type == 1) {
                    us.setType(type);
                    us.setScore(score);
                    us.computeGrade();
                    System.out.println(us.showinfo());
                } else if (type == 2) {
                    gs.setType(type);
                    gs.setScore(score);
                    gs.computeGrade();
                    System.out.println(gs.showinfo());
                } else {
                    System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                }
            }
        }
    }
}