<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src = "../js/nh/UpupGradeChk.js"></script>
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">


<h2>등업 신청</h2>


<table class="ttcss" border="" cellpadding="0">

	<tr>

		<td align="center" class="wbbr">회원등급</td>
				<td class="gg" style="padding: 5px">
				<select name="grade" id="grade" style="width: 200px;">                                   <!-- select 콤보박스 같은거 -->
				<option value="A">항공사</option>
				<option value="H">호텔사</option>
				<option value="M" >매니저</option> <!-- selected 미리 선택되어있게 -->
				</select>
		</td>

	</tr>

	<tr>
		<td colspan="2"  style="padding: 5px">신청 양식</td>
	</tr>
	<tr>
		<td colspan="2" id="contents">
		
		</td>
	</tr>
</table>
