

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
           // $('#imagen').show()
           document.getElementById('imagen').src='assets/img/logo/logoShort.png'
           // $('#imagen').src='pic_bulboff.gif'
            estado = false
        }else{
          //  $('#imagen').hide()
         // document.getElementById('imagen').src='assets/img/logo/logo3.png'
           // $('#imagen').src='pic_bulboff.gif'
            $('#imagen').addClass("imagen1");
            estado = true
        }
    }
    
    
})
