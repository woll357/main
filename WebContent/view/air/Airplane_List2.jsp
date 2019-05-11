<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">

<h2>비행기 검색</h2>
<form action="Airplane_List2">
<input type="hidden" name="air_code" value="${dd }">
<input type="hidden" name= "aotcont"  value="in"/>
<table border="" class="ttcss">
	<tr>

		<td align="right" class="wbbr"  colspan="13" style="border-bottom: 3px white solid;" >비행기 검색　<input style="padding: 10px" type="text" name="ap_code"></td>
		<td class="wbbr" style="border-bottom: 3px white solid; border-right: 10px #dcefef solid;" align="center"><input  class="btncss2"  type="submit" value="선택"></td>
	</tr>
	<tr >
		<td class="wbbr">비행기 코드</td>
		<td class="wbbr">항공사 코드</td>
		<td class="wbbr">항공기이름</td>
		<td class="wbbr">기종</td>
		<td class="wbbr">길이</td>
		<td class="wbbr">날개폭</td>
		<td class="wbbr">좌석수</td>
		<td class="wbbr">최대 이륙 무게 (톤)</td>
		<td class="wbbr">엔진 종류</td>
		<td class="wbbr">순향 속도</td>
		<td class="wbbr">최대 고도</td>
		<td class="wbbr"></td>
		<td style="border-right: 10px #dcefef solid;" class="wbbr" colspan="2">좌석종류</td>
		
	</tr>
<c:forEach var="dto" items="${data }" varStatus="no" >
	<tr>
	<td><a href="Airplaneitem_List?ap_code=${dto.ap_code }&aotcont=in">${dto.ap_code }</a>
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
	<td >${dto.flightclass }</td>
	
	<td style="border-right: 10px #dcefef solid;"><a href="Airplane_Delete?ap_code=${dto.ap_code }&aotcont=in"><input class="btncss" type="button" value="삭제"></a></td>
	
	
	</tr>
	</c:forEach>
	<tr>
	<td colspan="15" align="right" ><a href="Airplane_Insert?air_code=${dto.air_code }&aotcont=in"><input class="btncss" type="button" value="등록"></a></td>
	</tr>
</table>
</form>