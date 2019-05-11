<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<link rel="stylesheet" href="../css/nh/tot.css" />
<h2>여행객 상세정보</h2>
<table class="ttcss" border="">
	<tr>
		<td class="wbbr">여권번호</td>
		<td class="wbbr">생년월일</td>
		<td class="wbbr">영문 성</td>
		<td class="wbbr">영문 이름</td>
		<td class="wbbr">한글 이름</td>
		<td class="wbbr">연락처</td>
		<td class="wbbr">이메일</td>
	</tr>
<c:forEach var="i" items="${tdtos }">
		<tr>
			<td>${i.passport }</td>
			<td>19${i.birthDate.substring(0,2) }년 ${i.birthDate.substring(2,4) }월 ${i.birthDate.substring(4) }일</td>
			<td>${i.cEngLastName }</td>
			<td>${i.cEngFirstName }</td>
			<td>${i.cKorName }</td>
			<td>${i.cph1 }-${i.cph2 }-${i.cph3 }</td>
			<td>${i.cemail1 }@${i.cemail2 }</td>
		</tr>
</c:forEach>
</table>
		 <c:choose>
		<c:when test="${tdtos.size()==0 }">
			<h2>조회된 결과가 없습니다.</h2>
		</c:when>
		</c:choose>