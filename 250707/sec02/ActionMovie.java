package sec02;

public class ActionMovie extends Movie{
    ActionMovie(String name) {
        super(name);
    }

    double discountPrice() {
        double result = super.discountPrice();
        result -= 1000; // 액션 영화는 2000원 추가 할인
        return result;
    }
}
