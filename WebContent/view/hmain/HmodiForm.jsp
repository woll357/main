<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <script src="../js/yjm/hmain_modi.js"></script>

    <form name = "hotmod" action="HmodiReg" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${dto.id }" />
    <input type="hidden" name="country" value="${dto.country }" />
    <input type="hidden" name="city" value="${dto.city }" />
    

    <h2 align="left">호텔수정</h2> 
    <table  width="100%" border=""  style="text-align: center; border: 10px #dcefef solid;" cellspacing="0">
    	<tr>
			<td style="border-bottom: 10px #dcefef solid;">호텔명</td>
			<td><input type="text" name="hname" value="${dto.hname }" id="hname"/></td>
		</tr>
		<tr>
			<td style="border-bottom: 10px #dcefef solid;">호텔정보</td>
			<td><input type="text" name="hinfo" value="${dto.hinfo }" id="hinfo"/></td>
		</tr>   
    	<tr>
			<td style="border-bottom: 10px #dcefef solid;">파일</td>
			<td>
			<c:choose>
				<c:when test="${dto.himg!=null }">
					${dto.himg }<input type="button" value="파일삭제" onclick="fileDelete()"/>	
					<input type="hidden" name="himg" value="${dto.himg }" id="himg" />
				</c:when>
				<c:otherwise>
					<input type="file" name="himg" id="himg"/>	
				</c:otherwise>
			
			</c:choose>		
			</td>
		</tr>
    		<tr>

			<td colspan="2" align="right">
			<input type="button" value="수정" class="hotmodimodi"/>
    	</td>
    	</tr>
    </table>
    
    
    </form>
