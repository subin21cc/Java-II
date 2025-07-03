package sec01;

import java.util.Scanner;

public class SongTest {
    public static void main(String[] args) {
        // 객체배열 생성
        Song[] list = new Song[3];
        Scanner s = new Scanner(System.in);

        /*
        list[0] = new Song("제니", "I like jennie");
        list[1] = new Song("제니", "I like jennie");
        list[2] = new Song("제니", "I like jennie");
        */

        for(int i=0; i<list.length; i++) {
            String singer, title;
            System.out.print("singer: ");
            singer = s.nextLine();
            System.out.print("title: ");
            title = s.nextLine();
            list[i] = new Song(singer, title);
        }

        // 객체정보 출력
        for(int i=0; i<list.length; i++) {
            System.out.println(list[i].singer + list[i].title);
        }

        // for~each문
        for(Song ss : list) {
            System.out.println(ss.singer + ss.title);
        }
    }
}
