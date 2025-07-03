package sec03;

public class TicketTest {
    public static void main(String[] args) {
        // 번호가 101이고 신용카드로 결제하는 일반 입장권을 나타내는 WalkupTicket 객체를 생성한다
        WalkupTicket ticket1 = new WalkupTicket(101, true);
        // ticket1의 가격을 100,000원으로 정한다
        ticket1.setPrice(100000.0);
        // ticket1의 현재 상태를 출력한다
        System.out.println(ticket1.toString());

        // 20일 전에 구입하는 번호가 201인 예약 입장권을 나타내는 AdvanceTicket 객체를 생성한다
        AdvanceTicket ticket2 = new AdvanceTicket(201, 20);
        // ticket2의 가격을 100,000원으로 정한다
        ticket2.setPrice(100000.0);
        // ticket2의 현재 상태를 출력한다
        System.out.println(ticket2.toString());

        // 30일 전에 구입하는 번호가 202인 예약 입장권을 나타내는 AdvanceTicket 객체를 생성한다
        AdvanceTicket ticket3 = new AdvanceTicket(202, 35);
        // ticket3의 가격을 100,000원으로 정한다
        ticket3.setPrice(100000.0);
        // ticket3의 현재 상태를 출력한다
        System.out.println(ticket3.toString());

        // 5일 전에 구입하는 번호가 203인 예약 입장권을 나타내는 AdvanceTicket 객체를 생성한다
        AdvanceTicket ticket4 = new AdvanceTicket(203, 5);
        // ticket4의 가격을 100,000원으로 정한다
        ticket4.setPrice(100000.0);
        // ticket4의 현재 상태를 출력한다
        System.out.println(ticket4.toString());

    }
}
