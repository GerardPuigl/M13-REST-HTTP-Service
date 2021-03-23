$(document).ready(function () {
	updateTable();
});

var table=$('#employeeTable').DataTable({
    columnDefs: [
        {targets: '_all',classname: 'dt-center' }
      ]
  });

//Read employee List & Update the table
function updateTable() {
	$.get("/EmployeeList", function (data) {
		table.clear();
		$.each(data, function (i, employee) {
			table.row.add(createRow(employee)).draw();
		});
	});
};

//create Row for DataTables Format
function createRow(employee){
	return [
		employee.id,
		employee.name,
		employee.job,
		employee.salary,
	   "<button type='button' class='btn btn-light' data-toggle='modal' data-target='#modal' onclick='editEmployee(" + employee.id + ")'>Modificar</button>" +
	   "<button type='button' class='btn btn-danger' onclick='deleteEmployee(" + employee.id + ")'>Eliminar</button>" 
	   ];
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
				table.row.add(createRow(data)).order( [ 0, 'asc' ] ).page('last').draw(false);
			},
			error: function (xhr, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});
		//Update employee
	} if ($('#action').val() == 'Actualitzar') {
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
				table.row(data.id).data(createRow(data)).draw(false);
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
	bootbox.confirm({
		size: "small",
		message: "Estas segur que vols eliminar l'Empleat?",
		centerVertical: "modal-dialog-centered",
		buttons: {
			confirm: {
				label: 'Eliminar',
				classcourse: 'btn-danger'
			},
			cancel: {
				label: 'Cancel·lar',
				classcourse: 'btn-default'
			}
		},
		callback: function (result) {
			if (result == true) {
				$.ajax({
					type: "DELETE",
					url: "/EmployeeList/" + id,
					success: function (data, textStatus, jQxhr) {
						var indexes = table
						.rows()
						.indexes()
						.filter( function ( value, index ) {
						  return id === table.row(value).data()[0];
						} );
					   table.rows(indexes).remove().draw(false);
					},
					error: function (xhr, textStatus, errorThrown) {
						console.log(textStatus);
					}
				});
			}
		}
	})
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
function newEmployee() {
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