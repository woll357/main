<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>관리자호텔상세보자</h2>
<table border="">
	<tr>
		<td rowspan="3"><img src="../img/${dto.himg }" alt="" /></td>
		<td>${dto.country }</td>
		<td>${dto.city }</td>
	</tr>
	<tr>
	<td colspan="2">${dto.hname }</td>
	</tr>
	<tr>
	<td colspan="2">${dto.hinfo }</td>
	</tr>
</table>

방목록 S=> 스탠다르룸  D=>디럭스룸
<c:forEach var="data" items="${roomdata }" varStatus="no">
<table border="">
	<tr>
		<tr>
		<td rowspan="7"><img src="../img/${data.rimg }" alt="" /></td>
		<td>방종류</td>
		<td>${data.rkind }</td>
		<td><a href="HroomModiForm?rcode=${data.rcode }">방수정</a></td>
	</tr>
	<tr>
		<td>방갯수</td>
		<td>${data.rcnt }</td>
		<td><a href="HroomDelete">방삭제</a></td>
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
</c:forEach>