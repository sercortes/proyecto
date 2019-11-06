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
                    <h3>${EMPRESA.nombreEmpresa}</h3>
                    <h4>${EMPRESA.nitEmpresa}</h4>
                    <p class="card-text">${EMPRESA.razonSocial}</p>
                    <p class="card-text">${EMPRESA.dirreccion}</p>
                    <p class="card-text">${EMPRESA.telefono}</p>
                    <p class="card-text">${EMPRESA.sectorEconomico}</p>
                    <p class="card-text">${EMPRESA.descripcion}</p>
                    <p class="card-text">${EMPRESA.paginaWeb}</p>
                    <p class="card-text">${EMPRESA.tamano.nombre}</p>
                    <p class="card-text">${EMPRESA.tipoEntidad.nombre}</p>
                    <a href="/SavPro/Companys" class="btn btn-primary m-4">
                       <i class="fas fa-arrow-left"></i> Volver
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>



<%@include file="/views/template/footer.jspf"%>  