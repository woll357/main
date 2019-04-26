<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="NoticeWriteReg" method="post">
	<table border="" width="100%">
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="content" cols="30" rows="5">남기실 말</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="작성" />
				<input type="reset" value="초기화" />
				<a href="NoticeList">목록으로</a>
			</td>
		</tr>
	</table>
</form>