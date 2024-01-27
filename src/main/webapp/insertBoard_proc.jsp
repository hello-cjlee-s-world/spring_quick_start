<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.springbook.biz.board.BoardVO" %>
<%@page import="com.springbook.biz.board.impl.BoardDao" %>
<%
//1. 사용자 입력 정보 추출
request.setCharacterEncoding("EUC-KR");
String title=request.getParameter("writer");
String writer=request.getParameter("title");
String content=request.getParameter("content");

//2. DB 연동 처리
BoardVO vo = new BoardVO();
vo.setTitle(title);vo.setWriter(writer);vo.setContent(content);
new BoardDao().insertBoard(vo);

//3. 화면 네비게이션
response.sendRedirect("getBoardList.jsp");
%>
