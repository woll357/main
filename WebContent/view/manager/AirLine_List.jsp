<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">

<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">
<h2>항공사 목록</h2>
<table border="" class="ttcss">
	<tr>
		<td class="wbbr"  width="250" ></td>
		<td class="wbbr" >항공사 코드</td>
		<td class="wbbr">아아디</td>
		<td class="wbbr" >사업자등록번호</td>
		<td class="wbbr" colspan="2">회사이름</td>
	</tr>
	<c:forEach var="dto" items="${data }" varStatus="no">
	<tr>
		<td><img src="../img/${dto.img }" width="250px" height="100px"></td>
		<td>${dto.air_code }</td>
		<td>${dto.id }</td>
		<td>${dto.crn }</td>
		<td>${dto.air_name }</td>
		<td><a href="AirLine_Delete?air_code=${dto.air_code }&id=${dto.id }&partner=in"><input type="button" class="btncss" value="삭제"></a></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>