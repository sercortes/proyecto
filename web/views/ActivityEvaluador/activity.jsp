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



                    <br>

                    <div class="table-responsive">
                        <table id="example" class="table table-striped table-bordered">
                            <thead class="letrablanca">
                                <tr class="bg-primary">
                                    <th>Nombre</th>
                                    <th>Fecha inicio</th>
                                    <th>Fecha Fin</th>
                                    <th>Sesiones</th>
                                    <th>Calificar</th>
                                </tr>
                            </thead>
                            <c:choose>
                                <c:when test="${fn:length(ACTIVIDADES) > 0}">
                                    <c:forEach items="${ACTIVIDADES}" var="actividades">


                                        <tbody>


                                            <tr>
                                                <td>${actividades.actividadf.nombreActividad}</td>
                                                <td>${actividades.actividadf.fechaInicio}</td>
                                                <td>${actividades.actividadf.fechaFin}</td>
                                                <td>${actividades.actividadf.numeroSesiones}</td>

                                                <td>
                                                    <form action="/SavPro/GradeActivity" method="POST">
                                                        <input type="hidden" name="idActividad" value="${actividades.actividadFormacionId}" />
                                                        <input type="hidden" name="idEvaluador" value="${actividades.evaluadorId}" />
                                                        <button class="btn btn-success" type="submit"><i class="fas fa-paper-plane"></i> Calificar</button>

                                                    </form>
                                                </td>


                                            </tr>


                                        </tbody>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <h1>No tienes calificaciones pendientes</h1>
                                </c:otherwise>
                            </c:choose>


                            <tfoot class="letrablanca">
                                <tr class="bg-primary">
                                    <th>Nombre</th>
                                    <th>Fecha inicio</th>
                                    <th>Fecha Fin</th>
                                    <th>Sesiones</th>   
                                    <th>Calificar</th>
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



