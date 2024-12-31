package day02;

public class Ex03_OperatorConditional {

	public static void main(String[] args) {
		/*n1가 홀수이면 false라고 출력하고 짝수이면 ture라고 출력하는 예제*/
		//n이 홀수이면 홀수라고 출력하고 짝수이면 짝수라고 출력하는 예제
		
		int n1=4;
		boolean isEven = n1%2==0;
		System.out.println(n1+"는 짝수? "+isEven);
		
		String result =(n1 %2 == 0)?"짝수":"홀수" ;
		System.out.println(n1+"는 "+result);

	}

}
