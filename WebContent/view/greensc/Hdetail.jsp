<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="../css/nh/tot.css" type="text/css">
   <h2>호텔상세보기</h2>
    <div align="center">

<table class="ttcss" border="" style="text-align: center;">
	<tr>
		<td width="250" rowspan="5"><img width="320" src="../img/${dto.himg }" alt="" /></td>
		<td class="wbbr">나라</td>
		<td style="border-right: 10px #dcefef solid;">${dto.country }</td>
		
	</tr>
	<tr>
		<td class="wbbr">도시</td>
		<td style="border-right: 10px #dcefef solid;">${dto.city }</td>
	</tr>
	<tr>
		<td class="wbbr">호텔이름</td>
		<td style="border-right: 10px #dcefef solid;">${dto.hname }</td>
	</tr>

	<tr>
	<td class="wbbr">간단정보</td>
	<td style="border-right: 10px #dcefef solid;">${dto.hinfo }</td>
	</tr>
	<tr>
		<td class="wbbr" style="text-align: center;">상세주소</td>
		<td colspan="2">${dto.addDetail }</td>
	</tr>
</table>
</div>
<h2>방목록</h2>
<div align="center">

<c:forEach var="data" items="${roomdata }" varStatus="no">
<c:if test="${roomkind==data.rkind }">
<form action="../Basket/BasketHotelReg" method="post">
		<input type="hidden" name="rcode" value="${data.rcode }" />
		<input type="hidden" name="startDay" value="${param.startDay }" />
		<input type="hidden" name="endDay" value="${param.endDay }" />
<table class="ttcss" border="" style="text-align: center;">
	<tr>
		<tr>
		<td width="250" rowspan="7" style="border-top: 10px #dcefef solid; border-bottom: 10px #dcefef solid;"><img width="320" src="../img/${data.rimg }" alt="" /></td>
		<td class="wbbr" style="border-top: 10px #dcefef solid;">방종류</td>
		<c:if test="${data.rkind=='S' }">
		<td style="border-top: 10px #dcefef solid;">스탠다드</td>
		</c:if>
		<c:if test="${data.rkind=='D' }">
		<td style="border-top: 10px #dcefef solid;">디럭스룸</td>
		</c:if>
		<td rowspan="7" style="border-top: 10px #dcefef solid; border-bottom: 10px #dcefef solid;"><input type="submit" value="예약" /></td>
		<%-- <td><a href="../Basket/BasketHotelReg?rcode=${data.rcode}&startDay=${param.startDay }&endDay=${param.endDay }">예약</a></td> --%>
	</tr>
	<tr>
		<td class="wbbr">방갯수</td>
		<td>${data.rcnt }</td>
	</tr>
	<tr>
		<td class="wbbr">방인원</td>
		<td>${data.pcnt }</td>
	</tr>
	<tr>
		<td class="wbbr">금액</td>
		<td>${data.money }</td>

	</tr>
	<tr>
		<td class="wbbr">주말금액</td>
		<td>${data.wmoney }</td>
	</tr>
	<tr>
		<td class="wbbr">wifi</td>
		<td>${data.wifi }</td>
	</tr>	
	<tr>
		<td class="wbbr" style="border-bottom: 10px #dcefef solid;">조식</td>
		<td style="border-bottom: 10px #dcefef solid;">${data.morning }</td>
	</tr>
	<tr>		
	</tr>
	</table>
	</form>
	</c:if>
</c:forEach>
</div>
<br><br>