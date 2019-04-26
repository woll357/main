<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
 
<table border="" width="100%">
	<tr><td colspan="2">회원 문의</td>
	</tr><tr>
		<td>글번호</td><td>${dto.num }</td>
	</tr><tr>
		<td>제목</td><td>${dto.title }</td>
	</tr><tr>
		<td>작성자</td><td>${dto.id }</td>
	</tr><tr>
		<td>작성일</td><td>${dto.time }</td>
	</tr><tr>
		<td>내용</td><td>${dto.contentBr }</td>
	</tr>
</table>



<form action="ReplyQnaWriteReg" method="get">
	<input type="hidden" name="num" value="${dto.num }"/>
	<input type="hidden" name="qnum" value="${dto.num }"/>
	<table border="" width="100%">
	<tr><td colspan="2">답변 내용</td>
	</tr><tr>
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
				<a href="QnaList">목록으로</a>
			</td>
		</tr>
	</table>
 </form>   