<%-- 
    Document   : index
    Created on : 10/08/2019, 06:41:15 PM
    Author     : smart
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<title>Error 500</title>
<%@include file="/views/template/head.jspf"%>



<div class="container p-4">
    <div class="row">
        <div class="col-md-8 mx-auto">

            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-danger">Error 500 del Servidor</h6>
                </div>
                
                <p class="text-center p-2">Sentimos las molestias, por favor intentalo nuevamente, si el error persiste contacta al administrador</p>
                    <img class="img-responsive" src="assets/img/error500.png" />
                    
                <div class="card-body">
                    <p>${ERROR}</p>
                   <a href="/SavPro/Home" class="btn btn-danger btn-lg" role="button" aria-pressed="true">
                       <i class="fas fa-fw fa-home"></i> Volver</a>
                </div>
            </div>
                   
 
                   </div>

        </div>
                   
      

    </div>

</div>  