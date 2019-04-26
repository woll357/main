<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <script src="../js/jquery-3.3.1.min.js"></script>
 <script>
 
 $(document).ready(function(){
	
	 $('#awp').on({
		 'click' : function(){
			 $('div').css({
				 'visibility': 'hidden'
			 })

		 }
	 })
	 $('#rtp').on({
		 'click' : function(){
			 $('div').css({
				 'visibility': 'visible'
			 })

		 }
	 })
	 
	 $('submit').on({
		'click':function(){
		
			
		} 
	 })
	 
	 
 })
 
 </script>


<table>
	<tr>
		<td>항공</td>
		<td>숙박</td>
	</tr>
	<tr>
		<td>
			<form action="RsvAirReg" method="post">
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
					<td><input type="text" name="darea"/><input type="button" /></td>
					<td><input type="text" name="carea"/><input type="button" /></td>
				</tr>
				<tr>
					<td class="start">출발날짜</td>
					<td class="return"><div>귀국날짜</div></td>
				</tr>
				<tr>
					<td class="start"><input type="text" name="ddate1"/><input type="button" /></td>
					<td class="return"><div><input type="text" name="ddate2"/><input type="button" /></div></td>
				</tr>
				<tr>
					<td>인원</td>
					<td>좌석</td>
				</tr>
				<tr>
					<td><input type="text" name="seatcnt"/><input type="button" /></td>
					<td><input type="text" name="flightclass"/><input type="button" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" /></td>
				</tr>


			</table>
			</form>

		</td>
		<td>
		
		<form action="RsvHotReg" method="post">
		<input type="hidden" name="id" value="${mem.id }"/>
		<input type="hidden" name="grade" value="${mem.grade }"/>
		<table border="">
			<tr>
				<td>목적지</td>
			</tr>
			<tr>
				<td><input type="text" name="city"/></td>
			</tr>
			<tr>
				<td>체크인</td>
			</tr>
			<tr>
				<td><input type="text" name="startDay" /></td>
			</tr>
			<tr>
				<td>체크아웃</td>
			</tr>
			<tr>
				<td><input type="text" name="endDay"/></td>
			</tr>
			<tr>
				<td>인원</td>
			</tr>
			<tr>
				<td><input type="text" name="pcnt" /></td>
			</tr>
			<tr>
				<td>등급</td>
			</tr>
			<tr>
				<td><input type="text" name="rkind" /></td>
			</tr>
			<tr>
				<td><input type="submit" /></td>
			</tr>
			
		</table>
		
		
		
		
		</form>
		
		</td>
	</tr>
</table>