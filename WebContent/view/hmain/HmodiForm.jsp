<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <script>    	
    	function fileDelete() {
    		hotmod.action = "FileDelete";
    		hotmod.submit();
    	}
    
    </script>

    <form name = "hotmod" action="HmodiReg" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${dto.id }" />
    
    <table border="" width="100%">
    	<tr>
			<td>호텔명</td>
			<td><input type="text" name="hname" value="${dto.hname }"/></td>
		</tr>
		<tr>
			<td>호텔정보</td>
			<td><input type="text" name="hinfo" value="${dto.hinfo }"/></td>
		</tr>    
    	<tr>
			<td>파일</td>
			<td>
			<c:choose>
				<c:when test="${dto.himg!=null }">
					${dto.himg }<input type="button" value="파일삭제" onclick="fileDelete()"/>	
					<input type="hidden" name="himg" value="${dto.himg }"  />
				</c:when>
				<c:otherwise>
					<input type="file" name="himg" />	
				</c:otherwise>
			
			</c:choose>		
			</td>
		</tr>
    	<tr>
    		<td>나라</td>
    		<td><input type="text" name="country" value="${dto.country }"/></td>
    	</tr>
    	<tr>
    		<td>호텔</td>
    		<td><input type="text" name="city" value="${dto.city }"/></td>
    	</tr>
    		<tr>

			<td colspan="2" align="right">
			<input type="submit" value="수정" />
    	</td>
    	</tr>
    </table>
    
    
    </form>