<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/css_board_write.css?after">
</head>

<script>
</script>

<body>
	<div id="logo">
		<img id="logoImg" src="image/logo3.JPG" alt="logo">
	</div>

	<table>
		<tr>
			<td><h2>게시글</h2></td>
		</tr>
		<tr>
			<td><b>제목 :</b> ${title}</td>
		</tr>
		<tr>
			<td><textarea id="memo" name="memo" readonly>${m}</textarea></td>
		</tr>
	</table>

</body>
</html>