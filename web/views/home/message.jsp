<%-- 
    Document   : index
    Created on : 10/08/2019, 06:41:15 PM
    Author     : smart
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="/views/template/head.jspf"%>
<%@include file="/views/template/menu.jspf"%>



<div class="container-fluid">

    <div class="row">

        <div class="col-lg-12 mb-4">

            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Mensaje</h6>
                </div>
                <div class="card-body">
                    <c:choose>
                        <c:when test="${MSG == 0}">
                            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                <strong>Error!</strong> La operación no fué realizada correctamente.
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </c:when>
                        <c:when test="${MSG == 1}">
                            <div class="alert alert-success alert-dismissible fade show" role="alert">
                                <strong>Ok!</strong> La operación fué realizada correctamente.
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </c:when>

                    </c:choose>

                    <div class="dropdown-divider"></div>
                    <div class="col-auto">
                        <a href="${URL}" class="btn btn-success" role="button">
                            <i class="fas fa-fw fa-plus"></i> Volver</a>
                    </div>
                </div>
            </div>

        </div>


    </div>

</div>



<%@include file="/views/template/footer.jspf"%>  



