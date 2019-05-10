<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">

<script>

$(document).ready(function(){
	
	$('.btn').on({
		'click':function(){
			alert("로그인 하세요");
		}
		
	})

})



</script>

<h2>호텔 예약</h2>
<table class="ttcss" cellspacing="0" cellpadding="0">
<tr>
<td>
<table style="width: 100%" cellspacing="0">	
	
	
	<tr>
		<td class="wbbr" style="border-bottom: 3px white solid">체크인 :</td>
		<td>${param.startDay }</td>
		
		<td class="wbbr" style="border-bottom: 3px white solid">체크 아웃 :</td>
		<td>${param.endDay }</td>
		<td style="width: 452px;"></td>
	</tr>
	
</table>

<table  style="width: 100%" cellspacing="0">
	<tr>
		<td colspan="2" class="wbbr" width="40px">국가</td>
		<td class="wbbr" width="100px">도시</td>
		<td class="wbbr" width="350px">호텔이름</td>
		<td class="wbbr" width="100px">방 등급</td>
		<td class="wbbr" width="200px">간단정보</td>
		<td class="wbb">상세</td>
	</tr>
	

	<c:forEach var="dto" items="${dto}" varStatus="no">
		<form action="Hdetail" method="post">
		<input type="hidden" name="rkind" value="${dto.rkind }" /> 
			<input type="hidden" name="hcode" value="${dto.hcode }" /> <input
				type="hidden" name="startDay" value="${param.startDay }" /> <input
				type="hidden" name="endDay" value="${param.endDay }" />
			<table  style="width: 100%" cellspacing="0">
				<tr>

					<td class="bbr" width="20px">${no.index+1 }</td>
					<td class="bbr" width="61px">${dto.country }</td>
					<td class="bbr" width="100px">${dto.city }</td>
					<td class="bbr" width="350px"><img alt="" src="../img/${dto.himg }"><br>${dto.hname }</td>
					<td class="bbr">
					<c:choose>
					<c:when test="${dto.rkind=='D' }">디럭스룸</c:when>
					<c:otherwise>스탠다드룸</c:otherwise>
					</c:choose>

					</td>
					<td  class="bbr"  width="200px">${dto.hinfo }</td>

					<c:choose>
						<c:when test="${mem.id!=null && mem.id!=''}">
							<td  class="bb" width="75px"><input type="submit" value="상세조회" /></td>
						</c:when>
						<c:otherwise>
							<td  class="bb" width="75px"><input type="button" value="상세조회" class="btn" /></td>
						</c:otherwise>
					</c:choose>


				</tr>
			
			</table>
		</form>


	</c:forEach>


</table>

</td>
</tr>
</table>


