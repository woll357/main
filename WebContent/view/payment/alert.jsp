<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

if(request.getParameter("id")!=null && request.getParameter("id")!=""){

session.setAttribute("id", request.getAttribute("id"));
session.setAttribute("grade", request.getAttribute("grade"));

}
%>
<script>
if("${msg}"!=""){
alert("${msg}");
}
location.href="${goUrl}";

</script>