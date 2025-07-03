package sec02;

public class User {
    static int cnt;
    String id, pw;

    User(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    static void show() {
        System.out.println("====================================");
        System.out.println("1. 회원가입");
        System.out.println("2. 회원조회");
        System.out.println("3. 종료");
        System.out.println("====================================");
        System.out.print("번호를 입력하세요: ");
    }
}
