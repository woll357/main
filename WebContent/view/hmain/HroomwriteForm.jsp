<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="../js/yjm/hmain_rwrite.js"></script>
    <div align="center" style="margin-top: -250px">
    <h1>방등록</h1>
<form name="rmsign" action="HroomwriteReg" method="post" enctype="multipart/form-data">
	<input type="hidden" name="hcode" value="${mem.hcode }"  />

	<table border="" style="text-align: center;">
			<!-- <a href=""><input type="button" value=""/></a> -->
		<tr>
			<td>방종류</td>
			<td><select name="rkind">
				<option value="S">스탠다드</option>
				<option value="D">디럭스룸</option>
			</select></td>
		</tr>
		<tr>
			<td>방갯수 (1~99)</td>
<!-- 			<td><select name="rcnt">
				<option value=1>1</option>
				<option value=2>2</option>
				<option value=3>3</option>
				<option value=4>4</option>
				<option value=5>5</option>
			</select></td> -->
			<td><input type="number" name="rcnt" maxlength="2" oninput="maxLengthCheck(this)" id="rcnt"></td>
		</tr>
		<tr>
			<td>방인원</td>
			<td><select name="pcnt">
				<option value=2>2</option>
				<option value=4>4</option>
			</select></td>		
		</tr>
		<tr>
			<td>방이미지</td>
			<td><input type="file" name="rimg" id="rimg"/></td>
		</tr>
		<tr>
			<td>금액</td>
			<td><input type="number" name="money" id="money"/></td>
		</tr>
		<tr>
			<td>주말금액</td>
			<td><input type="number" name="wmoney" id="wmoney" /></td>
		</tr>
		<tr>
			<td>wifi여부</td>
			<td><select name="wifi">
				<option value=false>false</option>
				<option value=true>true</option>
			</select></td>
		</tr>
		<tr>
			<td>조식여부</td>
			<td><select name="morning">
				<option value=false>false</option>
				<option value=true>true</option>
			</select></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
			<input type="button" value="작성" class="roomsignup"/>
			<input type="reset" value="초기화" />
			</td>
		</tr>
	
	</table>
	


</form>
</div>