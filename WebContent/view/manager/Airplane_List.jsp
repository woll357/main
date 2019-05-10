
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  여기부분 수정 css --> 
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">
<h3>비행기 목록</h3>
<form action="Airplane_List2">
<input type="hidden" name= "partner"  value="in">

<table border="" class="ttcss">
	<tr>
		
		<td class="wbbr" style="border-bottom: 3px white solid;" align="right"  colspan="14">비행기 검색　<input style="padding: 10px" type="text" name="ap_code"></td>
		<td class="wbbr" style="border-right: 10px white solid;" align="center"><input style="background: #FFFFFF ;border-right: 10px white solid;" class="btncss2"  type="submit" value="선택"></td>
	</tr>
	<tr >
		
		<td class="wbbr" >비행기 코드</td>
		<td class="wbbr" >항공사명</td>
		<td class="wbbr" >항공사 코드</td>
		<td class="wbbr" >기종</td>
		<td class="wbbr" >거리</td>
		<td class="wbbr" >길이</td>
		<td class="wbbr" >날개폭</td>
		<td class="wbbr" >좌석수</td>
		<td class="wbbr" >최대 이륙 무게 (톤)</td>
		<td class="wbbr" >엔진 종류</td>
		<td class="wbbr" >순향 속도</td>
		<td class="wbbr" >최대 고도</td>
		<td class="wbbr" >최대운항거리</td>
		<td class="wbbr"  colspan="2">좌석종류</td>
		
		
		
	</tr>
<c:forEach var="dto" items="${ddd }" varStatus="no" >
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
	<td  style="border-right: 10px white solid;"><a href="Airplane_Delete?ap_code=${dto.ap_code }&partner=in"><input class="btncss" type="button" style="background-color: #dcefef;" value="삭제"></a></td>
	</tr>
</c:forEach>
</table>
</form>
</body>
</html>
