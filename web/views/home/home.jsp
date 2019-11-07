<%-- 
    Document   : index
    Created on : 10/08/2019, 06:41:15 PM
    Author     : smart
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/views/template/head.jspf"%>
<%@include file="/views/template/menu.jspf"%>



<div class="container-fluid">

    <div class="row">

        <div class="col-lg-12 mb-4">

            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Bienvenidos</h6>
                </div>
                <div class="card-body">
                    <p>Sistema de gestión de proyecto SAV PRO</p>
                    <p>Bienvenido ${USER.nombre}</p>
                    <c:choose>

                        <c:when test="${USER.perfil == 3}">

                            <p class="font-weight-bold">Por favor califica las actividades  de formación para que puedas certificarte</p>
                            <a href="/SavPro/ActivityAprendiz?id=${USER.idUsuario}" class="btn btn-danger" role="button">
                                <i class="fas fa-exclamation-circle"></i> Calificar Actividades de formación</a>

                        </c:when>
                             <c:when test="${USER.perfil == 3}">

                            <p class="font-weight-bold">No tienes calificaciones pendientes</p>

                        </c:when>
                        <c:otherwise>
                            
                            
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>

        </div>


    </div>

</div>



<%@include file="/views/template/footer.jspf"%>  



