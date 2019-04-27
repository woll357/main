<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="DeleteMySignReg" method="post">
	<table>
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${mem.id }</td>
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
			<input type="submit" value="회원 탈퇴"/>
			</td>
		</tr>
	</table>
</form>