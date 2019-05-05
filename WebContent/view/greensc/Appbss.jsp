<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src = "../js/nh/UpupGradeChk.js"></script>
<link rel="stylesheet" href="../css/nh/gradeUp.css" type="text/css">
<style>

</style>
<div id="back"><div id="in">
<table border="">

	<tr>

		<td align="center">회원등급</td>
				<td>
				<select name="grade" id="grade">                                   <!-- select 콤보박스 같은거 -->
				<option value="A">A</option>
				<option value="H">H</option>
				<option value="M" >M</option> <!-- selected 미리 선택되어있게 -->
				</select>
		</td>

	</tr>

	<tr>
		<td colspan="2">신청 양식</td>
	</tr>
	<tr>
		<td colspan="2" id="contents">
		
		</td>
	</tr>
</table>
</div></div>