<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.css">

<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://code.jquery.com/jquery-1.10.2.min.js"></script>

<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		var t = $('#example').DataTable({
			columnDefs : [ {
				searchable : false,
				orderable : false,
				targets : 0,
			}, ],
			order : [ [ 1, 'asc' ] ],
		});

		t.on('order.dt search.dt', function() {
			let i = 1;

			t.cells(null, 0, {
				search : 'applied',
				order : 'applied'
			}).every(function(cell) {
				this.data(i++);
			});
		}).draw();
	});
</script>
<title>报表</title>
</head>
<body>
	<div class="accordion" id="accordionExample">
		<div class="card">
			<div class="card-header" id="headingOne">
				<h2 class="mb-0">
					<button class="btn btn-link btn-block text-left" type="button"
						data-toggle="collapse" data-target="#collapseOne"
						aria-expanded="true" aria-controls="collapseOne">进货表</button>
				</h2>
			</div>

			<div id="collapseOne" class="collapse show"
				aria-labelledby="headingOne" data-parent="#accordionExample">
				<div class="card-body">
					<table id="example" class="display" style="width: 100%">
						<thead>
							<tr>
								<th>#</th>
								<th>书名</th>
								<th>数量</th>
								<th>供应商</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list }" var="item" varStatus="status">
								<tr>
									<td>${status.index+1}</td>
									<td>${item.bookName }</td>
									<td>${item.bookNum }</td>
									<td>${item.fromName }</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>

								<th>#</th>
								<th>书名</th>
								<th>数量</th>
								<th>供应商</th>
							</tr>
						</tfoot>
					</table>

				</div>
			</div>
		</div>
		<div class="card">
			<div class="card-header" id="headingTwo">
				<h2 class="mb-0">
					<button class="btn btn-link btn-block text-left collapsed"
						type="button" data-toggle="collapse" data-target="#collapseTwo"
						aria-expanded="false" aria-controls="collapseTwo">库存</button>
				</h2>
			</div>
			<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
				data-parent="#accordionExample">
				<div class="card-body">
					<table id="example" class="display" style="width: 100%">
						<thead>
							<tr>
								<th>#</th>
								<th>书名</th>
								<th>售价</th>
								<th>库存量</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list }" var="item" varStatus="status">

								<tr>
									<td>${status.index+1}</td>
									<td>${item.bookname }</td>
									<td>${item.soldprice }</td>
									<td>${item.quanity }</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>

								<th>#</th>
								<th>书名</th>
								<th>数量</th>
								<th>供应商</th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="card-header" id="headingThree">
		<h2 class="mb-0">
			<button class="btn btn-link btn-block text-left collapsed"
				type="button" data-toggle="collapse" data-target="#collapseThree"
				aria-expanded="false" aria-controls="collapseThree"></button>
		</h2>
	</div>
	<div id="collapseThree" class="collapse" aria-labelledby="headingThree"
		data-parent="#accordionExample">
		<div class="card-body">And lastly, the placeholder content for
			the third and final accordion panel. This panel is hidden by default.
		</div>
	</div>
	</div>
	</div>
</body>
</html>