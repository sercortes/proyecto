<%-- 
    Document   : index
    Created on : 10/08/2019, 06:41:15 PM
    Author     : smart
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/views/template/head.jspf"%>
<%@include file="/views/template/menu.jspf"%>



<%-- any content can be specified here e.g.: --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="container-fluid">



    <div class="row">

        <div class="col-lg-12 mb-4">


            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Interventores</h6>
                </div>

                <div class="card-body">

                    <form id="formulario1" class="card card-sm needs-validation" novalidate>
                        <div class="card-body row no-gutters align-items-center">
                            <input id="rol" type="hidden" value="${USER.perfil}" />
                            <!--end of col-->
                            <div class="col">
                                <input id="query" name="query" class="form-control form-control-lg form-control-borderless" type="search" placeholder="cargo, centro, nombre o apellidos" required>

                                <div class="valid-feedback">
                                    Ok
                                </div>
                                <div class="invalid-feedback">
                                    Primero escribe la palabra clave para buscar
                                </div>

                            </div>
                            <div class="col-auto">
                                <button id="search" class="btn btn-lg btn-success" type="submit"><i class="fas fa-search" style=""></i> Buscar</button>
                            </div>

                        </div>
                    </form>
                    
                    <div class="col-auto  float-right pb-3 pt-3">
                        <button id="boton" type="button" class="btn btn-primary boton" data-toggle="modal" data-target="#exampleModalCenter">
                            <i class="fas fa-fw fa-plus"></i> Nuevo
                        </button>
                    </div>


                    <table id="examples" class="table table-striped table-bordered table-responsive">
                        <thead class="letrablanca">
                            <tr class="bg-primary">
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Cargo</th>
                                <th>Centro</th>
                                <th>Correo</th>
                                <th>Dirección</th>
                                <th>Telefono</th>
                                <th>Celular</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <tbody id="resTable">




                        </tbody>
                        <tfoot class="letrablanca">
                            <tr class="bg-primary">
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Cargo</th>
                                <th>Centro</th>
                                <th>Correo</th>
                                <th>Dirección</th>
                                <th>Telefono</th>
                                <th>Celular</th>
                                <th>Opciones</th>
                            </tr>
                        </tfoot>
                    </table>
                    <div id="pager">
                        <ul id="pagination" class="pagination-sm"></ul>
                    </div>

                </div>
            </div>

        </div>



    </div>

</div>




<%@include file="/views/interventor/modal.jspf" %>
<%@include file="/views/interventor/modal1.jspf" %>

<%@include file="/views/template/footer.jspf"%>  

<script src="assets/js/pagination/jquery.twbsPagination.min.js"></script>
<script src="assets/js/interventor/interventor.js"></script>
<script src="assets/js/interventor/search.js"></script>
<script src="assets/js/validation.js"></script>



