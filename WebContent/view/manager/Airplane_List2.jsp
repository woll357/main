<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">

<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">

<h3>비행기 목록</h3>
<form action="Airplane_List2">
<input type="hidden" name="air_code" value="${dd }">
<table border="" style="width: 100%; border : 10px #dcefef solid;" cellspacing="0">
<tr>
		<td style="background: #D4F4FA"  colspan="11">비행기 검색</td>
		<td style="background: #D4F4FA"  colspan="4"><input type="text" name="ap_code"><input type="submit" value="선택"></td>
	</tr>
	<tr >
		
		<td>비행기 코드</td>
		<td>항공사명</td>
		<td>항공사 코드</td>
		<td>항공기이름</td>
		<td>기종</td>
		<td>길이</td>
		<td>날개폭</td>
		<td>좌석수</td>
		<td>최대 이륙 무게 (톤)</td>
		<td>엔진 종류</td>
		<td>순향 속도</td>
		<td>최대 고도</td>
		<td>최대운항거리</td>
		<td colspan="3">좌석종류</td>
		
		
	</tr>
<c:forEach var="dto" items="${data }" varStatus="no" >
	<tr>
	<td><a href="Airplaneitem_List?ap_code=${dto.ap_code }&partner=in">${dto.ap_code }</a>
	<td>${dto.air_name }</td>
	<td>${dto.air_code }</td>
	
	<td>${dto.air_ty }</td>
	<td>${dto.aircraft_type }</td>
	<td>${dto.linear_content }</td>
	<td>${dto.wings_width }</td>
	<td>${dto.numberof_sea }</td>
	<td>${dto.max_two }</td>
	<td>${dto.engine_type }</td>
	<td>${dto.tail_velocity }</td>
	<td>${dto.maximum_altitude }</td>
	<td>${dto.maximum_od }</td>
	<td>${dto.flightclass }</td>
	<td><a href="Airplane_Delete?ap_code=${dto.ap_code }&partner=in"><input type="button" value="삭제"></a></td>
	</tr>
	</c:forEach>
	
</table>
</form>
</body>
</html>