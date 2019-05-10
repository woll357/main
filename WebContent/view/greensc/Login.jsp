<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script src="../js/jquery-3.3.1.min.js"></script>
<script src = "../js/nh/loginChk.js"></script>
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">


<form action="LoginReg" method="post" name="frm">
<table cellspacing="80px" style="background-image: url('../img/login.jpg'); width: 1000px; height: 800px;">
<tr>
<td>
<br><br><br><br><br><br><br><br><br><br>
<table style="background-color : rgba( 255, 255, 255, 0.5 ); border : 5px #dcefef solid; border-radius: 50px;" cellspacing="20px">
	<tr>
		<td colspan="2"><font size="7px">로그인 하세요</font></td>
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
		
		<input type="button" value="로그인" id="btn" class="btncss"/>
		<a href="SignUp"><input type="button" value="회원가입" class="btncss"/></a>
		<a href="FindMySign"><input type="button" value="ID/PW찾기" class="btncss"/></a>
		
		</td>
	</tr>
</table>
</td>
</tr>
</table>


</form>
