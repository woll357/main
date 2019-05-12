<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">

<h2>Q&A</h2>
<table class="ttcss" cellspacing="0" border="">
	<tr>
		<td width="100px;" class="wbbr">글번호</td>
		<td>${param.no }</td>
	</tr>
	<tr>
		<td class="wbbr">제목</td>
		<td>${dto.title }</td>
	</tr>
	<tr>
		<td class="wbbr">작성자</td>
		<td>${dto.id }</td>
	</tr>
	<tr>
		<td class="wbbr">작성일</td>
		<td>${dto.time }</td>
	</tr>
	<tr>
		<td class="wbbr">내용</td>
		<td>
		<c:if test="${dto.img!=null}"><img alt="" src="../img/${dto.img}"></c:if>
		${dto.contentBr }</td>
	</tr>
	<tr>
		<td colspan="2" align="right"><c:if test="${dto.answer=='대기' }">
				<a href="QnaList?center=in">목록으로</a>
			</c:if> <c:if test="${mem.grade=='M' }">
				<c:choose>
					<c:when test="${dto.answer=='대기' }">
						<a href="ReplyQna?num=${dto.num }&center=in&no=${param.no}">답변</a>
					</c:when>

					<c:otherwise>
					</c:otherwise>
				</c:choose>
			</c:if></td>
	</tr>
</table>



<c:if test="${dto.answer=='완료' }">

<table style="width: 100%; border: 10px #dcefef solid; border-collapse: collapse;"cellpadding="5px;" cellspacing="0" border="">
		<tr>
			<td  width="100px;" class="wbbr">글번호</td>
			<td>${param.no }</td>
		</tr>
		<tr>
			<td class="wbbr">제목</td>
			<td>${dto2.title }</td>
		</tr>
		<tr>
			<td class="wbbr">작성자</td>
			<c:choose>
				<c:when test="${mem.grade=='M' }">
					<td>${mem.id }</td>
				</c:when>
				<c:otherwise>
					<td class="wbbr">운영자</td>
				</c:otherwise>
			</c:choose>


		</tr>
		<tr>
			<td class="wbbr">작성일</td>
			<td>${dto2.time }</td>
		</tr>
		<tr>
			<td class="wbb">내용</td>
			<td>
			<c:if test="${dto2.img!=null}"><img alt="" src="../img/${dto2.img}"></c:if>
			${dto2.contentBr }</td>
		</tr>
		<tr>
			<td colspan="2" align="right"><a href="QnaList?center=in">목록으로</a></td>
		</tr>
	</table>

</c:if>
