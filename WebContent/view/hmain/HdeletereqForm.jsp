<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="HdeletereqReg" method="post">
		<input type="hidden" name="Code" value="${mem.hcode }"  />
		<input type="hidden" name="id" value="${mem.id }"  />
		<input type="hidden" name="kind" value="호텔" />
		<table border="">
				<tr>
					<td>사유</td>
					<td><input type="text" name="request" /></td>
				</tr>	
				
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="작성" />
					<input type="reset" value="초기화" />
				</td>
			</tr>
		</table>

</form>