

// $(window).resize(function() {
//    if ($(window).width() < 768) {
//      $('#imagen').hide()
//    }else{
//       $('#imagen').show()
//       .attr("src","http://dummyimage.com/250x155/")
//    }
//  });


$(document).ready(function(){

    
    let estado = false;
    
    
    $('.boton1').click(function (){
       
        ocultar()
         
    })
    
    function ocultar(){
        if (estado) {
            $('#imagen').show()
            estado = false
        }else{
            $('#imagen').hide()
            estado = true
        }
    }
    
    
})
