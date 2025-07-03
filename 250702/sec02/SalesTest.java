package sec02;

public class SalesTest {
    public static void main(String[] args) {
        Sales s1 = new Sales("딸기");
        Sales s2 = new Sales("바나나");
        Sales s3 = new Sales("사과");

        System.out.println("총 판매량: " + Sales.getSales());

    }
}
