var arrayEvaluadores = []

$(document).ready(function () {

    $('#addEvaluador').click(function () {

        let evaluador = $('#evaluador option:selected')
        let idEvaluador = evaluador.val();
        let nameEvaluador = (evaluador.text()).trim()

        let exist = arrayEvaluadores.find(element => {
            return idEvaluador === element.id
        })


        if (exist === undefined) {
            arrayEvaluadores.push(
                    {
                        'id': idEvaluador,
                        'nombre': nameEvaluador
                    }
            )

            $('#tableChild').append(`<tr>
                                            <td>${nameEvaluador}</td>
                                            <td>
                                                <button class="btn btn-danger btn-xs" role="button" title="Eliminar"  onclick = "eliminar(${idEvaluador})" >
                                                     <i class="far fa-trash-alt"></i> 
                                                </button>   
                                            </td>
                                        </tr>`);
        } else {
            alert('Este evaluador ya ha sido agregado')
        }

    })

    $('#evaluador').change(function () {
        if ($('#evaluador').val() != '') {
            $('#addEvaluador').show();
        } else {
            $('#addEvaluador').hide();
        }
    })

})

function addFunction(ev) {
    let name = $('#nombre').val()
    let sesiones = $('#sesiones').val()
    let fechaInicio = $('#fechaInicio').val()
    let fechaFin = $('#fechaFin').val()
    let id = $('#idProyecto').val()
    if (name == "" || sesiones == "" ||
            fechaInicio == "" || fechaFin == "" || arrayEvaluadores.length === 0) {
        alertify.alert('Complete el formulario, por favor')
    } else {

        let data = {
            'id': id,
            'nombre': name,
            'sesiones': sesiones,
            'fechaInicio': fechaInicio,
            'fechaFin': fechaFin,
            'arrayEvaluadores': JSON.stringify(arrayEvaluadores)
        }

        $('#contenido').append(`
                                        <img src="assets/img/cargar/loader.gif"/>
                                        Un momento, por favor...`);

        $.ajax({
            type: 'POST',
            url: './NewActivity',
            dataType: "json",
            data,
            success: function (datas) {
                console.log(datas)
            }, error: function (error) {

                $('#contenido').html('');
                let texto = ''


                if (error.statusText === "OK") {
                    alertify.success('Operación realizada')
                    texto = 'Operaciones realizadas con éxito'
                } else {
                    alertify.error('Ups ocurrio un error')
                    texto = 'Ups ocurrio un error'
                }

                $('#mensaje').append(`<div class="alert alert-success alert-dismissible fade show" role="alert">
                <strong>Ok!</strong> ${texto}.
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>`)

                $('#formulario')[0].reset()
                $('#formulario').removeClass('was-validated')
                $('#tableChild').html('')
                $('#addEvaluador').hide();
            }
        })
    }

}

function eliminar(idEvaluador) {
    let exist = arrayEvaluadores.find(element => {
        return idEvaluador === element.id
    })

    index = arrayEvaluadores.indexOf(exist)
    arrayEvaluadores.splice(index, 1)

    $('#tableChild').html('')

    for (var item of arrayEvaluadores) {
        $('#tableChild').append(`<tr>
                                            <td>${item.nombre}</td>
                                            <td>
                                                <button class="btn btn-danger btn-xs" role="button" title="Eliminar"  onclick = "eliminar(${item.id})" >
                                                     <i class="far fa-trash-alt"></i> 
                                                </button>   
                                            </td>
                                        </tr>`);
    }

}