<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
#top{
   position:relative;
   height:50px;
}
#logo{
   position:relative;
}
#subMenu{
   position:relative;
   top:50px;
}
#mainUrl{
   position:relative;
   top:50px;
}
#bottom{
   position:relative;
   top:50px;
}
</style>
</head>
<body>
<div style="width: 1000px; margin-left: -500px; position: absolute; left: 50%">
   <div id="top" style="height:50px" ><jsp:include page="inc/top.jsp" /></div> 
   <div id="logo" style="height:150px"><jsp:include page="inc/logo.jsp" /></div>
   <div id="subMenu" style="height:50px" ><jsp:include page="inc/subMenu.jsp" /></div>
   <div id="mainUrl" style="height:800px"><jsp:include page="${mainUrl }" /></div>
   <div id="bottom" style="height:50px"><jsp:include page="inc/bottom.jsp" /></div>
</div>
</body>
</html>