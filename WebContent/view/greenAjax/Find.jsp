<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="../js/jquery-3.3.1.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="../js/nh/blackListChk.js"></script>
<link rel="stylesheet" href="../css/nh/tot.css" type="text/css">


<table style="width: 100%">

	<tr>
		<td colspan="7"><c:choose>
				<c:when test="${msg=='No' }">
	자료가 없습니다.
	</c:when>



				<c:otherwise>


					<c:forEach var="dto" items="${data}" varStatus="no">

						<form action="FindDetail" method="post">
							<input type="hidden" value="${dto.id }" name="id" />
							<table style="width: 100%" cellspacing="0">
								<tr>
									<td style="width: 49px;" class="bbr">${no.index+1 }</td>
									<td style="width: 201px;" class="bbr">${dto.id }</td>
									<td style="width: 151px;" class="bbr">${dto.pname }</td>
									<td style="width: 201px;" class="bbr">${dto.phone1 }-****-${dto.phone3 }</td>
									<td style="width: 101px;" class="bbr">
									<c:choose>
									<c:when test="${dto.black=='블랙리스트' }">Y</c:when>
									<c:otherwise>N</c:otherwise>
									</c:choose>
									</td>
									<td style="width: 100px;" class="bbr">${dto.preason }</td>
									<td style="width: 98px;" class="bb"><input type="submit" value="검색" /></td>
								</tr>
								
							</table>
						</form>

					</c:forEach>
					
					
					<c:choose>
					<c:when test="${start!=null}">
					<tr>
						<td colspan="5" align="center">
						
						<c:if test="${startPage>1 }">
							<input type="button" id="pageBtn" data-page="${startPage-1 }" value="이전"/>
						</c:if>
							<c:forEach begin="${startPage }" end="${endPage }" var="i">
								<c:choose>
									<c:when test="${i==nowPage }">
									[${i }]
									</c:when>	
									<c:otherwise>
										
										<input type="button" id="pageBtn" data-page="${i }" value="${i }"/>
										
									</c:otherwise>
								</c:choose>
								
							</c:forEach>
							<c:if test="${endPage<totalPage }">
							<input type="button" id="pageBtn" data-page="${endPage+1 }" value="다음"/>
							
							</c:if>
							
						</td>
					</tr></c:when>
					<c:otherwise></c:otherwise>
					</c:choose>
					
					
					
					
				</c:otherwise>
			</c:choose></td>
	</tr>

</table>



