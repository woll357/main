<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 align="center">호텔상세</h1>
<div align="center">
<table border="" style="text-align: center;">
	<tr>
		<td rowspan="3"><img width="300" src="../img/${dto.himg }" alt="" /></td>
		<td>${dto.country }</td>
		<td>${dto.city }</td>
	</tr>
	<tr>
	<td colspan="2">${dto.hname }</td>
	</tr>
	<tr>
	<td colspan="2">${dto.hinfo }</td>
	</tr>
		<tr>
		<td colspan="3">${dto.addDetail }</td>
	</tr>
	<tr>
		<td>사업자등록번호</td>
		<td colspan="2">${dto.crn }</td>
	</tr>
</table>
</div>
<br>
<h2 align="center">방목록</h2>   
<c:forEach var="data" items="${roomdata }" varStatus="no">
<div align="center">
<table  border="" style="text-align: center;">
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
		<td><a href="HroommodiForm?rcode=${data.rcode }&hotcont=in">방수정</a></td>
	</tr>
	<tr>
		<td>방갯수</td>
		<td>${data.rcnt }</td>
		<td rowspan="2"><a href="HnoresDatewriteForm?rcode=${data.rcode }&hotcont=in&rcnt=${data.rcnt }">예약불가날짜선정</a></td>
	</tr>
	<tr>
		<td>방인원</td>
		<td>${data.pcnt }</td>
		
	</tr>
	<tr>
		<td>금액</td>
		<td>${data.money }</td>
		<td rowspan="2"><a href="HnoresList?rcode=${data.rcode }&hotcont=in">예약불가날짜목록</a></td>
		
	</tr>
	<tr>
		<td>주말금액</td>
		<td>${data.wmoney }</td>
	</tr>
	<tr>
		<td>wifi</td>
		<td>${data.wifi }</td>
		<td rowspan="2"><a href="HroomDelete?rcode=${data.rcode }&hotcont=in">방삭제</a></td>
	</tr>	
	<tr>
		<td>조식</td>
		<td>${data.morning }</td>
	</tr>
	<tr>
		
	</tr>
	</table>
	</div>
</c:forEach>