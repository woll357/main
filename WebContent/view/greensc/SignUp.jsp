<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src = "../js/nh/countryCombo.js"></script>
<script src = "../js/nh/signUpChk.js"></script>
<link rel="stylesheet" href="../css/nh/signup.css" type="text/css">



<div id="back"><div id="in">

<form action="SignUpReg" method="post" name="frm">
	<table style="width: 100%">
	<tr>
	<td colspan="3"><font size="70px"><b>회원가입</b></font><hr color="#dcefef" size="1px"></td>
	</tr>
		<tr>
			<td align="center" width="100" class="tt">id</td>
			<td width="400px;">
			<input name="id" type="text" id="id" maxlength="8"  onkeyup="butPat()" class="inin"/>
			<div id="idTag">4~16자, 특수문자, 한글 제외</div>
			</td><td>
			<input type="button" value="중복확인" class="btn" id="idBtn" disabled="disabled"/>
			</td>
		</tr>
		<tr>
			<td align="center" class="tt">pw</td>
			<td colspan="2"><input name="pw" type="password" maxlength="16" id="pw" onkeyup="chkPat()"  class="inin"/>
			<div id="pwTag">8 ~ 16자, 특수문자 제외</div>		
			</td>
		</tr>
		<tr>
			<td align="center" class="tt">pw 확인</td>
			<td colspan="2"><input name="pw2" type="password" maxlength="16" id="pw2" onkeyup="chkPat()"  class="inin"/>
			<div id="pw2Tag">pw와 동일하게 입력</div>
			</td>
			
		</tr>
		<tr>
			<td align="center" class="tt">이름</td>
			<td colspan="2"><input name="pname" type="text" id="pname" onkeyup="chkPat()"  class="inin"/>
			<div id="nameTag">한글이름</div>
			</td>
		</tr>
		<tr>
			<td align="center" class="tt">연락처</td>
			<td>
			<input name="phone" type="text" id="phone1"  maxlength="3" onkeyup="butPat()"  class="ppin"/> -
			<input name="phone" type="text" id="phone2"  maxlength="4" onkeyup="butPat()"  class="ppin"/> -
			<input name="phone" type="text" id="phone3" maxlength="4" onkeyup="butPat()"  class="ppin"/>
			<div id="ppTag"></div>
			</td><td>
			<input type="button" value="중복확인" class="btn" id="phoneBtn" disabled="disabled"/>
			</td>
		</tr>
		<tr>
			<td align="center" class="tt">생년월일</td>
			<td colspan="2"><input name="birth" type="text" maxlength="8" id="birth" onkeyup="chkPat()"  class="inin"/>
			<div id="bbTag">예) 19000101</div>
			</td>
			
		</tr>
		<tr>
			<td align="center" class="tt">성별</td>
			<td colspan="2">
			<input type="radio" name=gender value="1" checked="checked"/>남자
			<input type="radio" name=gender value="2"/>여자
			
			<div id="ggTag"></div>
			</td>
			
		</tr>

		<tr>
			<td align="center" class="tt">주소</td>
			<td id="address" colspan="2">
			<select name="country" id="country">
					<option value="한국">한국</option>
					<option value="일본">일본</option>
					<option value="태국">태국</option>
					<option value="중국">중국</option>
					<option value="필리핀">필리핀</option>
			</select> <select name="city" id="city">
					<option value="서울">서울</option>
					<option value="인천">인천</option>

			</select> <input type="text" name="addDetail" id="addDetail" value="상세주소" onkeyup="chkPat()"/>
			
			</td>

		</tr>

		<tr>
			<td align="center" class="tt">Email</td>
			<td colspan="2">
			<input type="text" name="email" id="email1" onkeyup="chkPat()" class="ee"/> @
			<input type="text" name="email" id="email2" onkeyup="chkPat()" class="ee"/>
			<div id="emTag"></div>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center" class="tt"><input type="button" value="가입" id="subBtn"/>
				<input type="reset" value="초기화" /></td>
		</tr>
	</table>
</form>

</div></div>