<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/nh/centerList.css" type="text/css">


<div id="backk">
<table border="" width="100%" cellpadding="5px;" style="border : 10px #dcefef solid;">
	<tr>
		<td width="100px;">글번호</td>
		<td>${dto.num }</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${dto.title }</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${dto.id }</td>
	</tr>
	<tr>
		<td>작성일</td>
		<td>${dto.time }</td>
	</tr>
	<tr>
		<td>내용</td>
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
						<a href="ReplyQna?num=${dto.num }&center=in">답변</a>
					</c:when>

					<c:otherwise>
					</c:otherwise>
				</c:choose>
			</c:if></td>
	</tr>
</table>



<c:if test="${dto.answer=='완료' }">

<table border="" width="100%" cellpadding="5px;" style="border : 10px #dcefef solid;">
		<tr>
			<td  width="100px;">글번호</td>
			<td>${dto2.num }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${dto2.title }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<c:choose>
				<c:when test="${mem.grade=='M' }">
					<td>${mem.id }</td>
				</c:when>
				<c:otherwise>
					<td>운영자</td>
				</c:otherwise>
			</c:choose>


		</tr>
		<tr>
			<td>작성일</td>
			<td>${dto2.time }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
			<c:if test="${dto2.img!=null}"><img alt="" src="../img/${dto2.img}"></c:if>
			${dto2.contentBr }</td>
		</tr>
		<tr>
			<td colspan="2" align="right"><a href="QnaList?center=in">목록으로</a></td>
		</tr>
	</table>

</c:if>
</div>