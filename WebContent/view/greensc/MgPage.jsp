<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src = "../js/nh/mgPageChk.js"></script>
<link rel="stylesheet" href="../css/nh/mgpage.css" type="text/css">


<div id="back">
<table style="width: 100%">
    		<tr>
    			<td id="searchId" class="tt"> 회원 검색 </td>
    			<td id="searchNum" class="tt"> 회원 총 수 : ${memNum }</td>
    		</tr>
    		<tr>
		<td colspan="2"><hr color="#dcefef" size="1px"></td>
	</tr>
    		<tr>
    			<td colspan="2">
    				<table style="width: 100%">
    					<tr>
    					<td class="tt">아이디 검색</td>
    						<td class="tt"><input type="text" id="id" maxlength="8" onkeyup="chkPat1()"/></td>
    						<td class="tt"><input type="button" value="검색" id="btn1"/></td>
    					</tr>
    					<tr>
    					<td class="tt">이름 검색</td>
    						<td class="tt"><input type="text" id="name" onkeyup="chkPat2()"/></td>
    						<td class="tt"><input type="button" value="검색" id="btn2"/></td>
    					</tr>
    					<tr>
    					<td class="tt">핸드폰 뒷자리 검색</td>
    						<td class="tt"><input type="text" id="phone" maxlength="4" onkeyup="chkPat3()"/></td>
    						<td class="tt"><input type="button" value="검색" id="btn3"/></td>
    					</tr>
    				</table>
    			</td>
    		</tr>
    		<tr>
		<td colspan="2"><hr color="#dcefef" size="1px"></td>
	</tr>
    		<tr>
    			<td colspan="2" class="tt"> 회원 검색 결과</td>
    		
    		</tr>
    		<tr>
		<td colspan="2"><hr color="#dcefef" size="1px"></td>
	</tr>
    		<tr>
    			<td colspan="3">
    			<table style="width: 100%">
    				<tr>
		<td class="ttt">번호</td>
		<td class="ttt">아이디</td>
		<td class="ttt">이름</td>
		<td class="ttt">연락처</td>
		<td class="ttt">블랙리스트</td>
		<td class="ttt">사유</td>
		<td class="ttt">상세보기</td>
	</tr>
    		</table>	
    			
    			</td>
    		</tr>
    		<tr>
    			<td colspan="3" id="contents">
    	
    			</td>
    		</tr>
    	</table>
    	</div>