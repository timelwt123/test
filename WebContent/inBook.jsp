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
<style>
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
#forgot-pass {
text-align: center;
margin-top: 10px;
}
#forgot-pass a {
color: #868686;
font-size: 12px;
text-decoration: none;
}

#apDiv1 {
	position:absolute;
	width:324px;
	height:284px;
	z-index:1;
	left: -3px;
	top: 523px;
	background-color:#FFF
}
</style>
<script type="text/javascript">

</script>
</head>
<body>
<div class="shell">
<div id="img-box">
<img src="提纳里.jpg" alt="">
</div>

<div id="form-body">
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