<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" >
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" ></script>
<title>报表</title>
</head>
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
<body>
<div class="fixed-top">
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
  <path d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5Z"/>
</svg>
<a href="inBook2.jsp" >回到首页</a>
</div>
<div class="accordion" id="accordionExample">
  <div class="card">
    <div class="card-header" id="headingOne">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          月销售金额排行榜
        </button>
      </h2>
    </div>

    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
      <div class="card-body">
         <table class="table table-striped table-dark">
  <thead>
    <tr>
         <tr>
      <th scope="col">序号</th>
      <th scope="col">书名</th>
      <th scope="col">月销量</th>
      <th scope="col">月销售金额</th>
    </tr>
    </tr>
  </thead>
  <tbody>
<c:forEach items="${list1 }" var="item" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td>${item.bookname }</td>
						<td>${item.monthxs }</td>
						<td>${item.monsumprice }</td>
					</tr>
				</c:forEach>
  </tbody>
  </tbody>
</table>
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" id="headingTwo">
      <h2 class="mb-0">
        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          月销售总量排行榜
        </button>
      </h2>
    </div>
    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
      <div class="card-body">
         <table class="table table-striped table-dark">
  <thead>
    <tr>
         <tr>
      <th scope="col">序号</th>
      <th scope="col">书名</th>
      <th scope="col">月销量</th>
      <th scope="col">月销售金额</th>
    </tr>
    </tr>
  </thead>
  <tbody>
<c:forEach items="${list1 }" var="item" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td>${item.bookname }</td>
						<td>${item.monthxs }</td>
						<td>${item.monsumprice }</td>
					</tr>
				</c:forEach>
  </tbody>
  </tbody>
</table>
      </div>
    </div>
  </div>
</div>
</body>
</html>