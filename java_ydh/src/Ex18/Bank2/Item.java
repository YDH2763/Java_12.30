package Ex18.Bank2;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Item {
	
	private static final long serialVersionUID = 12345L;
	
	private Date date;	//입출금 날짜
	private Type type;	//입금 또는 출금
	private long money;	//금액
	
	public Item(Type type, long money) {
		this.type =type;
		this.money =money;
		this.date =new Date();
	}

	public String getDateStr() {
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		return f.format(date);
	}
	
	@Override
	public String toString() {
		return getDateStr()+" "+type+" "+money+"원";
	}
	
}
