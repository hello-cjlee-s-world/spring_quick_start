<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.impl.BoardDao"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	// 1. ����� �Է� ���� ����(�˻� ����� ���߿� ����)
	// 2. DB ���� ó��
	BoardVO vo = new BoardVO();
	BoardDao boardDAO = new BoardDao();
	List<BoardVO> boardList = boardDAO.getBoardList(vo);
	
	// 3. ���� ȭ�� ���� 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� ���</title>
</head>
<body>
<center>
<h1>�� ���</h1>
<h3>�׽�Ʈ�� ȯ���մϴ�...  <a href="logout_proc.jsp">Log-out</a></h3>

<!-- �˻� ���� -->
<form action="getBoardList.jsp" method="post">
<table border="1" cellpadding="0" cellspacing="0" widht="700">
	<tr>
		<td align="right">
			<select name="searchCondition">
				<option value="TITLE">����</option>
				<option value="CONTENT">����</option>
			</select>
			<input name="searchKeyword" type="text">
			<input type="submit" value="�˻�">
		</td>
	</tr>
</table>
</form>
<!-- �˻� ���� -->

<table border="1" cellpadding="0" cellspacing="0" widht="700">
	<tr>
		<th bgcolor="orange" width="100">��ȣ</th>
		<th bgcolor="orange" width="200">����</th>
		<th bgcolor="orange" width="150">�ۼ���</th>
		<th bgcolor="orange" width="150">�����</th>
		<th bgcolor="orange" width="100">��ȸ��</th>
	</tr>
	
	<% for(BoardVO board : boardList) {%>
	<tr>
		<td><%=board.getSeq()%></td>
		<td align="left"> 
			<a href="getBoard.jsp?seq=<%=board.getSeq() %>"><%= board.getTitle() %></a>
		</td>
		<td><%=board.getWriter()%></td>
		<td><%=board.getRegdate()%></td>
		<td><%=board.getCnt()%></td>
	</tr>
	<% } %>
</table>
<br>
<a href="insertBoard.jsp">�� �� ���</a>
</center>
</body>
</html>