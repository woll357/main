<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src = "../js/nh/findId.js"></script>

<style>
#back{
	position: absolute;
	width: 800px;
	height: 450px;
	background-color: #dcefef;
	left: 100px;
	top: 450px;
}
#in{
	position: absolute;
	width: 780px;
	height: 430px;
	background-color: white;
	left: 10px;
	top: 10px;
}
.tt{
	height: 75px;
	font-size: 40px;
	padding-left: 30px;
	vertical-align: bottom;
}
.inin{
	height: 40px;
	font-size: 25px;
	padding-left: 30px;

}
</style>






<div id="back"><div id="in">
<table style="width: 100%">
	<tr>
		<td class="tt">PW 찾기</td>
			
	</tr>
	<tr>
		<td>
		<hr color="#dcefef" size="1px" style="width: 220px;" align="left">
		<form action="FindMySignReg" method="post" name="frm1">
			<table>
				<tr>
					<td class="inin">ID</td>
					<td><input type="text" name="id" id="id"/></td>
				</tr>
				<tr>
					<td class="inin">연락처</td>
					<td><input type="text" name="phone" id="phone1" maxlength="3"/> -
					<input type="text" name="phone" id="phone2" maxlength="4"/> -
					<input type="text" name="phone" id="phone3" maxlength="4"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="inin">
					<input type="button" value="PW찾기" id="btn1"/>
					</td>
				</tr>
			</table>
		</form>
		
		
		<hr color="#dcefef" size="1px">
		
		</td>
		</tr>
		<tr>
		
		<td class="tt">ID 찾기</td>		
	</tr>
	<tr>
		<td>
		<hr color="#dcefef" size="1px" style="width: 220px;" align="left">
		<form action="FindMySignReg" method="post" name="frm2">
			<table>
				<tr>
					<td  class="inin">연락처</td>
					<td><input type="text" name="phone" id="phone11" maxlength="3"/> -
					<input type="text" name="phone" id="phone22" maxlength="4"/> -
					<input type="text" name="phone" id="phone33" maxlength="4"/></td>
				</tr>
				<tr>
					<td colspan="2" class="inin">
					<input type="button" value="ID찾기" id="btn2"/>
					</td>
				</tr>
			</table>
		</form>
		
		</td>
	</tr>

</table>
</div></div>