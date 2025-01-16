package day13;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex05_Synchronized {

	public static void main(String[] args) {
		BankBook bankBook =new BankBook("이병건",0);
		Cunstomer1 c1 =new Cunstomer1("이병건",bankBook);
		Cunstomer1 c2 =new Cunstomer1("주호민",bankBook);
		
		c1.start();
		c2.start();
		
	}

}

@AllArgsConstructor
class Cunstomer1 extends Thread{
	private String name;
	private BankBook bankBook;
	@Override
	public void run() {
		System.out.println(name+"님이"+10000+"원을 'ATM'으로 입금 중입니다.");
		bankBook.deposit(name, 10000);
	}
}
@AllArgsConstructor
class Cunstomer2 extends Thread{
	private String name;
	private BankBook bankBook;
	@Override
	public void run() {
		System.out.println(name+"님이"+10000+"원을 '모바일앱'으로 입금 중입니다.");
		bankBook.deposit(name, 10000);
	}
}
@Data
@AllArgsConstructor
class BankBook{
	private String name;
	private int balance;
	
	public synchronized void deposit(String name,int money) {
		System.out.println(name+"님 - 임금 전 잔액:"+balance);
		balance +=money;
		
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+":"+money+"원 입금. 잔액 : "+balance);
	}
}