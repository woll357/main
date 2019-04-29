<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("utf-8"); %>
<table>
	<tr>
		<td>>여권번호</td>
		<td>생년월일</td>
		<td>영문 성</td>
		<td>영문 이름</td>
		<td>한글 이름</td>
		<td>연락처</td>
		<td>이메일</td>
	</tr>

<c:forEach var="i" items="tdtos">
		<tr>
			<td><input type="text" readonly="readonly" value="${i.passport }" /></td>
			<td><input type="text" readonly="readonly" value="19${i.birthDate.substring(0,2) }년" /></td>
			<td><input type="text" readonly="readonly" value="${i.birthDate.substring(2,4) }월" /></td>
			<td><input type="text" readonly="readonly" value="${i.birthDate.substring(4) }일" /></td>
			<td><input type="text" readonly="readonly" value="${i.cEngLastName }" /></td>
			<td><input type="text" readonly="readonly" value="${i.cEngFirstName }" /></td>
			<td><input type="text" readonly="readonly" value="${i.cKorName }" /></td>
			<td><input type="text" readonly="readonly" value="${i.cph.substring(0,3) }-" /></td>
			<td><input type="text" readonly="readonly" value="${i.cph.substring(3,7) }-" /></td>
			<td><input type="text" readonly="readonly" value="${i.cph.substring(7) }" /></td>
			<td><input type="text" readonly="readonly" value="${i.cemail }" /></td>
		
		</tr>
</c:forEach>
</table>
