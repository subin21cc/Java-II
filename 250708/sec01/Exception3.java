package sec01;
import java.io.*;

public class Exception3 {

	public static void main(String[] args) {
		//  텍스트파일 객체 생성
		try {
			FileReader fin=new FileReader("test.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 없습니다.");
		}
	}

}
