package sec02;

import java.util.Scanner;

public class UserTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] list = new User[100];
        int num;
        while (true){
            User.show();
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.print("id: ");
                    String id = scanner.next();
                    System.out.print("pw: ");
                    String pw = scanner.next();
                    list[User.cnt] = new User(id, pw);
                    User.cnt++;
                    break;

                case 2:
//                    for (User user : list) {
//                        System.out.println("{ " + user.id + ", " + user.pw + " }");
//
//                    }
                    for(int i=0; i<User.cnt; i++) {
                        System.out.println("{ " + list[i].id + ", " + list[i].pw + " }");
                    }
                    System.out.println("총 회원수는 " + User.cnt + "명 입니다.");
                    break;

                case 3: // 종료
                    System.out.println("Exit");
                    System.exit(0);
            }
        }
    }
}
