<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<script>
$.ajax({
	url : 'c:.csv',
	dataType : 'text',
}).done(successFunction);

function successFunction(data) {
	var allRows = data.split(/\r?\n|\r/);
	var table = '<table>';
	for (var singleRow = 0; singleRow < allRows.length; singleRow++) {
		if (singleRow === 0) {
			table += '<thead>';
			table += '<tr>';
		} else {
			table += '<tr>';
		}
		var rowCells = allRows[singleRow].split(',');
		for (var rowCell = 0; rowCell < rowCells.length; rowCell++) {
			if (singleRow === 0) {
				table += '<th>';
				table += rowCells[rowCell];
				table += '</th>';
			} else {
				table += '<td>';
				table += rowCells[rowCell];
				table += '</td>';
			}
		}
		if (singleRow === 0) {
			table += '</tr>';
			table += '</thead>';
			table += '<tbody>';
		} else {
			table += '</tr>';
		}
	}
	table += '</tbody>';
	table += '</table>';
	$('body').append(table);
}


</script>
</body>
</html>