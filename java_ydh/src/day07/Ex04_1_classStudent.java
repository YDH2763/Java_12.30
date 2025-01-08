package day07;
import java.util.Scanner;
public class Ex04_1_classStudent {
	
	static Scanner number =new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner number =new Scanner(System.in);
		char menu=0;
		int c=0;	//현재 입력되어있는 배열의 수 
		System.out.println("관리할 학생들의 수를 입력하세요.");
		int n=number.nextInt();
		Student list[] =new Student[n];//입력 가능한 최대 배열의 수
		
		for(int i=1;;i++) {
			System.out.print("메뉴\r\n"
					+ "1. 학생 성적 추가\r\n"
					+ "2. 학생 성적 조회\r\n"
					+ "3. 학생 성적 수정\r\n"
					+ "4. 프로그램 종료\r\n"
					+ "메뉴 선택 : ");
			menu=number.next().charAt(0);
			
			switch(menu) {
			case '1':
				System.out.println("학생 성적 추가");
				System.out.print("학년 : ");
				int grade = number.nextInt();
				System.out.print("반 : ");
				int classNum = number.nextInt();
				System.out.print("번호 : ");
				int num = number.nextInt();
				System.out.print("이름 : ");
				String name = number.next();
				System.out.print("과목 : ");
				String subject = number.next();
				System.out.print("성적 : ");
				int score = number.nextInt();
				Student s=new Student(grade,classNum,num,name,subject,score);
				list[c]=s;
				c++;
				break;
			case '2':
				System.out.println("학생 성적 조회");
				for(int j=1;j<=c;j++) {
					list[j-1].print();	//배열의 시작은 0번부터
				}
				break;
			case '3':
				System.out.println("학생 성적 수정");
				System.out.println("수정할 학생의 정보를 입력하세요.");
				System.out.print("학년 : ");
				grade = number.nextInt();
				System.out.print("반 : ");
				classNum = number.nextInt();
				System.out.print("번호 : ");
				num = number.nextInt();
				System.out.print("과목 : ");
				subject = number.next();
				System.out.println("수정할 성적을 입력하세요.");
				System.out.print("성적 : ");
				score = number.nextInt();
				int index = -1;
				/* 0번지부터 c-1번지까지 list에서 하나씩 꺼내서
				 * list에 정보와 위에서 입력받은 학년, 반, 번호, 과목 정보가 같으면
				 * index에 해당 번지를 저장하고 break로 빠져 나옴
				 * */
				for(int j = 0; j<c; j++) {
					if(list[j].equal(grade, classNum, num, subject)) {
						index = j;
						break;
					}
				}
				if(index >= 0) {
					//index 번지에 있는 학생의 성적을 입력받은 새 성적으로 수정
					list[index].setScore(score);
					System.out.println("학생 정보를 수정했습니다.");
				}else {
					System.out.println("과목이 없거나 학생 정보가 없습니다.");
				}
				break;
			case '4':
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("다시 입력해주세요.");
				break;
			}
			if(menu=='4') {
				break;
			}
		}
		
	}

}

class Student{
	int grade, classNum, num;	//학년, 반, 번호
	String name;				//이름
	String subject;				//과목
	int score;					//점수
	
	public void print() {
		System.out.println(grade + "학년 " + classNum + "반 " + 
				num + "번 " + name + " " + subject + " : " + score);
	}	//배열에 입력된 값을 출력
	
	public boolean equal(int grade, int classNum, int num, String subject) {
		if(this.grade!=grade) {
			return false;
		}
		if(this.classNum!=classNum) {
			return false;
		}
		if(this.num!=num) {
			return false;
		}
		if(!this.subject.equals(subject)) {
			return false;
		}
		return true;
	}
	public void setScore(int score) {
		this.score=score;	//점수(매개변수) 수정
	}
	
	public Student(int grade, int classNum, int num, String name, String subject, int score) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		this.subject = subject;
		this.score = score;
	}	//매개변수 선언
	
	
}