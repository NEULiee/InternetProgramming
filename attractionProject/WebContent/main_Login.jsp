<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/css_main_Login.css?after">
</head>

<body>

	<form>
		<div id="logo">
			<img id="logoImg" src="image/logo3.JPG" alt="logo">
		</div>

		<div id="u">
			<ul class="menu">
				<li><a href="attractionServlet?type=byuserIDName">내정보</a></li>
				<li><a href="reserve.jsp">놀이기구 예약</a></li>
				<li><a href="boardServlet?type=all">게시판</a></li>
			</ul>
		</div>
		<table id="t">
			<tbody>
				<tr>
					<td><img class="attractionImg" src="image/gyrodrop.jpg"
						alt="img"></td>
					<td><img class="attractionImg" src="image/hyesung.jpg"
						alt="img"></td>
					<td><img class="attractionImg" src="image/tExpress.jpg"
						alt="img"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>