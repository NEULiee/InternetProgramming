<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/css_board_write.css?after">
</head>

<script>
	function textLoad() {
		var title = document.getElementById("title").value;
		var area = document.getElementById("memo").value;
		if (title == "") {
			alert("제목을 입력해주세요.");
			return false;
		} else if (area == "") {
			alert("내용을 입력해주세요.");
			return false;
		} else {
			alert("게시글이 작성되었습니다.")
			return true;
		}
	}
</script>

<body>
	<div id="logo">
		<img id="logoImg" src="image/logo3.JPG" alt="logo">
	</div>


	<form action="boardServlet?type=add" method="post">
		<table>
			<tr>
				<td><h2>게시판 글쓰기</h2></td>
			</tr>
			<tr>
				<td><b>제목 : </b><input type="text" id="title" name="title"></td>
			</tr>
			<tr>
				<td><textarea id="memo" name="memo"></textarea></td>
			</tr>
			<tr id="b">
				<td><input type="submit" id="load" onclick="textLoad()"
					value="OK"></td>
			</tr>
		</table>
	</form>
</body>
</html>