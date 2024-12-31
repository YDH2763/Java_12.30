package day02;

public class Ex01_OperatorLogical {

	public static void main(String[] args) {
		
		//성적을 저장하기위한 정수 변수를 선언하고, 80으로 초기화
		//자료형((ex)int) 변수명((ex)n1) = 초기값;
		int n1;
		n1=90;
		/*성적이 80점 이상이고 90점 미만이다.
		 * n1이 80보다 (크거나 같)(고) 90보다 (작다)
		 * n1이 80보다 (크거나 같다) && n1이 90보다 (작다)
		 * && =and, || = or, ! = not
		 */
		boolean isB = (n1>=80 && n1<90);
		System.out.println(n1 +"는 B입니까?" +isB);
		
		int age = 15;
		boolean isAdult = (age>=19);
		System.out.println(age +"살은 성인입니까?" +isAdult);
		//나이가 19세 이상이 아니면 미성년자로 판별하는 예제(!연산자)
		System.out.println(age +"살은 미성년자입니까?" +!isAdult);
		
		//정수가 0이상인지 판별하는 예제(||연산자)
		int n2=-1;
		//n2가 0보다 크거나 n2이 0이랑 같다.
		boolean isPositive = (n2>0||n2==0);
		System.out.println(n2+ "는 0이상인가?" +isPositive);
		
		

	}

}
