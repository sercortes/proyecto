<%-- 
    Document   : index
    Created on : 10/08/2019, 06:41:15 PM
    Author     : smart
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/views/template/head.jspf"%>
<%@include file="/views/template/menu.jspf"%>



<div class="container p-4">
    <div class="row">
        <div class="col-md-12 mx-auto">
            <div class="card text-left">
                <div class="card-body">
                   <a href="/SavPro/Activitys?&id=${PROYECTO.idProyecto}" class="btn btn-info btn-xs float-right" role="button">Ver Actividades de Formación <i class="fas fa-book"></i></a>
                    <h4>${PROYECTO.nombre}</h4>
                    <p class="card-text">${PROYECTO.copartidaSena}</p>
                    <p class="card-text">${PROYECTO.descripcion}</p>
                    <p class="card-text">${PROYECTO.objetivos}</p>
                    <p class="card-text">${PROYECTO.empresa.nombreEmpresa}</p>
                    <p class="card-text">${PROYECTO.interventor.nombres}</p>
                    
                    <a href="/SavPro/Projects" class="btn btn-primary m-4"><i class="fas fa-file-alt"></i> Ver otros proyectos</a>
                </div>
            </div>
        </div>
    </div>
</div>



<%@include file="/views/template/footer.jspf"%>  