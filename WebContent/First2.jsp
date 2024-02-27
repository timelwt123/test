<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图书销售系统</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />

<link rel="stylesheet" href="bootstrap/css/bootstrap-select.css">
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="bootstrap/js/vue.js"></script>
<script src="bootstrap/js/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap-select.js"></script>
<script type="text/javascript" src="static/jquery.js"></script>
<style type="text/css">
#apDiv1 {
	position:absolute;
	width:433px;
	height:78px;
	z-index:1;
	left: 295px;
	top: 188px;
	background-color:#999;
	border-radius:36px;
}
.nameFont {
	font-family: "宋体";
	font-size: 50px;
	font-style: normal;
	color: #000;
	text-decoration: none;
}
.timeFont {
	font-family: "宋体";
	font-size: 36px;
	font-weight: normal;
	background-color: #FFF;
	word-spacing: normal;
	height: 200px;
	width: 300px;
	text-align: center;
}
#apDiv2 {
	border-radius:50px;
	position:absolute;
	width:200px;
	height:115px;
	z-index:2;
	left: 60px;
	top: 188px;
}
#apDiv3 {
	position:absolute;
	width:355px;
	height:50px;
	z-index:3;
	left: 362px;
	top: 305px;
	background-color: #666;
	float: none;
	font-size: 36px;
	color:#FFF;
	text-align:center;
}

body {
	background-image: url();
	background-repeat: no-repeat;
}
#apDiv4 {
	position:absolute;
	width:200px;
	height:115px;
	z-index:4;
	left: 844px;
	top: 136px;
	text-align:center;
	font-size:36px;
}
#apDiv5 {
	position:absolute;
	width:433px;
	height:78px;
	z-index:3;
	left: 295px;
	top: 295px;
	background-color:#999;
	border-radius:36px;
	opacity: 0.5;
}
#apDiv5:hover{
	background-color:#000;
	width:500px;
	height::90px;}
	#apDiv1:hover{
	background-color:#000;
	width:500px;
	height::90px;}
h2{
	color:#FFF;
	text-align:center;
	}
	h6{
		color:#000;
		text-align:center;}
#apDiv6 {
	position:absolute;
	width:72px;
	height:33px;
	z-index:4;
	left: 834px;
	top: 133px;
}
#apDiv7 {
	position:absolute;
	width:77px;
	height:77px;
	z-index:5;
	left: 834px;
	top: 186px;
	text-align:center;
	background-color:#999;
	border-radius:36px;
}
#apDiv7:hover{
	background-color:#000;
	width:100px;
	height::100px;}
#apDiv8 {
	position:absolute;
	width:77px;
	height:77px;
	z-index:6;
	left: 832px;
	top: 294px;
	text-align:center;
	background-color:#999;
	border-radius:36px;
}
#apDiv8:hover{
	background-color:#000;
	width:100px;
	height::100px;}
#apDiv9 {
	position:absolute;
	width:77px;
	height:77px;
	z-index:7;
	left: 963px;
	top: 186px;
	text-align:center;
	background-color:#999;
	border-radius:36px;
}
#apDiv9:hover{
	background-color:#000;
	width:100px;
	height::100px;}
#apDiv10 {
	position:absolute;
	width:77px;
	height:77px;
	z-index:8;
	left: 963px;
	top: 294px;
			text-align:center;
	background-color:#999;
	border-radius:36px;
}
#apDiv10:hover{
	background-color:#000;
	width:100px;
	height::100px;}
a:link {
	color: #FFF;
	text-decoration: none;
}
a:visited {
	text-decoration: none;
	color: #FFF;
}
a:hover {
	text-decoration: none;
	color: #FFF;
}
a:active {
	text-decoration: none;
}
#apDiv11 {
	position:absolute;
	width:259px;
	height:33px;
	z-index:9;
	left: 867px;
	top: 130px;
	text-align:left;
}
</style>
<script type="text/javascript">
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
</script>
</head>

<body onload="MM_preloadImages('头像2.jpg','头像4.jpg')">
<iframe src="http://i.tianqi.com/index.php?c=code&id=34 " width="280" height="25" marginwidth="0" marginheight="0" hspace="0" vspace="0" frameborder="0" scrolling="no"></iframe>
<div id="apDiv10" class="shadow p-3 mb-5 bg-white rounded">
  <h2><a href="统计.jsp">统计</a></h2>
</div>
<div id="apDiv9" class="shadow p-3 mb-5 bg-white rounded">
  <h2><a href="销售.jsp">销售</a></h2>
</div>
<div class="nameFont" id="apDiv1">
  <h2><strong>图书销售管理</strong></h2>
</div>
<div id="apDiv2"><a href="#" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('toux','','头像4.jpg',1)"><img src="头像3.jpg" name="toux" width="200" height="200" border="0" id="toux" /></a></div>
<div id="apDiv5">
  <h2>
    <!-- #BeginDate format:fIS1m -->Wednesday, 2023-06-14  14:59<!-- #EndDate --></h2>
</div>
<div id="apDiv6">
<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-book-half" viewBox="0 0 16 16">
  <path d="M8.5 2.687c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
</svg>
<i class="bi bi-book-half"></i>
</div>
<div id="apDiv7" class="shadow p-3 mb-5 bg-white rounded">
  <h2><a href="进货.jsp">进货</a></h2>
</div>
<div id="apDiv8" class="shadow p-3 mb-5 bg-white rounded">
  <h2><a href="退货.jsp">退货</a></h2>
</div>
<div id="apDiv11">
  <h4>操作列表</h4>
</div>
</body>
</html>