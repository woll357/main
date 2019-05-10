<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src = "../js/nh/findId.js"></script>
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">

	<h2>PW 찾기</h2>

		
		<form action="FindMySignReg" method="post" name="frm1">
			<table style="border-collapse: collapse; border : 10px #dcefef solid; width: 100%"  border="" cellspacing="0" cellpadding="5px;">
				<tr>
					<td class="wbbr">ID</td>
					<td><input type="text" name="id" id="id"/></td>
				</tr>
				<tr>
					<td class="wbbr">연락처</td>
					<td><input type="text" name="phone" id="phone1" maxlength="3"/> -
					<input type="text" name="phone" id="phone2" maxlength="4"/> -
					<input type="text" name="phone" id="phone3" maxlength="4"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="inin">
					<input type="button" value="PW찾기" id="btn1" class="btncss2"/>
					</td>
				</tr>
			</table>
		</form>
		

		
		<h2>ID 찾기</h2>
		
		<form action="FindMySignReg" method="post" name="frm2">
			<table style="border-collapse: collapse; border : 10px #dcefef solid; width: 100%"  border="" cellspacing="0" cellpadding="5px;">
				<tr>
					<td  class="wbbr">연락처</td>
					<td><input type="text" name="phone" id="phone11" maxlength="3"/> -
					<input type="text" name="phone" id="phone22" maxlength="4"/> -
					<input type="text" name="phone" id="phone33" maxlength="4"/></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="button" value="ID찾기" id="btn2" class="btncss2"/>
					</td>
				</tr>
			</table>
		</form>
		



