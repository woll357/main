
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>비행기 등록</title>
</head>
<body>
<script src="../js/jquery-3.3.1.min.js"></script>   
<script type="../js/odk/Airplane_insert"></script>
<h2>비행기등록</h2>
<form name="airinre" action="Airplane_InsertReg">
<table width=100% >
	<tr >
		<td>비행기 코드</td><td><input type="text" class="ap"  name="ap_code"></td>
	</tr>
	<tr>
		<td>항공사 코드</td>
		<td><input type="text" readonly="readonly" name="air_code" value="${mem.air_code }"></td>
	</tr>
	<tr>
		<td>항공기이름</td>
		<td>
		<select name="air_ty">
		<option value="보잉737">보잉737</option>
		<option value="에어버스A321">에어버스A321</option>
		<option value="에어버스A111">에어버스A111</option>
		</select>
	</tr>
	<tr>
		<td align="right" colspan="3"><input type="button" class="planego" value="등록"></td>
	</tr>
</table>
</form>
</body>
</html>