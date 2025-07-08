package sec02;

public class MovieTest {
    public static void main(String[] args) {
        ActionMovie am = new ActionMovie("드래곤 길들이기");
        HorrorMovie hm = new HorrorMovie("노이즈");
        ComedyMovie cm = new ComedyMovie("극한직업");

        int sum = 0;
        sum += am.discountPrice();
        sum += hm.discountPrice();
        sum += cm.discountPrice();

        System.out.println(am.name + ", 할인가: " + (int)am.discountPrice() + "원");
        System.out.println(hm.name + ", 할인가: " + (int)hm.discountPrice() + "원");
        System.out.println(cm.name + ", 할인가: " + (int)cm.discountPrice() + "원");

        System.out.println("==========================");
        System.out.printf("총 예매 금액: %d원", sum);
    }
}
