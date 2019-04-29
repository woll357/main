<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
<form action="AirItem_InsertReg">
	<table border="">
		<tr>
			<td>비행기코드</td>
			<td><input type="text" name="ap_code" /></td>
		</tr>
		<tr>
			<td>출발시간</td>
			<td><input type="text" name="ddate" /></td>
		</tr>
		<tr>
				<td>출발지</td>
				<td>
				<select name="darea">                                 
				<option value="인천">인천</option>
				<option value="도쿄">도쿄</option>
				<option value="오사카">오사카</option>
				<option value="상해">상해</option>
				<option value="베이징">베이징</option>
				<option value="마닐라">마닐라</option>
				<option value="보라카이">보라카이</option>
				<option value="세부">세부</option>
				<option value="푸켓">푸켓</option>
			
				</select>
			</td>
		</tr>
		<tr>
		<tr>
			<td>도착지</td>
				<td>
				<select name="carea">                               
				<option value="인천">인천</option>
				<option value="도쿄">도쿄</option>
				<option value="오사카">오사카</option>
				<option value="상해">상해</option>
				<option value="베이징">베이징</option>
				<option value="마닐라">마닐라</option>
				<option value="보라카이">보라카이</option>
				<option value="세부">세부</option>
				<option value="푸켓">푸켓</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>가격</td>
			<td><input type="text" name="money" /></td>
		</tr>
		<tr>
			<td>좌석수</td>
			<td><input type="text" name="totseatcnt" /></td>
		</tr>
		<tr>
				<td>좌석등급</td>
				<td>
				<select name="flightclass">                                   <!-- select 콤보박스 같은거 -->
				<option value="일반">일반</option>
				<option value="비즈니스">비즈니스</option>
		
				</select>
			</td>
		</tr>
				<tr>
				<td colspan="2" align="right">
				<input type="submit" value="작성" />
				<input type="reset" value="초기화" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>