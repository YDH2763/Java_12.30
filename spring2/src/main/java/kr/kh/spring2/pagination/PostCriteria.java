package kr.kh.spring2.pagination;

import lombok.Data;

@Data
public class PostCriteria extends Criteria {
	
	private int po_bo_num;
	String orderBy;

	public PostCriteria(int page, int perPageNum) {
		super(page, perPageNum);
	}
}
