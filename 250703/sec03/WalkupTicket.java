package sec03;

public class WalkupTicket extends Ticket{
    // 신용카드로 결제하는 지 여부를 결정한다
    private boolean payByCreditCard;

    // 생성자 메소드
    // 목적: 입장권의 변수 값을 주어진 값으로 초기화한다
    public WalkupTicket(int number, boolean payByCreditCard) {
        super(number);
        this.payByCreditCard = payByCreditCard;
    }

    // 메소드: getPrice
    // 목적: 입장권의 가격을 반환한다
    public double getPrice() {
        if (payByCreditCard) {
            return super.price * 1.05;
        }
        else {
            return super.price;
        }
    }

    // 메소드: getPayByCreditCard
    // 목적: 입장권의 신용카드 결제 여부를 알려 준다
    public boolean getPayByCreditCard() {
        return payByCreditCard;
    }

    // 메소드: toString
    // 목적: 일반 입장권의 현재 상태를 반환한다
    public String toString() {
        String result = super.toString();
        result += ", 신용카드 결제: " + payByCreditCard + ", 가격: " + (int) getPrice();
        return result;
    }
}
