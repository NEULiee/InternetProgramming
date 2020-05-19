<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/css_board_write.css">
</head>

<script>
	function modi() {
		alert("수정이 완료되었습니다.")
	}
</script>

<body>
	<div id="logo">
		<img id="logoImg" src="image/logo3.JPG" alt="logo">
	</div>
	<form action="boardServlet?type=upd" method="post">
		<table>
			<tr>
				<td><h2>게시글 수정</h2></td>
			</tr>
			<tr>
				<td><b>글번호</b> : <input type="text" value="${boardID}" name="bID" readonly="readonly" class="num"></td>
			</tr>
			<tr>
				<td><b>제목 : </b> <input type="text" value="${title}" name="title" class="box"></td>
			</tr>
			<tr>
				<td><textarea id="memo" name="memo">${m}</textarea></td>
			</tr>
			<tr id="b">
				<td><input type="submit" id="load" onclick="modi()"
					value="OK"></td>
			</tr>
		</table>
	</form>
</body>
</html>