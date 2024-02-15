<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
	
	// 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
	// 2. DB 연동 처리
	/* BoardVO vo = new BoardVO();
	BoardDao boardDAO = new BoardDao();
	List<BoardVO> boardList = boardDAO.getBoardList(vo);
	 */
	// 3. 응답 화면 구성 
	
	/* controller 사용  */
	/* List<BoardVO> boardList = (List) session.getAttribute("boardList"); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>글 목록</title>
</head>
<body>
<center>
<h1>글 목록</h1>
<h3>테스트님 환영합니다...  <a href="logout.do">Log-out</a></h3>

<!-- 검색 시작 -->
<form action="getBoardList.jsp" method="post">
<table border="1" cellpadding="0" cellspacing="0" widht="700">
	<tr>
		<td align="right">
			<select name="searchCondition">
				<option value="TITLE">제목</option>
				<option value="CONTENT">내용</option>
			</select>
			<input name="searchKeyword" type="text">
			<input type="submit" value="검색">
		</td>
	</tr>
</table>
</form>
<!-- 검색 종료 -->

<table border="1" cellpadding="0" cellspacing="0" widht="700">
	<tr>
		<th bgcolor="orange" width="100">번호</th>
		<th bgcolor="orange" width="200">제목</th>
		<th bgcolor="orange" width="150">작성자</th>
		<th bgcolor="orange" width="150">등록일</th>
		<th bgcolor="orange" width="100">조회수</th>
	</tr>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td>${board.seq }</td>
				<td align="left"> 
					<a href="getBoard.do?seq=${board.seq}">${board.title}</a>
				</td>
				<td>${board.writer}</td>
				<td>${board.regdate}</td>
				<td>${board.cnt}</td>
			</tr>
		</c:forEach>
</table>
<br>
<a href="insertBoard.jsp">새 글 등록</a>
</center>
</body>
</html>