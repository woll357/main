<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src = "../js/nh/blackListChk.js"></script>


<table border="">
	<tr>
		<td id="searchId">블랙리스트 검색</td>
		<td id="searchNum">블랙리스트 회원 총 수 : ${memNum }</td>
	</tr>
	<tr>
		<td colspan="2">
			<table style="width: 100%">
				<tr>
					<td>아이디 검색</td>
					<td><input type="text" id="id" maxlength="8"
						onkeyup="chkPat1()" /></td>
					<td><input type="button" value="검색" id="btn1" /></td>
				</tr>
				<tr>
					<td>이름 검색</td>
					<td><input type="text" id="name" onkeyup="chkPat2()" /></td>
					<td><input type="button" value="검색" id="btn2" /></td>
				</tr>
				<tr>
					<td>핸드폰 뒷자리 검색</td>
					<td><input type="text" id="phone" maxlength="4"
						onkeyup="chkPat3()" /></td>
					<td><input type="button" value="검색" id="btn3" /></td>
				</tr>
				<tr>
					<td>블랙리스트 사유검색</td>
					<td><select name="preason" id="preason">
							<option value="강성고객">강성고객</option>
							<option value="경범죄">경범죄</option>
							<option value="중범죄">중범죄</option>
					</select></td>
					<td><input type="button" value="검색" id="btn4" /></td>
				</tr>
			</table>
		</td>
	</tr>

	<tr>
		<td colspan="2">회원 검색 결과</td>

	</tr>
	<tr>
		<td colspan="3">
			<table>
				<tr>
					<td>번호</td>
					<td>아이디</td>
					<td>이름</td>
					<td>핸드폰 번호</td>
					<td>블랙리스트 여부</td>
					<td>블랙리스트 사유</td>
					<td>상세보기</td>
				</tr>
			</table>

		</td>
	</tr>
	<tr>
		<td colspan="3" id="contents"></td>
	</tr>
</table>