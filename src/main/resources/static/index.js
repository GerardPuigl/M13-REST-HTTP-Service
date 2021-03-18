
$(document).ready(function() {
	$('#newEmployee').submit(function(evento) {
		evento.preventDefault();
		$.ajax({
			url: '/EmployeeList',
			type: 'POST',
			data: JSON.stringify({
				"name": $('#name').val(),
				"job": $('#job').val()
			}),
			processData: false,
			contentType: "application/json"
		})
		updateTable()
	});

	$(function() {
		updateTable();
	});

	function updateTable() {
		$.get("/EmployeeList", function(data) {
			$('#employeeTable > tbody').empty()
			$.each(data, function(i, employee) {
				var tblRow = "<tr>" +
					"<td>" + employee.id + "</td>" +
					"<td>" + employee.name + "</td>" +
					"<td>" + employee.job + "</td>" +
					"<td>" + employee.salary + "</td>" +
					"<td>" +
					"<button type=submit>Modificar</button>" +
					"<button type=submit>Eliminar</button>" +
					"</td>"
				$(tblRow).appendTo("#employeeTable tbody");
			});
		});
	};
});
