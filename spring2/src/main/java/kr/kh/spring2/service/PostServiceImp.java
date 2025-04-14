package kr.kh.spring2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring2.dao.PostDAO;
import kr.kh.spring2.model.vo.BoardVO;
import kr.kh.spring2.model.vo.PostVO;
import kr.kh.spring2.pagination.Criteria;
import kr.kh.spring2.pagination.PageMaker;

@Service
public class PostServiceImp implements PostService{

	@Autowired
	PostDAO postDao;

	@Override
	public List<PostVO> getPostList() {
		
		return postDao.selectPostList();
	}

	@Override
	public List<BoardVO> getBoardList() {
		
		return postDao.selectBoardList();
	}

	@Override
	public List<PostVO> selectPostList(Criteria cri) {
		if(cri == null) {
			return null;
		}
		
		return postDao.selectPostList2(cri);
	}

	@Override
	public PageMaker getPageMaker(Criteria cri) {
		if(cri==null) {
			return null;
		}
		
		int count =postDao.selectCountPostList(cri);
		return new PageMaker(1,cri,count);
	}
	
}
