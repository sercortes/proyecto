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
                    <h6 class="m-0 font-weight-bold text-primary">Proyectos</h6>
                </div>
                <div class="card-body">




                    <div class="col-auto">
                    
                        <a href="/SavPro/NewProject" class="btn btn-primary" role="button">
                       <i class="fas fa-fw fa-plus"></i> Nuevo</a>
                       
                    </div>

                    <br>


                    <div class="table-responsive">
                        <table id="example" class="table table-striped table-bordered">
                            <thead class="letrablanca">
                                <tr class="bg-primary">
                                    <th>Nombre</th>
                                    <th>% SENA</th>
                                    <th>Nombre Empresa</th>
                                    <th>Nombre Interventor</th>                                    
                                    <th>Ver actividades Formación</th>
                                    <th>Opciones</th>
                                </tr>
                            </thead>
                            <c:forEach items="${PROYECTOS}" var="proyectos">
                                <tbody>

                                <tr>
                                    <td>${proyectos.nombre}</td>
                                    <td>${proyectos.copartidaSena}</td>
                                    <td>${proyectos.empresa.nombreEmpresa}</td>
                                    <td>${proyectos.interventor.nombres}</td>
                                    <td class="text-center">
                                      <a href="/SavPro/Activitys?id=${proyectos.idProyecto}" class="btn btn-primary btn-xs" role="button"><i class="fas fa-book"></i></a>
                                    </td>
                                    <td>

                                        <a href="/SavPro/SeeProject?id=${proyectos.idProyecto}" class="btn btn-primary btn-xs" role="button"><i class="far fa-eye"></i></a>
                                        <a href="/SavPro/edithProject?id=${proyectos.idProyecto}" class="btn btn-success btn-xs" role="button"><i class="far fa-edit"></i></a>  
                                        <a href="/SavPro/DeleteProject?id=${proyectos.idProyecto}" class="btn btn-danger btn-xs" role="button" onclick="if (!(confirm('desea eliminar el proyecto')))
                                                    return false"><i class="far fa-trash-alt"></i> 
                                        </a> 
                                        
                                              
                                    </td>

                                </tr>


                                </tbody>
                            </c:forEach>
                            <tfoot class="letrablanca">
                                <tr class="bg-primary">
                                    <th>Nombre</th>
                                    <th>% SENA</th>
                                    <th>Nombre Empresa</th>
                                    <th>Nombre Interventor</th>
                                    <th>Ver actividades Formación</th>
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