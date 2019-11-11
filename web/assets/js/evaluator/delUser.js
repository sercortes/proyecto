
function eliminar(e){
    
     alertify.confirm("Desea eliminar el usuario "+e,
                function () {
                    
                    $.ajax({
                        type: "get",
                        url: "./DelUser?id="+e,
                        dataType: "json",
                        success: function (data) {
                            $('#row' + e).remove()
                            alertify.success('usuario eliminado');
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

