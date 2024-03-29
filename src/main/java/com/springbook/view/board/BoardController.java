package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardService;

@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/dataTransform.do")
	// Responsebody - 자바 객체인 BoardVO 를 http 응답 프로토콜의 몸체로 변환하기 위해 사용된다. 
	// 앞에서 MappingJackson2HttpMessageConverter 변환기를 생성하도록 스프링 설정파일(presentation-layer.xml)에 <mvc:annotation-drive>을 추가했다.
	// 따라서 dataTransform() 메소드의 실행 결과는 JSON으로 변환되어 HTTP 응답 보디에 설정될 것이다.
	@ResponseBody 
	public List<BoardVO> dataTranform(BoardVO vo){
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		return boardList;
	}
	
	// 글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		System.out.println("글 등록 처리");
		// 파일 업로드 처ㅣ
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String filename=uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("D:/"+filename));
		}
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("글 삭제 처리");
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}

	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard (BoardVO vo, Model model) {
		System.out.println("글 상세 조회 처리");
		// Model 정보 저장
		model.addAttribute("board", boardService.getBoard(vo));
		return "getBoard.jsp";
	}
	
	// 검색 조건 목록 설정
		@ModelAttribute("conditionMap")
		public Map<String, String> searchConditionMap(){
			Map<String, String> conditionMap = new HashMap<String, String>();
			conditionMap.put("제목", "TITLE");
			conditionMap.put("내용", "CONTENT");
			return conditionMap;
		}
		
	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		System.out.println("글 목록 검색 처리");
		// Null Check
		if(vo.getSearchCondition()==null) vo.setSearchCondition("TITLE"); 
		if(vo.getSearchKeyword()==null) vo.setSearchKeyword(""); 
		// Model 정보 저장
		model.addAttribute("boardList", boardService.getBoardList(vo)); 
		return "getBoardList.jsp";
	}
}
