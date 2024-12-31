package day02;

public class Ex07_IfNumber {

	public static void main(String[] args) {
		/* n이 0보다 크면 양수라고 출력하고
		 * n이 0이면 0이라고 출력하고
		 * n이 0보다 작으면 음수라고 출력하는 코드를 작성
		 * */
		int n=100;
		
		if(n>0) {
			System.out.println("n의 값 "+n+"는 양수");
		}
		else if(n<0) {
			System.out.println("n의 값 "+n+"는 음수");
		}
		else {
			System.out.println("n의 값 "+n+"는 0");
		}
		
	}

}
