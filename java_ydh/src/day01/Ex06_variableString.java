package day01;

public class Ex06_variableString {

	public static void main(String[] args) {
		
		String a = "Hello World!";
		String b = "";//빈 문자열은 가능
		String c = "A";
		String d = null;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d); //null이라는 문자열이 출력되는 것이 아님
		
		char ch1 ='1'; 
		char operator = '+';
		char ch2 = '2';
		System.out.println(ch1 + operator + ch2 + "");
		System.out.println("" + ch1 + operator + ch2);
		
	}

}
