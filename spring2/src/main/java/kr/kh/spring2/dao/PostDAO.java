package kr.kh.spring2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring2.model.vo.BoardVO;
import kr.kh.spring2.model.vo.PostVO;
import kr.kh.spring2.pagination.Criteria;

public interface PostDAO {

	List<PostVO> selectPostList();

	List<BoardVO> selectBoardList();

	List<PostVO> selectPostList2(@Param("cri")Criteria cri);

	int selectCountPostList(@Param("cri")Criteria cri);

}
