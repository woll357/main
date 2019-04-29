<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<table>
	<tr>
		<td>여권번호</td>
		<td>생년월일</td>
		<td>영문 성</td>
		<td>영문 이름</td>
		<td>한글 이름</td>
		<td>연락처</td>
		<td>이메일</td>
	</tr>

<c:forEach var="i" items="${tdtos }">
		<tr>
			<td>${i.passport }</td>
			<td>19${i.birthDate.substring(0,2) }년</td>
			<td>${i.birthDate.substring(2,4) }월</td>
			<td>${i.birthDate.substring(4) }일</td>
			<td>${i.cEngLastName }</td>
			<td>${i.cEngFirstName }</td>
			<td>${i.cKorName }</td>
			<td>${i.cph1 }-</td>
			<td>${i.cph2 }-</td>
			<td>${i.cph3 }</td>
			<td>${i.cemail1 }@</td>
			<td>${i.cemail2 }</td>
		</tr>
</c:forEach>
</table>
