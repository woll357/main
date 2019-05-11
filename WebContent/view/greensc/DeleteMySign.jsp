<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script src="../js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">

<script>
$(document).ready(function(){
	
	$('#btn').on({
		'click':function(){
			if('${mem.id}'=='admin'){
				alert("해당 계정은 삭제가 불가능 합니다.");
			}else{
				frm.submit();
			}
			
		}
	})
	
})
</script>


<h2>회원 탈퇴 신청</h2>
<form action="DeleteMySignReg" method="post" name="frm">
	<table style="width: 100%; border : 10px #dcefef solid; border-collapse: collapse;" cellpadding="10px" border="">
		<tr>
			<td class="wbbr">아이디</td>
			<td id="mem" class="lgtd">${mem.id }</td>
		</tr>
		<tr>
			<td class="wbbr">비밀번호</td>
			<td><input type="password" name="pw"/></td>
		</tr>
		<tr>
			<td colspan="2" class="lgtd" align="center">
			회원 탈퇴에 동의합니다.
			<input type="checkbox" name="agree" value="true" style="width: 20px;"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="button" value="회원 탈퇴" id="btn" style="width: 200px;" class="btncss"/>
			</td>
		</tr>
	</table>
</form>