<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>관리자호텔리스트보기</h2>

<form action="HlistSearch?partner=in" method="post">
	<table border="">
		<tr>
			<td>코드검색</td>
			<td><input type="text" name="hcode" /></td>
			<td><input type="submit" value="검색" /></td>
		</tr>
	</table>
</form>
<form action="HlistCountrySearch?partner=in" method="post">
	<table border="">
		<tr>
			<td>나라검색</td>
			<td><select name="country">
				<option value="일본">일본</option>
				<option value="중국">중국</option>
				<option value="필리핀">필리핀</option>
				<option value="태국">태국</option>
			</select></td>
			<td><input type="submit" value="검색" /></td>
		</tr>
	</table>
</form>
<br><br>
<table border="">
<c:forEach var="dto" items="${data }" varStatus="no">	
	<tr>
		<td>호텔코드</td>
		<td colspan="2" width="200">${dto.hcode }</td>
	</tr>
	<tr>
		<td rowspan="3" width="220"><img src="../img/${dto.himg }" alt="" /></td>
		<td>${dto.country }</td>
		<td>${dto.city }</td>
	</tr>
	<tr>
	<td colspan="2">${dto.hname }</td>
	</tr>
	<tr>
	<td colspan="2">${dto.hinfo }</td>
	</tr>
	<tr>
		<td colspan="3">${dto.addDetail }</td>
	</tr>
	<tr>
	<td align="left" colspan="3"><a href="Hdetail?hcode=${dto.hcode }&partner=in">관리자상세조회</a></td>
	</tr>
</c:forEach>
	<tr>
		<td colspan="5" align="center">
				<c:if test="${startPage>1 }">
				<a href="?page=${startPage-1 }&partner=in">[이전]</a>
				</c:if>
			<c:forEach begin="${startPage }" end="${endPage }" var="i">
				<c:choose>
					<c:when test="${i==nowPage }">
						[${i }]
					</c:when>
					<c:otherwise>
							<a href="?page=${i }">${i }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${endPage<totalPage}">
				<a href="?page=${endPage+1 }&partner=in">[다음]</a>
			</c:if>
		</td>

	</tr>



</table>
