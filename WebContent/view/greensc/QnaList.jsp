<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h2>Q&A</h2>
<table style="width: 100%; border: 10px #dcefef solid; border-collapse: collapse;"cellpadding="5px;" cellspacing="0" border="">
<tr>
<c:choose>
<c:when test="${mem.grade=='M' }">
<td colspan="3" style="border-right: 1px white solid;">총 문의글 : ${totcnt }</td>
<td style="border-right: 1px white solid;">대기 문의 : ${qqcnt }</td>
<td >완료 : ${aacnt }</td>
</c:when>
<c:otherwise>
<td colspan="3" align="right"style="border-right: 1px white solid;">내 문의글 : ${mycnt }</td>
<td align="right"style="border-right: 1px white solid;">대기 문의 : ${qqcnt }</td>
<td align="right"style="border-right: 1px white solid;">완료 : ${aacnt }</td>
</c:otherwise>
</c:choose>

</tr>

	<tr>
		<td>글번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>답변</td>
	</tr>

	<c:forEach var="dto" items="${data}" varStatus="no">
				<tr>
					<td>${dto.num }</td>
					<td><a href="QnaDetail?num=${dto.num }&center=in&page=${nowPage}&center=in">${dto.title }</a></td>
					<td>${dto.id }</td>
					<td>${dto.time }</td>
					<td>${dto.answer }</td>

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
	<tr>
		<td colspan="5" align="right"><a href="QnaWriteForm?center=in">글쓰기</a></td>
	</tr>

</table>
