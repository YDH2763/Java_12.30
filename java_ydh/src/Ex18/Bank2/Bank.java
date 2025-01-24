package Ex18.Bank2;

public enum Bank {
	우리,국민,신한,농협,기업;
	public static void printBanks() {
		Bank[] list=Bank.values();
		for(int i=0;i<list.length;i++) {
			System.out.println((i==0?"": ",")+list[i]);
		}
		System.out.println();
		
	}
	
	public static boolean check(String str) {
		try {
			//Bank bank=Bank.valueOf(str);
			return Bank.valueOf(str) !=null;
		}catch(Exception e) {
			return false;
		}
	}
}
