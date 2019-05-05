<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script src="../js/jquery-3.3.1.min.js"></script>
<script src = "../js/nh/loginChk.js"></script>


<style>
.lgtd{
	height: 50px;
	font-size: 30px;
}
input{
	height: 30px;
}
#id{
	width: 250px;
}
#pw{
	width: 250px;
}
#btn{
	width: 100px;
}
#loglog{
	position: absolute;
	left: 350px;
	top: 550px;
	
}

</style>



<body>
<div id="loglog">
<form action="LoginReg" method="post" name="frm">

<table>
	<tr>
		<td colspan="2"><font size="20px">로그인 하세요</font></td>
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


</form>

</div>

</body>
</html>