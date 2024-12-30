package day01;

public class Ex12_OperatorComparison {

	public static void main(String[] args) {
		//비교 연산자 예제 : 결과가 false 아니면 true
		int n1 =1, n2 =2;
		System.out.println(n1 + ">" + n2 + "?" +(n1>n2));
		System.out.println(n1 + "=" + n2 + "?" +(n1==n2));
		System.out.println(n1 + "<" + n2 + "?" +(n1<n2));
		System.out.println(n1 + ">=" + n2 + "?" +(n1>=n2));
		System.out.println(n1 + "<=" + n2 + "?" +(n1<=n2));
		System.out.println(n1 + "!=" + n2 + "?" +(n1!=n2));
		
		String a1= "abc";
		String a2= "abc";
		String a3= new String("abc");
		System.out.println(a1 + " == "+a2+" ? "+(a1 == a2));
		System.out.println(a1 + " == "+a3+" ? "+(a1 == a3));
		System.out.println(a1 + " != "+a2+" ? "+(a1 != a2));
		System.out.println(a1 + " != "+a3+" ? "+(a1 != a3));
		
		System.out.println("------------");
		System.out.println(a1 + " equals "+a2+" ? "+(a1.equals(a2)));
		System.out.println(a1 + " equals "+a3+" ? "+(a1.equals(a3)));
		
		

	}

}
