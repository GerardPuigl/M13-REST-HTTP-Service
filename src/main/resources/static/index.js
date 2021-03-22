
$(document).ready(updateTable());

//Read employee List & Update the table
function updateTable() {
	$.get("/EmployeeList", function (data) {
		$('#employeeTable > tbody').empty();
		var table_data;
		$.each(data, function (i, employee) {
			table_data += "<tr>" +
				"<td>" + employee.id + "</td>" +
				"<td>" + employee.name + "</td>" +
				"<td>" + employee.job + "</td>" +
				"<td>" + employee.salary + "</td>" +
				"<td>" +
				"<button type='button' class='btn btn-light' data-toggle='modal' data-target='#modal' onclick='editEmployee(" + employee.id + ")'>Modificar</button>" +
				"<button type='button' class='btn btn-danger' onclick='deleteEmployee(" + employee.id + ")'>Eliminar</button>" +
				"</td>"
		});
		$('#employeeTable > tbody').append(table_data);
	});
};

//Create & update
function sendEmployee() {
	//create employee
	if ($('#action').val() == 'Afegir') {
		$.ajax({
			url: '/EmployeeList',
			type: 'POST',
			contentType: 'application/Json',
			data: JSON.stringify({
				"name": $('#name').val(),
				"job": $('#job').val()
			}),
			success: function (data, textStatus, jQxhr) {
				updateTable();
			},
			error: function (xhr, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});
	//Update employee
	} if ($('#action').val()=='Actualitzar') {
		$.ajax({
			url: '/EmployeeList/' + $('#idEmployee').val(),
			type: 'PUT',
			contentType: 'application/Json',
			data: JSON.stringify({
				"id": $('#idEmployee').val(),
				"name": $('#name').val(),
				"job": $('#job').val()
			}),
			success: function (data, textStatus, jQxhr) {
				updateTable();
				$('#modal').modal('hide');
			},
			error: function (xhr, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});
	}
	$('#EmployeeForm').trigger('reset');
	$('#action').val('Afegir');
	$('#formType').html('Afegir nou');
};

//Delete employee
function deleteEmployee(id) {
	if (confirm("Desitja eliminar a l'Empleat?")) {
		$.ajax({
			type: "DELETE",
			url: "/EmployeeList/" + id,
			success: function (data, textStatus, jQxhr) {
				updateTable();
			},
			error: function (xhr, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});
	};
};

//Read one employee info and put in the modifier form.
function editEmployee(id) {
	$.get("/EmployeeList/" + id, function (data) {
		$('#idEmployee').val(data.id);
		$('#name').val(data.name);
		$('#job').val(getJobCode(data.job));
	});
	$('#action').val('Actualitzar');
	$('#formType').html('Actualizar');
};

//Set Form in New Employee Mode
function newEmployee(){
	$('#EmployeeForm').trigger('reset');
	$('#action').val('Afegir');
	$('#formType').html('Afegir nou');
}


//Take the enum codes for Employee Jobs.
function getJobCode(job) {
	if (job == 'Director de projectes') {
		return 'Director_Projectes';
	} if (job == 'Programador Senior') {
		return 'Programador_Senior';
	} if (job == 'Programador_Mid') {
		return 'Programador_Mid';
	} if (job == 'Programador Junior') {
		return 'Programador_Junior';
	} if (job == 'Administratiu') {
		return 'Administratiu';
	} else {
		return "Default";
	}
}