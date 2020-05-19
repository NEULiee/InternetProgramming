<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/css_login.css">
</head>
<script>
	function login() {
		var userIDName = document.getElementById("ID").value;
		var password = document.getElementById("pwd").value;
		if (userIDName == "") {
			alert("아이디를 입력해주세요.");
			return false;
		} else if (password == "") {
			alert("비밀번호를 입력해주세요.");
			return false;
		} else {
			return true;
		}
	}
</script>
<body>
	<div id="logo">
		<img id="logoImg" src="image/logo3.JPG" alt="logo">
	</div>
	<form action="userServlet?type=lo" method="post">
		<div>
			<table class="t">
				<tr>
					<td><h2>로그인</h2></td>
					<td></td>
				</tr>
				<tr>
					<td>아이디:</td>
					<td><input type="text" class="textbox" name="userIDName"
						id="ID" required></td>
				</tr>
				<tr>
					<td>비밀번호:</td>
					<td><input type="text" class="textbox" name="password"
						id="pwd" required></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" class="button" onclick="login()"
						id="finish" value="OK"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>