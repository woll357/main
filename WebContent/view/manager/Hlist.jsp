<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style >
.aaa{
	position: absolute;
	top: 4px;

}
.bbb{
position: absolute;
	top: 4px; 
	left:331px;

}
</style>
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">

<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">
<div align="center">
<form class="aaa" action="HlistSearch?partner=in" method="post">
	<table class="ttcss" border="">
		<tr>
			<td class="wbbr">호텔코드검색</td>
			<td><input type="text" name="hcode" /></td>
			<td><input type="submit" value="검색" class="btncss2" style="background: #FFFFFF ;" /></td>
		</tr>
	</table>
</form>
</div>
<div align="center">
<form class="bbb" action="HlistCountrySearch?partner=in" method="post">
	<table class="ttcss" border="">
		<tr>
			<td class="wbbr">나라검색</td>
			<td><select name="country">
				<option value="일본">일본</option>
				<option value="중국">중국</option>
				<option value="필리핀">필리핀</option>
				<option value="태국">태국</option>
			</select></td>
			<td><input type="submit" value="검색" class="btncss2" style="background: #FFFFFF ;" /></td>
		</tr>
	</table>
</form>
</div>
<br><br>
<h2>호텔리스트</h2>
<div align="center">
<table class="ttcss" border="" style="text-align: center;">
<c:forEach var="dto" items="${data }" varStatus="no">	

	<tr>
		<td rowspan="3" width="220"><img src="../img/${dto.himg }" alt="" /></td>
		<td>${dto.country }</td>
		<td style="border-right: 10px #dcefef solid;">${dto.city }</td>
	</tr>
	<tr>
	<td colspan="2" style="border-right: 10px #dcefef solid;">${dto.hname }</td>
	</tr>
	<tr>
	<td colspan="2" style="border-right: 10px #dcefef solid;">${dto.hinfo }</td>
	</tr>
	<tr>
		<td class="wbbr">호텔코드</td>
		<td  colspan="2" width="200" style="border-right: 10px #dcefef solid;" >${dto.hcode }</td> 
	</tr>
	<tr>
		<td class="wbbr">아이디</td>
		<td colspan="2" style="border-right: 10px #dcefef solid;">${dto.id }</td>
	</tr>
		<tr>
		<td class="wbbr">상세주소</td>
		<td colspan="2" style="border-right: 10px #dcefef solid;">${dto.addDetail }</td>
	</tr>
	<tr>
	<td align="right" colspan="3" style="border-right: 10px #dcefef solid;"><a href="Hdetail?hcode=${dto.hcode }&partner=in">관리자상세조회</a></td>
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
							<a href="?page=${i }&partner=in">${i }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${endPage<totalPage}">
				<a href="?page=${endPage+1 }&partner=in">[다음]</a>
			</c:if>
		</td>

	</tr>



</table>
</div>
<br><br>