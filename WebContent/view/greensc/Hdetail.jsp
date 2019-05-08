<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div align="center">
<h1>호텔상세보기</h1>
<table border="">
	<tr>
		<td rowspan="5"><img src="../img/${dto.himg }" alt="" /></td>
		<td>나라</td>
		<td>${dto.country }</td>
		
	</tr>
	<tr>
		<td>도시</td>
		<td>${dto.city }</td>
	</tr>
	<tr>
		<td>호텔이름</td>
		<td>${dto.hname }</td>
	</tr>

	<tr>
	<td>간단정보</td>
	<td>${dto.hinfo }</td>
	</tr>
	<tr>
		<td style="text-align: center;">상세주소</td>
		<td colspan="2">${dto.addDetail }</td>
	</tr>
</table>
</div>
<div align="center">
<h1>방목록</h1>
<c:forEach var="data" items="${roomdata }" varStatus="no">
<form action="../Basket/BasketHotelReg" method="post">
		<input type="hidden" name="rcode" value="${data.rcode }" />
		<input type="hidden" name="startDay" value="${param.startDay }" />
		<input type="hidden" name="endDay" value="${param.endDay }" />
<table border="">
	<tr>
		<tr>
		<td rowspan="7"><img width="280" src="../img/${data.rimg }" alt="" /></td>
		<td>방종류</td>
		<c:if test="${data.rkind=='S' }">
		<td>스탠다드</td>
		</c:if>
		<c:if test="${data.rkind=='D' }">
		<td>디럭스룸</td>
		</c:if>
		<td rowspan="7"><input type="submit" value="예약" /></td>
		<%-- <td><a href="../Basket/BasketHotelReg?rcode=${data.rcode}&startDay=${param.startDay }&endDay=${param.endDay }">예약</a></td> --%>
	</tr>
	<tr>
		<td>방갯수</td>
		<td>${data.rcnt }</td>
	</tr>
	<tr>
		<td>방인원</td>
		<td>${data.pcnt }</td>
	</tr>
	<tr>
		<td>금액</td>
		<td>${data.money }</td>

	</tr>
	<tr>
		<td>주말금액</td>
		<td>${data.wmoney }</td>
	</tr>
	<tr>
		<td>wifi</td>
		<td>${data.wifi }</td>
	</tr>	
	<tr>
		<td>조식</td>
		<td>${data.morning }</td>
	</tr>
	<tr>		
	</tr>
	</table>
	</form>
</c:forEach>
</div>
<br><br>