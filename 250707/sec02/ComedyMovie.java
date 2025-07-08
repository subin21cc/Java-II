package sec02;

public class ComedyMovie extends Movie{
    ComedyMovie(String name) {
        super(name);
    }

    double discountPrice() {
        double result = super.discountPrice();
        result -= 1500;
        return result;
    }
}
