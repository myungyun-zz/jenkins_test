package com.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.board.domain.BoardVO;
import com.board.mapper.BoardMapper;

@org.springframework.stereotype.Controller
@RequestMapping("/board")
public class Controller {

	@Autowired
	private BoardMapper boardMapper;
	
	//게시글 목록
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK) // 사용하든 안하든 response에는 지장없음
	public ModelAndView board() throws Exception{
		List<BoardVO> boardListShow = boardMapper.boardList();
		
		return new ModelAndView("boardList","list",boardListShow);
	}
	
	//게시글 작성 페이지(GET)
	@RequestMapping(value="/postPage", method=RequestMethod.GET)
	public ModelAndView writeForm() throws Exception {
		return new ModelAndView("boardWrite");
	}
	
	//게시글 작성(POST)
	//@ResponseBody
	@RequestMapping(value="/post", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView write(@ModelAttribute("BoardVO")BoardVO board 
				, @RequestBody JSONObject data
				/*, HttpServletRequest req*/
				/*@RequestParam(value = "subject",required=true) String subject,
				@RequestParam(value = "writer",required=true) String writer,
				@RequestParam(value = "content",required=true) String content*/) throws Exception {
		
		/*System.out.println(subject.toString());
		System.out.println(writer.toString());
		System.out.println(content.toString());*/
		
		String subject=data.get("subject").toString();
		String writer=data.get("writer").toString();
		String content=data.get("content").toString();
	
		System.out.println("제목 : "+subject);
		System.out.println("작성자 : "+writer);
		System.out.println("내용 : "+content);
		
		/*String subject = req.getParameter("subject");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");*/
		
		board.setSubject(subject);
		board.setContent(content);
		board.setWriter(writer);
		
		/*req.setCharacterEncoding("UTF-8");
		System.out.println(subject);
		System.out.println(writer);
		System.out.println(content);*/
		
		boardMapper.boardInsert(board);
		return new ModelAndView("redirect://localhost:8080/board");
	}
	
	//게시글 상세페이지 보기
	@RequestMapping(value="/view")
	public ModelAndView view(@RequestParam(value="page")int bno) throws Exception{
		
	//	System.out.println(bno);
		BoardVO board=boardMapper.boardView(bno);
		boardMapper.hitPlus(bno);
		
		return new ModelAndView("boardView","board",board);
	}
	
	//게시글 수정페이지 가기
	@RequestMapping(value="/updatePage")
	public ModelAndView updatePage(@RequestParam(value="page")int bno) throws Exception{
		
		BoardVO board=boardMapper.boardView(bno);
		
		return new ModelAndView("boardUpdate","board",board);
	}
	
	//게시글 수정(PATCH)
		//@ResponseBody
		@RequestMapping(value="/update", method= RequestMethod.PUT)
		public ModelAndView update(@ModelAttribute("BoardVO")BoardVO board 
					, @RequestBody JSONObject data
					, @RequestParam(value="page")int bno) throws Exception {
			
			String subject=data.get("subject").toString();
			String writer=data.get("writer").toString();
			String content=data.get("content").toString();
		
			System.out.println("제목 : "+subject);
			System.out.println("작성자 : "+writer);
			System.out.println("내용 : "+content);
			
			board.setBno(bno);
			board.setSubject(subject);
			board.setContent(content);
			//board.setWriter(writer);
			
			boardMapper.boardUpdate(board);
			//List<BoardVO> boardListShow = boardMapper.boardList();
			return new ModelAndView("boardUpdate"+bno);
		}
		
		//게시글 삭제
		@RequestMapping(value="/delete", method=RequestMethod.DELETE)
		public ModelAndView boardDelete(@RequestParam(value="page")int bno) throws Exception{
			
			boardMapper.boardDelete(bno);
			
			return new ModelAndView("redirect://localhost:8080/board");
		}
}
