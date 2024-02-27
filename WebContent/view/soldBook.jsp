<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org"> 
<head>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" >
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" ></script>
<meta charset="UTF-8">
<title>销售</title>
<script type="text/javascript">

</script>
<style type="text/css">
#apDiv1 {
	position:absolute;
	width:563px;
	height:424px;
	z-index:1;
	left: 430px;
	top: 81px;
}

a{
text-decoration: none;
color:black;
}
a:hover{
text-decoration: none;
color:blue;
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
<form class="was-validated" name="xsfm" action="xs.do" method="post">

  <div class="mb-3">
    <div class="input-group is-invalid">
      <div class="input-group-prepend">
        <span class="input-group-text" id="validatedInputGroupPrepend">@</span>
      </div>
      <input type="text" name="uesrname" class="form-control is-invalid" aria-describedby="name="uesrname"" placeholder="Uername"  required>
    </div>
    <div class="invalid-feedback">
      请输入顾客名称
    </div>
  </div>
  
  <div class="mb-3">
    <div class="input-group is-invalid">
      <div class="input-group-prepend">
        <span class="input-group-text" id="validatedInputGroupPrepend">NAME</span>
      </div>
      <input type="text" id="xsname" list="kucunlist" name="xsname" class="form-control is-invalid" aria-describedby="xsname" placeholder="BookName" required>
	<datalist id="kucunlist">
	<c:forEach items="${list }" var="item">
	<option value=${item.bookname }:"库存:"${item.quanity }-"售价:"${item.soldprice }></option>
	</c:forEach>
	</datalist>
    </div>
    <div class="invalid-feedback">
      请输入书名/查看库存
    </div>
    <span class="d-inline-block" tabindex="0" data-toggle="tooltip" title="Disabled tooltip">
</span>

	<div class="mb-3">
    <div class="input-group is-invalid">
      <div class="input-group-prepend">
        <span class="input-group-text" id="validatedInputGroupPrepend">NUM</span>
      </div>
      <input type="text" name="buynum" class="form-control is-invalid" aria-describedby="buynum" placeholder="Num" required>
    </div>
    <div class="invalid-feedback">
      请输入购买数量
    </div>
  </div>
  
 
  </div>
	  <div class="mb-3">
    <label for="validationTextarea">顾客备注</label>
    <textarea class="form-control is-invalid" id="validationTextarea" placeholder="Required example textarea" required></textarea>
    <div class="invalid-feedback">
      Please enter a message in the textarea.
    </div>
  </div>
	
    <div class="input-group-append">
       <button class="btn btn-outline-secondary" type="submit">提交</button>
       <button class="btn btn-outline-secondary" type="reset">重置</button>
    </div>
  <div class="invalid-feedback">
    Example invalid input group feedback
  </div>
</form>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
        &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
         &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
       <a href="inBook2.jsp" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">退出</a>
</div>



</body>
</html>