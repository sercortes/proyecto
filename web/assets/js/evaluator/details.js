function detailsEvaluador(idEvaluador){

    let id = idEvaluador;
    
    console.log(id)
    
    $.ajax({
        type: 'post',
        url: './Evaluatordetails',
        dataType: 'JSON',
        data: {
            id: id
        }
    }).done(function (data){
        console.log(data)
        $('#nombre').val(data.nombres)
        $('#apellido').val(data.apellidos)
        $('#email').val(data.email)
    })
    
}