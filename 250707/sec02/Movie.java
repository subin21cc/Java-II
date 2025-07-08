package sec02;

public class Movie {
    protected String name;
    protected int price = 15000;
    protected int discountRate = 10;

    Movie(String name) {
        this.name = name;
    }

    double discountPrice() {
        double result = price - (price * discountRate / 100);
        return result;
    }
}
