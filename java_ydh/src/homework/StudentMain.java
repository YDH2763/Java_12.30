package homework;

import java.util.Scanner;
import java.util.stream.Stream;


import lombok.Getter;
import lombok.Setter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class StudentMain {
	static String studentfileName= "src/homework/student.txt";
	static String subectfileName= "src/homework/subject.txt";
	static String scorefileName= "src/homework/score.txt";
	
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
		
		//불러오기
		
		stuload(studentfileName,stulist);
		 if(stulist ==null) {
			 stulist=new ArrayList<Student>();
		 }
		 
		subload(subectfileName,sublist);
		if(sublist ==null) {
			 sublist=new ArrayList<Subject>();
		 }
		
		scoload(scorefileName,scolist);
		 if(scolist ==null) {
			 scolist=new ArrayList<Score>();
		 }
		 
		int s=0;
		final int Exit=13;
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
			if(s==Exit) {
				stusave(studentfileName,stulist);
				subsave(subectfileName,sublist);
				scosave(scorefileName,scolist);
				break;
			}
		}
		
	}

	private static void stusave(String studentfileName, ArrayList<Student> stulist) {
		try(FileOutputStream fos = new FileOutputStream(studentfileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				
				oos.writeObject(stulist);
				
			} catch (Exception e) {
				System.out.println("[저장하기 실패]");
			}
		return;
	}

	private static void subsave(String subectfileName, ArrayList<Subject> sublist) {
		try(FileOutputStream fos = new FileOutputStream(subectfileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				
				oos.writeObject(sublist);
				
			} catch (Exception e) {
				System.out.println("[저장하기 실패]");
			}
		return;
		
	}

	private static void scosave(String scorefileName, ArrayList<Score> scolist) {
		try(FileOutputStream fos = new FileOutputStream(scorefileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				
				oos.writeObject(scolist);
				
			} catch (Exception e) {
				System.out.println("[저장하기 실패]");
			}
		return;
		
	}

	private static Object scoload(String scorefileName, ArrayList<Score> scolist) {
		try(FileInputStream fis = new FileInputStream(scorefileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
				
			 ArrayList<Score> temp=(ArrayList<Score>) ois.readObject();
			 scolist.addAll(temp);
			 
				
			} catch (Exception e) {
				System.out.println("[불러오기 실패]");
			}
		return scolist;
		
	}

	private static Object subload(String subectfileName, ArrayList<Subject> sublist) {
		try(FileInputStream fis = new FileInputStream(subectfileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			
			 ArrayList<Subject> temp=(ArrayList<Subject>) ois.readObject();
			 sublist.addAll(temp);
			 
				
			} catch (Exception e) {
				System.out.println("[불러오기 실패]");
			}
		return sublist;
		
	}

	private static Object stuload(String studentfileName, ArrayList<Student> stulist) {
		try(FileInputStream fis = new FileInputStream(studentfileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){
				
			 
			 ArrayList<Student> temp=(ArrayList<Student>) ois.readObject();
			 stulist.addAll(temp);
			 
			} catch (Exception e) {
				System.out.println("[불러오기 실패]");
			}
		return stulist;
		
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
		Student std =insertStudent();
		//입력받은 학년, 반, 번호, 이름을 이용하여 객체 생성=>리스트에 있는 기능을 활용하기 위해
		//생성한 객체가 리스트에 있는지 확인하여 있으면 종료=>student클래스의 equals를 오버라이딩
		//리스트.indexOf(객체2)=>Object.equals(객체1,객체2)=>객체1.equals(객체2)
		//없으면 리스트에 추가후 안내 문구
		scanStudent(std);
	
	}


	private static Student insertStudent() {
		Student temp = inputBaseStudent();
		
		removeBuffer();
		System.out.println("이름을 입력하세요.");
		String name=number.next();
		
		temp.setName(name);
		return temp;
	}

	private static Student inputBaseStudent() {
		System.out.println("학생의 학년을 입력하세요.");
		int grade=number.nextInt();
		System.out.println("학생의 반을 입력하세요.");
		int classNum=number.nextInt();
		System.out.println("학생의 번호을 입력하세요.");
		int num=number.nextInt();
		
		return new Student(grade,classNum,"",num);
		
	}

	private static void scanStudent(Student std) {
		if(stulist.contains(std)) {
			System.out.println("이미 등록된 학생입니다.");
			return;
		}
		stulist.add(std);
		System.out.println("입력되었습니다.");
		return;
	}

	private static void renameStudent() {
		System.out.println("2.학생 수정");
		
		Student std = inputBaseStudent();
		
		int index =stulist.indexOf(std);
		
		if(index <0) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		System.out.println("수정할 학생의 정보를 입력하세요.");
		Student newstd =insertStudent();
		
		Student oldstd =stulist.remove(index);
		//번지에 있는 객체를 위에서 생성한 객체로 변경
		if(stulist.contains(newstd)) {
			System.out.println("이미 등록된 학생입니다.");
			stulist.add(index,oldstd);
			return;
		}
		stulist.add(index,oldstd);
		
		stulist.get(index).update(newstd);
		System.out.println("학생을 수정했습니다.");
		
	}

	/*private static ArrayList<Student> searchStudentlist(int grade, int classNum, int num) {
		ArrayList<Student>templist=new ArrayList<Student>();
		for(Student std:stulist) {
				if(std.getGrade()==(grade)) {
					if(std.getClassNum()==(classNum)) {
						if(std.getNum()==(num)) {
							templist.add(std);
						}
					}
				}
			
		}
		return templist;
	}*/

	private static void deleteStudent() {
		//학년, 반, 번호, 입력
		System.out.println("3.학생 삭제");
		Student std=inputBaseStudent();
		//입력받은 정보를 객체 생성
		//생성한 객체를 이용하여 리스트에서 삭제
		//삭제에 성공하면 성공 알림 문구
		if(stulist.remove(std)) {
			System.out.println("학생을 삭제했습니다.");
			return;
		}
		//실패하면 실패 알림문구 출력
		System.out.println("일치하는 학생이 없습니다.");
		
	}

	/*private static boolean printStudentNumberlist(ArrayList<Student> templist, boolean b) {
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
		return true;
	}*/

	

	private static void inputSubject() {
		//학년, 학기, 과목명을 입력
		System.out.println("4.과목 등록");
		Subject subject=insertSubject();
		//이미 등록된 과목이면 알림 후 종료=>Subject 클래스의 equals를 오버라이딩
		scanSubject(subject);
		//과목을 추가 후 알림
		sublist.add(subject);
		System.out.println("과목을 등록하였습니다.");
		System.out.println(sublist);
		return;
		
	}

	private static Subject insertSubject() {
		System.out.println("학년을 입력하세요.(3학년 이하로 입력)");
		int grade=number.nextInt();
		if(grade>3) {
			System.out.println("잘못 입력하였습니다.");
			return null;
		}
		//학기
		System.out.println("학기를 입력하세요.(2학기 이하)");
		int term=number.nextInt();
		if(term>2) {
			System.out.println("잘못 입력하였습니다.");
			return null;
		}
		removeBuffer();
		System.out.println("과목을 입력하세요.");
		String subject=number.next();
		return new Subject(grade, term, subject);
	}

	private static boolean scanSubject(Subject subject) {
			if(stulist.contains(subject)) {
				System.out.println("이미 존재하는 과목 입니다.");
				return false;
			}
		return true;
	}

	private static void renameSubject() {
		//학년, 학기, 과목명을 입력
		System.out.println("5.과목 수정");
		Subject subject =insertSubject();
		//등록된 과목이 아니면 알림 후 종료=>indexOf로 번지를 가져와서 사용
		int index =sublist.indexOf(subject);
		if(index < 0) {
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		//새 과목 정보를 입력(학년, 학기, 과목)
		System.out.println("수정할 과목 정보를 입력하세요.");
		Subject newSubject =insertSubject();
		
		//등록된 과목이면 알림 후 종료
			//리스트에서 index 번지에 있는 값을 제거 후 제거된 객체를 저장
		if(sublist.contains(newSubject)) {
			System.out.println("이미 등록된 과목입니다.");
			return;
		}
			//제거된 리스트에 새 과목정보와 일치하는 과목이 있으면 제거된 객체를 다시 저장
		
		//아니면 수정
		sublist.set(index, newSubject);
		System.out.println("과목이 수정되었습니다.");
	}

	/*private static boolean scanRenamesubject(int grade, int term, String subject) {
		for(Subject subject1:sublist) {
			if(subject1.getGrade()!=grade || subject1.getTerm()!=term || !subject1.getSubject().equals(subject)) {
				System.out.println("과목을 잘못 입력했습니다.");
				return true;
			}
		}
		return false;
	}*/

	/*private static ArrayList<Subject> searchSubjectlist(String subject) {
		ArrayList<Subject>templist=new ArrayList<Subject>();
		for(Subject sub:sublist) {
			if(sub.getSubject().contains(subject)) {
				templist.add(sub);
			}
		}
		return templist;
	}*/

	private static void deleteSubject() {
		//학년, 학기, 과목명을 입력
		System.out.println("6.과목 삭제");
		Subject subject =insertSubject();

		if(sublist.remove(subject)) {
			System.out.println("과목을 삭제했습니다.");
			return;
		}
		System.out.println("일치하는 과목이 없습니다.");
		return;
	}

	private static void inputScore() {
		System.out.println("7.점수 등록");
		System.out.println("학생의 정보를 입력하세요.");
		//학년, 반, 번호를 입력
		Student std=inputBaseStudent();
		//입력한 정보로 객체를 생성(Student)
		int index =stulist.indexOf(std);
		//리스트에 있는지 확인해서 없으면 알림후 종료
		if(index<0) {
			System.out.println("일치하는 학생의 이름이 없습니다.");
			return;
		}
		//학년, 학기, 과목을 입력
		System.out.println("과목을 입력하세요.");
		Subject sub = insertSubject();
		//성적을 입력해서 과목 정보와 성적을 이용하여 객체를 생성(Score)
		System.out.println("점수를 입력하세요.");
		int score=number.nextInt();
		if(score>100||score<0) {
			System.out.println("점수를 잘못 입력하엿습니다.");
			System.out.println("점수의 범위는 '0'이상'100'이하 입니다.");
			return;
		}
		scanStudentScore(name,subject,score);
		System.out.println("학생의 점수를 입력하였습니다.");
		//학생을 선택하여 객체 저장 list.get(xx).update()=>temp.update()
		
		//학생 성적에 새 성적이 있는지 확인해서 없으면 추가 후 알림
		//있으면 추가 안하고 알림
		
		//학생에게 새 성적을 주고 추가 하라고 시킨 후 추가 여부를 이용하여 추가했으면 성공 알림
		//실패했으면 실패 알림
	}

	private static void scanStudentScore(String name, String subject, int score) {
		for(Score scor: scolist) {
			if(scor.getName().equals(name)&&scor.getSub().equals(subject) &&scor.getScore()==score) {
				System.out.println("이미 등록된 학생 점수입니다.");
				return;
			}
			else {
				Score sco =new Score(name,subject,score);
				scolist.add(sco);
			}
		}
		
	}

	private static void renameScore() {
		//학년, 반, 번호를 입력
		System.out.println("학생의 이름을 입력하세요.");
		String name=number.next();
		System.out.println("학생의 학년을 입력하세요.");
		int grade=number.nextInt();
		System.out.println("학생의 반을 입력하세요.");
		int classNum=number.nextInt();
		System.out.println("학생의 번호을 입력하세요.");
		int num=number.nextInt();
		//입력한 정보로 객체 생성(Student)
		ArrayList<Student>temp1=searchStudentlist(grade,classNum,num);
		//리스트에 있는지  확인해서 없으면 알림 후 종료=>indexOf
		if(!stulist.contains(temp1)) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		if(!temp1.getName().equals(name)) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		//학년, 학기, 과목을 입력
		System.out.println("학기를 입력하세요.(2학기 이하)");
		int term=number.nextInt();
		if(term>2) {
			System.out.println("잘못 입력하였습니다.");
			return;
		}
		System.out.println("과목을 입력하세요.");
		String subject=number.next();
		//입력한 정보로 객채를 생성(Subject)
		ArrayList<Subject>temp2=searchSubjectlist(subject);
		//과목 리스트에 등록된 과목인지 확인후 아니면 알림 후 종료
		if(!sublist.contains(temp2)) {
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		//새 과목 정보를 입력(학년,학기,과목)을 입력
		System.out.println("학년을 입력하세요.(3학년 이하로 입력)");
		int newgrade=number.nextInt();
		if(grade>3) {
			System.out.println("잘못 입력하였습니다.");
			return;
		}
		System.out.println("학기를 수정하세요.(2학기 이하)");
		int newterm=number.nextInt();
		if(term>2) {
			System.out.println("잘못 입력하였습니다.");
			return;
		}
		System.out.println("과목을 수정하세요.");
		String newsubject=number.next();
		//과목 리스트에 등록된 과목인지 확인후 아니면 알림 후 종료
		if(scanSubject(newgrade,newterm,newsubject)) {
			return;
		}		
		//성적을 입력
		System.out.println("점수를 수정하세요.");
		int newscore=number.nextInt();
		if(newscore>100||newscore<0) {
			System.out.println("점수를 잘못 입력하엿습니다.");
			System.out.println("점수의 범위는 '0'이상'100'이하 입니다.");
			return;
		}
		//새 과목 정보와 성적을 이용하여 성적 객체를 생성
		
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
		System.out.println("학생의 학년을 입력하세요.");
		int grade=number.nextInt();
		System.out.println("학생의 반을 입력하세요.");
		int classNum=number.nextInt();
		System.out.println("학생의 번호을 입력하세요.");
		int num=number.nextInt();
		//입력한 정보로 객체 생성(Student)
		ArrayList<Student>temp1=searchStudentlist(grade,classNum,num);
		//리스트에 있는지  확인해서 없으면 알림 후 종료=>indexOf
		if(!stulist.contains(temp1)) {
			System.out.println("시험을 보지 않은 학생입니다.");
			return;
		}
		//학년, 반, 번호를 입력
		System.out.println("학기를 입력하세요.(2학기 이하)");
		int term=number.nextInt();
		if(term>2) {
			System.out.println("잘못 입력하였습니다.");
			return;
		}
		System.out.println("과목을 입력하세요.");
		String subject=number.next();
		//입력한 정보로 객채를 생성(Subject)
		ArrayList<Subject>temp2=searchSubjectlist(subject);
		//과목 리스트에 등록된 과목인지 확인후 아니면 알림 후 종료
		if(!sublist.contains(temp2)) {
			System.out.println("존재하는 과목이 아닙니다.");
			return;
		}
		/*System.out.println("다음 학생 중 수정할 번호를 고르세요.");
		int index = number.nextInt()-1;
		number.nextLine();
		Score sco =templist.get(index);
		scolist.remove(sco);
		System.out.println("삭제되었습니다.");
		return;*/
		
	}

	private static void searchStudent() {
		System.out.println("10.학생 조회");
		//학년, 반, 번호를 입력
		System.out.println("학생의 학년을 입력하세요.");
		int grade=number.nextInt();
		System.out.println("학생의 반을 입력하세요.");
		int classNum=number.nextInt();
		System.out.println("학생의 번호을 입력하세요.");
		int num=number.nextInt();
		//입력한 정보를 이용해서 객체를 생성
		ArrayList<Student>templist=searchStudentlist(grade, classNum, num);
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
		System.out.println("학생의 학년을 입력하세요.");
		int grade=number.nextInt();
		System.out.println("학생의 반을 입력하세요.");
		int classNum=number.nextInt();
		System.out.println("학생의 번호을 입력하세요.");
		int num=number.nextInt();
		//입력한 정보를 이용해서 객체를 생성
		ArrayList<Student> temp1 = searchStudentlist(grade,classNum,num);
		//리스트에서 일치하는 학생이 있으면 정보를 출력
		for(Student ss:stulist) {
			
		}
		//
		
		//학년, 학기, 과목명을 입력
		System.out.println("학기를 입력하세요.(2학기 이하)");
		int term=number.nextInt();
		if(term>2) {
			System.out.println("잘못 입력하였습니다.");
			return;
		}
		System.out.println("과목을 입력하세요.");
		String subject=number.next();
		//과목 정보로 객체를 생성
		
		//리스트에서 학생을 선택
		ArrayList<Score>templist=new ArrayList<Score>();
		//선택한 학생에게 과목정보를 주면서 성적을 출력하고 요청
		printScorelist(templist,false);
		return;
		
	}

	private static boolean printScorelist(ArrayList<Score> templist, boolean b) {
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

