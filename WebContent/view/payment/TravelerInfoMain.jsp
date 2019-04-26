<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<h1>여행객 정보 입력 페이지</h1>
<form action="../payment/TravelerInfoReg" method="post">

<input type="hidden" name="id" value="1111"/>
<c:forEach var="l" items="${basketIDs }" >

<input type="hidden" name="basketIDs" value="${l }"  />

</c:forEach>

	<c:forEach var="i" items="${airBaskets }" >
	
		<input type="hidden" name="airBaskets" value="${i.basketID }" />
			
				<table border="">
					<tr>
					<td>성명(한글)</td>
					<td>여권번호</td>
					<td>성(영어)</td>
					<td>이름(영어)</td>
					<td>생년월일 ex)900202</td>
					<td>연락처</td>
					<td>이메일</td>
					</tr>
					
					<c:forEach varStatus="" var="j" begin="1" end="${i.psn }" step="1" >
							<tr>
					<td><input name="cKorName" type="text" /></td>
					<td><input name="passport" type="text" /></td>
					<td><input name="cEngLastName" type="text" /></td>
					<td><input name="cEngFirstName" type="text" /></td>
					<td><input name="birthDate" type="text" maxlength="6" /></td>
					<td><select name="cph1">
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
					</select>-<input name="cph2" style="width:30px" type="text" maxlength="4" />-<input name="cph3" style="width:30px" type="text" maxlength="4" /></td>
					<td><input name="cemail1" style="width:100px" type="text" />@
					<select name="cemail2">
					<option>직접입력</option>
					<option value="hanmail.net" >hanmail.net</option>
					<option value="empal.com">empal.com</option>
					<option value="freechal.com">freechal.com</option>
					<option value="gmail.com">gmail.com</option>
					<option value="hotmail.com">hotmail.com</option>
					<option value="nate.com">nate.com</option>
					<option value="naver.com">naver.com</option>
					</select>
					<input style="width:100px" type="text" /></td>		
					</tr>
				</c:forEach>
		</c:forEach>	
		<tr>
		<td>
		<input type="submit" value="제출" />
		</td>
		</tr>
	</table>
</form>