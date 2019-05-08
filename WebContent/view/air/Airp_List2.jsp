<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

</head>
<body>
<form action="Airp_Detail">
	<table  align="center">	
		<tr>
			<td style="background: #D4F4FA" >항공편 코드</td>
			<td style="background: #D4F4FA" ><input type="text" name="air_p" /></td>
			<td style="background: #D4F4FA"  align="center"><input type="submit" value="선택  " /></td>
		</tr>
			</table>
</form>
<form action="Airp_Detail">
<table align="center">
<tr>
			<td style="background: #D4F4FA" >날짜</td>			
			<td style="background: #D4F4FA" ><input type="text" name="ddate" /></td>
			<td style="background: #D4F4FA"  align="center"><input type="submit" value="선택  " /></td>
		</tr>
		</table>
</form>
<table width=100%>
	<tr>
		<td style="background: #D4F4FA" >상품코드</td>
		<td style="background: #D4F4FA" >비행기코드</td>
		<td style="background: #D4F4FA" >출발시간</td>
		<td style="background: #D4F4FA" >출발지</td>
		<td style="background: #D4F4FA" >도착지</td>
		<td style="background: #D4F4FA" >도착시간</td>
		<td style="background: #D4F4FA" >남은좌석</td>	
		<td style="background: #D4F4FA" >좌석등급</td>
	</tr>
<c:forEach var="dt" items="${dto }" varStatus="no" >
	<tr>
	<td>${dt.ccode }</td>	
		<td>${dt.ap_code }</td>
		<td>${dt.ddate }</td>
		<td>${dt.darea }</td>
		<td>${dt.carea }</td>
		<td>${dt.a_time }</td>
		<td>${dt.seatcnt }</td>
		<td>${dt.flightclass }</td>
	</tr>
 </c:forEach>
	<tr>
		<td colspan="10" align="center">
		<c:if test="${startpage>1 }">       <!-- 스타트 페이지가 1보다클때만 나와라 -->
			<a href="?page=${startpage-1 }&aotcont=in">[이전]</a> 
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
			<c:if test="${endpage<totalpage }">  <!-- 마지막 페이지가 토탈페이지보다 작을때만 다음이 나오게-->
			<a href="?page=${endpage+1 }&aotcont=in">[다음]</a> 
		</c:if>
		</td>
	</tr>
</table>
</body>
</html>