<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <script>    	
    	function fileDelete() {
    		hotmod.action = "FileDelete";
    		hotmod.submit();
    	}
    	
     	$(document).ready(function(){
    		$('.hotmodimodi').on({
    			'click':function() {
    				var img = $('#himg').val();
    				
    				if($('#himg').val()=='' || $('#hinfo').val()=='' || $('#hname').val()=='') {
    					alert("기입이완료되지않았습니다.");
    					hotmod.button();
    				}
             		if(img!=null) {
                		var ssimg = img.substring(img.lastIndexOf(".")+1);
                		console.log(ssimg);
                 		if(ssimg=='txt' || ssimg=='doc' || ssimg=='hwp' || ssimg=='ppt' || ssimg=='xls' || ssimg=='pptx'
                 				|| ssimg=='xlsx' || ssimg=='docx' || ssimg=='mp3' || ssimg=='wma' || ssimg=='wav'){
                  			alert("값이 잘못되었습니다.");
             			}
                 		else{
                       		hotmod.submit();
                   		 }
               		 }
    				
    			}
    			
    		})
    		
    	}) 
    
    </script>

    <form name = "hotmod" action="HmodiReg" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${dto.id }" />
    <input type="hidden" name="country" value="${dto.country }" />
    <input type="hidden" name="city" value="${dto.city }" />
    
    <table border="" width="100%">
    	<tr>
			<td>호텔명</td>
			<td><input type="text" name="hname" value="${dto.hname }" id="hname"/></td>
		</tr>
		<tr>
			<td>호텔정보</td>
			<td><input type="text" name="hinfo" value="${dto.hinfo }" id="hinfo"/></td>
		</tr>    
    	<tr>
			<td>파일</td>
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
			<input type="submit" value="수정" class="hotmodimodi"/>
    	</td>
    	</tr>
    </table>
    
    
    </form>