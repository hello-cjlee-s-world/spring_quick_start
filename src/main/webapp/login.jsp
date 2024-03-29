<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- 다국어 처리를 위한 MessageSource 불러올 수 있게 태그 라이브러리 사용 -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" context="text/html" charset="EUC-KR">
<title><spring:message code="message.user.login.title" /></title>
</head>
<body>
<center>
<h1><spring:message code="message.user.login.title" /></h1>
<a href="login.do?lang=en"><spring:message code="message.user.login.language.en" /></a>
<a href="login.do?lang=ko"><spring:message code="message.user.login.language.ko" /></a>
<hr>
<form action="login.do" method="post">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange"><spring:message code="message.user.login.id" /></td>
		<td><input type="text" name="id" value="${user.id}"/></td>
	</tr>
	<tr>
		<td bgcolor="orange"><spring:message code="message.user.login.password" /></td>
		<td><input type="password" name="password" value="${user.password}"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="<spring:message code="message.user.login.loginBtn"/>">
		</td>
	</tr>
</table>
</form>
</center>


</body>
</html>