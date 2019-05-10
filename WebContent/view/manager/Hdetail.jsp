<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="../css/dk/input.css" type="text/css">

<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">
<h2>호텔상세보기</h2>
<div align="center">
<table class="ttcss" border="" style="text-align: center;">
	<tr>
		<td width="220" rowspan="3"><img src="../img/${dto.himg }" alt="" /></td>
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
		<td class="wbbr">호텔코드</td>
		<td  colspan="2" width="200" style="border-right: 10px #dcefef solid;" >${dto.hcode }</td> 
	</tr>
	<tr>
		<td class="wbbr">아이디</td>
		<td colspan="2" style="border-right: 10px #dcefef solid;">${dto.id }</td>
	</tr>
		<tr>
		<td class="wbbr">상세주소</td>
		<td colspan="2" style="border-right: 10px #dcefef solid;">${dto.addDetail }</td>
	</tr>
	<tr>
		<td class="wbbr">사업자등록번호</td>
		<td colspan="2" style="border-right: 10px #dcefef solid;">${dto.crn }</td>
	</tr>
	<tr>
		<td class="wbbr">연락처</td>
		<td colspan="2" style="border-right: 10px #dcefef solid;">${sdto.phone }</td>	
	</tr>
</table>
</div>
<br>
<h2 >방목록</h2>
<c:forEach var="data" items="${roomdata }" varStatus="no">
<div align="center">
<table class="ttcss" border="" style="text-align: center;">

	<tr>
		
	</tr>
	<tr>
		<td width="220" rowspan="8" style="border-top: 10px #dcefef solid; border-bottom: 10px #dcefef solid;"><img width="300" src="../img/${data.rimg }" alt="" /></td>
		<td class="wbbr" style="border-top: 10px #dcefef solid;">방코드</td>
		<td  style="border-top: 10px #dcefef solid;">${data.rcode }</td>
		<td align="center" rowspan="4" style="border-top: 10px #dcefef solid;"><a href="HroomModiForm?rcode=${data.rcode }&partner=in">방수정</a></td>
	</tr>
	<tr>
		<td class="wbbr">방종류</td>
		<c:if test="${data.rkind=='S' }">
		<td>스탠다드</td>
		</c:if>
		<c:if test="${data.rkind=='D' }">
		<td>디럭스룸</td>
		</c:if>
	
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
		<td align="center" rowspan="4" style="border-bottom: 10px #dcefef solid;"><a href="HroomDelete?rcode=${data.rcode }&partner=in">방삭제</a></td>
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
	</div>
</c:forEach>
<br><br>