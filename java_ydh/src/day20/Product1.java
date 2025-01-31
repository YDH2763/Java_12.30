package day20;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product1 {

	private String code;		//
	private Category category;	//
	private String productName;	//
	private String Option;		//
	private int price;			//
	private int amount;			//
}
