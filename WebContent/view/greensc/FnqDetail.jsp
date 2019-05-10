<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>자주묻는질문</h2>
<table border="" width="100%" cellpadding="5px;" style="border : 10px #dcefef solid; border-collapse: collapse;">
	<tr>
		<td id="listDetail">글번호</td><td>${dto.num }</td>
	</tr><tr>
		<td>제목</td><td>${dto.title }</td>
	</tr><tr>
		<td>작성자</td>
		<c:choose>
			<c:when test="${mem.grade=='M' }"><td>${dto.id }</td></c:when>
			<c:otherwise><td>운영자</td></c:otherwise>
		</c:choose>
	</tr><tr>
		<td>작성일</td><td>${dto.time }</td>
	</tr><tr>
		<td>조회수</td><td>${dto.view }</td>
	</tr><tr>
		<td>내용</td><td><c:if test="${dto.img!=null}"><img alt="" src="../img/${dto.img}"><br></c:if>${dto.contentBr }</td>
	</tr><tr>
		<td colspan="2" align="right">
			<a href="../greensc/FnqList?center=in">목록으로</a>
			
		</td>
	</tr>
</table>
