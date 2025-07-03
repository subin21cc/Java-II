package sec02;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = {88, 97, 90, 100, 95};

        int max = Array.maxArray(arr);
        int min = Array.minArray(arr);

        System.out.println("저번 학기 점수의 최대값: " + max);
        System.out.println("저번 학기 점수의 최소값: " + min);
    }
}
