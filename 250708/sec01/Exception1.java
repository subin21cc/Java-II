package sec01;
//단일 예외처리
public class Exception1 {

	public static void main(String[] args) {
		// 예외 배열을 벗어나 인덱스 접근
		String[] names= {"Yang","Oh","Lee","Kim"};
		try {
			System.out.println(names[0]);
			System.out.println(names[1]);
			System.out.println(names[4]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 접근이 잘못됨");
		} finally {
			System.out.println("예외 발생과 상관없이 항상 실행");
		}
		System.out.println("The End");

	}

}
