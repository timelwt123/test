<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
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
form {
width: 562px;
height: 520px;
background-color: #fff;
box-shadow: 0px 15px 40px #b6354e;
border-radius: 15px;
display: flex;
justify-content: center;
align-items: center;
}
#img-box {
width: 330px;
height: 520px;
}
#img-box img {
height:100%;
border-radius:36px;
}
#img-box img:hover {
height:100%;
border-radius:360px;
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
</style>
</head>
<body>
<div class="shell">
<div id="img-box">
<img src="提纳里.jpg" alt="">
</div>
<form method="post" action="lo.do" method="post">
<div id="form-body">
<div id="welcome-lines">
<div id="w-line-1">Hello World!</div>
<div id="w-line-2">Welcome</div>
</div>
<div id="input-area">
<div class="f-inp">
<input type="text" name="user" value="${cookie.username.value}" placeholder="Username" required>
</div>
<div class="f-inp">
<input type="password" name="pwd" value="${cookie.userpassword.value}" placeholder="Password" required>
</div>
</div>
<div class="col-auto my-1">
      <div class="form-check">
        <input class="form-check-input" type="checkbox" id="autoSizingCheck2" name="rem" value="rem">
        <label class="form-check-label" for="autoSizingCheck2">
          Remember me
        </label>
      </div>
    </div>
<div id="submit-button-cvr">
<button type="submit" id="submit-button">登录</button>
</div>
<div id="forgot-pass">
<a href="注册.jsp">注册</a>
</div>
</div>
</form>
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