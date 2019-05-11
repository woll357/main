<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">

<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">
<script src="../js/odk/datesarch.js"></script>

<c:forEach var="dt" items="${dto }" end="0">
<h2>${dt.darea } → ${dt.carea } 상품 목록</h2>
</c:forEach>


<form id="cc" action="Airp_Detail">
<table border="" class="ttcss">
<input type="hidden" value="${param.air_p}" name="air_p">
<input type="hidden" value="in" name="partner">
		<tr>
			
			<td class="wbbr" style="border-bottom: 3px white solid;" align="right" colspan="7" >날짜　<input style="padding: 10px" type="text" class="ddate" name="ddate" /></td>
			<td class="wbbr" style="border-right: 10px #dcefef solid;border-bottom: 3px white solid;" align="center"><input class="aa"  style="background: #FFFFFF;font-size: 20px;color: #779191;"  type="button" value="선택  " /></td>
		</tr>
	<tr>
		<td class="wbbr">상품코드</td>
		<td class="wbbr">비행기코드</td>
		<td class="wbbr">출발시간</td>
		<td class="wbbr">출발지</td>
		<td class="wbbr">도착지</td>
		<td class="wbbr">도착시간</td>
		<td class="wbbr">남은좌석</td>	
		<td class="wbbr" style="border-right: 10px #dcefef solid;">좌석등급</td>
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
		<td style="border-right: 10px #dcefef solid;">${dt.flightclass }</td>
	</tr>
 </c:forEach>
		<tr>
		<td colspan="10" align="center">
		<c:if test="${startpage>1 }">       <!-- 스타트 페이지가 1보다클때만 나와라 -->
			<a href="?page=${startpage-1 }&partner=in&air_p=${param.air_p}">[이전]</a> 
		</c:if>
		<c:forEach begin="${startpage }" end="${endpage }" var="i">
				<c:choose>
				<c:when test="${i==nowpage }"> <!-- 지금 페이지가 내 페이지라면 -->
				[${i }]
				</c:when>
				<c:otherwise>
					<a href="?page=${i }&partner=in&air_p=${param.air_p}">${i }</a> <!-- 자기 자신으로 돌아오는데 페이지가 i -->
				</c:otherwise>
				</c:choose>			
			</c:forEach>
			<c:if test="${endpage<totalpage }">  <!-- 마지막 페이지가 토탈페이지보다 작을때만 다음이 나오게-->
			<a href="?page=${endpage+1 }&partner=in&air_p=${param.air_p}">[다음]</a> 
		</c:if>
		</td>
	</tr>
</table>
</form>
</body>
</html>