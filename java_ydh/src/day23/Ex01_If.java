package day23;

public class Ex01_If {

	public static void main(String[] args) {
		/*짝수이면 짝수라고 출력하고, 2를 나눈값을 출력
		 * 홀수면 홀수라고 출력하고 +1한 값을 출력*/
		int n=2;
		if(n%2 == 0) {
			System.out.println("짝수");
			System.out.println(n/2);
		}
		if(n%2 == 1) {
			System.out.println("홀수");
			System.out.println(n+1);
		}

	}

}
