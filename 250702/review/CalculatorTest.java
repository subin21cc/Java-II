package review;
import java.util.*;
public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 주요메서드: next(), nextInt(), nextDouble(), nextLine()
		Scanner s=new Scanner(System.in);
		int num1,num2;
		String op;
		System.out.print("num1:");
		num1=s.nextInt();
		System.out.print("operator:");
		op=s.next();
		System.out.print("num2:");
		num2=s.nextInt();
		
		Calculator c=new Calculator(num1,num2);
		//
		c.showinfo(op);
		s.close();
		
	}

}
