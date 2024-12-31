package day02;

public class Ex04_IfEvenNumber {

	public static void main(String[] args) {
		//홀짝 판별 예제
		int n=3;
		//n이 짝수면 짝수라고 출력
		//n을 2로 나누었을 때 나머지가 0과 같다.
		if(n%2==0) {
			System.out.println(n+"은 짝수");
		}
		
		//n이 홀수라면 홀수라고 출력
		//n을 2로 나누었을때 나머지가 0과 같지 않다.
		
		if(n%2!=0) {
			System.out.println(n+"은 홀수");
		}
		
		

	}

}
