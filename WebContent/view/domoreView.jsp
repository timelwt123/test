<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>批量进货单</title>
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.css">
<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>
<script type="text/javascript">
function filterGlobal() {
    $('#example')
        .DataTable()
        .search($('#global_filter').val(), $('#global_regex').prop('checked'), $('#global_smart').prop('checked'))
        .draw();
}
 
function filterColumn(i) {
    $('#example')
        .DataTable()
        .column(i)
        .search(
            $('#col' + i + '_filter').val(),
            $('#col' + i + '_regex').prop('checked'),
            $('#col' + i + '_smart').prop('checked')
        )
        .draw();
}
 
$(document).ready(function () {
    $('#example').DataTable();
 
    $('input.global_filter').on('keyup click', function () {
        filterGlobal();
    });
 
    $('input.column_filter').on('keyup click', function () {
        filterColumn($(this).parents('tr').attr('data-column'));
    });
});

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
 <table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th>#</th>
                <th>书名</th>
                <th>进货数量</th>
                <th>总花费</th>
                <th>供应商</th>
                <th>时间</th>
            </tr>
        </thead>
        <tbody>
         <c:forEach items="${ml }" var="item" varStatus="status">

					<tr>
						<td>${status.index+1}</td>
						<td>${item.bookname }</td>
						<td>${item.num }</td>
						<td>${item.sumprice }</td>
						<td>${item.fromname }</td>
						<td>${item.datetime }</td>
					</tr>
				</c:forEach>
				</tbody>
				<tfoot>
				<tr>
                 <th>#</th>
                <th>书名</th>
                <th>进货数量</th>
                <th>总花费</th>
                <th>供应商</th>
                <th>时间</th>
            </tr>
        </tfoot>
    </table>
    <table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th>#</th>
                <th>书名</th>
                <th>进货数量</th>
                <th>总花费</th>
                <th>供应商</th>
                <th>时间</th>
            </tr>
        </thead>
        <tbody>
         <c:forEach items="${morekucun }" var="item" varStatus="status">

					<tr>
						<td>${status.index+1}</td>
						<td>${item.bookname }</td>
						<td>${item.quanity }</td>
						<td>${item.price }</td>
						<td></td>
						<td></td>
					</tr>
				</c:forEach>
				</tbody>
				<tfoot>
				<tr>
                 <th>#</th>
                <th>书名</th>
                <th>进货数量</th>
                <th>总花费</th>
                <th>供应商</th>
                <th>时间</th>
            </tr>
        </tfoot>
    </table>
</body>
</html>