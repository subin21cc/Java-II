package sec01;

class Book {
    // 필드=멤버변수
    String title;
    String author;
    int price;

    // 생성자
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    Book(String title) {
        this.title = title;
        this.author = "작자미상";
    }

    Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // 멤버메소드:출력가능
    void display() {
        System.out.println("--------------------");
        System.out.println("title: " + title);
        System.out.println("author: " + author);
        System.out.println("price: " + price);
        System.out.println("--------------------");
    }

}
public class BookTest {
    public static void main(String[] args) {
        // 객체 생성
        Book b1 = new Book("자바를 부탁해", "나이화", 25000);
        // 객체 멤버 접근
//        b1.title = "자바를 부탁해";
//        b1.author = "나이화";
//        b1.price = 25000;
        // 출력 : 객체정보조회, 검색, 추가, 수정, 삭제
//        System.out.println("title" + b1.title);
//        System.out.println("author" + b1.author);
//        System.out.println("price" + b1.price);
        b1.display();

    }
}
