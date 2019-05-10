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
    <h2>호텔검색</h2> 
    <div align="center">
<form class="aaa" action="HlistSearch?partner=in" method="post">
	<table  class="ttcss" border="">
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
<div>
<br><br>
<c:choose>

	<c:when test="${data.size()==0 }">
		<h1 align="center">검색결과가 없습니다.</h1>
	</c:when>
</c:choose>
</div>
<br><br>
<c:forEach var="dto" items="${data }" varStatus="no">
<div>	
<table class="ttcss" border="" style="text-align: center;">

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
	<td align="right" colspan="3"><a href="Hdetail?hcode=${dto.hcode }&partner=in">관리자상세조회</a></td>
	</tr>

</table>
</div>
</c:forEach>