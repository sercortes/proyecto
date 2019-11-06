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
                    <h6 class="m-0 font-weight-bold text-primary">Calificaciones</h6>
                </div>
                <div class="card-body">



                    <br>

                    <div class="table-responsive">
                        <table id="example" class="table table-striped table-bordered">
                            <thead class="letrablanca">
                                <tr class="bg-primary">
                                    <th>Nota</th>
                                    <th>Descripción</th>
                                    <th>fecha Evaluación</th>
                                    <th>Evaluador</th>
                                </tr>
                            </thead>
                            <c:choose>
                                <c:when test="${fn:length(ACTIVIDADES) > 0}">
                                    <c:forEach items="${ACTIVIDADES}" var="actividades">


                                        <tbody>


                                            <tr>
                                         
                                         <td>${actividades.nota}</td>
                                         
                                         <c:if test="${actividades.nota == null}">
                                            <p class="text-danger">No ha sido calificada</p>
                                         </c:if>
                                            
                                        <td>${actividades.descripcion}</td>
                                        <td>${actividades.fechaEvaluacion}</td>
                                                
                                        

                                        <td>
                                            <form action="/SavPro/Evaluatordetails" method="POST">
                                                <input type="hidden" name="idEvaluador" value="${actividades.evaluadorId}" />
                                                <button class="btn btn-success" type="submit"><i class="far fa-eye"></i> Ver</button>

                                            </form>
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
                                    <th>Nota</th>
                                    <th>Descripción</th>
                                    <th>fecha Evaluación</th>
                                    <th>Evaluador</th>
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



