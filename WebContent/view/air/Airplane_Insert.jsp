<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">

<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">
<script src="../js/jquery-3.3.1.min.js"></script>   
<script src="../js/odk/Airplane_insert.js"></script>
<h2 >비행기 등록</h2>
<form name="airinre" action="Airplane_InsertReg">
<input  type="hidden" value="in" name="aotcont">
<table border="" class="ttcss">
	<tr >
		<td class="wbbr">비행기 코드</td><td style="border-right: 10px #dcefef solid;"><input type="text" class="ap"  name="ap_code"></td>
	</tr>
	<tr>
		<td class="wbbr">항공사 코드</td>
		<td style="border-right: 10px #dcefef solid;"><input type="text" readonly="readonly" name="air_code" value="${mem.air_code }"></td>
	</tr>
	<tr>
		<td class="wbbr">항공기이름</td>
		<td style="border-right: 10px #dcefef solid;">
		<select name="air_ty">
		<option value="보잉737">보잉737</option>
		<option value="에어버스A321">에어버스A321</option>
		<option value="에어버스A111">에어버스A111</option>
		</select>
	</tr>
	<tr>
	<td class="wbbr"></td>
		<td  align="right" colspan="2"><input type="button" style="background-color: #dcefef;font-size: 20px;color: #779191;" class="planego" value="등록"></td>
	</tr>
</table>
</form>
