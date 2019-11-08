

 $(window).resize(function() {
    if ($(window).width() < 768) {
            $('#imagen').attr('src', 'assets/img/logo/logoShort.png')
    }else{
         $('#imagen').attr('src', 'assets/img/logo/logo34.png')
    }
  });


$(document).ready(function(){

    
    let estado = false;
    
    
    $('.boton1').click(function (){
       
        ocultar()
         
    })
    
    function ocultar(){
        if (estado) {
            $('#imagen').attr('src', 'assets/img/logo/logo34.png')
            estado = false
        }else{
            $('#imagen').attr('src', 'assets/img/logo/logoShort.png')
            estado = true
        }
    }
    
    
})
