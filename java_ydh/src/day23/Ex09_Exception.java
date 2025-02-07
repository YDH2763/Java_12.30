package day23;

public class Ex09_Exception {

	public static void main(String[] args) {
		
		/* 0으로 나누었을 대 0으로 나눌 수 없습니다를 처리하도록 수정 */
		double n1=1,n2=0;
		try {
			/* 조건문을 이용해서 n2가 0일때 "0으로 나눌수가 없습니다."으로 출력하게되고 else로 아래 코드를 출력
			 * n2가 0이면 예외를 발생 시켜서 try catch로 예외 처리*/
			if(n2==0) {
				throw new Exception();
			}
			System.out.println(n1+"/"+n2+"="+(n1/n2));
		}catch(Exception e){
			System.out.println("0으로 나눌 수 없습니다.");
			System.out.println("프로그램 종료.");
		}
		
		
	}

}
