<%-- 
    Document   : index
    Created on : 10/08/2019, 06:41:15 PM
    Author     : smart
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/views/template/head.jspf"%>
<%@include file="/views/template/menu.jspf"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="container-fluid">



    <div class="row">

        <div class="col-lg-12 mb-4">


            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Actividades de formación</h6>
                </div>
                <div class="card-body">



                    <div class="col-auto">
                        <a href="/SavPro/AddActivity?id=${PROYECTO.idProyecto}" class="btn btn-primary" role="button">
                            <i class="fas fa-fw fa-plus"></i> Nueva</a>
                        <a href="/SavPro/SeeProject?id=${PROYECTO.idProyecto}" class="btn btn-info btn-xs" role="button">Ver Proyecto <i class="fas fa-file-alt"></i></a>
                    </div>
                    <br>

                    <div class="table-responsive">
                        <table id="example" class="table table-striped table-bordered">
                            <thead class="letrablanca">
                                <tr class="bg-primary">
                                    <th>Nombre</th>
                                    <th>Fecha inicio</th>
                                    <th>Fecha Fin</th>
                                    <th>Sesiones</th>
                                    <th>Ver calificaciones</th>
                                    <th>Opciones</th>
                                </tr>
                            </thead>
                            <c:choose>
                                <c:when test="${fn:length(ACTIVIDADES) > 0}">
                                    <c:forEach items="${ACTIVIDADES}" var="actividades">


                                        <tbody>


                                            <tr>
                                                <td>${actividades.nombreActividad}</td>
                                                <td>${actividades.fechaInicio}</td>
                                                <td>${actividades.fechaFin}</td>
                                                <td>${actividades.numeroSesiones}</td>
                                                <td>
                                                    <a href="/SavPro/GradeActivitys?id=${actividades.idActividad}" class="btn btn-primary btn-xs" role="button">
                                                        <i class="far fa-eye"></i></a>

                                                </td>
                                               
                                                <td>
                                                    <a href="/SavPro/EditActivity?id=${actividades.idActividad}" class="btn btn-warning btn-xs" role="button"><i class="far fa-edit"></i></a>
                                                    
                                                    <a href="/SavPro/DelActivity?id=${actividades.idActividad}" class="btn btn-danger btn-xs" role="button" onclick="if (!(confirm('desea eliminar la actividad de formacion')))
                                                                return false"><i class="fas fa-trash"></i></a>

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
                                    <th>Fecha inicio</th>
                                    <th>Fecha Fin</th>
                                    <th>Sesiones</th>   
                                    <th>Ver calificaciones</th>
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



