<%-- 
    Document   : index
    Created on : 10/08/2019, 06:41:15 PM
    Author     : smart
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/views/template/head.jspf"%>
<%@include file="/views/template/menu.jspf"%>



<div class="container-fluid">

    <div class="row">

        <div class="col-lg-12 mb-4">

            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Agregar Nueva</h6>
                </div>
                <div class="card-body">

                    <form action="/SavPro/UpdateActivity" method="POST" class="needs-validation" novalidate>
                        <div class="form-row">

                            <input name="id" type="hidden" value="${ACTIVIDAD.idActividad}" class="form-control" required>


                            <div class="col-md-6 mb-3">
                                <label for="validationCustom01">Nombre Actividad:</label>
                                <input name="nombre" value="${ACTIVIDAD.nombreActividad}" type="text" class="form-control" id="validationCustom01" maxlength="50" placeholder="Nombre actividad formación" required>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Ingrese un nombre válido
                                </div>
                            </div>

                            <div class="col-md-6 mb-3">
                                <label for="validationCustom02">Número de sesiones:</label>
                                <input name="sesiones"  value="${ACTIVIDAD.numeroSesiones}" type="number" class="form-control" id="validationCustom02" maxlength="30" placeholder="# sesiones" required>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                            </div>

                         

                            <div class="col-md-6 mb-3">
                                <label for="validationCustom04">Fecha Inicio</label>
                                <input name="fechaInicio" value="${ACTIVIDAD.fechaInicio}" type="date" class="form-control" id="validationCustom04" maxlength="30" placeholder="telefono" required>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Selecione una fecha
                                </div>
                            </div>
                            
                            <div class="col-md-6 mb-3">
                                <label for="validationCustom04">Fecha Fin</label>
                                <input name="fechaFin" value="${ACTIVIDAD.fechaFin}" type="date" class="form-control" id="validationCustom04" maxlength="30" placeholder="telefono" required>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Selecione una fecha
                                </div>
                            </div>
                              </div>                      
                        

                        <button class="btn btn-success float-right" type="submit"><i class="fas fa-paper-plane"></i> Enviar</button>

                    </form>



                </div>
                
                 <div class="col-lg-12 mb-4">
            <a href="${URL}" class="btn btn-primary m-4">
                <i class="fas fa-arrow-left"></i> Volver
            </a>
        </div>
                
            </div>

        </div>

    </div>

</div>

<script src="assets/js/validation.js"></script>

<%@include file="/views/template/footer.jspf"%>  