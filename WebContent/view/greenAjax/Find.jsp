<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/nh/mgpage.css" type="text/css">




<table style="width: 100%">

	<tr>
		<td colspan="7" class="ttt"><c:choose>
				<c:when test="${msg=='No' }">
	자료가 없습니다.
	</c:when>



				<c:otherwise>


					<c:forEach var="dto" items="${data}" varStatus="no">

						<form action="FindDetail" method="post">
							<input type="hidden" value="${dto.id }" name="id" />
							<table style="width: 100%">
								<tr>
									<td class="ttt">${no.index }</td>
									<td class="ttt">${dto.id }</td>
									<td class="ttt">${dto.pname }</td>
									<td class="ttt"><font size="3px;">${dto.phone1 }-****-${dto.phone3 }</font></td>
									<td class="ttt">${dto.black }</td>
									<td class="ttt">${dto.preason }</td>

									<td class="ttt"><input type="submit" value="검색" /></td>
								</tr>
								<tr>
									<td colspan="7"><hr color="#dcefef" size="1px"></td>
								</tr>
							</table>
						</form>

					</c:forEach>
				</c:otherwise>
			</c:choose></td>
	</tr>

</table>


<!-- 
<script>

$(document).ready(function(){
	
	$('#blackBtn').on({
		'click':function(){
			
			
			if($('#black').val()!=null && $('#black').val()!=""){
				$('#black').val("");
			}else{
				$('#black').val("블랙리스트");
			}
		}
	})
	
	
});

</script>

<c:choose>
<c:when test="${msg=='No1' }">
<script>
alert("아이디가 없습니다.");
location.href="${goUrl}";

</script>
</c:when>
<c:when test="${msg=='No2' }">
<script>
alert("본인 계정은 마이페이지를 이용해 주세요.");
location.href="${goUrl}";

</script>
</c:when>
<c:otherwise></c:otherwise>
</c:choose>
<form action="ModifyMemReg" method="post">
	<input type="hidden" name="id" value="${param.id }" />
	<table border="">
		<tr>
			<td colspan="2"><h2>마이페이지</h2></td>
		</tr>
		<tr>
			<td>ID</td>
			<td>${param.id }</td>
		</tr>
		<tr>
			<td>pw</td>
			<td><input type="password" name="pw" value="${dto.pw }" /></td>
		</tr>
		<tr>
			<td>email</td>
			<td><input type="text" name="email" value="${dto.email }" /></td>
		</tr>
		<tr>
			<td>연락처</td>
			<td><input type="text" name="phone" value="${dto.phone }" /></td>
		</tr>
		<tr>
			<td colspan="2">주소</td>
		</tr>
		<tr>
			<td>나라</td>
			<td><input type="text" name="country" value="${dto.country}" /></td>
		</tr>
		<tr>
			<td>도시</td>
			<td><input type="text" name="city" value="${dto.city}" /></td>
		</tr>
		<tr>
			<td>상세주소</td>
			<td><input type="text" name="addDetail" value="${dto.addDetail}" /></td>
		</tr>
		<tr>
			<td>블랙리스트</td>
			<td><input id="black" readonly="readonly" type="text"
				name="black" value="${dto.black }" /></td>
		</tr>
		<tr>
			<td>블랙리스트 사유</td>
			<td><input type="text" name="preason" value="${dto.preason}" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="수정하기" /> <input
				type="button" value="블랙리스트 추가하기" id="blackBtn" /> <input
				type="reset" value="초기화" /></td>
		</tr>


	</table>
</form>
 -->
