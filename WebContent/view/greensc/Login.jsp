<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script src="../js/jquery-3.3.1.min.js"></script>
<script>

$(document).ready(function(){
	
	$('#btn').on({
		'click':function(){
			var idPat =/^[0-9A-Za-z]*$/;
			
			if(!idPat.test($('#pw').val()) || !idPat.test($('#id').val())){
				alert('아이디 형식을 확인해주세요');
			}else{
				frm.submit();
			}
		}
	})
	
	
})


</script>



<body>

<form action="LoginReg" method="post" name="frm">




<table border="">
	<tr>
		<td colspan="2">로그인 하세요</td>
	</tr>
	<tr>
		<td>ID</td>
		<td><input type="text" name="id" id="id"/></td>
	</tr>
	<tr>
		<td>PW</td>
		<td><input type="password" name="pw" id="pw"/></td>
	</tr>
	<tr>
		<td colspan="2">
		
		<input type="button" value="로그인" id="btn"/>
		<a href="SignUp"><input type="button" value="회원가입"/></a>
		<a href="FindMySign"><input type="button" value="ID/PW찾기"/></a>
		
		</td>
	</tr>
</table>


</form>



</body>
</html>