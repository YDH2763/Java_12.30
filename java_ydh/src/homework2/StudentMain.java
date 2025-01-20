package homework2;

import java.util.Scanner;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
		int s=0;
		for(int i=0;;i++) {
			printMenu();
			try {
				s =number.nextInt();
				removeBuffer();
				runMenu(s);
			}catch(InputMismatchException e) {
				System.out.println("올바르게 입력되지 않았습니다.");
				removeBuffer();
			}
			if(s==13) {
				break;
			}
		}
		
	}

	private static void removeBuffer() {
		number.nextLine();
		
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
		//학년, 반, 번호, 이름 입력
		//주의: 학생 추가시 성적 리스트를 생성
		System.out.println("1.학생 등록");
		System.out.println("학생의 이름을 입력하세요.");
		String name=number.next();
		System.out.println("학생의 학년을 입력하세요.");
		int grade=number.nextInt();
		System.out.println("학생의 반을 입력하세요.");
		int classNum=number.nextInt();
		System.out.println("학생의 번호을 입력하세요.");
		int num=number.nextInt();
		//입력받은 학년, 반, 번호, 이름을 이용하여 객체 생성=>리스트에 있는 기능을 활용하기 위해
		Student std= new Student(grade, classNum, name, num);
		stulist.add(std);
		//생성한 객체가 리스트에 있는지 확인하여 있으면 종료=>student클래스의 equals를 오버라이딩
		//리스트.indexOf(객체2)=>Object.equals(객체1,객체2)=>객체1.equals(객체2)
		//없으면 리스트에 추가후 안내 문구
		scanStudent(std);
	
	}

	

	private static void scanStudent(Student std) {
		Stream<Student> stream =stulist.stream();
		/*if(stulist.indexOf(std).equals()) {
			System.out.println("이미 등록되어있는 학생입니다.");
			return;
		}*/
		System.out.println("입력되었습니다.");
		return;
		
	}

	private static void renameStudent() {
		//학년, 반, 번호 입력
		System.out.println("2.학생 수정");
		System.out.println("수정할 학생의 이름을 입력하세요.");
		String name=number.next();
		//입력한 학생 정보를 객체 생성
		ArrayList<Student>templist=searchStudentlist(name);
		for(int i=0;i<templist.size();i++) {
			System.out.println((i+1)+"."+templist.get(i));
		}
		//생성한 객체가 리스트에 있으면 번지를 가져옴
		System.out.println("다음 학생중 수정할 번호를 고르세요.");
		int index = number.nextInt()-1;
		number.nextLine();
		Student std =templist.get(index);
		//번지가 음수이면 안내문구를 출력후 종료
		
		//아니면 수정할 학년, 반, 번호, 이름을 입력
		System.out.println("학생의 이름을 입력하세요.");
		String newname=number.next();
		System.out.println("학생의 학년을 입력하세요.");
		int newgrade=number.nextInt();
		System.out.println("학생의 반을 입력하세요.");
		int newclassNum=number.nextInt();
		System.out.println("학생의 번호을 입력하세요.");
		int newnum=number.nextInt();
		//입력받은 정보로 객체를 생성
		//번지에 있는 객체를 위에서 생성한 객체로 변경
		std.update(newgrade, newclassNum, newnum, newname);
		System.out.println("다음 학생의 정보가 수정되었습니다.");
		return;
		
	}

	private static ArrayList<Student> searchStudentlist(String name) {
		ArrayList<Student>templist=new ArrayList<Student>();
		for(Student std:stulist) {
			if(std.getName().contains(name)) {
				templist.add(std);
			}
			
		}
		return templist;
	}

	private static void deleteStudent() {
		//학년, 반, 번호, 입력
		System.out.println("3.학생 삭제");
		System.out.println("삭제할 학생의 이름을 입력하세요.");
		String name=number.next();
		if(!stulist.contains(name)) {
			System.out.println("입력한 학생이 존재하지 않습니다.");
			return;
		}
		//입력받은 정보를 객체 생성
		ArrayList<Student> templist=searchStudentNumberlist(name);
		for(int j=0;j<templist.size();j++) {
			System.out.println((j+1)+"."+templist.get(j));
		}
		if(printStudentNumberlist(templist,true)) {
			return;
		}
		System.out.println("다음 학생중 삭제할 학생의 번호를 입력하세요.");
		int index=number.nextInt()-1;
		number.nextLine();
		//생성한 객체를 이용하여 리스트에서 삭제
		//삭제에 성공하면 성공 알림 문구
		Student std =templist.get(index);
		stulist.remove(std);
		System.out.println("삭제하였습니다.");
		//실패하면 실패 알림문구 출력
		
		return;
	}

	private static boolean printStudentNumberlist(ArrayList<Student> templist, boolean b) {
		if(templist==null||templist.size()==0) {
			System.out.println("아직 등록되지 않았습니다.");
			return false;
		}
		for(int j=0;j<templist.size();j++) {
			if(b) {
				System.out.println((j+1)+".");
			}
			System.out.println(templist.get(j));
		}
		return false;
	}

	private static ArrayList<Student> searchStudentNumberlist(String name) {
		ArrayList<Student> templist= new ArrayList<Student>();
		for(Student s : stulist) {
			if(s.getName().contains(name)) {
				templist.add(s);
			}
		}
		return templist;
	}

	private static void inputSubject() {
		//학년, 학기, 과목명을 입력
		System.out.println("4.과목 등록");
		//학년
		System.out.println("학년을 입력하세요.(3학년 이하로 입력)");
		int grade=number.nextInt();
		if(grade>3) {
			System.out.println("잘못 입력하였습니다.");
			return;
		}
		//학기
		System.out.println("학기를 입력하세요.(2학기 이하)");
		int term=number.nextInt();
		if(term>2) {
			System.out.println("잘못 입력하였습니다.");
			return;
		}
		//과목
		System.out.println("과목을 입력하세요.");
		String subject=number.next();
		//이미 등록된 과목이면 알림 후 종료=>Subject 클래스의 equals를 오버라이딩
		
		//과목을 추가 후 알림
		Subject sub = new Subject(subject);
		sublist.add(sub);
		System.out.println("입력되었습니다.");
		
	}

	private static void renameSubject() {
		//학년, 학기, 과목명을 입력
		System.out.println("5.과목 수정");
		System.out.println("수정할 과목을 입력하세요.");
		String subject=number.next();
		//등록된 과목이 아니면 알림 후 종료=>indexOf로 번지를 가져와서 사용
		
		ArrayList<Subject>templist=searchSubjectlist(subject);
		for(int i=0;i<templist.size();i++) {
			System.out.println((i+1)+"."+templist.get(i));
		}
		//새 과목 정보를 입력(학년, 학기, 과목)
		System.out.println("다음 과목중 수정할 번호를 고르세요.");
		int index = number.nextInt()-1;
		number.nextLine();
		Subject sub =templist.get(index);
		System.out.println("과목을 수정하세요.");
		String newsubject=number.next();
		//등록된 과목이면 알림 후 종료
			//리스트에서 index 번지에 있는 값을 제거 후 제거된 객체를 저장
		
			//제거된 리스트에 새 과목정보와 일치하는 과목이 있으면 제거된 객체를 다시 저장
		
		//아니면 수정
			//새 객체를 다시 추가
		sub.update(newsubject);
		System.out.println("과목이 수정되었습니다.");
	}

	private static ArrayList<Subject> searchSubjectlist(String subject) {
		ArrayList<Subject>templist=new ArrayList<Subject>();
		for(Subject sub:sublist) {
			if(sub.getSubject().contains(subject)) {
				templist.add(sub);
			}
		}
		return templist;
	}

	private static void deleteSubject() {
		//학년, 학기, 과목명을 입력
		System.out.println("6.과목 삭제");
		System.out.println("삭제할 과목을 입력하세요.");
		String subject=number.next();
		//입력한 정보로 객체를 생성
		ArrayList<Subject>templist=searchSubjectlist(subject);
		for(int i=0;i<templist.size();i++) {
			System.out.println((i+1)+"."+templist.get(i));
		}
		//리스트에서 생성한 객체를 제거해서 성공하면 성공 알림 그리고 실패하면 실패 알림
		System.out.println("다음 과목중 삭제할 번호를 고르세요.");
		int index = number.nextInt()-1;
		number.nextLine();
		Subject sub =templist.get(index);
		sublist.remove(sub);
		System.out.println("삭제되었습니다.");
		return;
	}

	private static void inputScore() {
		//학년, 반, 번호를 입력
		
		//입력한 정보로 객체를 생성(Student)
		
		//리스트에 있는지 확인해서 없으면 알림후 종료
		
		System.out.println("7.점수 등록");
		System.out.println("시험을 본학생의 이름을 입력하세요.");
		String name=number.next();
		if(!stulist.contains(name)) {
			System.out.println("학생이 존재하지 않습니다.");
			return;
		}
		//학년, 학기, 과목을 입력
		System.out.println("학생이 시험을 본 과목을 입력하세요.");
		String subject=number.next();
		if(!sublist.contains(subject)) {
			System.out.println("시험을 본 과목이 아닙니다.");
			return;
		}
		//입력한 정보로 객채를 생성(Subject)
		
		//과목 리스트에 등록된 과목인지 확인후 아니면 알림 후 종료
		
		//성적을 입력해서 과목 정보와 성적을 이용하여 객체를 생성(Score)
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
		//학생을 선택하여 객체 저장 list.get(xx).update()=>temp.update()
		
		//학생 성적에 새 성적이 있는지 확인해서 없으면 추가 후 알림
		//있으면 추가 안하고 알림
		
		//학생에게 새 성적을 주고 추가 하라고 시킨 후 추가 여부를 이용하여 추가했으면 성공 알림
		//실패했으면 실패 알림
	}

	private static void renameScore() {
		//학년, 반, 번호를 입력
		System.out.println("8.점수 수정");
		System.out.println("시험을 본학생의 이름을 입력하세요.");
		String name=number.next();
		if(!scolist.contains(name)) {
			System.out.println("시험을 보지 않은 학생입니다.");
			return;
		}
		//입력한 정보로 객체 생성(Student)
		
		//리스트에 있는지  확인해서 없으면 알림 후 종료=>indexOf
		
		ArrayList<Score>templist=searchScorelist(name);
		for(int i=0;i<templist.size();i++) {
			System.out.println((i+1)+"."+templist.get(i));
		}
		System.out.println("다음 학생 중 수정할 번호를 고르세요.");
		int index = number.nextInt()-1;
		number.nextLine();
		Score sco =templist.get(index);
		System.out.println("시험을 본학생의 이름을 입력하세요.");
		String newname=number.next();
		if(!stulist.contains(newname)) {
			System.out.println("학생이 존재하지 않습니다.");
			return;
		}
		//학년, 학기, 과목을 입력
		
		//입력한 정보로 객채를 생성(Subject)
		
		//과목 리스트에 등록된 과목인지 확인후 아니면 알림 후 종료
		
		//새 과목 정보를 입력(학년,학기,과목)을 입력
		
		//과목 리스트에 등록된 과목인지 확인후 아니면 알림 후 종료
				
		System.out.println("학생이 시험을 본 과목을 입력하세요.");
		String newsubject=number.next();
		if(!sublist.contains(newsubject)) {
			System.out.println("시험을 본 과목이 아닙니다.");
			return;
		}
		//성적을 입력
		System.out.println("점수를 입력하세요.");
		int newscore=number.nextInt();
		if(newscore>100||newscore<0) {
			System.out.println("점수를 잘못 입력하엿습니다.");
			System.out.println("점수의 범위는 '0'이상'100'이하 입니다.");
			return;
		}
		//새 과목 정보와 성적을 이용하여 성적 객체를 생성
		sco.newScore(newname,newsubject,newscore);
		//학생에게 기존 과목 정보와 성적 정보를 주면서 수정하라고 요청한 후 성공하면 알림
		
		//실패하면 알림
		System.out.println("다음 학생의 과목과 성적이 수정되었습니다.");
		
	}

	private static ArrayList<Score> searchScorelist(String name) {
		ArrayList<Score> templist = new ArrayList<Score>();
		for(Score sco:scolist) {
			if(sco.getName().contains(name)) {
				templist.add(sco);
			}
		}
		return templist;
	}

	private static void deleteScore() {
		System.out.println("9.점수 삭제");
		//학년, 반, 번호를 입력
		System.out.println("시험을 본학생의 이름을 입력하세요.");
		String name=number.next();
		//입력한 정보로 객체 생성(Student)
		
		//리스트에 있는지  확인해서 없으면 알림 후 종료=>indexOf
				
		if(!scolist.contains(name)) {
			System.out.println("시험을 보지 않은 학생입니다.");
			return;
		}
		ArrayList<Score>templist=searchScorelist(name);
		for(int i=0;i<templist.size();i++) {
			System.out.println((i+1)+"."+templist.get(i));
		}
		//학년, 반, 번호를 입력
		
		//입력한 정보로 객채를 생성(Subject)
		
		//과목 리스트에 등록된 과목인지 확인후 아니면 알림 후 종료
				
		//새 과목 정보를 입력(학년,학기,과목)을 입력
				
		//과목 리스트에 등록된 과목인지 확인후 아니면 알림 후 종료
						
		//실패하면 실패 알림
		System.out.println("다음 학생 중 수정할 번호를 고르세요.");
		int index = number.nextInt()-1;
		number.nextLine();
		Score sco =templist.get(index);
		scolist.remove(sco);
		System.out.println("삭제되었습니다.");
		return;
		
	}

	private static void searchStudent() {
		System.out.println("10.학생 조회");
		//학년, 반, 번호를 입력
		System.out.println("학생의 이름을 입력하세요.");
		String name=number.next();
		//입력한 정보를 이용해서 객체를 생성
		ArrayList<Student>templist=searchStudentlist(name);
		//리스트에서 일치하는 학생 정보를 출력
		printStudentlist(templist,false);
		
		
	}

	private static boolean printStudentlist(ArrayList<Student> templist, boolean b) {
		if(templist==null||templist.size()==0) {
			System.out.println("결과가 없습니다.");
			return false;
		}
		for(int i=0;i<templist.size();i++) {
			if(b) {
				System.out.print(i+1+".");
			}
			System.out.println(templist.get(i));
		}
		return true;
	}

	private static void searchSubject() {

		System.out.println("11.과목 조회");
		//등록된 과목 전체 출력
		System.out.println(sublist);
		return;
		
		
	}

	private static void searchScore() {
		System.out.println("12.점수 조회");
		//학년, 반, 번호를 입력
		System.out.println("시험을 본학생의 이름을 입력하세요.");
		String name=number.next();
		//입력한 정보를 이용해서 객체를 생성
		
		//리스트에서 일치하는 학생이 있으면 정보를 출력
		
		//
		if(!stulist.contains(name)) {
			System.out.println("학생이 존재하지 않습니다.");
			return;
		}
		else {
			int index =scolist.indexOf(name);
			System.out.println(scolist.get(index));
		}
		//학년, 학기, 과목명을 입력
		
		//과목 정보로 객체를 생성
		
		//리스트에서 학생을 선택
		
		//선택한 학생에게 과목정보를 주면서 성적을 출력하고 요청
		return;
		
	}

	private static void printMenu() {
		System.out.println("-----------------");
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
		System.out.println("13.프로그램 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");
	}

}

