<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h2 align="left">삭제신청</h2>
<form  action="HdeletereqReg" method="post">
		<input type="hidden" name="Code" value="${mem.hcode }"  />
		<input type="hidden" name="id" value="${mem.id }"  />
		<input type="hidden" name="kind" value="호텔" />
		<table width="100%" border=""  style="text-align: center; border: 10px #dcefef solid;" cellspacing="0">
				<tr>
					<td>사유</td>
					<td><textarea cols="145" rows="20" name="request" ></textarea></td>
				</tr>	
				
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="작성" />
					<input type="reset" value="초기화" />
				</td>
			</tr>
		</table>

</form>
