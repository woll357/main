<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/nh/centerList.css" type="text/css">



<div id="back">
	<table style="width: 100%; border: 10px #dcefef solid;" cellspacing="0">
		<tr>
			<td colspan="4" class="listCnt" align="right">게시글 수 :</td>
			<td class="listCnt">${totcnt}</td>
		</tr>
		<tr>
			<td class="listNo" style="border-bottom: 10px #dcefef solid;">글번호</td>
			<td class="listtt" style="border-bottom: 10px #dcefef solid;">제목</td>
			<td class="listnn" style="border-bottom: 10px #dcefef solid;">작성자</td>
			<td class="listdd" style="border-bottom: 10px #dcefef solid;">작성일</td>
			<td class="listvv" style="border-bottom: 10px #dcefef solid;">조회수</td>
		</tr>

		<c:forEach var="dto" items="${data}" varStatus="no">
			<tr>
				<td class="listNo">${dto.num }</td>
				<td class="listtt"><a
					href="NoticeDetail?num=${dto.num }&center=in&page=${nowPage}">${dto.title }</a></td>
				<c:choose>
					<c:when test="${mem.grade=='M' }">
						<td class="listnn">${dto.id }</td>
					</c:when>
					<c:otherwise>
						<td class="listnn">운영자</td>
					</c:otherwise>
				</c:choose>

				<td class="listdd">${dto.time }</td>
				<td class="listvv">${dto.view }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="center"><c:if test="${startPage>1 }">
					<a href="?page=${startPage-1 }&center=in">이전</a>
				</c:if> <c:forEach begin="${startPage }" end="${endPage }" var="i">
					<c:choose>
						<c:when test="${i==nowPage }">
						[${i }]
					</c:when>
						<c:otherwise>
							<a href="?page=${i}&center=in">${i}</a>
						</c:otherwise>
					</c:choose>

				</c:forEach> <c:if test="${endPage<totalPage }">
					<a href="?page=${endPage+1 }&center=in">다음</a>
				</c:if></td>
		</tr>
		<c:if test="${mem.grade=='M' }">

			<tr>
				<td colspan="5" id="listWrite"><a href="NoticeWrite?center=in">글쓰기</a></td>
			</tr>
		</c:if>


	</table>
</div>