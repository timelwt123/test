<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.css">
<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>
<title>排行榜</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	min-height: 100vh;
	background: url(流浪者.jpg) center/cover;
	display: flex;
	justify-content: center;
	align-items: center;
}

main.table {
	width: 77vw;
	height: 80vh;
	background-color: #fff5;
	box-shadow: 0 8px 16px #0005;
	border-radius: 16px;
	overflow: hidden;
}

.header {
	width: 100%;
	height: 10%;
	background-color: #fff4;
	padding: 0 40px;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.header .input-group {
	width: 35%;
	height: 50%;
	background-color: #fff5;
	padding: 0 20px;
	border-radius: 10px;
	display: flex;
	justify-content: center;
	align-items: center;
	transition: .2s;
}

.header .input-group:hover {
	width: 45%;
	background-color: #fff8;
	box-shadow: 0 5px 40px #0002;
}

.header .input-group img {
	width: 20px;
	height: 20px;
}

.header .input-group input {
	width: 100%;
	background-color: transparent;
	border: none;
	outline: none;
}

.shell {
	width: 95%;
	max-height: calc(90% - 25px);
	background-color: #fffb;
	margin: 8px auto;
	border-radius: 10px;
	overflow: auto;
	overflow: overlay;
}

.shell::-webkit-scrollbar {
	width: 10px;
	height: 10px;
}

table {
	width: 100%;
}

td img {
	width: 36px;
	height: 36px;
	margin-right: 10px;
	border-radius: 50%;
	vertical-align: middle;
}

table, th, td {
	border-collapse: collapse;
	padding: 20px;
	text-align: left;
}

thead th {
	position: sticky;
	top: 0;
	left: 0;
	background-color: #d5d1defe;
	cursor: pointer;
}

/* 偶数行背景色 */
tbody tr:nth-child(even) {
	background-color: #0000000b;
}

tbody tr:hover {
	background-color: #fff6 !important;
}

.button {
	padding: 5px 0;
	border-radius: 40px;
	text-align: center;
}

tr:nth-child(4n) .button {
	background-color: #86e49d;
	color: #006b21;
}

tr:nth-child(4n-1) .button {
	background-color: #ebc474;
}

tr:nth-child(4n+1) .button {
	background-color: #d893a3;
	color: #b30021;
}

tr:nth-child(4n+2) .button {
	background-color: #6fcaea;
}
#apDiv1 {
	position:absolute;
	width:177px;
	height:53px;
	z-index:1;
	left: 887px;
	top: 40px;
}
a{
text-decoration: none;
color:black;
}
a:hover{
text-decoration: none;
}
#apDiv2 {
	position:absolute;
	width:85px;
	height:26px;
	z-index:1;
	left: 815px;
	top: 29px;
}
</style>
</head>
<body>

	<main class="table">
	<section class="header">
<h1><img src="house-door-fill (1).svg">月销售总金额排行榜&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img
				src="arrow-right-circle-fill.svg"><a href="cnt2">月销售总量排行榜</a>
			<img
				src="arrow-right-circle-fill.svg"><a href="inBook2.jsp">回到首页</a></h1>
				
				
		<div class="input-group">
			<input type="search" placeholder="Search Data..."> <img
				src="search.png">
		</div>
	</section>
	<section class="shell">
		<table>
			<thead>
				<tr>
					<th>序号</th>
					<th>书名</th>
					<th>月销量</th>
					<th>月销售金额</th>
				</tr>
			</thead>
			<tbody>
<c:forEach items="${list2 }" var="item" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td>${item.bookname }</td>
						<td>${item.monthxs }</td>
						<td>${item.monsumprice }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	</main>
</body>
</html>