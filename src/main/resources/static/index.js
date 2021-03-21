
$(document).ready(function() {
	$('#newEmployee').submit(function(evento) {
		evento.preventDefault();
		$.ajax({
			url: '/EmployeeList',
			type: 'POST',
			contentType: 'application/Json',
			data: JSON.stringify({
				"name": $('#name').val(),
				"job": $('#job').val()
			}),
			success: function(data, textStatus, jQxhr) {
				updateTable();
				$('#newEmployee').trigger('reset');
			},
			error: function(xhr, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});

	});

	$(function() {
		updateTable();
	});
});

function updateTable() {
	$.get("/EmployeeList", function(data) {
		$('#employeeTable > tbody').empty();
		var table_data;
		$.each(data, function(i, employee) {
			table_data += "<tr>" +
				"<td ><form>" + employee.id + "</td>" +
				"<td >" + employee.name + "</td>" +
				"<td>" + employee.job + "</td>" +
				"<td>" + employee.salary + "</td>" +
				"<td>" +
				"<button type=submit>Modificar</button>" +
				"<button type=submit onclick='deleteEmploye(" + employee.id + ")'>Eliminar</button>" +
				"<form></td>"
		});
		$('#employeeTable > tbody').append(table_data);
	});
};

function deleteEmploye(id) {
	if (confirm("Desitja eliminar a l'Empleat?")) {
		$.ajax({
			type: "DELETE",
			url: "/EmployeeList/" + id,
			success: function(data, textStatus, jQxhr) {
				updateTable();
			},
			error: function(xhr, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});

	};

};
