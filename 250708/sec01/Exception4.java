package sec01;

public class Exception4 {

	public static void main(String[] args) {
		Student student = null;
		try {
			System.out.println( "성적의 총점을 계산합니다~" );
	        System.out.println( student.getKorean() + student.getEnglish() );
	        System.out.println( "계산 완료 Bye~ Bye~" );
			
		} catch (ArithmeticException e) {
			System.out.println("산술연산이 잘못됨");
		}catch (NullPointerException e) {
			System.out.println("null 객체에 접근할 수 없습니다.");
		}catch (Exception e) {
			System.out.println("알 수 없는 에러 발생!!");
		}		
	}
}
