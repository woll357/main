<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <div align="center">
    <h1>정말삭제하시겠습니까?</h1>
<form action="HroomDeleteReg" method="post" >
     <input type="hidden" name="rcode" value="${dto.rcode }" />
	<table>
		<tr>
			<td><input type="submit" value="삭제" style="background-color: #dcefef; font-size: 20px; color: #779191 ; border: 0;" /></td>
		</tr>
	</table>


</form>
</div>