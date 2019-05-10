<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/nh/blackListChk.js"></script>
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">

<h2>블랙리스트 관리</h2>


	<table class="ttcss"cellpadding="0">

		<tr>
			<td id="searchNum" colspan="3" class="bb">블랙리스트 회원 총 수 : ${memNum }</td>
		</tr>
		
		
					<tr>
						<td class="wbbr" style="width: 300px;">아이디 검색</td>
						<td class="bb" style="width: 300px;">
						<input type="text" id="id" maxlength="8" onkeyup="chkPat1()"/></td>
						
						<td class="bbr" style="width: 400px;">
						<input type="button" value="검색" id="btn4" class="btncss2" onclick="bbtn4()"/></td>
						
						
					</tr>
					<tr>
						<td class="wbbr">이름 검색</td>
						<td class="bb"><input type="text" id="name"
							onkeyup="chkPat2()" /></td>
						
						
						<td class="bbr">
						<input type="button" value="검색" id="btn5" class="btncss2" onclick="bbtn5()"/></td>
						
						
						
					</tr>
					<tr>
						<td class="wbbr">핸드폰 뒷자리 검색</td>
						<td class="bb"><input type="text" id="phone" maxlength="4"
							onkeyup="chkPat3()" /></td>
							
							
						<td class="bbr">
						<input type="button" value="검색" id="btn6" class="btncss2" onclick="bbtn6()"/></td>
						
						
					</tr>
					<tr>
						<td class="wbbr">블랙리스트 사유검색</td>
						<td class="bb"><select name="preason" id="preason">
								<option value="강성고객">강성고객</option>
								<option value="경범죄">경범죄</option>
								<option value="중범죄">중범죄</option>
						</select></td>
						
						
						<td class="bbr"><input type="button" value="검색" id="btn7" class="btncss2"  onclick="bbtn7()"/></td>
						
						
					</tr>
					
				

		<tr>
			<td colspan="3" class="bb">회원 검색 결과</td>

		</tr>
		
		<tr>
			<td colspan="3">
				<table style="border-collapse: collapse; width: 100%">
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
