<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>관리자호텔상세보자</h2>
<table border="">
	<tr>
		<td>호텔코드</td>
		<td colspan="2">${dto.hcode }</td>
	</tr>
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
		<tr>
		<td colspan="3">${dto.addDetail }</td>
	</tr>
	<tr>
		<td>사업자등록번호</td>
		<td colspan="2">${dto.crn }</td>
	</tr>
</table>

<br><br>방목록 
<c:forEach var="data" items="${roomdata }" varStatus="no">
<table border="">

	<tr>
		<td align="left">방코드</td>
		<td colspan="3">${data.rcode }</td>
	</tr>
	<tr>
		<td rowspan="7"><img width="300" src="../img/${data.rimg }" alt="" /></td>
		<td>방종류</td>
		<c:if test="${data.rkind=='S' }">
		<td>스탠다드</td>
		</c:if>
		<c:if test="${data.rkind=='D' }">
		<td>디럭스룸</td>
		</c:if>
		<td><a href="HroomModiForm?rcode=${data.rcode }&partner=in">방수정</a></td>
	</tr>
	<tr>
		<td>방갯수</td>
		<td>${data.rcnt }</td>
		<td><a href="HroomDelete?rcode=${data.rcode }&partner=in">방삭제</a></td>
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