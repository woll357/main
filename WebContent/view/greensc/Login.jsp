<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script src="../js/jquery-3.3.1.min.js"></script>
<script src = "../js/nh/loginChk.js"></script>



<form action="LoginReg" method="post" name="frm">
<table cellspacing="80px" style="background-image: url('../img/login.jpg'); width: 1000px; height: 800px;">
<tr>
<td>
<br><br><br><br><br><br><br><br><br><br>
<table style="background-color : #d8d8d8; border : 5px #dcefef solid; border-radius: 50px;" cellspacing="20px">
	<tr>
		<td colspan="2"><font size="7px">로그인 하세요</font></td>
	</tr>
	<tr>
		<td class="lgtd">ID</td>
		<td><input type="text" name="id" id="id"/></td>
	</tr>
	<tr>
		<td class="lgtd">PW</td>
		<td><input type="password" name="pw" id="pw"/></td>
	</tr>
	<tr>
		<td colspan="2" class="lgtd">
		
		<input type="button" value="로그인" id="btn"/>
		<a href="SignUp"><input type="button" value="회원가입"/></a>
		<a href="FindMySign"><input type="button" value="ID/PW찾기"/></a>
		
		</td>
	</tr>
</table>
</td>
</tr>
</table>


</form>
