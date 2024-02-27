<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>进货</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/r/bs-3.3.5/jq-2.1.4,dt-1.10.8/datatables.min.css"/>
<meta charset="UTF-8">
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
<script>
Session session=SessionUtil.getSession();
Query query=session.createQuery("from inBook");
</script>
</head>
<body>
<form name="fm1" action="in.do" method="post">
请输入需要进货的书籍名称：<input type="text" name="inBook" required="required" placeholder="书籍名称"><br>
请输入进货数量:<input type="text" name="inNum" required="required" placeholder="进货数量"><br>
<select name="from">
<option name="1">供应商1</option>
<option name="2">供应商2</option>
</select>
<br>
<input type="submit" name="sb" value="提交">
<input type="reset" name="res" value="重置">
</form>
<br>
<table>
<thead>进货表</thead>
<tbody>
<tr>
<th>书籍名称</th>
<th>进货数量</th>
<th>供应商</th>
</tr>
<c:forEach items="${query }" var="item">
					<tr>
						<td>${item.bookName }</td>
						<td>${item.bookNum }</td>
						<td>${item.fromName }</td>
					</tr>
				</c:forEach>
</tbody>
</table>
</body>
</html>