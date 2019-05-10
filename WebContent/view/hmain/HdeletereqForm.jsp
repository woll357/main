<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/dk/input.css" type="text/css">

<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">
    <h2>삭제신청</h2>
<form  action="HdeletereqReg" method="post">
		<input type="hidden" name="Code" value="${mem.hcode }"  />
		<input type="hidden" name="id" value="${mem.id }"  />
		<input type="hidden" name="kind" value="호텔" />
		<table class="ttcss" border="" style="text-align: center;">
				<tr>
					<td>사유</td>
					<td><textarea cols="142" rows="20" name="request" ></textarea></td>
				</tr>	
				
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="작성" style="background-color: #dcefef; font-size: 20px; color: #779191"/>
					<input type="reset" value="초기화" style="background-color: #dcefef; font-size: 20px; color: #779191"/>
				</td>
			</tr>
		</table>

</form>
