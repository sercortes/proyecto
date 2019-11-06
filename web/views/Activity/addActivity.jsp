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

                    <form onsubmit="addFunction()" class="needs-validation" novalidate>
                        <div class="form-row">

                            <input id="idProyecto" name="id" type="hidden" value="${PROYECTO.idProyecto}" class="form-control" required>


                            <div class="col-md-6 mb-3">
                                <label for="validationCustom01">Nombre Actividad:</label>
                                <input name="nombre" type="text" class="form-control" id="nombre" maxlength="50" placeholder="Nombre actividad formación" required>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Ingrese un nombre válido
                                </div>
                            </div>

                            <div class="col-md-6 mb-3">
                                <label for="validationCustom02">Número de sesiones:</label>
                                <input name="sesiones" type="number" class="form-control" id="sesiones" maxlength="30" placeholder="# sesiones" required>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                            </div>



                            <div class="col-md-6 mb-3">
                                <label for="validationCustom04">Fecha Inicio</label>
                                <input name="fechaInicio" type="date" class="form-control" id="fechaInicio" maxlength="30" placeholder="telefono" required>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Selecione una fecha
                                </div>
                            </div>

                            <div class="col-md-6 mb-3">
                                <label for="validationCustom04">Fecha Fin</label>
                                <input name="fechaFin" type="date" class="form-control" id="fechaFin" maxlength="30" placeholder="telefono" required>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Selecione una fecha
                                </div>
                            </div>


                            <div class="dropdown-divider"></div>


                            <div class="col-md-6 mb-3 mb-3">
                                <label for="exampleFormControlSelect1">Evaluadores</label>
                                <div class="input-group">
                                    <select name="evaluador" class="form-control" id="evaluador" tabindex="4" required>
                                        <option value="">No</option>
                                        <c:forEach items="${EVALUADORES}" var="evaluadores">
                                            <option value="${evaluadores.idUsuario}">${evaluadores.nombre}</option>
                                        </c:forEach>
                                    </select>
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button" id="addEvaluador"><i class="fa fa-plus"></i> Agregar</button>
                                    </div>

                                    <div class="valid-feedback">
                                        Correcto
                                    </div>
                                    <div class="invalid-feedback">
                                        Seleccione el usuario
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6 mb-3 mb-3">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th scope="col">Nombre</th>
                                            <th scope="col">Opciones</th>
                                        </tr>
                                    </thead>
                                    <tbody id="tableChild">
                                        
                                    </tbody>
                                </table>
                            </div>

                        </div>



                        <div class="dropdown-divider"></div>


                        <button class="btn btn-success float-right" type="submit"><i class="fas fa-paper-plane"></i> Enviar</button>

                    </form>



                </div>

                <div class="col-lg-12 mb-4">
                    <a href="/SavPro/Activitys?id=${PROYECTO.idProyecto}" class="btn btn-primary m-4">
                        <i class="fas fa-arrow-left"></i> Volver
                    </a>
                </div>

            </div>

        </div>

    </div>

</div>


<%@include file="/views/template/footer.jspf"%>  
<script src="assets/js/evaluator/addEvaluator.js"></script>
<script src="assets/js/validation.js"></script>