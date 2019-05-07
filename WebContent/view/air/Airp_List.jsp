<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="AirCom_Detail" method="post">
	<table width=100%  >	
		<tr>
			<td style="background: #D4F4FA" colspan="2">항공편 코드</td>
			<td style="background: #D4F4FA"><input type="text" name="air_p"/></td>
			<input type="hidden" name="air_code" value="${mem.air_code }">
			<input type="hidden" name="id" value="${mem.id }">
			<td style="background: #D4F4FA" align="center"><input type="submit" value="선택  " /></td>
		</tr>
	<tr>
		<td>항공편코드</td>
		<td>회사명</td>
		<td>출발지</td>
		<td>도착지</td>
	</tr>

<c:forEach var="dto" items="${data}" varStatus="no">	
	<tr>
	<td><%-- <a href="AirItem_Detail?ccode=${dto.ccode }">${dto.ccode }</a> --%><a href="Airp_List2?air_p=${dto.air_p }&air_code=${mem.air_code }&aotcont=in">${dto.air_p }</a></td>	
		<td>${dto.air_name }</td>
		<td>${dto.darea }</td>
		<td>${dto.carea }</td>
		
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5" align="center">
		<c:if test="${startpage>1 }">       <!-- 스타트 페이지가 1보다클때만 나와라 -->
			<a href="?page=${startpage-1 }">[이전]</a> 
		</c:if>
		<c:forEach begin="${startpage }" end="${endpage }" var="i">
				<c:choose>
				<c:when test="${i==nowpage }"> <!-- 지금 페이지가 내 페이지라면 -->
				[${i }]
				</c:when>
				<c:otherwise>
					<a href="?page=${i }&aotcont=in">${i }</a> <!-- 자기 자신으로 돌아오는데 페이지가 i -->
				</c:otherwise>
				</c:choose>			
			</c:forEach>
		</td>
	</tr>
	</table>

</form>
</body>
</html>