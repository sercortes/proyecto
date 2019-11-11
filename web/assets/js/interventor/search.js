

$(document).ready(function () {

  
    $('#search').click(function () {
        
        buscar();
        
    })



});

function eliminar(id){
    
    alertify.confirm("Desea eliminar el interventor "+id,
                function () {
                    
                    $.ajax({
                        type: "get",
                        url: "./deleteInterventor",
                        dataType: "json",
                        data:{
                        id:id
                        },
                        success: function (data) {
                            $('#row' + id).remove()
                            alertify.success('interventor eliminado');
                            console.log(data)
                        }, error: function (error) {
                            console.log(error)
                        }
                    }).fail(function (error) {
                        console.log(error)
                        alertify.error('ups ocurrio un error')
                    });


                }, function () {
            alertify.error('Cancelado');
        })
    
    
   
}


function buscar() {
    let query = $('#query').val();
    if (query === '') {
        alertify.alert('Ingrese un valor a buscar')
    } else {

        let id = $('#query').val();

        $.ajax({
            type: "get",
            async: true,
            datatype: 'json',
            url: "./searchInterventor",
            data: {
                id: id
            },
            success: function (data) {
                if (data.length === 0) {
                    console.log('no encontrado')
                    $('#pagination').html('<h3>Elementos no econtrado</h3>')
                    var table = $('#resTable').html('');
                } else {
                   alertify.success('busqueda realizada')
                    $('#formulario1')[0].reset()
                    $('#formulario1').removeClass('was-validated')
                    
                    generate_table(data)
                    $('#pagination').html('')

                }
            }
        })

    }
}


function generate_table(displayRecords) {
    var table = $('#resTable').html('');

    for (var item of displayRecords) {
        table.append(`<tr id="row${item.idUsuario}">
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
