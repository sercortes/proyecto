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
                    <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
                </div>

                <div class="card-body">

                    <div class="row float-right pb-4">
                    <div class="col-auto">
                        <button id="boton" type="button" class="btn btn-primary float-right" data-toggle="modal" data-target="#exampleModalCenter">
                            <i class="fas fa-fw fa-plus"></i> Nuevo
                        </button>
                    </div>
                        </div>

                    <div id="tabla" class="table-responsive">
                        
                    </div>



                </div>
            </div>

        </div>



    </div>

</div>




<%@include file="/views/users/modal.jspf" %>
<%@include file="/views/users/modal1.jspf" %>

<%@include file="/views/template/footer.jspf"%>  

<script src="assets/js/users/addAjax.js"></script>
<script src="assets/js/users/delUser.js"></script>
<script src="assets/js/validation.js"></script>



