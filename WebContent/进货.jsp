<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/r/bs-3.3.5/jq-2.1.4,dt-1.10.8/datatables.min.css"/>
<meta charset="UTF-8">
<title>进货</title>
<script type="js/bootstrap.min.js"></script>
<script type="js/query-1.12.4.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css" />

<link rel="stylesheet" href="bootstrap/css/bootstrap-select.css">
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="bootstrap/js/vue.js"></script>
<script src="bootstrap/js/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-select.js"></script>
<script type="text/javascript" src="static/jquery.js"></script>
</head>
<body>
<center>
<div class="card" style="18rem">
  <img src="book-fill.svg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">进货</h5>
    <p class="card-text">请根据报价表确定进货方案</p>
        <form name="fm1" action="pro.do" method="post">
	<input class="btn btn-primary" type="submit" value="点击此处进行报价查询">
</form>
  </div>
</div>
</center>
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