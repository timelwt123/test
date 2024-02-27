<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DatatablesInput</title>
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.css">
<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>


<script type="text/javascript">
$(document).ready(function () {
    var table = $('#example').DataTable({
        columnDefs: [
            {
                orderable: false,
                targets: [1, 2, 3],
            },
        ],
    });
 
    $('button').click(function () {
        var data = table.$('input, select').serialize();
        alert('The following data would have been submitted to the server: \n\n' + data.substr(0, 120) + '...');
        return false;
    });
});
</script>
<style type="text/css">
a {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
	color: blue;
}
</style>
</head>
<body>
	<div class="fixed-top">
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
			fill="currentColor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
  <path
				d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5Z" />
</svg>
		<a href="inBook2.jsp">回到首页</a>
	</div>
	<form name="domorefm" action="domore.do" method="post">
		<input type="submit" value="Submit">
		<table id="example" class="display" style="width: 100%">
			<thead>
				<tr>
					<th>#</th>
					<th>书名</th>
					<th>报价</th>
					<th>供应商</th>
					<th>是否进货</th>
					<th>进货数量</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="item" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td>${item.pk.bookName }</td>
						<td>${item.price }</td>
						<td>${item.pk.fromName }</td>
						<td><div class="form-check">
								<input class="form-check-input position-static" type="checkbox"
									id="inornot" name="inornot" value=${item.pk.bookName }+${item.price }+${item.pk.fromName } aria-label="...">
							</div></td>
							<td><input
									type="text" name="num"></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>#</th>
					<th>书名</th>
					<th>报价</th>
					<th>供应商</th>
					<th>是否进货</th>
					<th>进货数量</th>
				</tr>
			</tfoot>
		</table>
	</form>
</body>

</html>