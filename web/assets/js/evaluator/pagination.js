//
//
// $(document).ready(function(){
//	
//         let id = $('#idd').val();
//        
//	var $pagination = $('#pagination'),
//		totalRecords = 0,
//		records = [],
//		displayRecords = [],
//		recPerPage = 10,
//		page = 1,
//		totalPages = 0;
//           
//	$.ajax({
//		url: "./EvaluatorProject?id="+id,
//		async: true,
//                type: "GET",
//		dataType: 'json',
//		success: function (data) {
//			records = data;
//			console.log(records);
//			totalRecords = records.length;
//			totalPages = Math.ceil(totalRecords / recPerPage);
//			apply_pagination();
//		}
//	});
//	function generate_table() {
//		var tr;
//		$('#emp_body').html('');
//		for (var i = 0; i < displayRecords.length; i++) {
//			tr = $('<tr/>');
//			tr.append("<td>" + displayRecords[i].idUsuario + "</td>");
//			tr.append("<td>" + displayRecords[i].nombre + "</td>");
//			tr.append("<td>" + displayRecords[i].apellido + "</td>");
//			$('#emp_body').append(tr);
//		}
//	}
//	function apply_pagination() {
//		$pagination.twbsPagination({
//			totalPages: totalPages,
//			visiblePages: 6,
//			onPageClick: function (event, page) {
//				displayRecordsIndex = Math.max(page - 1, 0) * recPerPage;
//				endRec = (displayRecordsIndex) + recPerPage;
//				console.log(displayRecordsIndex + ' '+ endRec);
//				displayRecords = records.slice(displayRecordsIndex, endRec);
//				generate_table();
//			}
//		});
//	}
//  });