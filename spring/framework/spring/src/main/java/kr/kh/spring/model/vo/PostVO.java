package kr.kh.spring.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PostVO {
	
	int po_num;
	String po_title, po_content, po_me_id;
	Date po_date;
	int po_view;
	
}
