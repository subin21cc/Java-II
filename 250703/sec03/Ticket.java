package sec03;

public class Ticket {
    // 입장권의 번호와 가격에 대한 객체 변수를 선언한다.
    protected int number;
    protected double price;

    // 생성자 메소드
    Ticket(int number) {
        this.number = number;
    }

    // 메소드: getNumber
    public int getNumber() {
        return number;
    }

    // 메소드: getPrice
    // 목적: 입장권의 가격을 반환한다
    public double getPrice() {
        return price;
    }

    // 메소드: toString
    // 목적: 입장권의 정보를 문자열로 반환한다
    public String toString() {
        String result = "번호: " + number;
        return result;
    }

    // 메소드: setPrice
    // 목적: 입장권의 가격을 주어진 값으로 변경한다
    public void setPrice(double price) {
        this.price = price;
    }
}
