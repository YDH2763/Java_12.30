package homework2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentProgram implements ConsoleProgram {
	
	private Scanner number =new Scanner(System.in);
	
	private StudentManager studentManager =new StudentManager();
	private SubjectManager subjectManager =new SubjectManager();
	
	
	public void run() {
		//불러오기
		String studentfileName="src/homework2/student.txt";
		String subjectfileName="src/homework2/subject.txt";
		
		load(studentfileName,new ArrayList<Object>(studentManager.getList()));
		load(subjectfileName,new ArrayList<Object>(subjectManager.getList()));
		
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
				//저장하기
				
				break;
			}
		}
	}
	
	@Override
	public void printMenu() {
		
	}
	
	@Override
	public void runMenu(int menu) {
		switch(menu) {
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
	
	
	
	private void inputStudent() {
		//학년, 반, 번호, 이름 입력
		
		//주의: 학생객체 생성시 성적 리스트를 생성
		//입력받은 학년, 반, 번호, 이름을 이용하여 객체 생성=>리스트에 있는 기능을 활용하기 위해
		
		//학생 매니저에게 학생 객체를 만들어 주면서 추가하라고 시키고 추가 여부를 확인해서 알림
		
	}

	private void renameStudent() {
		//학년, 반, 번호, 이름 입력
		
		//입력한 학생의 정보를 객체 생성
		
		//학생 매니저에게 학생 객체를 주면서 있는지 확인 요청하여 있으면 알림 후 종료
		
		//아니면 수정할 학년, 반, 번호, 이름을 입력
		
		//입력받은 정보로 객체를 생성
		
		//학생 매니저에게 기존 학생 객체와 새 학생 객체를 주면서 수정하고 수정 여부를 알려달라고 요청
		
		//결과에 따라 알림
		
	}

	private void deleteStudent() {
		//학년, 반, 번호를 입력
		
		//입력받은 정보로 객체 생성
		
		//학생 매니저에게 학생 객체를 주면서 삭제하고 삭제여부를 알려달라고 요청
		
		//삭제에 성공하면 성공알림문구
		
		//실패하면 실패 알림문구 출력
		
	}

	private void inputSubject() {
		//학년, 학기, 과목명을 입력
		
		//과목 객체 생성
		
		//과목 매니저에게 과목을 주면서 등록하라고 요청 후 결과에 따라 알림
		
	}

	private void renameSubject() {
		//학년, 학기, 과목명을 입력
		//입력한 정보로 객체를 생성
		//새과목 정보를 입력(학년, 학기, 과목)
		//과목 매니저에게 기존 과목객체와 새 과목 객체를 주면서 수정하라고 요청 후 결과에 따라 알림
		
		
	}

	private void deleteSubject() {
		//학년, 학기, 과목명을 입력
		//입력한 정보로 객체를 생성
		//과목 매니저에게 과목객체를 주면서 삭제하라고 요청 후 결과에 따라 알림
		
	}

	private void inputScore() {
		//학년, 반, 번호, 이름 입력
		//입력한 학생의 정보를 객체 생성(Student)
		//학생 매니저에게 학생이 있는지 없는지 알려달라고 하고 요청후 없으면 알림 후 종료
		//학년, 학기, 과목명을 입력
		//입력한 정보로 객체를 생성(Subject)
		//과목 매니저에게 과목이 있는지 없는지 알려달라고 요청 후 없으면 알림 후 종료
		//성적을 입력해서 과목 정보와 성적을 이용하여 객체를 생성(Score)
		//학생 매니저에게 학생 객체와, 성적 객체를 주면서 성적을 등록하고 요청 후......... 
		
	}

	private void renameScore() {
		//학년, 반, 번호, 이름 입력
		//입력한 학생의 정보를 객체 생성(Student)
		//학생 매니저에게 학생이 있는지 없는지 알려달라고 하고 요청후 없으면 알림 후 종료
		//학년, 학기, 과목명을 입력
		//입력한 정보로 객체를 생성(Subject)
		//과목 매니저에게 과목이 있는지 없는지 알려달라고 요청 후 없으면 알림 후 종료
		//새 학년, 새 학기, 새 과목을 입력
		//과목 매니저에게 새과목을 확인 후 없으면 알림 후 종료
		//성적을 입력
		//새 과목 정보와 성적을 이용하여 새 성적 객체를 생성
		//학생 매니저에게 기존.............
		
	}

	private void deleteScore() {
		//학년, 반, 번호, 이름 입력
		//입력한 학생의 정보를 객체 생성(Student)
		//학생 매니저에게 학생이 있는지 없는지 알려달라고 하고 요청후 없으면 알림 후 종료
		//학년, 학기, 과목명을 입력
		//입력한 정보로 객체를 생성(Subject)
		//과목 매니저에게 과목이 있는지 없는지 알려달라고 요청 후 없으면 알림 후 종료
		//학생매니저에게 과목을 주고 삭제 요청 후 결과에 따라 알림
		
		
	}

	private void searchStudent() {
		//학년 반 번호를 입력
		//입력한 정보를 이용해서 객체를 생성
		//학생매니저에게 학생 정보를 주면서 출력하라고 요청
		
	}

	private void searchSubject() {
		//과목 매니자에게 등록된 과목을 출력하라고 요청
		
	}

	private void searchScore() {
		//학년 반 번호를 입력
		//입력한 정보를 이용해서 객체를 생성
		//학생 매니저에게 학생이 있는지 확인 후 없으면 알림
		//학년 학기 과목명을 입력
		//과목정보로 객체를 생성
		//학생 매니저에게 학생정보와 과목 정보를 주면서 성적을 출력하라고 요청
		
	}

	private  void removeBuffer() {
		number.nextLine();
		
	}
}
