<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/r/bs-3.3.5/jq-2.1.4,dt-1.10.8/datatables.min.css"/>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" >
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" ></script>
<meta charset="UTF-8">
<title>销售单</title>
<style type="text/css">
#apDiv1 {
	position:absolute;
	width:128px;
	height:45px;
	z-index:1;
	left: 564px;
	top: 24px;
	background-color:#999;
	border-radius:36px;
	text-align:center;
}
#apDiv1:hover{
	width:150px;
	height:60px;
	background-color:#000;
	border-radius:36px;
	text-align:center;
	}
	h2{
		text-align:center;
		color:#FFF;}
#apDiv2 {
	position:absolute;
	width:440px;
	height:335px;
	z-index:2;
	left: 457px;
	top: 133px;
}

a{
text-decoration: none;
color:black;
}
a:hover{
color:blue;
text-decoration: none;
}

</style>
</head>
<body>
<div class="fixed-top">
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
  <path d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5Z"/>
</svg>
<a href="inBook2.jsp" >回到首页</a>
</div>
<div id="apDiv1" align="center">
  <h2>销售单</h2>
</div>
<br>
<div id="apDiv2" align="center">
  <table width="470" height="354" border="0" cellpadding="0" cellspacing="0">
    <tr class="font-weight-bold">
      <td width="115"  align="center" valign="middle">姓名:</td>
      <td width="326">${username }</td>
    </tr>
    <tr class="font-weight-bold">
      <td align="center" valign="middle">销售书名：</td>
      <td>${nameInfo }</td>
    </tr>
    <tr class="font-weight-bold">
      <td align="center">销售数量：</td>
      <td>${buynum }</td>
    </tr>
    <tr class="font-weight-bold">
      <td align="center">总金额：</td>
      <td>${sumprice }</td>
    </tr>
    <tr class="font-weight-bold">
      <td align="center">生成时间：</td>
      <td>${dateInfo }</td>
    </tr>
    <tr>
    <td>
    <hr>
    </td>
    <td>
    <hr>
    </td>
    </tr>
    <tr>
    <td><form name="jhdform" action="rxsb.do" method="post">
<button type="submit" class="btn btn-outline-success">查看日销售表</button>
</form><td>
      <td colspan="2" align="right">&nbsp;<button type="button" class="btn btn-primary"><a href="inBook2.jsp" class="badge badge-primary">退出</a></button></td>
    </tr>
  </table>

</div>
</body>
</html>