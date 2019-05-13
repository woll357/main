<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">






<h2 >비행기 목록</h2>
<form action="Airplane_List2">
<input type="hidden" name="air_code" value="${mem.air_code }"> 
<input  type="hidden" value="in" name="aotcont">
<table border="" class="ttcss">
	<tr>
	
		<td align="right" class="wbbr" colspan="13" style="border-bottom: 3px white solid;">비행기 코드　<input type="text" style="padding: 10px" type="text" name="ap_code"></td>
		<td class="wbr"  style="border-bottom: 3px white solid;"><input type="submit" style="background: #FFFFFF ;" class="btncss2" value="선택" ></td>
	</tr>
	<tr >
		<td class="wbbr">비행기 코드</td>
		<td class="wbbr">항공사 코드</td>
		<td class="wbbr" width="50">항공기이름</td>
		<td class="wbbr" width="80">기종</td>
		<td class="wbbr">길이</td>
		<td class="wbbr">날개폭</td>
		<td class="wbbr">좌석수</td>
		<td class="wbbr">최대 이륙 무게 (톤)</td>
		<td class="wbbr">엔진 종류</td>
		<td class="wbbr">순향 속도</td>
		<td class="wbbr">최대 고도</td>
		<td class="wbbr">최대운항거리</td>
		<td class="wbbr" width="80" colspan="2">좌석종류</td>
		
		
		
	</tr>
<c:forEach var="dto" items="${data }" varStatus="no" >
	<tr>
	<td><a href="Airplaneitem_List?ap_code=${dto.ap_code }&aotcont=in">${dto.ap_code }</a>
	<td>${mem.air_code }</td>
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
	
	<td align="right"><a href="Airplane_Delete?ap_code=${dto.ap_code }&air_code=${mem.air_code}&aotcont=in"><input  class="btncss" type="button" style="background-color: #dcefef;" type="button" value="삭제"></a></td>
	
	
	</tr>
	</c:forEach>
	<tr>
	<td colspan="14" align="right" ><a href="Airplane_Insert?air_code=${mem.air_code }&aotcont=in"><input  class="btncss" type="button" style="background-color: #dcefef;" value="등록"></a></td>
	</tr>
</table>
</form>

