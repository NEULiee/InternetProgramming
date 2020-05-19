<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign up</title>
<link rel="stylesheet" href="css/css_signup.css">
</head>

<script type="text/javascript"
	src="<c:url value="/jq/jquery-3.4.1.js"/>"></script>
<script type="text/javascript">
	function signup() {
		var userIDName = document.getElementById("ID").value;
		var password = document.getElementById("pwd").value;
		var userName = document.getElementById("name").value;
		if (userIDName == "") {
			alert("아이디를 입력해주세요.");
			return false;
		} else if (password == "") {
			alert("비밀번호를 입력해주세요.");
			return false;
		} else if (userName == "") {
			alert("이름을 입력해주세요.")
			return false;
		} else {
			alert("회원가입이 완료되었습니다.")
			return true;
		}
	}
</script>

<body>
	<div id="logo">
		<img id="logoImg" src="image/logo3.JPG" alt="logo">

	</div>

	<form action="userServlet?type=add" method="post">
		<div>
			<table class="t">
				<tr>
					<td><h2>회원가입</h2></td>
					<td></td>
				</tr>
				<tr>
					<td>아이디:</td>
					<td><input type="text" class="textbox" name="userIDName"
						id="ID" required></td>
					<!-- 
					<td><input type="button" class="button" onclick="dupCheck()"
						id="check" value="중복확인"></td>
					-->
				</tr>
				<tr>
					<td>비밀번호:</td>
					<td><input type="text" class="textbox" name="password"
						id="pwd" required></td>
				</tr>
				<tr>
					<td>이름:</td>
					<td><input type="text" class="textbox" name="userName"
						id="name" required></td>
				</tr>
				<tr>
					<td></td>
					<!-- submit 타입 button -->
					<td><input type="submit" class="button"
						onclick="return signup()" id="finish" value="OK"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>