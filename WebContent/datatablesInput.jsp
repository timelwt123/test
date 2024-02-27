<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DatatablesInput</title>
<!--第一步：引入Javascript / CSS （CDN）-->
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.css">

<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>

<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>
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

</head>
<body>
<form name="domorefm" action="domore.do" method="post">
<button type="submit">Submit form</button>
    <table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Position</th>
                <th>Office</th>
                <th>Office</th>
                <th>Office</th>
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
									id="inornot" name="inornot" 
									value=${item.pk.bookName }+${item.price }+${item.pk.fromName }
									 aria-label="...">
							</div></td>
							<td>
							<input type="text" name="num">
							</td>
					</tr>
				</c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Position</th>
                <th>Office</th>
                <th>Office</th>
                <th>Office</th>
            </tr>
        </tfoot>
    </table>
    </form>
</body>
</html>