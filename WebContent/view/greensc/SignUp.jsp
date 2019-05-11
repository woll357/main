<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src = "../js/nh/countryCombo.js"></script>
<script src = "../js/nh/signUpChk.js"></script>
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">

<h2>회원가입</h2>
<form action="SignUpReg" method="post" name="frm">
	<table class="ttcss" border="" cellpadding="5px">
	
		<tr>
			<td align="center" width="100" class="wbbr" >ID</td>
			<td width="400px;" colspan="2">
			<input name="id" type="text" id="id" maxlength="8"  onkeyup="butPat()"/>
			<input type="button" value="중복확인" class="btn" id="idBtn" disabled="disabled" style="background-color: #dcefef; color: #779191;"/>
			<div id="idTag">4~16자, 영문과 숫자로 입력하세요.</div>
			
			</td>
		</tr>
		<tr>
			<td align="center" class="wbbr">PW</td>
			<td colspan="2"><input name="pw" type="password" maxlength="16" id="pw" onkeyup="chkPat()" />
			<div id="pwTag">8 ~ 16자, 영문, 숫자, 한글 입력 가능합니다.</div>		
			</td>
		</tr>
		<tr>
			<td align="center" class="wbbr">PW 확인</td>
			<td colspan="2"><input name="pw2" type="password" maxlength="16" id="pw2" onkeyup="chkPat()" />
			<div id="pw2Tag">pw와 동일하게 입력하세요</div>
			</td>
			
		</tr>
		<tr>
			<td align="center" class="wbbr">이름</td>
			<td colspan="2"><input name="pname" type="text" id="pname" onkeyup="chkPat()" />
			<div id="nameTag">한글이름만 가능합니다.</div>
			</td>
		</tr>
		<tr>
			<td align="center" class="wbbr">연락처</td>
			<td width="600px" style="border-right: 1px white solid">
			<input name="phone" type="text" id="phone1"  maxlength="3" onkeyup="butPat()"/> -
			<input name="phone" type="text" id="phone2"  maxlength="4" onkeyup="butPat()"/> -
			<input name="phone" type="text" id="phone3" maxlength="4" onkeyup="butPat()"/>
			<div id="ppTag"></div>
			</td><td>
			<input type="button" value="중복확인" class="btn" id="phoneBtn" disabled="disabled" style="background-color: #dcefef; color: #779191;"/>
			</td>
		</tr>
		<tr>
			<td align="center" class="wbbr">생년월일</td>
			<td colspan="2"><input name="birth" type="text" maxlength="8" id="birth" onkeyup="chkPat()" />
			<div id="bbTag">예) 19000101</div>
			</td>
			
		</tr>
		<tr>
			<td align="center" class="wbbr">성별</td>
			<td colspan="2">
			<input type="radio" name=gender value="1" checked="checked"/>남자
			<input type="radio" name=gender value="2"/>여자
			
			<div id="ggTag"></div>
			</td>
			
		</tr>

		<tr>
			<td align="center" class="wbbr">주소</td>
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
			<td align="center" class="wbbr">Email</td>
			<td colspan="2">
			<input type="text" name="email" id="email1" onkeyup="chkPat()"/> @
			<input type="text" name="email" id="email2" onkeyup="chkPat()"/>
			<div id="emTag"></div>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center" ><input type="button" value="가입" id="subBtn" style="background-color: #dcefef; color: #779191;"/>
				<input type="reset" value="초기화" style="background-color: #dcefef; color: #779191;"/></td>
		</tr>
	</table>
</form>
