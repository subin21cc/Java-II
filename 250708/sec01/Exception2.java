package sec01;

//다중 예외 처리
public class Exception2 {

	public static void main(String[] args){
		Student[] students = new Student[5];
        students[0] = new Student( "STU001", "홍길동" );
        students[1] = new Student( "STU002", "홍길순" );
        for(Student s:students) {
        	try {
        		System.out.println(s.getName());	
			} catch (NullPointerException e) {
				System.out.println("값이 null입니다.");
			}
        }
        	
	}
}
