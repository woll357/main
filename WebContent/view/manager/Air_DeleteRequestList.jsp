<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="../css/dk/input.css" type="text/css">
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">

<h2>호텔삭제신청목록</h2>
<div align="center">


<table class="ttcss" border="" style="text-align: center;">
		<c:choose>
	<c:when test="${data.size()==0 }">
		<h1 align="center">검색결과가 없습니다.</h1>
	</c:when>
	</c:choose>
	<tr>
		<td class="wbbr">code</td>
		<td class="wbbr">신청자아이디</td>
		<td class="wbbr">요청날짜</td>
		<td class="wbbr">종류</td>
		<td class="wbbr" colspan="2">요청내용</td>
	</tr>

	<c:forEach var="dto" items="${data }" varStatus="no">
	<tr>
		<td>${dto.code }</td>
		<td>${dto.id }</td>
		<td>${dto.requsetdate }</td>
		<td>${dto.kind }</td>
		<td>${dto.request }</td>
		<td><a href="Air_DeleteRequestDelete?code=${dto.code }"><input type="button" value="삭제" class="btncss" style="background-color: #dcefef; color: #779191;"></a></td>
	</tr>
	</c:forEach>
</table>
</div>
