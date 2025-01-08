package day07;
import java.util.Scanner;
public class Ex05_ClassStudent2 {

	public static void main(String[] args) {
		// 학생의 성적을 관리하는 프로그램을 만들기위해 필요한
		// Student 클래스를 작성하세요.
		/*
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 프로그램 종료
		 * 메뉴 선택 : */
		Scanner number= new Scanner(System.in);
		System.out.println("명단에 넣을 학생수를 입력하세요.");
		int l =number.nextInt();
		
		int score[]=new int[l];
		int grade[]=new int[l];
		int classnum[]=new int[l];
		int num[]=new int[l];
		String name[]=new String[l];
		String subject[]=new String[l];
		
		int count=0;
		int c=0;
		for(int i=0;;i++) {
			System.out.println("학생 수 :"+l+"명");
			System.out.println("메뉴");
			System.out.println("1. 학생 성적 추가");
			System.out.println("2. 학생 성적 조회");
			System.out.println("3. 학생 성적 수정");
			System.out.println("4. 학생 성적 삭제");
			System.out.println("5. 프로그램 종료");
			System.out.print(" 메뉴 선택 : ");
			char sn=number.next().charAt(0);
			System.out.println("");
			
			switch(sn) {
			case '1':
				System.out.println("혹시 학생 1명 더 추가하시겠습니까?");
				System.out.println("o,x중 하나를 입력하세요.");
				char ox =number.next().charAt(0);
				if(ox=='o') {
					l++;
					if(c==0) {
						Enter_student(grade,classnum,num,name,subject,score,l);
						if(sn=='1') {
							break;
						}
					}
					else {
						System.out.println("이미 정보를 입력하였습니다.");
						if(sn=='1') {
							break;
						}
					}
				}
				else if(ox=='x') {
					if(c==0) {
						Enter_student(grade,classnum,num,name,subject,score,l);
						if(sn=='1') {
							break;
						}
					}
					else {
						System.out.println("이미 정보를 입력하였습니다.");
						if(sn=='1') {
							break;
						}
					}
				}
				else {
					System.out.println("잘못입력하여 메인메뉴로 돌아갑니다.");
					if(sn=='1') {
						break;
					}
				}
		
			case '2':
				out_student( grade,  classnum,  num,  name,  subject,
						 score, l);
				if(sn=='2') {
					break;
				}
			case '3':
				changeScore(score, l, name);
				if(sn=='3') {
					break;
				}
			case '4':
				//입력
				System.out.print("삭제할 학생의 순서를 입력해주세요.: ");
				int ds=number.nextInt();
				System.out.println("");
				if(ds>l) {
					System.out.println("잘못 입력하여 메뉴로 돌아갑니다.");
				}
				//삭제할 정보가 있는 번지를 찾음
				
				//index 다음에 있는 데이터들을 한칸씩 당겨줌
				
				//개수 1개를 감소
				else {
					for(int j=1;j<=l;j++) {
						if(ds==j) {
							System.out.println(name[j-1]+"학생의 정보를 삭제합니다.");
							for(int k=1;k<=l;k++) {
								name[j-1]=name[j];
								subject[j-1]=subject[j];
								grade[j-1]=grade[j];
								classnum[j-1]=classnum[j];
								num[j-1]=num[j];
								score[j-1]=score[j];
							}
							
						}
					}
					l--;
				}
				if(sn=='4') {
					break;
				}
			
			case '5':
				System.out.println("프로그램을 종료합니다.");
				break;
			default :
				System.out.println("다시 입력해주세요.");
			}
			if(sn=='5') {
				break;
			}
			
		}
		
	}

	private static void changeScore(int[] score, int l, String[]name) {
		Scanner number= new Scanner(System.in);
		System.out.print("변경할 학생의 점수의 순서를 입력해주세요.: ");
		int ss=number.nextInt();
		System.out.println("");
		if(ss>l) {
			System.out.println("잘못 입력하여 메뉴로 돌아갑니다.");
		}
		else {
			for(int j=1;j<=l;j++) {
				if(ss==j) {
					System.out.print("다음"+name[j-1]+"학생의 점수를 수정해주세요. ");
					int rs=number.nextInt();
					System.out.println("");
					score[j-1]=rs;
					System.out.println("학생"+name[j-1]+"의 점수가 수정되었습니다.");
				}
			}
		}
		
	}

	private static void out_student(int[] grade, int[] classnum, int[] num, String[] name, String[] subject,
			int[] score, int l) {
		Scanner number= new Scanner(System.in);
		System.out.print("조회할 학생의 순서를 입력해주세요.: ");
		int se=number.nextInt();
		System.out.println("");
		if(se>l) {
			System.out.println("잘못 입력하여 메뉴로 돌아갑니다.");
		}
		else {
			for(int j=1;j<=l;j++) {
				if(se==j) {
					System.out.println(grade[j-1]+"학년 "+classnum[j-1]+"반 "+
num[j-1]+"번 "+name[j-1]+" "+subject[j-1]+" : "+score[j-1]);
				}
			}
		}
		
	}

	private static void Enter_student(int[] grade, int[] classnum, int[] num, String[] name, String[] subject,
			int[] score, int l) {
		Scanner scan =new Scanner(System.in);
		for(int i=0;i<l;i++) {
			System.out.print("학생의 이름을 입력하세요 : ");
			String n=scan.next();
			name[i]=n;
			System.out.println("");
			
			System.out.print("학생의 학년을 입력하세요 : ");
			int g=scan.nextInt();
			grade[i]=g;
			System.out.println("");
			
			System.out.print("학생의 반을 입력하세요 : ");
			int cn=scan.nextInt();
			classnum[i]=cn;
			System.out.println("");
			
			System.out.print("학생의 번을 입력하세요 : ");
			int sn=scan.nextInt();
			num[i]=sn;
			System.out.println("");
			
			System.out.print("학생의 과목을 입력하세요 : ");
			String ss=scan.next();
			subject[i]=ss;
			System.out.println("");
			
			System.out.print("학생의 성적을 입력하세요 : ");
			int s=scan.nextInt();
			score[i]=s;
			System.out.println("");
			if(i>0) {
				if((String)name[i]==(String)name[i-1] ) {
					if(grade[i]==grade[i-1]) {
						if(classnum[i]==classnum[i-1]) {
							if(num[i]==num[i-1]) {
								System.out.println("이전 학생과 같은 값이 입력되었습니다.");
								break;
							}
						}
					}
				}
			}
			
			//입력받은 정보를 이용해서 객체를 생성하는 코드를 작성하세요.
			/*Student tmp =new Student(grade, classnum, num,name,subject, score);
			list[count]=tmp;
			list[count].print();*/
		}
		
	}
	//주어진 정보가 배열의 볓번지에 있는지 알려주는 기능
	public int indexOf(Student[] list, int grade, int count, int classnum, int num, String subject) {
		int index = -1;
		for(int i=0;i<count;i++) {
			if(list[i].equals(grade, classnum, num, subject)) {
				index = -i;
				break;
			}
		}
		return -1;
	}
}

