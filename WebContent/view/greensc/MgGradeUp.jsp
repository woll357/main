<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<table border="">
	<tr>
		<td colspan="5">관리자 등업</td>
	</tr>
	<tr>
		<td>요청 번호</td>
		<td>아이디</td>
		<td>요청 등급</td>
		<td>요청 날짜</td>
		<td>상세</td>
		</tr>
	<c:forEach var="dto" items="${mgData}" varStatus="no">
		<tr>
		<td>${no.index+1 }</td>
		<td>${dto.id }</td>
		<td>${dto.grade }</td>
		<td>${dto.time }</td>
		<td><a href="GradeDetail?no=${dto.num }&rq=mg">열람</a></td>
		</tr>
	</c:forEach>
	
	<tr>
		<td colspan="5">항공 등업</td>
	</tr>
	
	
	<tr>
		<td>요청 번호</td>
		<td>아이디</td>
		<td>요청 등급</td>
		<td>요청 날짜</td>
		<td>상세</td>
		</tr>
	<c:forEach var="dto" items="${airData}" varStatus="no">
		<tr>
		<td>${no.index+1 }</td>
		<td>${dto.id }</td>
		<td>${dto.grade }</td>
		<td>${dto.time }</td>
		<td><a href="GradeDetail?no=${dto.no }&rq=air">열람</a></td>
		</tr>
	</c:forEach>
	
	
	<tr>
		<td colspan="5">호텔 등업</td>
	</tr>
	
	<tr>
		<td>요청 번호</td>
		<td>아이디</td>
		<td>요청 등급</td>
		<td>요청 날짜</td>
		<td>상세</td>
		</tr>
	<c:forEach var="dto" items="${hotData}" varStatus="no">
		<tr>
		<td>${no.index+1 }</td>
		<td>${dto.id }</td>
		<td>${dto.grade }</td>
		<td>${dto.time }</td>
		<td><a href="GradeDetail?no=${dto.no }&rq=hot">열람</a></td>
		</tr>
	</c:forEach>
	
</table>