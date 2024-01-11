package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.impl.BoardServiceImpl;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. spring container를 구동한다
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. spring 컨테이너로부터 BoardServiceImpl 객체를 Lookup 한다.
		BoardServiceImpl boardService = (BoardServiceImpl)container.getBean("boardService");
		
		// 3. 글 등록 기능 테스트
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트 제목");
		vo.setWriter("테스트 작성자");
		vo.setContent("테스트 글 내용");
		boardService.insertBoard(vo);
		
		// 4. 글 목록 검색 기능 테스트
		List<BoardVO> boardList = boardService.getBoardList();
		System.out.println("===================글 목록===================");
		for(BoardVO b:boardList) {
			System.out.println("====>"+b.toString());
		}
		System.out.println(boardList.size());
		
		// 5. container 종료
		container.close();
	}
}
