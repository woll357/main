<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<table border="">
<tr>
<td colspan="4">게시글 수 : </td>
<td>${totcnt}</td>
</tr>
<tr>
<td>글번호</td>
<td>제목</td>
<td>작성자</td>
<td>작성일</td>
<td>조회수</td>
</tr>

<c:forEach var="dto" items="${data}" varStatus="no">	
	<tr>
		<td>${start+no.index+1 }</td>
		<td><a href="NoticeDetail?num=${dto.num }&center=in&page=${nowPage}">${dto.title }</a></td>
		<c:choose>
			<c:when test="${mem.grade=='M' }"><td>${dto.id }</td></c:when>
			<c:otherwise><td>운영자</td></c:otherwise>
		</c:choose>
		
		<td>${dto.time }</td>
		<td>${dto.view }</td>
	</tr>
</c:forEach>
<tr>
		<td colspan="5" align="center">
		<c:if test="${startPage>1 }">
			<a href="?page=${startPage-1 }&center=in">이전</a>
		</c:if>
			<c:forEach begin="${startPage }" end="${endPage }" var="i">
				<c:choose>
					<c:when test="${i==nowPage }">
						[${i }]
					</c:when>	
					<c:otherwise>
						<a href="?page=${i}&center=in">${i}</a>
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
			<c:if test="${endPage<totalPage }">
			<a href="?page=${endPage+1 }&center=in">다음</a>
			</c:if>
		</td>
	</tr>
<c:if test="${mem.grade=='M' }">

<tr>
<td colspan="5"><a href="NoticeWrite?center=in">글쓰기</a></td>
</tr>
</c:if>


</table>