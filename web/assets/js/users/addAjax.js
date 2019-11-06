$(document).ready(function () {

    listar()

    $("#boton").click(function () {

        $.ajax({
            type: "GET",
            url: './AddUser',
            datatype: 'json'
        }).done(function (data) {

            select = document.getElementById('perfil');
            let str = '<option value="">No</option>'

            for (var item of data) {
                str += "<option value=" + item.idPerfil + ">" + item.nombre + "</option>"
            }
            select.innerHTML = str;
        })

    });

    $('#exampleModalCenter').on('hidden.bs.modal', function (e) {
        listar()
    })

    $('#exampleModal').on('hidden.bs.modal', function (e) {
        listar()
    })

});

function listar() {
    $.ajax({
        type: "GET",
        url: './ListUsers',
        datatype: 'json'
    }).done(function (data) {

        select = document.getElementById('tabla');
        let str = `<table id="examples" class="table table-striped table-bordered">
                                <thead class="letrablanca">
                                    <tr class="bg-primary">
                                        <th>Correo</th>
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th>Clave</th>
                                        <th>Rol</th>
                                        <th>Estado</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                            <tbody>
                                                 `

        for (var item of data) {
            str += `<tr id="row${item.idUsuario}">
                                                    <td>${item.email}</td>
                                                    <td>${item.nombre}</td>
                                                    <td>${item.apellido}</td>
                                                    <td>${item.password}</td>
                                                    <td>${item.perfilUsuario.nombre}</td>
                                                    <td>${item.estado}</td>
                                                    <td>
                                                        <button class="btn btn-success btn-xs" role="button" onclick = "editar(${item.idUsuario})">
                                                            <i class="far fa-edit"></i>
                                                        </button>
                                                        
                                                      <button class="btn btn-danger btn-xs" role="button" onclick = "eliminar(${item.idUsuario})" >
                                                            <i class="far fa-trash-alt"></i> 
                                                        </button>           
                                                </td>
                                                </tr> `
        }

        str += `      </tbody>
                                <tfoot class="letrablanca">
                                    <tr class="bg-primary">
                                        <th>Correo</th>
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th>Clave</th>
                                        <th>Rol</th>
                                        <th>Estado</th>
                                        <th>Opciones</th>
                                    </tr>
                                </tfoot>
                            </table>`

        select.innerHTML = str;
    })
}

function myFunction() {
    let name = $('#nombre').val();
    let ape = $('#apellido').val();
    let email = $('#email').val();
    let password = $('#password').val();
    let perfil = $('#perfil').val();
    let estado = $('#estado').val();
    if (name == "" || ape == "" ||
            email == "" || password == "" ||
            perfil == "" || estado == "") {

        alertify.alert('Complete el formulario')
    } else {

        $.ajax({
            type: "post",
            url: "./NewUser",
            data: {
                name: name,
                ape: ape,
                email: email,
                password: password,
                perfil: perfil,
                estado: estado
            }
        }).done(function (data) {
            var res = JSON.parse(data);
            if (res.localeCompare("ok") === 0) {
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
    let id = $('#id').val();
    let name = $('#nombreE').val();
    let ape = $('#apellidoE').val();
    let email = $('#emailE').val();
    let perfil = $('#perfilE').val();
    let estado = $('#estadoE').val();
    if (name == "" || ape == "" || 
            perfil == "" || estado == "") {

        alertify.alert('Complete el formulario')
    } else {

        $.ajax({
            type: "post",
            url: "./SaveUser",
            data: {
                id: id,
                name: name,
                ape: ape,
                email: email,
                perfil: perfil,
                estado: estado
            }
        }).done(function (data) {
            console.log(data)
            var res = JSON.parse(data);
            if (res.localeCompare("ok") === 0) {
                alertify.success('Editado')
            } else {
                alertify.error('Ups ocurrio un error')
            }
        });

    }
}

function editar(e) {


    $('#exampleModal').modal('show');

    $.ajax({
        type: "GET",
        url: './loadUser?id=' + e,
        datatype: 'json'
    }).done(function (data) {

        console.log(data)

        $('#id').val(data.idUsuario)
        $('#nombreE').val(data.nombre)
        $('#apellidoE').val(data.apellido)
        $('#emailE').val(data.email)
        $('#perfilE').val(data.perfil)
        $('#estadoE').val(data.estado)
        
        select = document.getElementById('perfilE');
            let str = `<option value="${data.perfilUsuario.idPerfil}">${data.perfilUsuario.nombre}</option>`

            for (var item of data.lista) {
                if(item.idPerfil != data.perfilUsuario.idPerfil){
                    str += "<option value=" + item.idPerfil + ">" + item.nombre + "</option>"
                }
                
            }
            select.innerHTML = str;


    })

}
      