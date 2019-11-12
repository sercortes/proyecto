

$(document).ready(function () {
    
    listar()
    
    $('#exampleModalCenter').on('hidden.bs.modal', function (e) {
      listar()
    })

    $('#exampleModal').on('hidden.bs.modal', function (e) {
      listar()
    })
    
    
    
$('#boton').click(function (){
   
   $.ajax({
            type: 'get',
            url: './formInterventor',
            dataType: 'json'
   }).done(function (data){
      
      
      selectCentro = document.getElementById('centro')
      let str = '<option value="">No</option>'
      
      for(var item of data.listacentro){
          str += "<option value=" + item.id + ">" + item.nombre + "</option>"
      }
      
      selectCentro.innerHTML = str;
      
      selectCargo = document.getElementById('cargo')
      str = '<option value="">No</option>';
      
      for(var item of data.listaCargo){
              str += "<option value=" + item.id + ">" + item.nombre + "</option>"
      }
      
      selectCargo.innerHTML = str;
   
   })
   
})



function generate_table(data) {
    var table = $('#resTable').html('');

    for (var item of data) {
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


   

function listar() {

   

    $.ajax({
        url: "./listIntervertors",
        type: "GET",
        dataType: 'json',
        success: function (data) {
                generate_table(data)
        }
    });

}


});

function editar(e) {


    $('#exampleModal').modal('show');


    $.ajax({
        type: "get",
        url: './formEditInterventor',
        data:{
            id:e
        },
        datatype: 'json'
    }).done(function (data) {

        console.log(data)
        
        $('#idE').val(data.idInterventor)
        
        $('#nombreE').val(data.nombres)
        $('#apellidoE').val(data.apellidos)
        $('#telefonoE').val(data.telefono)
        $('#correoE').val(data.correo)
        $('#direccionE').val(data.direccion)
        $('#celularE').val(data.telefonoCelular)
        

      selectCentro = document.getElementById('centroE')
      let str = `<option value="${data.centroFormacion.id}">${data.centroFormacion.nombre}</option>`
      for (var item of data.listacentro) {
                if(item.id != data.centroFormacion.id){
                    str += "<option value=" + item.id + ">" + item.nombre + "</option>"
                }
                
            }
      selectCentro.innerHTML = str;
       
      selectCargo = document.getElementById('cargoE')
      str = `<option value="${data.cargoInterventor.id}">${data.cargoInterventor.nombre}</option>`
        for (var item of data.listaCargo) {
                if(item.id != data.cargoInterventor.id){
                    str += "<option value=" + item.id + ">" + item.nombre + "</option>"
                }
                
            }
      selectCargo.innerHTML = str;

    })

}

function myFunctionAdd() {
    
        let nombre = $('#nombre').val()
        let apellido = $('#apellido').val()
        let telefono = $('#telefono').val()
        let correo = $('#correo').val()
        let direccion = $('#direccion').val()
        let celular = $('#celular').val()
        
        let cargo = $('#cargo').val();
        let centro = $('#centro').val();
        
    if (nombre == "" || apellido == "" || 
            telefono == "" || correo == "" || direccion == "" || celular == "") {
        alertify.alert('Complete el formulario')
    }else {

        $.ajax({
            type: "get",
            url: "./addInterventor",
            dataType: 'json',
            data: {
                nombre: nombre,
                apellido: apellido,
                telefono: telefono,
                correo: correo,
                direccion: direccion,
                celular: celular,
                cargo: cargo,
                centro:centro
            }
        }).done(function (data) {
            console.log(data)
            if (data.localeCompare("ok") === 0) {
               alertify.success('Agregado')
                $('#formulario')[0].reset()
                $('#formulario').removeClass('was-validated');
            } else {
                alertify.error('Ups ocurrio un error')
            }
        });

    }
}


function myFunctionEdit() {
        
        let id = $('#idE').val()
        let nombre = $('#nombreE').val()
        let apellido = $('#apellidoE').val()
        let telefono = $('#telefonoE').val()
        let correo = $('#correoE').val()
        let direccion = $('#direccionE').val()
        let celular = $('#celularE').val()
        
        let cargo = $('#cargoE').val();
        let centro = $('#centroE').val();
        
    if (nombre == "" || apellido == "" || 
            telefono == "" || correo == "" || direccion == "" || celular == "") {
        alertify.alert('Complete el formulario')
    } else {

        $.ajax({
            type: "get",
            url: "./updateInterventor",
            dataType: 'json',
            data: {
                id: id,
                nombre: nombre,
                apellido: apellido,
                telefono: telefono,
                correo: correo,
                direccion: direccion,
                celular: celular,
                cargo: cargo,
                centro:centro
            }
        }).done(function (data) {
            console.log(data)
            if (data.localeCompare("ok") === 0) {
                alertify.success('Editado')
            } else {
                alertify.error('Ups ocurrio un error')
            }
        });

    }
}


