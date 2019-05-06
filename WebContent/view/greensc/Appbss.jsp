<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src = "../js/nh/UpupGradeChk.js"></script>
<link rel="stylesheet" href="../css/nh/gradeUp.css" type="text/css">


<div id="back"><div id="in">
<table style="width: 100%">
	<tr>
		<td colspan="2"><font size="30px;"><b>등업 신청</b></font>
		<hr color="#dcefef" size="1px">
		</td>
	</tr>
	<tr>

		<td align="center" class="gg">회원등급</td>
				<td class="gg">
				<select name="grade" id="grade">                                   <!-- select 콤보박스 같은거 -->
				<option value="A">A</option>
				<option value="H">H</option>
				<option value="M" >M</option> <!-- selected 미리 선택되어있게 -->
				</select>
		</td>

	</tr>

	<tr>
		<td colspan="2" ><hr color="#dcefef" size="1px">신청 양식<hr color="#dcefef" size="1px"></td>
	</tr>
	<tr>
		<td colspan="2" id="contents">
		
		</td>
	</tr>
</table>
</div></div>