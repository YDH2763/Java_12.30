package day02;

public class Ex17_For {

	public static void main(String[] args) {
		/*Hello World를 5번 출력하는 예제
		 * 반복횟수: int i=0;선언하고 i가 5가 될때까지 계속 1씩 증가 
		 * 규칙성: Hello World를 출력
		 * 반복문 종료 후: 없음
		 * */
		//for문
		for(int i=0;i<5;i++) {//i=1으로 선언할 때 i<=5으로 선언
			System.out.println("Hello World");
		}
		
		System.out.println("--------------");
		
		//while문
		int k=0;
		while(k<5) {
			System.out.println("Hello World");
			k++;
		}

	}

}
