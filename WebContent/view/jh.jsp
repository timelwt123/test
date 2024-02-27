<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>进货表</title>
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.css">
<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>

<script type="text/javascript">
$(document).ready(function () {
    var t = $('#example').DataTable({
        columnDefs: [
            {
                searchable: false,
                orderable: false,
                targets: 0,
            },
        ],
        order: [[1, 'asc']],
    });
 
    t.on('order.dt search.dt', function () {
        let i = 1;
 
        t.cells(null, 0, { search: 'applied', order: 'applied' }).every(function (cell) {
            this.data(i++);
        });
    }).draw();
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
<a href="inBook2.jsp" >回到首页&nbsp;&nbsp;&nbsp;&nbsp;</a><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-1-circle" viewBox="0 0 16 16">
  <path d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8Zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0ZM9.283 4.002V12H7.971V5.338h-.065L6.072 6.656V5.385l1.899-1.383h1.312Z"/>
</svg><a class="dropdown-item" href="jhServlet" target="buttomFrame">查看进货表</a>
&nbsp;&nbsp;&nbsp;&nbsp;</a><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-2-circle" viewBox="0 0 16 16">
  <path d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8Zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0ZM6.646 6.24v.07H5.375v-.064c0-1.213.879-2.402 2.637-2.402 1.582 0 2.613.949 2.613 2.215 0 1.002-.6 1.667-1.287 2.43l-.096.107-1.974 2.22v.077h3.498V12H5.422v-.832l2.97-3.293c.434-.475.903-1.008.903-1.705 0-.744-.557-1.236-1.313-1.236-.843 0-1.336.615-1.336 1.306Z"/>
</svg><a class="dropdown-item" href="kucunServlet" target="buttomFrame">查看库存</a>
&nbsp;&nbsp;&nbsp;&nbsp;</a><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-3-circle" viewBox="0 0 16 16">
  <path d="M7.918 8.414h-.879V7.342h.838c.78 0 1.348-.522 1.342-1.237 0-.709-.563-1.195-1.348-1.195-.79 0-1.312.498-1.348 1.055H5.275c.036-1.137.95-2.115 2.625-2.121 1.594-.012 2.608.885 2.637 2.062.023 1.137-.885 1.776-1.482 1.875v.07c.703.07 1.71.64 1.734 1.917.024 1.459-1.277 2.396-2.93 2.396-1.705 0-2.707-.967-2.754-2.144H6.33c.059.597.68 1.06 1.541 1.066.973.006 1.6-.563 1.588-1.354-.006-.779-.621-1.318-1.541-1.318Z"/>
  <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0ZM1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8Z"/>
</svg><a class="dropdown-item" href="thServlet" target="buttomFrame">查看退货表&nbsp;&nbsp;&nbsp;&nbsp;</a>
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-4-circle" viewBox="0 0 16 16">
  <path d="M7.519 5.057c.22-.352.439-.703.657-1.055h1.933v5.332h1.008v1.107H10.11V12H8.85v-1.559H4.978V9.322c.77-1.427 1.656-2.847 2.542-4.265ZM6.225 9.281v.053H8.85V5.063h-.065c-.867 1.33-1.787 2.806-2.56 4.218Z"/>
  <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0ZM1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8Z"/>
</svg><a class="dropdown-item" href="rxsServlet" target="buttomFrame">查看日销售表</a>
</div>
<table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                 <th>#</th>
                <th>书名</th>
                <th>数量</th>
                <th>供应商</th>
                <th>供应商报价</th>
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
        <tfoot>
            <tr>
                
                <th>#</th>
                <th>书名</th>
                <th>数量</th>
                <th>供应商</th>
                <th>供应商报价</th>
            </tr>
        </tfoot>
    </table>
</body>
</html>