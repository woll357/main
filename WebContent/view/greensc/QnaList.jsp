<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/nh/centerList.css" type="text/css">



<div id="back">
<table style="width: 100%; border : 10px #dcefef solid;" cellspacing="0">
<tr>
<c:choose>
<c:when test="${mem.grade=='M' }">
<td colspan="3">총 문의글 : ${totcnt }</td>
<td>대기 문의 : ${qqcnt }</td>
<td>완료 : ${aacnt }</td>
</c:when>
<c:otherwise>
<td colspan="3" align="right">내 문의글 : ${mycnt }</td>
<td align="right">대기 문의 : ${qqcnt }</td>
<td align="right">완료 : ${aacnt }</td>
</c:otherwise>
</c:choose>

</tr>

	<tr>
		<td class="listNo" style="border-bottom: 10px #dcefef solid;">글번호</td>
		<td class="listtt" style="border-bottom: 10px #dcefef solid;">제목</td>
		<td class="listnn" style="border-bottom: 10px #dcefef solid;">작성자</td>
		<td class="listdd" style="border-bottom: 10px #dcefef solid;">작성일</td>
		<td class="listvv" style="border-bottom: 10px #dcefef solid;">답변</td>
	</tr>

	<c:forEach var="dto" items="${data}" varStatus="no">
				<tr>
					<td class="listNo">${dto.num+1 }</td>
					<td class="listtt"><a href="QnaDetail?num=${dto.num }&center=in&page=${nowPage}&center=in">${dto.title }</a></td>
					<td class="listnn">${dto.id }</td>
					<td class="listdd">${dto.time }</td>
					<td class="listvv">${dto.answer }</td>

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
		<td colspan="5" id="listWrite"><a href="QnaWriteForm?center=in">글쓰기</a></td>
	</tr>

</table>
</div>