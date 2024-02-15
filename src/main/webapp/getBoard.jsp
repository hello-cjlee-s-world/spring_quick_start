<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	/* // 1. �˻��� �Խñ� ��ȣ ����
	String seq = request.getParameter("seq");

	// 2. DB ���� ó��
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	BoardVO board = new BoardDao().getBoard(vo);
	
	// 3. ���� ȭ�� ���� */
	/* controller ���  */
	/* BoardVO board = (BoardVO) session.getAttribute("board"); */
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�� ��</title>
</head>
<body>
<center>
<h1>�� ��</h1>
<a href="logout.do">Log-out</a>
<hr>
<form action="updateBoard.do" method="post">
<input type="hidden" name="seq" value="${board.seq}">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">����</td>
		<td align="left"><input name="title" type="text" value="${board.title }"></td>
	</tr>
	<tr>
		<td bgcolor="orange">�ۼ���</td>
		<td align="left">${board.writer }</td>
	</tr>
	<tr>
		<td bgcolor="orange">����</td>
		<td align="left"><input name="content" type="text" value="${board.content }"></td>
	</tr>
	<tr>
		<td bgcolor="orange">�����</td>
		<td align="left">${board.regdate }</td>
	</tr>
	<tr>
		<td bgcolor="orange">��ȸ��</td>
		<td align="left">${board.cnt }</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="�� ����">
		</td>
	</tr>
</table>
</form>
<hr>
<a href="insertBoard.jsp">�� ���</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard.do?seq=${board.seq }">�� ����</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">�� ���</a>
</center>
</body>
</html>