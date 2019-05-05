<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/nh/calendar.js"></script>
<script src="../js/nh/homeBtnAct.js"></script>
<script src="../js/nh/searchCombo.js"></script>

<style>
.today {
	text-align: center;
	background-color: yellow;
	border-radius: 10px;
}

.sunday {
	text-align: center;
	color: red;
}

.workday {
	text-align: center
}

.satday {
	text-align: center;
	color: blue;
}

.week {
	text-align: center;
	font-size: 20px;
	background-color: #eff9f9;
	border-radius: 10px;
}

.tt {
	text-align: center;
	font-size: 30px;
}

.preNext {
	text-align: center;
	font-size: 30px;
}

#ddateCal1 {
	width: 600px;
	height: 200px;
}

.kindd {
	font-size: 40px;
}

.rtrt {
	font-size:30px;
	width: 80px;
	height: 60px;
	text-align: center;
	border-radius: 10px 10px 0 0;
}

#rtp {
	background-color: #dcefef;	
}

.airBackDiv {
	width: 600px;
	height: 430px;
	background-color: #dcefef;
}

.airInDiv {
	position: absolute;
	width: 580px;
	height: 410px;
	background-color: white;
	margin-left: 10px;
	margin-top: 10px;
}
.hotBackDiv {
	width: 380px;
	height: 430px;
	background-color: #dcefef;
}

.hotInDiv {
	position: absolute;
	width: 360px;
	height: 410px;
	background-color: white;
	margin-left: 10px;
	margin-top: 10px;
}
.airSelect{
	width: 200px;
	height: 35px;
	font-size: 20px;
}
.hotSelect{
	width: 250px;
	height: 30px;
	font-size: 20px;
}
.ssdate2{
	width: 150px;
	height: 35px;
	font-size: 20px;
}
.ssdate1{
width: 150px;
	height: 35px;
	font-size: 20px;
}
#ssdate2{
	width: 50px;
	height: 40px;
	font-size: 20px;
}
#ssdate1{
width: 50px;
	height: 40px;
	font-size: 20px;
}
#seatcnt{
width: 150px;
	height: 35px;
	font-size: 20px;
}




.startDay{
	width: 200px;
	height: 30px;
	font-size: 20px;
}
.endDay{
width: 200px;
	height: 30px;
	font-size: 20px;
}
#startDay{
	width: 50px;
	height: 35px;
	font-size: 20px;
}
#endDay{
width: 50px;
	height: 35px;
	font-size: 20px;
}
#pcnt{
width: 250px;
	height: 30px;
	font-size: 20px;
}
#plane{
	width: 150px;
	height: 35px;
	font-size: 20px;
}
#hott{
	width: 150px;
	height: 30px;
	font-size: 20px;
}
</style>



<table>
	<tr>
		<td class="kindd"><b>항공편 검색</b></td>
		<td class="kindd"><b>숙박편 검색</b></td>
	</tr>
	<tr>
		<td>
			<table cellspacing="0">
				<tr>
					<td id="rtp" class="rtrt">왕복</td>
					<td id="awp" class="rtrt">편도</td>
				</tr>
			</table>
			<div class="airBackDiv">
				<div class="airInDiv">







					<form action="RsvAirReg" method="post" name="airFrm">
						<input type="hidden" name="id" value="${mem.id }" /> <input
							type="hidden" name="grade" value="${mem.grade }" />
						<table style="font-size: 25px; width: 100%;">
							<tr>
								<td style="height: 50px;">출국도시</td>
								<td>도착도시</td>
							</tr>
							<tr>
								<td style="height: 40px;"><select name="darea" id="darea" class="airSelect">
										<option value="인천">인천</option>
										<option value="상해">상해</option>
										<option value="베이징">베이징</option>
										<option value="도쿄">도쿄</option>
										<option value="오사카">오사카</option>
										<option value="마닐라">마닐라</option>
										<option value="보라카이">보라카이</option>
										<option value="세부">세부</option>
										<option value="푸켓">푸켓</option>
								</select></td>
								<td><select name="carea" id="carea" class="airSelect">
										<option value="인천">인천</option>
										<option value="상해">상해</option>
										<option value="베이징">베이징</option>
										<option value="도쿄">도쿄</option>
										<option value="오사카">오사카</option>
										<option value="마닐라">마닐라</option>
										<option value="보라카이">보라카이</option>
										<option value="세부">세부</option>
										<option value="푸켓">푸켓</option>
								</select></td>
							</tr>
							<tr>
								<td class="start" style="height: 50px;">출발날짜</td>
								<td class="return">
									<div class="dd" style="visibility: visible;">귀국날짜</div>
								</td>
							</tr>
							<tr>
								<td class="start" style="height: 40px;"><input type="text" name="ddate1"
									class="ssdate1" readonly="readonly" /> <input type="button"
									value="날짜" id="ssdate1"></td>
								<td class="return">
									<div class="dd" style="visibility: visible;">
										<input type="text" name="ddate2" class="ssdate2"
											readonly="readonly" /> <input type="button" value="날짜"
											id="ssdate2" />
									</div>
								</td>
							</tr>
							<tr>
								<td style="height: 50px;">인원</td>
								<td>좌석</td>
							</tr>
							<tr>
								<td style="height: 40px;"><input type="number" name="seatcnt" id="seatcnt" />명</td>
								<td><select name="flightclass" id="flightclass" class="airSelect">
										<option value="일반">일반</option>
										<option value="비즈니스">비즈니스</option>
								</select></td>
							</tr>
							<tr>
							<td></td>
								<td style="height: 50px;">
								<input type="button" id="plane" value="검색" /></td>
							</tr>


						</table>
					</form>












				</div>
			</div>



		</td>
		<td>
			
			
			<font size="7x;"><br></font>
			<div class="hotBackDiv">
				<div class="hotInDiv">
			<form action="RsvHotReg" method="post" name="hotFrm">
				<input type="hidden" name="id" value="${mem.id }" /> <input
					type="hidden" name="grade" value="${mem.grade }" />
				<table style="font-size: 25px; width: 100%;">
					<tr>
						<td>목적지</td>
					</tr>
					<tr>
						<td><select name="city" class="hotSelect">
								<option value="상해">상해</option>
								<option value="베이징">베이징</option>
								<option value="도쿄">도쿄</option>
								<option value="오사카">오사카</option>
								<option value="마닐라">마닐라</option>
								<option value="보라카이">보라카이</option>
								<option value="세부">세부</option>
								<option value="푸켓">푸켓</option>
						</select></td>
					</tr>
					<tr>
						<td>체크인</td>
					</tr>
					<tr>
						<td><input type="text" name="startDay" class="startDay"
							readonly="readonly" />  <input type="button" value="날짜검색"
							id="startDay"></td>
					</tr>
					<tr>
						<td>체크아웃</td>
					</tr>
					<tr>
						<td><input type="text" name="endDay" class="endDay"
							readonly="readonly" />  <input type="button" value="날짜검색"
							id="endDay"></td>
					</tr>
					<tr>
						<td>인원</td>
					</tr>
					<tr>
						<td><input type="number" name="pcnt" id="pcnt" /></td>
					</tr>
					<tr>
						<td>등급</td>
					</tr>
					<tr>
						<td><select name="rkind" id="rkind" class="hotSelect">
								<option value="D">디럭스룸</option>
								<option value="S">스위트룸</option>
						</select></td>
					</tr>
					<tr>
						<td  align="center"><input type="button" id="hott" value="검색" /></td>
					</tr>

				</table>

			</form>
			</div></div>

		</td>
	</tr>
</table>

<div id="ddateCal1" style="visibility: hidden;"></div>