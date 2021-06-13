package com.board.dao;

import java.util.List;

import com.board.domain.BoardVO;

public interface BoardDAO {
	
	//게시물 목록보기
	public List<BoardVO> list() throws Exception;
	
	//게시물 작성하기
	public void write(BoardVO vo) throws Exception;
	
	//게시물 조회하기(글 읽기)
	public BoardVO view(int idx) throws Exception;
	
	//게시물 수정하기
	public void modify(BoardVO vo) throws Exception;
	
	//게시물 삭제하기
	public void delete(int idx) throws Exception;

	//게시물의 총 갯수 구하기
	public int count() throws Exception;
	
	//게시물 목록 + 페이징
	public List<BoardVO> listPage(int displayPost, int postNum) throws Exception;
	
	// 검색기능 부분
	public List<BoardVO> listPageSearch(
		int displayPost, int postNum, String searchType, String keyword) throws Exception;
}
