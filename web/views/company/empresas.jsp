<%-- 
    Document   : index
    Created on : 10/08/2019, 06:41:15 PM
    Author     : smart
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/views/template/head.jspf"%>
<%@include file="/views/template/menu.jspf"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="container-fluid">



    <div class="row">

        <div class="col-lg-12 mb-4">

                <div>
                   


                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Empresas</h6>
                    </div>
                    <div class="card-body">

                         <form action="/SavPro/SearchCompany" method="POST" class="card card-sm needs-validation" novalidate>
                        <div class="card-body row no-gutters align-items-center">
                            <input type="hidden" name="action" value="search" />
                            <!--end of col-->
                            <div class="col">
                                <input id="validationCustom01" name="query" class="form-control form-control-lg form-control-borderless" type="search" placeholder="nombre, descripción o sector económico" required>

                                <div class="valid-feedback">
                                    Ok
                                </div>
                                <div class="invalid-feedback">
                                    Primero escribe la palabra clave para buscar
                                </div>

                            </div>
                            <div class="col-auto">
                                <button class="btn btn-lg btn-success" type="submit"><i class="fas fa-search" style=""></i> Buscar</button>
                            </div>

                        </div>
                    </form>

             <hr class="sidebar-divider">

                        <div class="col-auto float-right pb-3">
                            <a href="/SavPro/AddCompany" class="btn btn-primary" role="button">
                                <i class="fas fa-fw fa-plus"></i> Nuevo</a>

                        </div>

                        <br>


                        <div class="table-responsive">
                            <table id="example" class="table table-striped table-bordered">
                                <thead class="letrablanca">
                                    <tr class="bg-primary">
                                        <th>Nombre</th>
                                        <th>Nit</th>
                                        <th>Dirección</th>
                                        <th>Telefono</th>
                                        <th>Sector económico</th>
                                        <th>Página Web</th>
                                        <th>Tipo</th>
                                        <th>Evaluadores</th>
                                        <th>Opciones</th>
                                    </tr>
                                </thead>
                                <c:choose>
                                    <c:when test="${fn:length(EMPRESAS) > 0}">
                                        <c:forEach items="${EMPRESAS}" var="empresas">

                                            <tbody>


                                                <tr>
                                                    <td>${empresas.nombreEmpresa}</td>
                                                    <td>${empresas.nitEmpresa}</td>
                                                    <td>${empresas.dirreccion}</td>
                                                    <td>${empresas.telefono}</td>
                                                    <td>${empresas.sectorEconomico}</td>
                                                    <td>${empresas.paginaWeb}</td>
                                                    <td>${empresas.tipoEntidad.nombre}</td>
                                                      <td class="text-center">
                                                          <a href="/SavPro/Evaluators?id=${empresas.idEmpresa}" class="btn btn-primary btn-xs" role="button"><i class="fas fa-user-shield"></i></a>
                                    </td>
                                                    <td>

                                                        <a href="/SavPro/Company?id=${empresas.idEmpresa}" class="btn btn-info btn-xs" role="button"><i class="far fa-eye"></i></a>

                                                        <a href="/SavPro/EditCompany?id=${empresas.idEmpresa}" class="btn btn-warning btn-xs" role="button"><i class="far fa-edit"></i></a>

                                                


                                                            <a href="/SavPro/DelCompany?id=${empresas.idEmpresa}" class="btn btn-danger btn-xs" role="button" onclick="if (!(confirm('desea eliminar la empresa')))
                                                                    return false"><i class="far fa-trash-alt"></i> </a> 
                                                              

                                                    </td>

                                                </tr>


                                            </tbody>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <h1>No hay registros</h1>
                                    </c:otherwise>
                                </c:choose>


                                <tfoot class="letrablanca">
                                    <tr class="bg-primary">
                                        <th>Nombre</th>
                                        <th>Nit</th>
                                        <th>Dirección</th>
                                        <th>Telefono</th>
                                        <th>Sector económico</th>
                                        <th>Página Web</th>
                                        <th>Tipo</th>
                                        <th>Evaluadores</th>
                                        <th>Opciones</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>



                    </div>
                </div>

            </div>



        </div>

    </div>


    <%@include file="/views/template/footer.jspf"%>  
    
    <script src="assets/js/validation.js"></script>
