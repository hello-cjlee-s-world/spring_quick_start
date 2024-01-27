<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.springbook.biz.board.BoardVO" %>
<%@page import="com.springbook.biz.board.impl.BoardDao" %>
<% 
// 1. seq 정보 추출
int seq = Integer.parseInt(request.getParameter("seq"));

// 2. DB 연동 처리
BoardVO vo = new BoardVO(); vo.setSeq(seq);
new BoardDao().deleteBoard(vo);

// 3. 화면 네비게이션
response.sendRedirect("getBoardList.jsp");
%>