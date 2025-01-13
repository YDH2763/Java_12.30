package day10;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;


public class Ex13_Phone {

	static Scanner number=new Scanner(System.in);
	
	public static void main(String[] args) {
		/* 전화번호를 관리하는 프로그램을 작성하세요.
		 * 1.전화번호 추가
		 * 	-이름과 전화번호를 입력받아 추가
		 * 	-동명이인이 있을 수 있기 때문에 중복되도 추가
		 * 2.전화번호 수정
		 * 	-이름을 입력
		 * 	-이름과 일치하는 목록을 출력
		 *  -수정하려는 전화번호를 선택
		 *  -새 전화번호를 입력받아 수정
		 * 3.전화번호 삭제
		 *  -이름을 입력
		 * 	-이름과 일치하는 목록을 출력
		 *  -삭제하려는 전화번호를 선택
		 *  -선택한 전화번호를 삭제
		 * 4.전화번호 조회
		 *  -이름을 입력
		 *  -이름이 포함된 전화번호를 출력
		 * 5.프로그램 종료
		 * 메뉴 선택 : */
		int c=0;
		ArrayList<String> name =new ArrayList<String>();
		ArrayList<String> phonenum =new ArrayList<String>();
		HashMap<String,String> user =new HashMap<String,String>();
		
		for(int i=1;;i++) {
			System.out.println("1.전화번호 추가");
			System.out.println("2.전화번호 수정");
			System.out.println("3.전화번호 삭제");
			System.out.println("4.전화번호 조회");
			System.out.println("5.프로그램 종료");
			System.out.print("메뉴 선택 : ");
			char s =number.next().charAt(0);
			
			switch(s) {
				case'1':
					System.out.println("1.전화번호 추가");
					System.out.print("이름을 입력하세요.: ");
					number.nextLine();
					String n=number.nextLine();
					System.out.print("전화번호를 입력하세요.: ");
					String p=number.nextLine();
					user.put(n,p);
					c++;
					break;
				case'2':
					if(c==0) {
						System.out.println("아직 입력받지 않았습니다.");
						break;
					}
					System.out.println("2.전화번호 수정");
					System.out.println("수정할 사람을 입력하세요.");
					number.nextLine();
					String rn=number.nextLine();
					if(user.containsKey(rn)) {
						System.out.println("수정할 사람의 전화번호를 입력하세요.");
						String rnp=number.nextLine();
						if(user.containsValue(rnp)) {
							System.out.println("전화번호를 수정하세요.");
							String rp=number.nextLine();
							user.put(rn,rp);
							System.out.println("수정했습니다.");
						}
						else {
							System.out.println("잘못 입력하였습니다.");
							break;
						}
					}
					else {
						System.out.println("잘못 입력하였습니다.");
					}
					
					break;
				case'3':
					if(c==0) {
						System.out.println("아직 입력받지 않았습니다.");
						break;
					}
					System.out.println("3.전화번호 삭제");
					System.out.println("삭제할 사람을 입력하세요.");
					number.nextLine();
					String dn=number.nextLine();
					if(user.containsKey(dn)) {
						System.out.println("삭제할 사람의 전화번호를 입력하세요.");
						String dn1=number.nextLine();
						if(user.containsValue(dn1)) {
							user.remove(dn,dn1);
							c--;
							System.out.println("삭제하였습니다.");
						}
						else {
							System.out.println("잘못 입력하였습니다.");
						}
					}
					else {
						System.out.println("잘못 입력하였습니다.");
					}
					break;
				case'4':
					if(c==0) {
						System.out.println("아직 입력받지 않았습니다.");
						break;
					}
					System.out.println("4.전화번호 조회");
					System.out.println(user);
					/*System.out.println("조회할 사람을 입력하세요.");
					number.nextLine();
					String sn=number.nextLine();*/
					/*if(user.containsKey(sn)) {
						for(int j=1;j<=c;j++) {
							if(user.containsKey(sn)) {
								System.out.println(user.get(sn));
							}
						}
					}*/
					/*else {
						System.out.println("잘못 입력하였습니다.");
					}*/
					break;
				case'5':
					System.out.println("5.프로그램 종료");
					break;
				default:
					System.out.println("잘못 입력하였습니다.");
					break;
			
			}
			if(s=='5') {
				break;
			}
		}
	}

}
