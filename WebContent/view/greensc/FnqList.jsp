<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<table border="">
<tr>
<td>글번호</td>
<td>제목</td>
<td>작성자</td>
<td>작성일</td>
<td>조회수</td>
</tr>

<c:forEach var="dto" items="${data}" varStatus="no">	
	<c:if test="${dto.num>-1 }">
	<tr>
		<td>${no.index }</td>
		<td><a href="../greensc/FnqDetail?num=${dto.num }&center=in">${dto.title }</a></td>
		<c:choose>
			<c:when test="${mem.grade=='M' }"><td>${dto.id }</td></c:when>
			<c:otherwise><td>운영자</td></c:otherwise>
		</c:choose>
		<td>${dto.time }</td>
		<td>${dto.view }</td>
	</tr>
	</c:if>
</c:forEach>
<c:if test="${mem.grade=='M' }">

<tr>
<td colspan="5"><a href="../greensc/FnqWrite?center=in">글쓰기</a></td>
</tr>
</c:if>


</table>