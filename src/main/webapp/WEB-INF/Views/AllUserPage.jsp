<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

    <title>All Users Page</title>
    
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	
	<link rel="stylesheet" href="https://cdn.datatables.net/2.0.8/css/dataTables.dataTables.css" />
	<script src="https://cdn.datatables.net/2.0.8/js/dataTables.js"></script>
	

</head>
<body style="background-color: rgb(252, 222, 182);">

	<!-- Navbar -->
	<%@ include file="Navbar.jsp" %>
	
    <h1 style="text-align: center; margin-top: 40px;">All Users in Database</h1>

	<table id="myTable" class="display" style="background-color: rgb(255, 236, 221);">
		<thead>
			<tr>
				<th>Email</th>
				<th>Last Login</th>
			</tr>
		</thead>

	</table>

	<script>
		
		// Data Table
		$('#myTable').DataTable( {
			ajax: {
				// Route to the API endpoint in the User Controller
				url: '/api/users',
				dataSrc: ''
			},
			columns: [

				// Data to be displayed in the table
				{ data: 'email' },
				{ data: 'lastLogin' },

				// Delete user button code
				{
					data: null,
					defaultContent: '<button>Delete User</button>'
				}
			]
		} );

		// Delete user button functionality
		$('#myTable').on('click', 'button', function() {

			// Get data from the buttons row row
			var data = $('#myTable').DataTable().row($(this).parents('tr')).data();
			
			// Route to the API endpoint for delete funciton in the User Controller
			$.ajax({

				// API Route
				url: '/api/users/' + data.email,
				type: 'DELETE',

				// Reload after user has been delted
				success: function() {
					$('#myTable').DataTable().ajax.reload();
				}
			});
		});

	</script>
	
</body>
</html>
