package day23;

public class Ex08_Exception {

	public static void main(String[] args) {
		/*다음 코드를 실행했을때 생기는 예외에 대한 원인과 해결 방법에 대해 설명하세요.*/
		try {
			/*방법1 : n2가 0이 되지 않게 수정*/
			int n1=1,n2=0;
			/*방법2 : try catch를 이용하여 예외 처리*/
			System.out.println(n1+"/"+n2+"="+(n1/n2));
		}catch(Exception e){
			System.out.println("0으로 나눌 수 없습니다.");
		}
		System.out.println("프로그램 종료");
	}

}
