<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<table border="">
	<tr>
		<td>ID 찾기</td>
		<td>PW 찾기</td>
	</tr>
	<tr>
		<td>
		<form action="FindMySignReg" method="post">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="id"/></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="text" name="phone"/></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="ID찾기"/>
					</td>
				</tr>
			</table>
		</form>
		
		
		
		</td>
		<td>
		
		<form action="FindMySignReg" method="post">
			<table>
				<tr>
					<td>연락처</td>
					<td><input type="text" name="phone"/></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="PW찾기"/>
					</td>
				</tr>
			</table>
		</form>
		
		</td>
	</tr>

</table>