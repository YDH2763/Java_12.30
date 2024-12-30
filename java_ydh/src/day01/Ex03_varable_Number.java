package day01;

public class Ex03_varable_Number {

	public static void main(String[] args) {
		byte n1 = 1;
		//n1=12345;//byte가 저장할 수 있는 범위를 넘었기 때문에 에러가 발생
		System.out.println(n1);
		
		int n2 = 12345678;
		//n2=123456789012;//int가 저장할 수 있는 범위를 넘었기 때문에 에러가 발생
		System.out.println(n2);
		
		long n3 = 123456789012L; //접미사 L(l)이 안 붇이면 에러 발생.
								//L이 안붇으면 int형이기 때문
		System.out.println(n3);
		
		float n4 = 3.14F;//3.14는 더블(double)형이기 때문에 float에 저장할 수 없음
						//접미사 F(f) 를 붙여야 한다.
		
		System.out.printf("%.9f\n", n4);//소수점 9자리까지 확인.
		
		double n5 = 3.14;
		System.out.printf("%.20f\n", n5);//소수점 20자리까지 확인.
		
		//10진수 표현이 아닌 값을 정수에 저장하는 예제
		int n6 = 0x10;//16진수 10=>16
		int n7 = 010;//8진수 10=>8
		int n8 = 0b10;//2진수 1=>2
		int n9 = 'A';//'A'의 해당하는 정수값(16진법 0041)이 저장 =>65
		double n10 = 1e3;//1*10^3 =>1000
		
		System.out.println(n6);
		System.out.println(n7);
		System.out.println(n8);
		System.out.println(n9);
		System.out.println(n10);
		
	}

}
