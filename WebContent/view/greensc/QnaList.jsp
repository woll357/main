<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="">
	<tr>
		<td>글번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>답변</td>
	</tr>

	<c:forEach var="dto" items="${data}" varStatus="no">
				<tr>
					<td>${dto.num+1 }</td>
					<td><a href="QnaDetail?num=${dto.num }">${dto.title }</a></td>
					<td>${dto.id }</td>
					<td>${dto.time }</td>
					<td>${dto.answer }</td>

				</tr>

	</c:forEach>

	<tr>
		<td colspan="5"><a href="QnaWriteForm">글쓰기</a></td>
	</tr>

</table>
