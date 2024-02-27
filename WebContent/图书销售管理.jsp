<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" >
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" ></script>
<meta charset="UTF-8">
<title>图书销售管理</title>
<script type="text/javascript">
var iframeid=document.getElementById("buttomFrame"); //iframe id
 function SetCwinHeight(){
  var iframeid=document.getElementById("buttomFrame"); //iframe id
  if (document.getElementById){
   if (iframeid && !window.opera){
    if (iframeid.contentDocument && iframeid.contentDocument.body.offsetHeight){
     iframeid.height = iframeid.contentDocument.body.offsetHeight;
    }else if(iframeid.Document && iframeid.Document.body.scrollHeight){
     iframeid.height = iframeid.Document.body.scrollHeight;
    }
   }
  }
 }
</script>

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">图书销售</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="inBook2.jsp" target="buttomFrame">进货 <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="退货.jsp" target="buttomFrame">退货</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="销售.jsp" target="buttomFrame">销售</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          统计
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item"  href="SumPrice" target="buttomFrame">月销售情况</a>
          <a class="dropdown-item" href="cnt" target="buttomFrame">月销售排行榜</a>
          <div class="dropdown-divider"></div>
			<a class="dropdown-item" href="jhServlet" target="buttomFrame">查看进货表</a>
          <a class="dropdown-item" href="kucunServlet" target="buttomFrame">查看库存</a>
          <a class="dropdown-item" href="thServlet" target="buttomFrame">查看退货表</a>
          <a class="dropdown-item" href="rxsServlet" target="buttomFrame">查看日销售表</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled">Disabled</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
<div>
<iframe id="buttomFrame" name="buttomFrame" src="inBook2.jsp" scrolling="yes" style="width:100%;min-height:800px; margin:0 auto;">
</iframe>
</div>
<%
	request.setCharacterEncoding("UTF-8");
	String mess=(String)request.getAttribute("mess");//获取mess
	if(mess!=null){//在前端接收服务器返回的判断的mess信息
		%>
		<script type="text/javascript">
		alert("<%=mess%>");//弹出窗口显示信息
		</script>
		<%
	}
%>
</body>
</html>