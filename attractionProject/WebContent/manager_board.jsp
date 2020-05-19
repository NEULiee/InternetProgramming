<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/css_manager_board.css">
</head>

<script>
	function del() {
		alert("게시글 삭제가 완료되었습니다.")
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
				<td class="c"><a
					href="boardServlet?type=byboardID&boardID=${b.boardID}">${b.title}</a></td>
				<td class="w">${b.userIDName}</td>
				<td><a href="boardServlet?type=modi&boardID=${b.boardID}" class="d">수정</a></td>				
				<td><a href="boardServlet?type=del&boardID=${b.boardID}" onclick="del()" class="d">삭제</a></td>
			</tr>
		</c:forEach>

		<tr></tr>

	</table>
</body>
</html>