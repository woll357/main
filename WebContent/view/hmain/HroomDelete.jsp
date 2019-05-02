<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form action="HroomDeleteReg" method="post" >
     <input type="hidden" name="rcode" value="${dto.rcode }" />

	<table>
		<tr>
			<td>정말 삭제하시겠습니까?</td>
		</tr>

		<tr><td><input type="submit" value="삭제" /></td></tr>
	</table>


</form>
			
			