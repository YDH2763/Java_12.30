package day06;
import java.util.Arrays;
import java.util.Scanner;
public class Ex09_ProgramScore {

	public static void main(String[] args) {
		/* 학생의 국어 성적을 관리하는 프로그램을 작성*/
		Scanner number=new Scanner(System.in);
		System.out.println("저장할 명단의 크기를 정하세요.");
		int list=number.nextInt();
		String a[]=new String[list];
		int b[]=new int[list];
		Student[]d=new Student[list];
		
		int c=0;
		for(int i=0;;i++) {
			System.out.println("-------메뉴--------");
			System.out.println("1.학생 국어 성적 추가");
			System.out.println("2.학생 국어 성적 전체 조회");
			System.out.println("3.프로그램 종료");
			System.out.println("-----------------");
			System.out.print("메뉴 선택 : ");
			
			char select =number.next().charAt(0);
			System.out.println("");
			System.out.println("-----------------");
			Select(a,b,list,select);
			//d=expend(a,c,list);
			if(select=='3') {
				break;
			}
		}
	}
	public static void studentScore(int n1[], int n2) {
		Scanner number=new Scanner(System.in);
		for(int k=0;k<n2;k++) {
			System.out.println("다음 학생의 성적을 입력하세요.");
			int n=number.nextInt();
			n1[k]=n;
		}
	}
	
	public static void studentName(String n1[], int n2) {
		Scanner number=new Scanner(System.in);
		for(int j=0;j<n2;j++) {
			System.out.println("다음 학생의 이름을 입력하세요");
			String n=number.next();
			n1[j]=n;
		}
	}
	
	public static void studentGraph(String n1[], int n2[], int n3) {
		for(int j=0;j<n3;j++) {
			System.out.print("학생: ");
			System.out.println((String)n1[j]);
			System.out.println(" ");
			System.out.print("성적: ");
			System.out.println(n2[j]+"점");
			System.out.println(" ");
		}
		double sum=0;
		for(int k=0;k<n3;k++) {
			sum +=n2[k];
		}
		double avg=sum/(double)n3;
		System.out.println(n3+"명의 평균은 "+avg+"점");
	}
	
	private static int Select(String a[], int b[], int list, char n4){
		switch(n4) {
		case '1':
			studentName(a,list);
			studentScore(b,list);
			if(n4=='1') {
				break;
			}
		case '2':
			studentGraph(a,b,list);
			if(n4=='2') {
				break;
			}
		case '3':
			System.out.println("프로그램을 종료합니다.");
			break;
		default :
			System.out.println("다시 입력해주세요.");
		}
		return n4;
	}
	
	/*private static Student[] expend(String[] a, int count,int list) {
		if(a == null) {
			return new Student[list];
		}
		if(count < a.length) {
			return a;
		}
		//확장
		Student t[] = new Student[a.length + 5];
		//복사 
		System.arraycopy(a, 0, t, 0, a.length);
		
		return t;
	}*/
	
	private static int insertSudent(Student[] n1, int n2) {
		Scanner number=new Scanner(System.in);
		
		System.out.print("이름 : ");
		number.nextLine();
		String name =number.nextLine();
		
		System.out.print("성적 : ");
		int score =number.nextInt();
		
		Student student =new Student(name, score);
		n1[n2]=student;
		
		return n2++;
	}
	
	private static void printStudent(Student[] n1,int n2) {
		int sum=0;
		for(int i=0;i<n2;i++) {
			n1[i].print();
			sum +=n1[i].getScore();
		}
		double avg = sum/(double)n2;
		System.out.println(avg);
		
	}
}

class Student {
	private int score;
	private String name;
	
	public Student(String name, int score) {
		this.name=name;
		this.score=score;
	}
	public int getScore() {
		return score;
	}
	
	public void print() {
		System.out.println(name +" : "+score);
	}
	
}
