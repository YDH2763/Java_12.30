package day01;

public class Ex02_Varabe_Char {

	public static void main(String[] args) {
		char ch1; // 문자 변수 ch1을 선언, 초기화를 하지 않아서 사용 x
		//System.out.println(ch1);//에러발생
		ch1='1'; // 저장 o
		System.out.println(ch1); // 애로벌생하지 얺움, 저장해서 초기화됨
		
		char ch2 ='한';// 선언과 동시에 초기화했기 때문에 사용가능
		System.out.println(ch2);
		
		char ch3 ='\u0041';// 유니코드 0041에 해당하는 A가 출력
		System.out.println(ch3);
		
		char ch4 ='\\', ch5='\n', ch6 = '\"';
		System.out.println(ch4);
		System.out.println(ch5); //Enter
		System.out.println(ch6);
		
		System.out.println(ch5);
		

	}

}
