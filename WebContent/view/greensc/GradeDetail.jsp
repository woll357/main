<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">

<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/nh/GradeUpRg.js"></script>

	<c:choose>

		<c:when test="${param.rq=='mg' }">
		<h2>등업관리 / 매니저등업</h2>
			<form action="GradeDetailReg" method="post" name="frm" id="ff">
				<input type="hidden" name="id" value="${dto.id }" /> <input
					type="hidden" name="bnum" value="${dto.bnum }" /> <input
					type="hidden" name="grade" value="${dto.grade }" /> <input
					type="hidden" name="time" value="${dto.time }" />
				<table border="" cellspacing="0" cellpadding=5px; class="ttcss">
					<tr>
						<td class="wbbr" width="300px">요청 등급</td>
						<td>${dto.grade }</td>
					</tr>
					
					<tr>
						<td class="wbbr">ID</td>
						<td>${dto.id }</td>
					</tr>
					
					<tr>
						<td class="wbbr">사번</td>
						<td>${dto.bnum }</td>
					</tr>
					
					
					<tr>
						<td class="wbbr">요청 시간</td>
						<td>${dto.time }</td>
					</tr>
					
					<tr>
						<td colspan="2" style="padding: 10px;" align="center"><input type="button" value="승인" id="ok"  class="btncss"/> <input
							type="button" value="거절" id="no" class="btncss"/></td>
					</tr>
				</table>
			</form>

		</c:when>

		<c:when test="${param.rq=='air' }">
		<h2>등업관리 / 항공사등업</h2>
			<form action="GradeDetailReg" method="post" name="frm" id="ff">
				<input type="hidden" name="no" value="${dto.no }" /> <input
					type="hidden" name="id" value="${dto.id }" /> <input type="hidden"
					name="crn" value="${dto.crn }" /> <input type="hidden"
					name="air_name" value="${dto.air_name }" /> <input type="hidden"
					name="grade" value="${dto.grade }" /> <input type="hidden"
					name="air_codecom" value="${dto.air_codecom }" /> <input
					type="hidden" name="img" value="${dto.img }" /> <input
					type="hidden" name="salesPercent" value="${dto.salesPercent }" />
				<table border="" cellspacing="0" cellpadding=5px; class="ttcss">
					<tr>
						<td class="wbbr" width="300px">요청 등급</td>
						<td>${dto.grade }</td>
					</tr>
					
					<tr>
						<td class="wbbr">ID</td>
						<td>${dto.id }</td>
					</tr>
					
					<tr>
						<td class="wbbr">사업자 번호</td>
						<td>${dto.crn }</td>
					</tr>
					
					<tr>
						<td class="wbbr">항공사 이름</td>
						<td>${dto.air_name }</td>
					</tr>
					
					<tr>
						<td class="wbbr">요청 수익률</td>
						<td>${dto.salesPercent*100 }%</td>
					</tr>
					
					<tr>
						<td class="wbbr">항공사 사진</td>
						<td><img alt="" src="../img/${dto.img }"></td>
					</tr>
					
					<tr>
						<td class="wbbr">요청 시간</td>
						<td>${dto.time }</td>
					</tr>
					
					<tr>
						<td colspan="2" style="padding: 10px;" align="center"><input type="button" value="승인" id="ok" class="btncss"/> <input
							type="button" value="거절" id="no" class="btncss"/></td>
					</tr>
				</table>
			</form>

		</c:when>



		<c:otherwise>
			<h2>등업관리 / 호텔사등업</h2>
			<form action="GradeDetailReg" method="post" name="frm" id="ff">
				<input type="hidden" name="no" value="${dto.no }" /> <input
					type="hidden" name="id" value="${dto.id }" /> <input type="hidden"
					name="crn" value="${dto.crn }" /> <input type="hidden" name="hname"
					value="${dto.hname }" /> <input type="hidden" name="country"
					value="${dto.country }" /> <input type="hidden" name="city"
					value="${dto.city }" /> <input type="hidden" name="hinfo"
					value="${dto.hinfo }" /> <input type="hidden" name="grade"
					value="${dto.grade }" /> <input type="hidden" name="himg"
					value="${dto.himg }" /> <input type="hidden" name="salesPercent"
					value="${dto.salesPercent }" />
				<table border="" cellspacing="0" cellpadding=5px; class="ttcss">
					<tr>
						<td class="wbbr" width="300px">요청 등급</td>
						<td>${dto.grade }</td>
					</tr>
					
					<tr>
						<td class="wbbr">ID</td>
						<td>${dto.id }</td>
					</tr>
					
					<tr>
						<td class="wbbr">사업자 번호</td>
						<td>${dto.crn }</td>
					</tr>
					
					<tr>
						<td class="wbbr">호텔 이름</td>
						<td>${dto.hname }</td>
					</tr>
					
					<tr>
						<td class="wbbr">요청 수익률</td>
						<td>${dto.salesPercent*100 }%</td>
					</tr>
					
					<tr>
						<td class="wbbr">호텔 사진</td>
						<td><img alt="" src="../img/${dto.himg }"></td>
					</tr>
					
					<tr>
						<td class="wbbr">요청 시간</td>
						<td>${dto.time }</td>
					</tr>
					
					<tr>
						<td colspan="2" style="padding: 10px;" align="center"><input
							type="button" value="승인" id="ok" class="btncss"/> <input type="button"
							value="거절" id="no" class="btncss"/></td>
					</tr>
				</table>
			</form>

		</c:otherwise>
	</c:choose>

