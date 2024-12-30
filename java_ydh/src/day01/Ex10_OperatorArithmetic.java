package day01;

public class Ex10_OperatorArithmetic {
	public static void main(String[] args) {
		int n1=5, n2=3;
		
		System.out.println(n1+"+"+n2+"="+(n1+n2));
		System.out.println(n1+"-"+n2+"="+(n1-n2));
		System.out.println(n1+"x"+n2+"="+(n1*n2));
		//정수 나누기 정수 =>정수 이므로 정수 나누기 실수로 변환해서 계산
		System.out.println(n1+"/"+n2+"="+(n1/(double)n2));
		System.out.println(n1+"%"+n2+"="+(n1%n2));
		
	}

}
