<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.springbook.biz.board.BoardVO" %>
<%@page import="com.springbook.biz.board.impl.BoardDao" %>
<% 
// 1. seq ���� ����
int seq = Integer.parseInt(request.getParameter("seq"));

// 2. DB ���� ó��
BoardVO vo = new BoardVO(); vo.setSeq(seq);
new BoardDao().deleteBoard(vo);

// 3. ȭ�� �׺���̼�
response.sendRedirect("getBoardList.jsp");
%>