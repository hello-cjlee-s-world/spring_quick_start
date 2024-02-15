package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDao;

@Controller
public class InsertBoardController {
	@RequestMapping(value="insertBoard.do")
	// 아래 주석과 같이 HttpServletRequest로 사용자가 입력한 값을 가져올 수 있지만 
	// 다른 방법으로 insertBoard() 메소드의 매개변수로 사용자가 입력한 값을 매핑할 BoardVO 클래스를 선언하면, 
	// 스프링 컨테이너가 insertBoard() 메소드를 실행할때 COmmand 객체를 사용자가 입력한 값까지 set 하여 넘겨준다.
	// DAO 객체도 마찬가지로 매개변수로 선언하면 스프링 커넽이너가 해당 객체를 생성하여 전달해준다
	//public void insertBoard(HttpServletRequest request) {
	public String insertBoard(BoardVO vo, BoardDao dao) {
		System.out.println("글 등록 처리");
		/*
		 * //1. 사용자 입력 정보 추출 String title=request.getParameter("writer"); String
		 * writer=request.getParameter("title"); String
		 * content=request.getParameter("content");
		 */

		//2. DB 연동 처리
		//BoardVO vo = new BoardVO();
		//vo.setTitle(title);vo.setWriter(writer);vo.setContent(content);
		dao.insertBoard(vo);
		return "redirect:getBoardList.do";
		
	}
}
