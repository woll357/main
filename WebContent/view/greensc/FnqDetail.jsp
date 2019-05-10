<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">
<h2>자주묻는질문</h2>
<table class="ttcss" border="">
	<tr>
		<td class="wbbr">글번호</td><td>${param.no}</td>
	</tr><tr>
		<td class="wbbr">제목</td><td>${dto.title }</td>
	</tr><tr>
		<td class="wbbr">작성자</td>
		<c:choose>
			<c:when test="${mem.grade=='M' }"><td>${dto.id }</td></c:when>
			<c:otherwise><td>운영자</td></c:otherwise>
		</c:choose>
	</tr><tr>
		<td class="wbbr">작성일</td><td>${dto.time }</td>
	</tr><tr>
		<td class="wbbr">조회수</td><td>${dto.view }</td>
	</tr><tr>
		<td class="wbb">내용</td><td><c:if test="${dto.img!=null}"><img alt="" src="../img/${dto.img}"><br></c:if>${dto.contentBr }</td>
	</tr><tr>
		<td colspan="2" align="right">
			<a href="../greensc/FnqList?center=in">목록으로</a>
			
		</td>
	</tr>
</table>
