package day04;

public class Ex06_VariableArgumrnt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Sum(1));
		System.out.println(Sum(1,2));
		System.out.println(Sum(1,2,3));
		
		System.out.println(1);
		System.out.println('1');
		System.out.println("1");
		System.out.println(1.2);
		
	}
	//가변 매개변수를 이용하여 여러개의 정수를 합하는 메소드 예제
	
	public static int Sum(int ...nums) {
		int Sum =0;
		for(int n1 : nums) {
			Sum += n1;
		}
		return Sum;
	}
	
}
