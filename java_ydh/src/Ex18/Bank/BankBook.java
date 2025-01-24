package Ex18.Bank;

import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class BankBook {
	private String bank;
	private String customer;
	private String accountNumber; 
	private int password;
	private int income;
	
	//List<Item> list;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankBook other = (BankBook) obj;
		return Objects.equals(accountNumber, other.accountNumber) && Objects.equals(bank, other.bank);
	}

	/**
	 * @param bank
	 * @param customer
	 * @param accountNumber
	 * @param password
	 * @param income
	 */
	public BankBook(String bank, String customer, String accountNumber, int password, int income) {
		this.bank = bank;
		this.customer = customer;
		this.accountNumber = accountNumber;
		this.password = password;
		this.income = income;
	}

	@Override
	public String toString() {
		return "은행 : "+ bank+"\r\n"+"이름 : "+customer+"\r\n"+"계좌번호 : "+accountNumber+"\r\n"+"금액 : "+income+"원";
	}
	
	
	
}
