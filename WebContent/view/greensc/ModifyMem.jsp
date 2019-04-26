<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <form action="ModifyMemReg" method="post">
    <input type="hidden" name="id" value="${mem.id }"/>
    	<table border="">
    		<tr>
    			<td colspan="2"><h2>마이페이지</h2></td>
    		</tr>
    		<tr>
    			<td>ID</td>
    			<td>${mem.id }</td>
    		</tr>
    		<tr>
    			<td>pw</td>
    			<td><input type="password" name="pw"/></td>
    		</tr>
    		<tr>
    			<td>email</td>
    			<td><input type="text" name="email" value="${dto.email }"/></td>
    		</tr>
    		<tr>
    			<td>연락처</td>
    			<td><input type="text" name="phone" value="${dto.phone }"/></td>
    		</tr>
    		<tr>
    			<td colspan="2">주소</td>
    		</tr>
    		<tr>
    			<td>나라</td>
    			<td><input type="text" name="country" value="${dto.country}"/></td>
    		</tr>
    		<tr>
    			<td>도시</td>
    			<td><input type="text" name="city" value="${dto.city}"/></td>
    		</tr>
    		<tr>
    			<td>상세주소</td>
    			<td><input type="text" name="addDetail" value="${dto.addDetail}"/></td>
    		</tr>
    		<tr>
    			<td colspan="2">
    			<input type="submit" value="수정하기"/>
    			<input type="reset" value="초기화"/>
    			<a href="Home">홈으로</a>
    			</td>
    		</tr>
    		
    		
    	</table>
    </form>