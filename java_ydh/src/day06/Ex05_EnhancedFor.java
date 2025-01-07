package day06;

public class Ex05_EnhancedFor {

	public static void main(String[] args) {
		int []a=new int[] {1,2,3,4,5};
		
		print(a);
		System.out.println("-------------");
		print2(a);
	}

	public static void print(int [] n1) {
		for(int i=0;i<n1.length;i++) {
			int t=n1[i];
			System.out.print(t+" ");
		}
		System.out.println();
	}
	
	public static void print2(int [] n1) {
		for(int t :n1) {
			System.out.print(t+" ");
		}
		System.out.println();
	}
}
