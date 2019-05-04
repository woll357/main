<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script src="../js/jquery-3.3.1.min.js"></script>  
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


    
<form action="DeleteMySignReg" method="post" name="frm">
	<table>
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td id="mem">${mem.id }</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="pw"/></td>
		</tr>
		<tr>
			<td colspan="2">
			회원 탈퇴에 동의합니다.
			<input type="checkbox" name="agree" value="true"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="button" value="회원 탈퇴" id="btn"/>
			</td>
		</tr>
	</table>
</form>