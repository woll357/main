<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:choose>

	<c:when test="${param.grade=='M' }">

		<form action="UpupReg" method="post">
			<input type="hidden" name="grade" value="M" />
			<table>
				<tr>
					<td>아이디</td>
					<td>${mem.id }</td>
				</tr>
				<tr>
					<td>사번</td>
					<td><input type="text" name="bnum"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="제출"> <input
						type="reset" value="초기화"></td>
				</tr>
			</table>
		</form>


	</c:when>
	<c:when test="${param.grade=='A' }">


		<form action="UpupReg" method="post">
			<input type="hidden" name="grade" value="A" />
			<table>
				<tr>
					<td>아이디</td>
					<td>${mem.id }</td>
				</tr>
				<tr>
					<td id="bnum">사업자등록번호</td>
					<td><input type="text" name="crn" /></td>
				</tr>
				<tr>
					<td>파일</td>
					<td><input type="file" name="img" /></td>
				</tr>
				<tr>
					<td>회사명</td>
					<td><input type="text" name="air_name" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="제출"> <input
						type="reset" value="초기화"></td>
				</tr>
			</table>
		</form>

	</c:when>
	<c:otherwise>

		<form action="UpupReg" method="post">
			<input type="hidden" name="grade" value="H" />

			<table border="">


				<tr>
					<td>아이디</td>
					<td>${mem.id }</td>
				</tr>

				<tr>
					<td>사업자등록번호</td>
					<td><input type="text" name="crn" /></td>
				</tr>
				<tr>
					<td>호텔이미지</td>
					<td><input type="file" name="himg" /></td>
				</tr>
				<tr>
					<td>호텔명</td>
					<td><input type="text" name="hname" /></td>
				</tr>
				<tr>
					<td>호텔정보</td>
					<td><textarea name="hinfo" rows="5" cols="30">남기실 말</textarea></td>
				</tr>
				<tr>

					<td colspan="2" align="right"><input type="submit" value="작성" />
						<input type="reset" value="초기화" /></td>
				</tr>
			</table>











		</form>

	</c:otherwise>

</c:choose>
