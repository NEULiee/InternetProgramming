<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/css_board.css">
</head>

<script>
	function sch() {
		var s = document.getElementById("search").value;
		if (s == "") {
			alert("찾으실 제목을 입력해주세요.");
			return false;
		} else {
			alert("검색이 완료되었습니다.");
		}
	}
</script>

<body>
	<div id="logo">
		<img id="logoImg" src="image/logo3.JPG" alt="logo">
	</div>

	<table class="t">
		<tr>
			<td><h2>게시판</h2></td>
			<td></td>
		</tr>
		<tr style="border-bottom: 1px solid black;">
			<td><b>글번호</b></td>
			<td width="300px" class="c"><b>제목</b></td>
			<td class="w"><b>글쓴이</b></td>
		</tr>

		<c:forEach var="b" items="${bli}">
			<tr>
				<td>${b.boardID}</td>
				<td class="c">
					<a href="boardServlet?type=byboardID&boardID=${b.boardID}">${b.title}</a>
				</td>
				<td class="w">${b.userIDName}</td>
			</tr>
		</c:forEach>

		<tr></tr>
		<tr>
			<td></td>
			<td></td>
			<td><input type="button" class="button"
				onclick="location.href = 'board_write.jsp'" id="finish" value="글쓰기"></td>
		</tr>
	</table>
	<form action="boardServlet?type=search" method="post">
		<table class="t">
			<tr>
				<td><input type="text" id="search" name="search"
					style="background-color: transparent; border-left-width: 0.5; border-right-width: 0.5; border-top-width: 0.5; border-bottom-width: 0.5; border-bottom-color: black; border-left-color: black; border-right-color: black; border-top-color: black; font-size: 18px;">
					<input type="submit" id="s" class="button" value="검색"
					onclick="sch()"></td>
			</tr>
		</table>
	</form>
</body>
</html>