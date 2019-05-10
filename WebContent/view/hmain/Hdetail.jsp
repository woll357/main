<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">

<h2 >호텔상세</h2>
<div align="center">
<table class="ttcss" border="" style="text-align: center;">
	<tr>
		<td width="250" rowspan="3"><img width="320" src="../img/${dto.himg }" alt="" /></td>
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
		<td class="wbbr">상세주소</td>
		<td colspan="2">${dto.addDetail }</td>
	</tr>
	<tr>
		<td class="wbbr">사업자등록번호</td>
		<td colspan="2">${dto.crn }</td>
	</tr>
</table>
</div>

<br>
<h2>방목록</h2> 


<c:forEach var="data" items="${roomdata }" varStatus="no">  
<table  class="ttcss" border="" style="text-align: center;">
	<tr>
		<tr>
		<td width="220" rowspan="7" style="border-top: 10px #dcefef solid; border-bottom: 10px #dcefef solid;"><img width="300" src="../img/${data.rimg }" alt="" /></td>
		<td class="wbbr" style="border-top: 10px #dcefef solid;">방종류</td>
		<c:if test="${data.rkind=='S' }">
		<td style="border-top: 10px #dcefef solid;">스탠다드</td>
		</c:if>
		<c:if test="${data.rkind=='D' }">
		<td style="border-top: 10px #dcefef solid;">디럭스룸</td>
		</c:if>
		<td style="border-top: 10px #dcefef solid;"><a href="HroommodiForm?rcode=${data.rcode }&hotcont=in">방수정</a></td>
	</tr>
	<tr>
		<td class="wbbr">방갯수</td>
		<td>${data.rcnt }</td>
		<td rowspan="2"><a href="HnoresDatewriteForm?rcode=${data.rcode }&hotcont=in&rcnt=${data.rcnt }">예약불가날짜선정</a></td>
	</tr>
	<tr>
		<td class="wbbr">방인원</td>
		<td>${data.pcnt }</td>
		
	</tr>
	<tr>
		<td class="wbbr">금액</td>
		<td>${data.money }</td>
		<td rowspan="2"><a href="HnoresList?rcode=${data.rcode }&hotcont=in">예약불가날짜목록</a></td>
		
	</tr>
	<tr>
		<td class="wbbr">주말금액</td>
		<td>${data.wmoney }</td>
	</tr>
	<tr>
		<td class="wbbr">wifi</td>
		<td>${data.wifi }</td>
		<td rowspan="2" style="border-bottom: 10px #dcefef solid;"><a href="HroomDelete?rcode=${data.rcode }&hotcont=in">방삭제</a></td>
	</tr>	
	<tr>
		<td class="wbbr" style="border-bottom: 10px #dcefef solid;">조식</td>
		<td style="border-bottom: 10px #dcefef solid;">${data.morning }</td>
	</tr>
	<tr>
		
	</tr>

	</table>

	</c:forEach>



