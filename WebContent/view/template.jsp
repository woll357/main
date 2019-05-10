<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
#top{
   position:relative;
   height:60px;
}
#logo{
   position:relative;
   height:150px;
}
#subMenu{
   position:relative;
   height:50px;
   top:60px;
}
#mainUrl{
   position:relative;
   min-height:600px;
   top:60px;
}
#bottom{
   position:relative;
   top:60px;
}
</style>
</head>
<body>
<div style="width: 1000px; margin-left: -500px; position: absolute; left: 50%">
   <div id="top" ><jsp:include page="inc/top.jsp" /></div> 
   <div id="logo"><jsp:include page="inc/logo.jsp" /></div>
   <div id="subMenu" ><jsp:include page="inc/subMenu.jsp" /></div>
   <div id="mainUrl"><jsp:include page="${mainUrl }" /></div>
   <div id="bottom"><jsp:include page="inc/bottom.jsp" /></div>
</div>
</body>
</html>