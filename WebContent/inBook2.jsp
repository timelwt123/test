<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>进货</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" >
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" ></script>
<style type="text/css">
* {
padding: 0;
margin: 0;
outline: none;
}

body {
background: linear-gradient(45deg, #fbda61, #ff5acd);
display: flex;
justify-content: center;
align-items: center;
height: 100vh;
}

.shell,
form {
position: relative;
}
.shell {
display: flex;
justify-content: center;
}

#img-box {
width: 330px;
height: 520px;
}
#img-box img {
height:100%;
}
#form-body {
width: 320px;
display: flex;
justify-content: center;
align-items: center;
flex-direction: column;
}
#welcome-lines {
width: 100%;
text-align: center;
line-height: 1;
}
#w-line-1 {
color: #7f7f7f;
font-size: 50px;
}
#w-line-2 {
color: #9c9c9c;
font-size: 30px;
margin-top: 17px;
}
#input-area {
width: 100%;
margin-top: 40px;
}
.f-inp {
padding: 13px 25px;
border: 2px solid #6e6d6d;
line-height: 1;
border-radius: 20px;
margin-bottom: 15px;
}
.f-inp input {
width: 100%;
font-size: 14px;
padding: 0;
margin: 0;
border: 0;
}
.f-inp input::placeholder {
color: #b9b9b9;
}
#submit-button-cvr {
margin-top: 20px;
}
#submit-button {
display: block;
width: 100%;
color: #fff;
font-size: 14px;
margin: 0;
padding: 14px 40px;
border: 0;
background-color: #f5506e;
border-radius: 25px;
line-height: 1;
cursor: pointer;
}
#apDiv1 {
	position:absolute;
	width:250px;
	height:400px;
	z-index:1;
	left: 338px;
	top: 156px;
	border-radius:36px;
}
img{
	
	border-radius:36px;}
#apDiv2 {
	position:absolute;
	width:404px;
	height:360px;
	z-index:2;
	left: 602px;
	top: 183px;
	border:	#000;
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
<body onLoad="MM_preloadImages('pass图像.jpg')">
<div id="apDiv2">
<div id="welcome-lines">
<div id="w-line-1" >Hello World!
</div>
<div id="w-line-2">Welcome</div>
</div>
<div id="input-area">
<div class="f-inp">
<form name="fm1" action="pro.do" method="post">
	<input class="btn btn-primary" type="submit" value="点击此处进行报价查询/单种进货">
</form>
</div>
<div class="f-inp">
<form name="plfm" action="more.do" method="post">
	<input class="btn btn-primary" type="submit" value="点击此处进行批量进货/单页进货">
</form>
</div>
</div>
</div>

</div>
<div id="apDiv1"><a href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image1','','pass图像.jpg',1)"><img src="提纳里.jpg" name="Image1" width="250" height="400" border="0"></a></div>
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