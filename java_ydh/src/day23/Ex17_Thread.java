package day23;

public class Ex17_Thread {

	public static void main(String[] args) {
		/* 쓰레드를 이용하여 +를 100번 출력하는 쓰레드를 생성해서 실행하고,
		 * -를 100번 출력하는 쓰레드를 생성하고 실행하는 코드를 작성하세요.*/
		Thread t=new Thread1();
		/*run()=>run 메소드를 호출하기 때문에 아래 코드가 대기*/
		t.start();	//새로운 스레드를 만들고, 거기에서 run을 호출하기 때문에 아래 코드가 실행
		
		Thread t2=new Thread(new Thread2());
		t2.start();
		
		Thread t3 =new Thread(()->{
			for(int i=0;i<100;i++) {
				System.out.println("=");
			}
		});
		t3.start();
		

	}

}

class Thread1 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("+");
		}
	}
}

class Thread2 implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("-");
		}
	}
}