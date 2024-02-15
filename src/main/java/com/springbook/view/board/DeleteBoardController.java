package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDao;

public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 삭제 처리");
		// 1. seq 정보 추출
		int seq = Integer.parseInt(request.getParameter("seq"));

		// 2. DB 연동 처리
		BoardVO vo = new BoardVO(); vo.setSeq(seq);
		new BoardDao().deleteBoard(vo);

		// 3. 화면 네비게이션
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.do");
		return mav;
	}

}
