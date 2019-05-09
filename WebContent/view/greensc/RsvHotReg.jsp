<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/nh/hotRev.css" type="text/css">

<script>

$(document).ready(function(){
	
	$('.btn').on({
		'click':function(){
			alert("로그인 하세요");
		}
		
	})

})



</script>


<table  style="width: 100%">
	<tr>
		<td colspan="4"><font size="30px"><b>호텔예약</b></font></td>
	</tr>
	<tr>
		<td colspan="4"><hr color="#dcefef" size="1px"></td>
	</tr>
	<tr>
		<td>체크인 :</td>
		<td><input type="text" readonly="readonly"
			value="${param.startDay }" /></td>
		<td>체크 아웃 :</td>
		<td><input type="text" readonly="readonly"
			value="${param.endDay }" /></td>
	</tr>
	<tr>
		<td colspan="4"><hr color="#dcefef" size="1px"></td>
	</tr>
</table>

<table  style="width: 100%">
	<tr>
		<td colspan="2" class="nnn">국가</td>
		<td class="cc">도시</td>
		<td class="hn">호텔이름</td>
		<td class="hg">방 등급</td>
		<td class="ii">간단정보</td>
		<td class="dd">상세</td>
	</tr>
	<tr>
		<td colspan="7"><hr color="#dcefef" size="1px"></td>
	</tr>

	<c:forEach var="dto" items="${dto}" varStatus="no">
		<form action="Hdetail" method="post">
			<input type="hidden" name="hcode" value="${dto.hcode }" /> <input
				type="hidden" name="startDay" value="${param.startDay }" /> <input
				type="hidden" name="endDay" value="${param.endDay }" />
			<table  style="width: 100%">
				<tr>

					<td class="no">${no.index+1 }</td>
					<td class="nn">${dto.country }</td>
					<td class="cc">${dto.city }</td>
					<td class="hn"><img alt="" src="../img/${dto.himg }"> ${dto.hname }</td>
					<td class="hg">
					<c:choose>
					<c:when test="${dto.rkind=='D' }">디럭스룸</c:when>
					<c:otherwise>스탠다드룸</c:otherwise>
					</c:choose>

					</td>
					<td class="ii">${dto.hinfo }</td>

					<c:choose>
						<c:when test="${mem.id!=null && mem.id!=''}">
							<td class="dd"><input type="submit" value="상세조회" /></td>
						</c:when>
						<c:otherwise>
							<td class="dd"><input type="button" value="상세조회" class="btn" /></td>
						</c:otherwise>
					</c:choose>


				</tr>
			<tr>
		<td colspan="7"><hr color="#dcefef" size="1px"></td>
	</tr>
			</table>
		</form>


	</c:forEach>


</table>




