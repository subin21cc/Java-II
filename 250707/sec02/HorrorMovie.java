package sec02;

public class HorrorMovie extends Movie{
    HorrorMovie(String name) {
        super(name);
    }

    double discountPrice() {
        double result = super.discountPrice();
        result -= 2000;
        return result;
    }
}
