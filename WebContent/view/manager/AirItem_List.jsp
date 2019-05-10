<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">

<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">
<h1 align="center">상품 목록</h1>
<form action="AirItem_Detail">
<table border="" style="width: 100%; border : 10px #dcefef solid;" cellspacing="0">
<input type="hidden" name= "partner"  value="in"/>
		<tr>
			<td style="background: #D4F4FA" colspan="9">상품 코드</td>
			<td style="background: #D4F4FA"><input type="text" name="ccode" /></td>
			<td style="background: #D4F4FA" align="center"><input type="submit" value="선택  " style="background: #FFFFFF"/></td>
		</tr>
	<tr>
	
		<td width="40">상품코드</td>
		<td width="30">비행기코드</td>
		<td>비행기코드</td>
		<td>출발시간</td>
		<td>출발지</td>
		<td>도착지</td>
		<td>가격</td>
		<td>도착시간</td>
		<td width="50" >예약된좌석</td>
		<td width="35">총좌석</td>	
		<td>좌석등급</td>
	</tr>

<c:forEach var="dto" items="${data}" varStatus="no">	
	<tr>
		
	<td><a href="AirItem_Detail?ccode=${dto.ccode }&partner=in">${dto.ccode }</a></td>	
		<td>${dto.air_code }</td>
		<td>${dto.ap_code }</td>
		<td>${dto.ddate }</td>
		<td>${dto.darea }</td>
		<td>${dto.carea }</td>
		<td>${dto.money }</td>
		<td>${dto.a_time }</td>
		<td>${dto.seatcnt }</td>
		<td>${dto.totseatcnt }</td>
		<td>${dto.flightclass }</td>
		
	</tr>
	</c:forEach>
	<tr>
		<td colspan="11" align="center">
		<c:if test="${startpage>1 }">       <!-- 스타트 페이지가 1보다클때만 나와라 -->
			<a href="?page=${startpage-1 }&partner=in">[이전]</a> 
		</c:if>
		<c:forEach begin="${startpage }" end="${endpage }" var="i">
				<c:choose>
				<c:when test="${i==nowpage }"> <!-- 지금 페이지가 내 페이지라면 -->
				[${i }]
				</c:when>
				<c:otherwise>
					<a href="?page=${i }&partner=in">${i }</a> <!-- 자기 자신으로 돌아오는데 페이지가 i -->
				</c:otherwise>
				</c:choose>			
			</c:forEach>
			<c:if test="${endpage<totalpage }">  <!-- 마지막 페이지가 토탈페이지보다 작을때만 다음이 나오게-->
			<a href="?page=${endpage+1 }&partner=in">[다음]</a> 
		</c:if>
		</td>
	</tr>
	</table>

</form>
</body>
</html>