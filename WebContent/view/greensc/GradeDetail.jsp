<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/nh/GradeUpRg.js"></script>
<link rel="stylesheet" href="../css/nh/centerList.css" type="text/css">

<div id="back">



	<c:choose>

		<c:when test="${param.rq=='mg' }">
			<form action="GradeDetailReg" method="post" name="frm" id="ff">
				<input type="hidden" name="id" value="${dto.id }" /> <input
					type="hidden" name="bnum" value="${dto.bnum }" /> <input
					type="hidden" name="grade" value="${dto.grade }" /> <input
					type="hidden" name="time" value="${dto.time }" />
				<table style="width: 100%; border: 10px #dcefef solid;"
					cellspacing="0">
					<tr>
						<td class="ggList">요청 등급</td>
						<td class="ggcont">${dto.grade }</td>
					</tr>
					<tr>
						<td colspan="2"><hr color="#dcefef" size="1px"></td>
					</tr>
					<tr>
						<td class="ggList">ID</td>
						<td class="ggcont">${dto.id }</td>
					</tr>
					<tr>
						<td colspan="2"><hr color="#dcefef" size="1px"></td>
					</tr>
					<tr>
						<td class="ggList">사번</td>
						<td class="ggcont">${dto.bnum }</td>
					</tr>
					<tr>
						<td colspan="2"><hr color="#dcefef" size="1px"></td>
					</tr>
					
					<tr>
						<td class="ggList">요청 시간</td>
						<td class="ggcont">${dto.time }</td>
					</tr>
					<tr>
						<td colspan="2"><hr color="#dcefef" size="1px"></td>
					</tr>
					<tr>
						<td colspan="2" class="ggList" style="padding: 10px;"><input type="button" value="승인" id="ok" /> <input
							type="button" value="거절" id="no" /></td>
					</tr>
				</table>
			</form>

		</c:when>

		<c:when test="${param.rq=='air' }">
			<form action="GradeDetailReg" method="post" name="frm" id="ff">
				<input type="hidden" name="no" value="${dto.no }" /> <input
					type="hidden" name="id" value="${dto.id }" /> <input type="hidden"
					name="crn" value="${dto.crn }" /> <input type="hidden"
					name="air_name" value="${dto.air_name }" /> <input type="hidden"
					name="grade" value="${dto.grade }" /> <input type="hidden"
					name="air_codecom" value="${dto.air_codecom }" /> <input
					type="hidden" name="img" value="${dto.img }" /> <input
					type="hidden" name="salesPercent" value="${dto.salesPercent }" />
				<table style="width: 100%; border: 10px #dcefef solid;"
					cellspacing="0">
					<tr>
						<td class="ggList">요청 등급</td>
						<td class="ggcont">${dto.grade }</td>
					</tr>
					<tr>
						<td colspan="2"><hr color="#dcefef" size="1px"></td>
					</tr>
					<tr>
						<td class="ggList">ID</td>
						<td class="ggcont">${dto.id }</td>
					</tr>
					<tr>
						<td colspan="2"><hr color="#dcefef" size="1px"></td>
					</tr>
					<tr>
						<td class="ggList">사업자 번호</td>
						<td class="ggcont">${dto.crn }</td>
					</tr>
					<tr>
						<td colspan="2"><hr color="#dcefef" size="1px"></td>
					</tr>
					<tr>
						<td class="ggList">항공사 이름</td>
						<td class="ggcont">${dto.air_name }</td>
					</tr>
					<tr>
						<td colspan="2"><hr color="#dcefef" size="1px"></td>
					</tr>
					<tr>
						<td class="ggList">요청 수익률</td>
						<td class="ggcont">${dto.salesPercent*100 }%</td>
					</tr>
					<tr>
						<td colspan="2"><hr color="#dcefef" size="1px"></td>
					</tr>
					<tr>
						<td class="ggList">항공사 사진</td>
						<td><img alt="" src="../img/${dto.img }"></td>
					</tr>
					<tr>
						<td colspan="2"><hr color="#dcefef" size="1px"></td>
					</tr>
					<tr>
						<td class="ggList">요청 시간</td>
						<td class="ggcont">${dto.time }</td>
					</tr>
					<tr>
						<td colspan="2"><hr color="#dcefef" size="1px"></td>
					</tr>
					<tr>
						<td colspan="2" class="ggList" style="padding: 10px;"><input type="button" value="승인" id="ok" /> <input
							type="button" value="거절" id="no" /></td>
					</tr>
				</table>
			</form>

		</c:when>



		<c:otherwise>

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
				<table style="width: 100%; border: 10px #dcefef solid;"
					cellspacing="0">
					<tr>
						<td class="ggList">요청 등급</td>
						<td class="ggcont">${dto.grade }</td>
					</tr>
					<tr>
						<td colspan="2"><hr color="#dcefef" size="1px"></td>
					</tr>
					<tr>
						<td class="ggList">ID</td>
						<td class="ggcont">${dto.id }</td>
					</tr>
					<tr>
						<td colspan="2"><hr color="#dcefef" size="1px"></td>
					</tr>
					<tr>
						<td class="ggList">사업자 번호</td>
						<td class="ggcont">${dto.crn }</td>
					</tr>
					<tr>
						<td colspan="2"><hr color="#dcefef" size="1px"></td>
					</tr>
					<tr>
						<td class="ggList">호텔 이름</td>
						<td class="ggcont">${dto.hname }</td>
					</tr>
					<tr>
						<td colspan="2"><hr color="#dcefef" size="1px"></td>
					</tr>
					<tr>
						<td class="ggList">요청 수익률</td>
						<td class="ggcont">${dto.salesPercent*100 }%</td>
					</tr>
					<tr>
						<td colspan="2"><hr color="#dcefef" size="1px"></td>
					</tr>
					<tr>
						<td class="ggList">호텔 사진</td>
						<td class="ggcont"><img alt="" src="../img/${dto.himg }"></td>
					</tr>
					<tr>
						<td colspan="2"><hr color="#dcefef" size="1px"></td>
					</tr>
					<tr>
						<td class="ggList">요청 시간</td>
						<td class="ggcont">${dto.time }</td>
					</tr>
					<tr>
						<td colspan="2"><hr color="#dcefef" size="1px"></td>
					</tr>
					<tr>
						<td colspan="2" class="ggList" style="padding: 10px;"><input
							type="button" value="승인" id="ok" /> <input type="button"
							value="거절" id="no" /></td>
					</tr>
				</table>
			</form>

		</c:otherwise>
	</c:choose>
</div>

