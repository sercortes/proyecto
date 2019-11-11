

$(document).ready(function () {
    
    var $pagination = $('#pagination'),
        totalRecords = 0,
        records = [],
        displayRecords = [],
        recPerPage = 10,
        page = 1,
        totalPages = 0;

    listar()

//    let perfil = $('#rol').val();
//    console.log(perfil)


function generate_table() {
    var table = $('#resTable').html('');

    for (var item of displayRecords) {
        table.append(`<tr id="row${item.idInterventor}">
                            <td>${item.nombres}</td>
                            <td>${item.apellidos}</td>
                            <td>${item.cargoInterventor.nombre}</td>
                            <td>${item.centroFormacion.nombre}</td>
                            <td>${item.correo}</td>
                            <td>${item.direccion}</td>
                            <td>${item.telefono}</td>
                            <td>${item.telefonoCelular}</td>
                            <td>
                                <button class="btn btn-warning btn-xs" role="button" title="Editar" onclick = "editar(${item.idInterventor})">
                                    <i class="far fa-edit"></i>
                                </button>

                              <button class="btn btn-danger btn-xs" role="button" title="Eliminar"  onclick = "eliminar(${item.idInterventor})" >
                                    <i class="far fa-trash-alt"></i> 
                                </button>           
                        </td>
                        </tr> `)
    }

}
function apply_pagination() {
    $pagination.twbsPagination({
        totalPages: totalPages,
        visiblePages: 6,
        onPageClick: function (event, page) {
            displayRecordsIndex = Math.max(page - 1, 0) * recPerPage;
            endRec = (displayRecordsIndex) + recPerPage;
            console.log(displayRecordsIndex + ' ' + endRec);
            displayRecords = records.slice(displayRecordsIndex, endRec);
            generate_table();
        },
    });
}

   

function listar() {

    console.log('sergio')

    $.ajax({
        url: "./listIntervertors",
        async: true,
        type: "GET",
        dataType: 'json',
        success: function (data) {
            records = data;
            totalRecords = records.length;
            totalPages = Math.ceil(totalRecords / recPerPage);
            apply_pagination();
        }
    });

}




});





