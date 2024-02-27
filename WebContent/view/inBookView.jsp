<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/r/bs-3.3.5/jq-2.1.4,dt-1.10.8/datatables.min.css" />
<meta charset="UTF-8">
<title>供应商书籍报价表</title>
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

<script type="text/javascript"
	src="https://cdn.datatables.net/r/bs-3.3.5/jqc-1.11.3,dt-1.10.8/datatables.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable({
			"pageLength" : 5,
			"lengthMenu" : [ 10, 25, 50, 75, 100 ],
		});

		// 添加class属性table table-striped table-bordered
		// $('#example')
		// .removeClass( 'display' )
		// .addClass('table table-striped table-bordered');
	});
</script>
</script>
<style type="text/css">
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
	<!-- 引入bootstrap的流式布局，固定宽度class样式 -->
	<div class="container">
		<table id="example" class="table table-striped table-bordered"
			cellspacing="0" width="100%">
			<thead>
				<tr>
					<td>#</td>
					<td>书名</td>
					<td>进货数量</td>
					<td>供应商</td>
					<td>供应商报价</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="item" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td>${item.bookName }</td>
						<td>${item.bookNum }</td>
						<td>${item.fromName }</td>
						<td>${item.fprice }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
<h2 align="center">继续进货</h2>
	<form name="fmpro" action="in.do" method="post">
  <div class="form-group" >
    <label for="inBook">进货书名:</label>
    <input type="text" class="form-control" name="inBook" required="required" placeholder="请输入书名">
  </div>
  <div class="form-group" >
    <label for="inNum">进货数量:</label>
    <input type="text" class="form-control" name="inNum"
			required="required" placeholder="请输入数量">
  </div>
  <div class="form-group" >
    <label for="soldprice">售价:</label>
    <input type="text" class="form-control" name="soldprice" required="required" placeholder="请输入售价">
  </div>
  <div class="form-group">
    <label for="from">请选择供应商:</label>
    <select class="form-control" name="from">
      <option>供应商1</option>
      <option>供应商2</option>
      <option>供应商3</option>
      <option>供应商4</option>
      <option>供应商5</option>
    </select>
  </div>
  <div class="btn-group" role="group" aria-label="button">
  <button type="submit" class="btn btn-secondary">提交</button>
  <button type="button" class="btn btn-secondary">Middle</button>
  <button type="reset" class="btn btn-secondary">重置</button>
  <button type="button" class="btn btn-outline-secondary"><a href="inBook2.jsp" class="text-decoration-none">退出</a></button>
</div>
</form>
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