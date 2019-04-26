<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품수정</title>
</head>
<body>
<h3>상품 수정</h3>
<form action="AirItem_ModifyReg" method="post">
	<table border="">
		<tr> 
			<td>비행기코드</td><td><input type="text" name="ap_code" value="${dto.ap_code }"></td>		
		</tr>
		<tr>
			<td>출발시간</td><td><input type="text" name="ddate" value="${dto.ddate }" ></td>		
		</tr>
		<tr>
			<td>출발지</td><td>
				<select name="carea">                                   
				<option value="인천">인천</option>
				<option value="도쿄">도쿄</option>
				<option value="오사카" >오사카</option> 
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
			<td>도착지</td><td>
				<select name="carea">                                   
				<option value="인천">인천</option>
				<option value="도쿄">도쿄</option>
				<option value="오사카" >오사카</option> 
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
		<td>가격</td><td><input type="text" name="money" value="${dto.money }"></td>
		</tr>
		<tr>
			<td>총좌석</td><td><input type="text" name="totseatcnt" value=""></td>		
		</tr>
		<tr>
			<td>좌석등급</td><td>
				<select name="flightclass">                                   
				<option value="인천">일반</option>
				<option value="도쿄">비즈니스</option>       
				</select>
			</td>
	</tr>
	<tr >
	<td colspan="2" align="right"><input type="submit" value="수정"><input type="hidden" name="ccode"  value="${dto.ccode }">
		<a href= "AirItem_Delete?ccode=${dto.ccode }" ><input type="button" value="삭제"></a></td>
	</tr>
		
	</table>
</form>
</body>
</html>