<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/r/bs-3.3.5/jq-2.1.4,dt-1.10.8/datatables.min.css"/>
<meta charset="UTF-8">
<title>退货单</title>

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
<style type="text/css">
#apDiv1 {
	position:absolute;
	width:205px;
	height:73px;
	z-index:1;
	left: 554px;
	top: 15px;
	background-color:#999;
	border-radius:36px;
	text-align:center;
}
#apDiv1:hover{
	width:250px;
	height:80px;
	background-color:#000;
	border-radius:36px;
	text-align:center;
	}
	h2{
		text-align:center;
		color:#FFF;}
#apDiv2 {
	position:absolute;
	width:616px;
	height:115px;
	z-index:2;
	left: 354px;
	top: 110px;
}


body {
	background-image: url(%E9%80%80%E8%B4%A7%E8%83%8C%E6%99%AF.jpg);
}
</style>
<script type="text/javascript">
console.debug(window.name);
var iframeid=123; //iframe id
 function SetCwinHeight(){
  var iframeid=123; //iframe id
   if (iframeid && !window.opera){
    if (iframeid.contentDocument && iframeid.contentDocument.body.offsetHeight){
     iframeid.height = iframeid.contentDocument.body.offsetHeight;
    }else if(iframeid.Document && iframeid.Document.body.scrollHeight){
     iframeid.height = iframeid.Document.body.scrollHeight;
    }
   }
  
 }
 console.debug(window.name);
 function method() {
     // 方法体里面定义是可以的
     var iframeid = 123;
 }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div id="apDiv2"><form name="tfm" action="th.do" method="post">
  <div class="form-group">
    <label for="exampleFormControlInput1">姓名:</label>
    <input type="text" class="form-control" name="tuname" required="required" placeholder="请输入姓名" required>
  </div>
   <div class="form-group">
    <label for="exampleFormControlInput1">书籍名称:</label>
    <input type="text" class="form-control" name="tbname" required="required" placeholder="请输入需要退货的书籍名称" requierd>
  </div>
  <div class="form-group">
    <label for="exampleFormControlInput1">退还数量:</label>
    <input type="text" class="form-control" name="tnum" required="required" placeholder="请输入退还数量" required>
  </div>
  <div class="form-group">
    <label for="reson">请输入退货理由：</label>
    <textarea class="form-control" name="reson" required="required" rows="3" required></textarea>
  </div>
  <div class="btn-group btn-group-lg" align="center" role="group" aria-label="...">
  <button type="submit" class="btn btn-primary">提交</button>
  <button type="button" class="btn btn-secondary btn-lg">Middle</button>
  <button type="reset" class="btn btn-primary">重置</button>
</div>
</form></div>
<div id="apDiv1">
  <h2>退货信息</h2>
</div>
</body>
</html>