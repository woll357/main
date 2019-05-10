<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2 align="left">방수정</h2>
    <script src="../js/yjm/hmain_rmodi.js"></script>

 <form name = "roommod" action="HroommodiReg" method="post" enctype="multipart/form-data">
     <input type="hidden" name="rcode" value="${dto.rcode }" />
 	<table   width="100%" border=""  style="text-align: center; border: 10px #dcefef solid;" cellspacing="0">
 		<tr>
			<td style="border-bottom: 10px #dcefef solid;">방종류</td>
			<td><select name="rkind">
				<option value="${dto.rkind }">${dto.rkind }</option>
				<option value="S">스탠다드</option>
				<option value="D">디럭스룸</option>
			</select></td>
		</tr>
		<tr>
			<td style="border-bottom: 10px #dcefef solid;">방갯수</td>
			<td>
<%-- 			<select name="rcnt">
				<option value="${dto.rcnt }">${dto.rcnt }</option>
				<option value=1>1</option>
				<option value=2>2</option>
				<option value=3>3</option>
				<option value=4>4</option>
				<option value=5>5</option>
			</select> --%>
				<input type="number" name="rcnt" maxlength="2" oninput="maxLengthCheck(this)" value="${dto.rcnt }" id="rcnt">
			</td>
		</tr>
		<tr>
			<td style="border-bottom: 10px #dcefef solid;">방인원</td>
			<td><select name="pcnt">
				<option value="${dto.pcnt }">${dto.pcnt }</option>
				<option value=2>2</option>
				<option value=4>4</option>
			</select></td>		
		</tr>
		<tr>
			<td style="border-bottom: 10px #dcefef solid;">방이미지</td>
			<td>
			<c:choose>
				<c:when test="${dto.rimg!=null }">
					${dto.rimg }<input type="button" value="파일삭제" onclick="fileDelete()"/>	
					<input type="hidden" name="rimg" value="${dto.rimg }"  id="rimg" />
				</c:when>
				<c:otherwise>
					<input type="file" name="rimg" id="rimg" />	
				</c:otherwise>			
			</c:choose>		
			</td>
		</tr>
		<tr>
			<td style="border-bottom: 10px #dcefef solid;">금액</td>
			<td><input type="number" name="money" value="${dto.money }"  id="money"/></td>
		</tr>
				<tr>
			<td style="border-bottom: 10px #dcefef solid;">주말금액</td>
			<td><input type="number" name="wmoney" value="${dto.wmoney }" id="wmoney"/></td>
		</tr>		
		<tr>
			<td style="border-bottom: 10px #dcefef solid;">wifi여부</td>
			<td><select name="wifi">
				<option value="${dto.wifi }">${dto.wifi }</option>
				<option value=false>false</option>
				<option value=true>true</option>
			</select></td>
		</tr>
		<tr>
			<td style="border-bottom: 10px #dcefef solid;">조식여부</td>
			<td><select name="morning">
				<option value="${dto.morning }">${dto.morning }</option>
				<option value=false>false</option>
				<option value=true>true</option>
			</select></td>
		</tr>
		   <tr>
			<td colspan="2" align="right">
			<input type="button" value="수정" class="modimodi"/>
    	</td>
    	</tr>
 	
 	</table>
 
 </form>
