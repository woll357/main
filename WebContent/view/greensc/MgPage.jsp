<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="../js/jquery-3.3.1.min.js"></script>

<script>

$(document).ready(function(){
	
	 
	   $('.btn').on({
	      'click':function(){
	    	  dataGet("../greenAjax/Find?id="+$('#id').val());
	      }
	   });
	   
	   
	function dataGet(url){
		$.ajax(url,
                {
                   success:function(dd){	                       
                	   $("#contents").html(dd);
                      
                   },
                   error:function(){
                      alert("실패다 실패");
                   },
                }
             );
	}
	
	
})

</script>

<table>
    		<tr>
    			<td colspan="3"> 회원 검색 </td>
    		</tr>
    		<tr>
    			<td>
    				<table>
    					<tr>
    					<td>아이디 검색</td>
    						<td><input type="text" id="id"/></td>
    						<td><input type="button" value="검색" class="btn"/></td>
    					</tr>
    				</table>
    			</td>
    		</tr>
    		
    		<tr>
    			<td colspan="3"> 회원 검색 결과</td>
    		</tr>
    		<tr>
    			<td colspan="3" id="contents">
    				
    			
    			
    			</td>
    		</tr>
    	</table>