package sec02;

import java.util.Scanner;

public class SumTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        String s = sc.nextLine();
        String[] numbers = s.split(" ");

        try {
            for (String i : numbers) {
                System.out.println(i);
                sum += Integer.parseInt(i); // 정수형 변환
            }
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException 발생!!");
        }
        finally {
            System.out.println("정수들의 합은 " + sum);
        }
    }
}
