package sec03;

public class AdvanceTicket extends Ticket{
    // 입장권의 사전 예약일수에 대한 객체 변수를 선언한다
    private int advancedays;

    // 생성자 메소드
    // 목적: 입장권의 변수 값을 주어진 값으로 초기화한다
    public AdvanceTicket(int number, int advancedays) {
        super(number);
        this.advancedays = advancedays;
    }

    // 메소드: getPrice
    // 목적: 입장권의 가격을 반환한다
    public double getPrice() {
        if (advancedays >= 30) {
            return super.price * 0.5;
        }
        else if (advancedays >= 10) {
            return super.price * 0.8;
        }
        else if (advancedays >= 5) {
            return super.price * 0.9;
        }
        else {
            return super.price;
        }
    }

    // 메소드: getAdvancedays
    // 목적: 예약 입장권의 사전 예약일수를 반환한다
    public int getAdvancedays() {
        return advancedays;
    }

    // 메소드: toString
    // 목적: 예약 입장권의 현재 상태를 반환한다
    public String toString() {
        String result = super.toString();
        result += ", 사전 예약일수: " + advancedays + ", 가격: " + (int) getPrice();
        return result;
    }
}
