<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src = "../js/nh/mgPageChk.js"></script>
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">


<h2>회원 관리</h2>
	<table style="border : 10px #dcefef solid; width: 100%;" cellspacing="0" cellpadding="0">

		<tr>
			<td id="searchNum" colspan="2" class="bb">회원 총 수 : ${memNum }</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<table style="width: 100%" cellspacing="0">
					<tr>
						<td class="wbbr" style="width: 300px;">아이디 검색</td>
						<td class="bb" style="width: 300px;">
						<input type="text" id="id" maxlength="8" onkeyup="chkPat1()"/></td>
						
						<td class="bb" style="width: 400px;">
						<input type="button" value="검색" id="btn1" class="btncss2"/></td>
						
						
					</tr>
					<tr>
						<td class="wbbr">이름 검색</td>
						<td class="bb"><input type="text" id="name"
							onkeyup="chkPat2()" /></td>
						
						
						<td class="bb">
						<input type="button" value="검색" id="btn2" class="btncss2"/></td>
						
						
						
					</tr>
					<tr>
						<td class="wbbr">핸드폰 뒷자리 검색</td>
						<td class="bb"><input type="text" id="phone" maxlength="4"
							onkeyup="chkPat3()" /></td>
							
							
						<td class="bb">
						<input type="button" value="검색" id="btn3" class="btncss2"/></td>
						
						
					</tr>
					
					
				</table>
			</td>
		</tr>

		<tr>
			<td colspan="2" class="bb">회원 검색 결과</td>

		</tr>
		
		<tr>
			<td colspan="3">
				<table style="border-collapse: collapse; width: 100%" cellspacing="0">
					<tr>
						<td style="width: 50px;" class="wbbr">번호</td>
						<td style="width: 200px;" class="wbbr">아이디</td>
						<td style="width: 150px;" class="wbbr">이름</td>
						<td style="width: 200px;" class="wbbr">연락처</td>
						<td style="width: 100px;" class="wbbr">블랙리스트</td>
						<td style="width: 100px;" class="wbbr">사유</td>
						<td style="width: 100px;" class="wbb">상세보기</td>
					</tr>
				</table>

			</td>
		</tr>
		<tr>
			<td colspan="3" id="contents"></td>
		</tr>
	</table>
