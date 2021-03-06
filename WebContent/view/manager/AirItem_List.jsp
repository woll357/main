<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">
<h2>상품 목록</h1>
<form action="AirItem_Detail">
<table border="" class="ttcss">
<input type="hidden" name= "partner"  value="in"/>
		<tr>
			
			<td class="wbbr" align="right" colspan="10" class="wbbr"  style="border-bottom: 3px white solid;">상품 코드　<input style="padding: 10px"  type="text" name="ccode" /></td>
			<td class="wbbr"  style="border-bottom: 3px white solid;" align="center"><input type="submit" value="선택  "  style="background: #FFFFFF ;" class="btncss2"/></td>
		</tr>
	<tr>
	
		<td class="wbbr" width="85">상품코드</td>
		<td class="wbbr" width="50">항공사 코드</td>
		<td class="wbbr" width="50">비행기코드</td>
		<td class="wbbr">출발시간</td>
		<td class="wbbr">출발지</td>
		<td class="wbbr" width="50">도착지</td>
		<td class="wbbr">가격</td>
		<td class="wbbr" >도착시간</td>
		<td class="wbbr" width="50" >예약된좌석</td>
		<td class="wbbr" width="35">총좌석</td>	
		<td class="wbbr">좌석등급</td>
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