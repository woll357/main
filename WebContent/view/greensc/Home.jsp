<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <script src="../js/jquery-3.3.1.min.js"></script>
 <script src = "../js/nh/calendar.js"></script>
<script src = "../js/nh/homeBtnAct.js"></script>
<script src = "../js/nh/searchCombo.js"></script>
 
<div id="ddateCal1" style="visibility: hidden;" >

</div>


<table>
	<tr>
		<td>항공</td>
		<td>숙박</td>
	</tr>
	<tr>
		<td>
			<form action="RsvAirReg" method="post" name="airFrm">
			<input type="hidden" name="id" value="${mem.id }"/>
			<input type="hidden" name="grade" value="${mem.grade }"/>
			<table border="">
				<tr>
					<td colspan="2"><table border="">
							<tr>
								<td id="rtp">왕복</td>
								<td id="awp">편도</td>
							</tr>
						</table></td>
				</tr>
				<tr>
					<td>출국도시</td>
					<td>도착도시</td>
				</tr>
				<tr>
					<td>
					<select name="darea" id="darea">
					<option value="인천">인천</option>
					<option value="상해">상해</option>
					<option value="베이징">베이징</option>
					<option value="도쿄">도쿄</option>
					<option value="오사카">오사카</option>
					<option value="마닐라">마닐라</option>
					<option value="보라카이">보라카이</option>
					<option value="세부">세부</option>
					<option value="푸켓">푸켓</option>
					</select>
					</td>
					<td>
					<select name="carea" id="carea">
					<option value="인천">인천</option>
					<option value="상해">상해</option>
					<option value="베이징">베이징</option>
					<option value="도쿄">도쿄</option>
					<option value="오사카">오사카</option>
					<option value="마닐라">마닐라</option>
					<option value="보라카이">보라카이</option>
					<option value="세부">세부</option>
					<option value="푸켓">푸켓</option>
					</select>
					</td>
				</tr>
				<tr>
					<td class="start">출발날짜</td>
					<td class="return"><div class="dd" style="visibility: visible;">귀국날짜</div></td>
				</tr>
				<tr>
					<td class="start">
					<input type="text" name="ddate1" class="ssdate1" readonly="readonly"/><input type="button" value="날짜검색" id="ssdate1">
					</td>
					<td class="return"><div class="dd" style="visibility: visible;">
					<input type="text" name="ddate2" class="ssdate2" readonly="readonly"/><input type="button" value="날짜검색" id="ssdate2"/>
					</div></td>
				</tr>
				<tr>
					<td>인원</td>
					<td>좌석</td>
				</tr>
				<tr>
					<td><input type="number" name="seatcnt" id="seatcnt"/>명</td>
					<td>
					<select name="flightclass" id="flightclass">
					<option value="일반">일반</option>
					<option value="비즈니스">비즈니스</option>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" id="plane" value="검색"/></td>
				</tr>


			</table>
			</form>

		</td>
		<td>
		
		<form action="RsvHotReg" method="post" name="hotFrm">
		<input type="hidden" name="id" value="${mem.id }"/>
		<input type="hidden" name="grade" value="${mem.grade }"/>
		<table border="">
			<tr>
				<td>목적지</td>
			</tr>
			<tr>
				<td>
					<select name="city">
					<option value="상해">상해</option>
					<option value="베이징">베이징</option>
					<option value="도쿄">도쿄</option>
					<option value="오사카">오사카</option>
					<option value="마닐라">마닐라</option>
					<option value="보라카이">보라카이</option>
					<option value="세부">세부</option>
					<option value="푸켓">푸켓</option>
					</select>
					</td>
					</tr>
			<tr>
				<td>체크인</td>
			</tr>
			<tr>
				<td><input type="text" name="startDay" class="startDay" readonly="readonly"/><input type="button" value="날짜검색" id="startDay"></td>
			</tr>
			<tr>
				<td>체크아웃</td>
			</tr>
			<tr>
				<td><input type="text" name="endDay" class="endDay" readonly="readonly"/><input type="button" value="날짜검색" id="endDay"></td>
			</tr>
			<tr>
				<td>인원</td>
			</tr>
			<tr>
				<td><input type="number" name="pcnt" id="pcnt"/></td>
			</tr>
			<tr>
				<td>등급</td>
			</tr>
			<tr>
				<td>
				<select name="rkind" id="rkind">
					<option value="D">디럭스룸</option>
					<option value="S">스위트룸</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="button" id="hott" value="검색"/></td>
			</tr>
			
		</table>
		
		
		
		
		</form>
		
		</td>
	</tr>
</table>