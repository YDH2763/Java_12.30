package day11;
import java.util.Scanner;
public class Ex01_Lambda {
	static Scanner number = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("두 단어를 입력하세요.");
		int a=number.nextInt();
		int b=number.nextInt();
		/*인터페이스의 객체를 생성하기위해 구현 클래스를 선언 후 구현 클래스의 객체를 생성*/
		MyMath mc=new MyMathClass();
		System.out.println(mc.max(a, b));
		
		/*인터페이스의 객체를 생성하기 위해 익명 클래스를 선언 후 객체를 생성*/
		MyMath mc1 =new MyMath() {

			@Override
			public int max(int n1, int n2) {
				// TODO Auto-generated method stub
				return n1 > n2 ? n1 : n2 ;
			}
			
		};
		System.out.println(mc1.max(a, b));
		
		/* 인터페이스의 객체를 생성하기 위해 익명 클래스를 선언 후 객체를 생성 : 람다식*/
		MyMath mc2=(n1,n2)-> n1 > n2 ? n1 : n2 ;;	//식이 짧은 경우 중괄호 없이 작성 가능
		System.out.println(mc2.max(a, b));
		
		Abs abs=(n) -> n < 0 ? - n : n ;
		System.out.println(abs.abs(-10));
		
	}

}
interface Abs{	//절댓값
	int abs(int n);
}
interface MyMath{
	int max(int n1, int n2);
}
//구현 클래스
class MyMathClass implements MyMath{

	@Override
	public int max(int n1, int n2) {
		
		return n1 > n2 ? n1 : n2 ;
	}
	
}