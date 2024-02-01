<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.springbook.biz.board.impl.BoardDao"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%
	/* // 1. 검색할 게시글 번호 추출
	String seq = request.getParameter("seq");

	// 2. DB 연동 처리
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	BoardVO board = new BoardDao().getBoard(vo);
	
	// 3. 응답 화면 구성 */
	/* controller 사용  */
	BoardVO board = (BoardVO) session.getAttribute("board");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 상세</title>
</head>
<body>
<center>
<h1>글 상세</h1>
<a href="logout_proc.jsp">Log-out</a>
<hr>
<form action="updateBoard.do" method="post">
<input type="hidden" name="seq" value="<%= board.getSeq() %>">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">제목</td>
		<td align="left"><input name="title" type="text" value="<%= board.getTitle() %>"></td>
	</tr>
	<tr>
		<td bgcolor="orange">작성자</td>
		<td align="left"><%= board.getWriter()%></td>
	</tr>
	<tr>
		<td bgcolor="orange">내용</td>
		<td align="left"><input name="content" type="text" value="<%= board.getContent()%>"></td>
	</tr>
	<tr>
		<td bgcolor="orange">등록일</td>
		<td align="left"><%= board.getRegdate()%></td>
	</tr>
	<tr>
		<td bgcolor="orange">조회수</td>
		<td align="left"><%= board.getCnt()%></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="글 수정">
		</td>
	</tr>
</table>
</form>
<hr>
<a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard.do?seq=<%= board.getSeq()%>">글 삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">글 목록</a>
</center>
</body>
</html>