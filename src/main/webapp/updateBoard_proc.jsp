<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.springbook.biz.board.BoardVO" %>
<%@page import="com.springbook.biz.board.impl.BoardDao" %>
<% 
// 1. ����� �Է� ���� ����
request.setCharacterEncoding("EUC-KR");
String title=request.getParameter("title");
String content=request.getParameter("content");
String seq=request.getParameter("seq");
/* System.out.println("title : "+title);
System.out.println("content : "+content);
System.out.println("seq : "+seq); */
// 2. DB ���� ó��
BoardVO vo = new BoardVO();
vo.setTitle(title);
vo.setContent(content);
vo.setSeq(Integer.parseInt(seq));
new BoardDao().updateBoard(vo);

// 3. ȭ�� �׺���̼�
response.sendRedirect("getBoardList.jsp");
%>