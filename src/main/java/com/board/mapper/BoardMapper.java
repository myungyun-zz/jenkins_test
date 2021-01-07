package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.BoardVO;

@Mapper
public interface BoardMapper {

	//글작성
	public void boardInsert(BoardVO board) throws Exception;
	
	//글 목록
	public List<BoardVO> boardList() throws Exception;
	
	//글 보기
	public BoardVO boardView(int bno) throws Exception;
	
	//조회수 증가
	public void hitPlus(int bno) throws Exception;
	
	//글 수정
	public void boardUpdate(BoardVO vo) throws Exception;
	
	//글 삭제
	public void boardDelete(int bno) throws Exception;
}
