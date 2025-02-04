package day20;

import java.text.DecimalFormat;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
	
	private String code;		//코드
	private String category;	//분류
	private String productName;	//제품명
	private String option;		//옵션
	private int price;			//가격
	private int amount;			//수량
	//private String authority;	//권한 : 관리자, 사용자
	
	public Product(String code, String category, String productName, String option, int price) {
		this.code = code;
		this.category = category;
		this.productName = productName;
		this.option = option;
		this.price = price;
	}

	@Override
	public String toString() {
		return "["+category+"]"+productName+" "
				+option+" - "+code+" : "+price+"원 "+amount;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(code, other.code);
	}

	public static String getCodePrefix(String category) {
		switch(category) {
		case "문구":
			return "ABC";
		case "의류":
			return "DEF";
		case "식품":
			return "XYZ";
		case "가전":
			return "ELC";
		case "기타":
			return "ETC";
			default:
				return null;
		}
	}

	public Product(int max, String category, String name, String option, int price) {
		this("",category,name,option,price);
		//code를 추가: ABC+001
		String prefix=getCodePrefix(category);
		DecimalFormat format=new DecimalFormat("000");
		String suffix = format.format(max+1);
		this.code=prefix+suffix;
		
	}
	
	
	public void update(String productName, String option, int price) {
		this.productName=productName;
		this.option=option;
		this.price=price;
	}
	
	public void updateStock(int amount) {
		this.amount += amount;
	}

	
	
	
}
