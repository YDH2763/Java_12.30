package homework;

import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
public class StudentMain {
	
	static Scanner number =new Scanner(System.in);
	static ArrayList<Student> stulist =new  ArrayList<Student>();
	static ArrayList<Subject> sublist =new  ArrayList<Subject>();
	static ArrayList<Score> scolist =new  ArrayList<Score>();
	
	public static void main(String[] args) {
		/*	학생성적 관리 프로그램을 작성하라
		 * 1.학생 등록		=>학년,반,번호,이름을 입력받아 등록
		  				  이미 등록된 학생정보(학년 반 번호가 같은 경우)등록 x
		 * 2.학생 수정		=>학년 반 번호를 입력받아 학생이 있는지 찾고 있으면 수정
		 				  수정하는 정보는 학년 반 번호 이름을 수정
		 				  이미 등록괸 학생 정보로 수정하려고 하면 수정 x
		 * 3.학생 삭제		=>학년 반 번호를 입력받아 학생이 있는지 찾고 있으면 삭제
		 * 4.과목 등록		=>학년 학기 과목명을 입력받아 없으면 등록
		 * 5.과목 수정		=>학년 학기 과목을 입력받아 있으면 학년 학기 과목을 입력받아 수정
		 				  수정하려는 과목이 이미 등록된 과목이면 수정 x
		 * 6.과목 삭제		=>학년 학기 과목을 입력받아 있으면 삭제
		 * 7.성적 등록		=>학년 반 번호를 입력받아 학생을 찾음
		 				  있으면 과목을 출력
		 				  과목을 선택
		 				  성적을 입력해서 학생 성적을 등록
		 * 8.성적 수정		=>학년 반 번호를 입력받아 학생을 찾음
		 				  있으면 학년 학기 과목명을 입력받고 있으면 성적을 입력받아 수정
		 * 9.성적 삭제		=>학년 반 번호를 입력받아 학생을 찾음
		 				  있으면 학년 학기 과목명을 입력받고 있으면 삭제
		 * 10.학셍 조회	=>학년 반을 입력하면 학생들을 조회
		 * 11.과목 조회	=>등록괸 과목 전체를 조회
		 * 12.성적 조회	=>학년 반 번호 성적을 조회
		 * */
		int c=0;
		for(int i=0;;i++) {
			printMenu();
			int s =number.nextInt();
			number.nextLine();
			runMenu(s);
			if(s==13) {
				break;
			}
		}
		
	}

	private static void runMenu(int s) {
		switch(s) {
		case 1 :
			inputStudent();
			return;
		case 2 :
			renameStudent();
			return;
		case 3 :
			deleteStudent();
			return;
		case 4 :
			inputSubject();
			return;
		case 5 :
			renameSubject();
			return;
		case 6 :
			deleteSubject();
			return;
		case 7 :
			inputScore();
			return;
		case 8 :
			renameScore();
			return;
		case 9 :
			deleteScore();
			return;
		case 10 :
			searchStudent();
			return;
		case 11 :
			searchSubject();
			return;
		case 12 :
			searchScore();
			return;
		case 13 :
			System.out.println("프로그램 종료");
			return;
		default:
			return;
		}
		
	}

	private static void inputStudent() {
		System.out.println("1.학생 등록");
		System.out.println("학생의 이름을 입력하세요.");
		String name=number.next();
		System.out.println("학생의 학년을 입력하세요.");
		int grade=number.nextInt();
		System.out.println("학생의 반을 입력하세요.");
		int classNum=number.nextInt();
		System.out.println("학생의 번호을 입력하세요.");
		int num=number.nextInt();
		scanStudent(grade,classNum,num);
		Student std= new Student(grade, classNum, name, num);
		stulist.add(std);
		System.out.println("입력되었습니다.");
		return;
	}

	private static void scanStudent(int grade, int classNum, int num) {
		if(stulist.contains(grade)||stulist.contains(classNum)||stulist.contains(num)) {
			System.out.println("반, 학년, 번호가 이미 다른 학생이랑 겹칩니다.");
			return;
		}
	}

	private static void renameStudent() {
		System.out.println("2.학생 수정");
		System.out.println("수정할 학생의 이름을 입력하세요.");
		String name=number.next();
		if(stulist.contains(name)) {
			int index=stulist.indexOf(name);
			System.out.println("학생의 이름을 입력하세요.");
			String newname=number.next();
			System.out.println("학생의 학년을 입력하세요.");
			int newgrade=number.nextInt();
			System.out.println("학생의 반을 입력하세요.");
			int newclassNum=number.nextInt();
			System.out.println("학생의 번호을 입력하세요.");
			int newnum=number.nextInt();
			
		}
		else {
			System.out.println("입력한 학생이 존재하지 않습니다.");
			return;
		}
		return;
		
	}

	private static void deleteStudent() {
		System.out.println("3.학생 삭제");
		System.out.println("삭제할 학생의 이름을 입력하세요.");
		String name=number.next();
		if(stulist.contains(name)) {
			
		}
		else {
			System.out.println("입력한 학생이 존재하지 않습니다.");
			return;
		}
	}

	private static void inputSubject() {
		System.out.println("4.과목 등록");
		System.out.println("과목을 입력하세요.");
		String subject=number.next();
		Subject sub = new Subject(subject);
		sublist.add(sub);
		System.out.println("입력되었습니다.");
		
	}

	private static void renameSubject() {
		System.out.println("5.과목 수정");
		System.out.println("수정할 과목을 입력하세요.");
		String subject=number.next();
		if(sublist.contains(subject)) {
			int index=sublist.indexOf(subject);
			System.out.println("과목을 다시 입력해주세요.");
			String newsubject=number.next();
			
		}
		else{
			
		}
		
		
	}

	private static void deleteSubject() {
		System.out.println("6.과목 삭제");
		System.out.println("삭제할 과목을 입력하세요.");
		String subject=number.next();
		if(!sublist.contains(subject)) {
			System.out.println("과목이 존재하지 않습니다.");
			return;
		}
		
		
	}

	private static void inputScore() {
		System.out.println("7.점수 등록");
		System.out.println("시험을 본학생의 이름을 입력하세요.");
		String name=number.next();
		if(!stulist.contains(name)) {
			System.out.println("학생이 존재하지 않습니다.");
			return;
		}
		System.out.println("학생이 시험을 본 과목을 입력하세요.");
		String subject=number.next();
		if(!sublist.contains(subject)) {
			System.out.println("시험을 본 과목이 아닙니다.");
			return;
		}
		System.out.println("점수를 입력하세요.");
		int score=number.nextInt();
		if(score>100||score<0) {
			System.out.println("점수를 잘못 입력하엿습니다.");
			System.out.println("점수의 범위는 '0'이상'100'이하 입니다.");
			return;
		}
		Score sco =new Score(name,subject,score);
		scolist.add(sco);
		System.out.println("학생의 점수를 입력하였습니다.");
		
	}

	private static void renameScore() {
		System.out.println("8.점수 수정");
		System.out.println("시험을 본학생의 이름을 입력하세요.");
		String name=number.next();
		if(!stulist.contains(name)) {
			System.out.println("학생이 존재하지 않습니다.");
			return;
		}
		System.out.println("학생이 시험을 본 과목을 입력하세요.");
		String subject=number.next();
		if(!sublist.contains(subject)) {
			System.out.println("시험을 본 과목이 아닙니다.");
			return;
		}
		
	}

	private static void deleteScore() {
		System.out.println("9.점수 삭제");
		System.out.println("시험을 본학생의 이름을 입력하세요.");
		String name=number.next();
		if(!stulist.contains(name)) {
			System.out.println("학생이 존재하지 않습니다.");
			return;
		}
		System.out.println("학생이 시험을 본 과목을 입력하세요.");
		String subject=number.next();
		if(!sublist.contains(subject)) {
			System.out.println("시험을 본 과목이 아닙니다.");
			return;
		}
		
		
	}

	private static void searchStudent() {
		System.out.println("10.학생 조회");
		System.out.println("학생의 이름을 입력하세요.");
		String name=number.next();
		if(!stulist.contains(name)) {
			System.out.println("학생이 존재하지 않습니다.");
			return;
		}
		else {
			int index =stulist.indexOf(name);
			System.out.println(sublist.get(index));
		}
		
	}

	private static void searchSubject() {
		System.out.println("11.과목 조회");
		System.out.println(sublist);
		
		
		
	}

	private static void searchScore() {
		System.out.println("12.점수 조회");
		System.out.println("시험을 본학생의 이름을 입력하세요.");
		String name=number.next();
		if(!stulist.contains(name)) {
			System.out.println("학생이 존재하지 않습니다.");
			return;
		}
		
		
	}

	private static void printMenu() {
		System.out.println("1.학생 등록");
		System.out.println("2.학생 수정");
		System.out.println("3.학생 삭제");
		System.out.println("4.과목 등록");
		System.out.println("5.과목 수정");
		System.out.println("6.과목 삭제");
		System.out.println("7.점수 등록");
		System.out.println("8.점수 수정");
		System.out.println("9.점수 삭제");
		System.out.println("10.학생 조회");
		System.out.println("11.과목 조회");
		System.out.println("12.점수 조회");
		System.out.print("메뉴 선택 : ");
	}

}

