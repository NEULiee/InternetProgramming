<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/css_reserve.css?after">
</head>

<script>
	function attractionReserve() {
		alert("예약이 완료되었습니다.")
	}
</script>

<body>
	<div id="logo">
		<img id="logoImg" src="image/logo3.JPG" alt="logo">
	</div>
	<form action="attractionServlet?type=add" method="post">
		<table class="t">
			<tr>
				<td><h2>놀이기구 예약</h2></td>
				<td></td>
			</tr>
			<tr>
				<td><b>놀이기구 :</b></td>
				<td><select name="attractionName">
						<option value="자이로드롭" class="b">자이로드롭</option>
						<option value="혜성특급" class="b">혜성특급</option>
						<option value="T-Express" class="b">T-Express</option>
				</select></td>
			</tr>
			<tr>
				<td><b>인원수 :</b></td>
				<td><select name="people">
						<option value="1" class="b">1</option>
						<option value="2" class="b">2</option>
						<option value="3" class="b">3</option>
						<option value="4" class="b">4</option>

				</select></td>
			</tr>
			<tr>
				<td><b>날짜 :</b></td>
				<td><select name="month">
						<option value="1" class="b">1</option>
						<option value="2" class="b">2</option>
						<option value="3" class="b">3</option>
						<option value="4" class="b">4</option>
						<option value="5" class="b">5</option>
						<option value="6" class="b">6</option>
						<option value="7" class="b">7</option>
						<option value="8" class="b">8</option>
						<option value="9" class="b">9</option>
						<option value="10" class="b">10</option>
						<option value="11" class="b">11</option>
						<option value="12" class="b">12</option>
				</select>월 <select name="day">
						<option value="1" class="b">1</option>
						<option value="2" class="b">2</option>
						<option value="3" class="b">3</option>
						<option value="4" class="b">4</option>
						<option value="5" class="b">5</option>
						<option value="6" class="b">6</option>
						<option value="7" class="b">7</option>
						<option value="8" class="b">8</option>
						<option value="9" class="b">9</option>
						<option value="10" class="b">10</option>
						<option value="11" class="b">11</option>
						<option value="12" class="b">12</option>
						<option value="13" class="b">13</option>
						<option value="14" class="b">14</option>
						<option value="15" class="b">15</option>
						<option value="16" class="b">16</option>
						<option value="17" class="b">17</option>
						<option value="18" class="b">18</option>
						<option value="19" class="b">19</option>
						<option value="20" class="b">20</option>
						<option value="21" class="b">21</option>
						<option value="22" class="b">22</option>
						<option value="23" class="b">23</option>
						<option value="24" class="b">24</option>
						<option value="25" class="b">25</option>
						<option value="26" class="b">26</option>
						<option value="27" class="b">27</option>
						<option value="28" class="b">28</option>
						<option value="29" class="b">29</option>
						<option value="30" class="b">30</option>
						<option value="31" class="b">31</option>
				</select>일</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" class="button"
					onclick="attractionReserve()" id="finish" value="예약"></td>
			</tr>
		</table>
	</form>
</body>
</html>