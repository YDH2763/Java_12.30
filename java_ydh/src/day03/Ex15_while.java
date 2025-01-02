package day03;

public class Ex15_while {

	public static void main(String[] args) {
		/*1에서 10사이의 짝수를 출력하는 while문 예제*/
		int a=0;
		while(a<=10) {
			if(a>0&&a%2==0) {
				System.out.print(a+", ");
			}
			a++;
		}
		//while문에서 continue를 만나면 증감식이 아닌 조건식으로 이동
	}

}
