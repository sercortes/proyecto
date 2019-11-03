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
                    <h6 class="m-0 font-weight-bold text-primary">Agregar Nuevo</h6>
                </div>
                <div class="card-body">

                    <form action="/SavPro/AddProject" method="POST" class="needs-validation" novalidate>
                        <div class="form-row">



                            <div class="col-md-6 mb-3">
                                <label for="validationCustom01">Nombre:</label>
                                <input name="nombre" type="text" class="form-control" id="validationCustom01" maxlength="50" placeholder="nombre proyecto" pattern="[A-Za-z]{3+}" required>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Ingrese un nombre válido
                                </div>
                            </div>

                            <div class="col-md-6 mb-3">
                                <label for="validationCustom02">Contra-partida SENA:</label>
                                <input name="sena" type="text" class="form-control" id="validationCustom02" maxlength="50" placeholder="% sena" required>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Ingrese un % válido
                                </div>
                            </div>
                            
                            
                            <div class="col-md-6 mb-3 mb-3">
                                <label for="exampleFormControlSelect1">Interventor</label>
                                <select name="interventor" class="form-control" id="exampleFormControlSelect1" tabindex="4" required>
                                      <option value="">No</option>
                                    <c:forEach items="${INTERVENTORES}" var="interventores">

                                        <option value="${interventores.idInterventor}">${interventores.nombres}</option>


                                    </c:forEach>
                                </select>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Seleccione el interventor
                                </div>
                            </div>
                            
                    
                                
                            <div class="col-md-6 mb-3 mb-3">
                                <label for="exampleFormControlSelect1">Empresa</label>
                                <select name="empresa" class="form-control" id="exampleFormControlSelect1" tabindex="4" required>
                                      <option value="">No</option>
                                    <c:forEach items="${EMPRESAS}" var="empresas">

                                        <option value="${empresas.idEmpresa}">${empresas.nombreEmpresa}</option>


                                    </c:forEach>
                                </select>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Seleccione la empresa asociada al proyecto
                                </div>
                            </div>
                           

                            <div class="col-md-6 mb-3">

                                <label for="validationCustom04" for="comment">Descipcion:</label>
                                <textarea name="descripcion" class="form-control" id="validationCustom04" rows="5" id="comment" maxlength="1000" required></textarea>

                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Ingrese una descripción válida
                                </div>
                            </div>
                            
                            <div class="col-md-6 mb-3">

                                <label for="validationCustom04" for="comment">Objetivos</label>
                                <textarea name="objetivos" class="form-control" id="validationCustom04" rows="5" id="comment" maxlength="1000" required></textarea>

                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Ingrese los objetivos válidos
                                </div>
                            </div>

                        </div>
                        <div class="form-row">
                            

                        </div>

                        <button class="btn btn-primary" type="submit">Enviar</button>

                    </form>



                </div>
            </div>

        </div>

    </div>

</div>

<script src="assets/js/validation_1.js"></script>

<%@include file="/views/template/footer.jspf"%>  