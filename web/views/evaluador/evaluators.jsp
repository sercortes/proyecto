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
                    <h6 class="m-0 font-weight-bold text-primary">Evaluadores</h6>
                </div>

                <div class="card-body">

                    <div class="col-auto">
                        <button id="boton" type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModalCenter">
                            <i class="fas fa-fw fa-plus"></i> Nuevo
                        </button>
                    </div>

                    <input id="idd" type="hidden" value="${ID}" maxlength="15">

                    <div class="dropdown-divider"></div>


                    <div id="tabla" class="table-responsive">

                    </div>




<!--
<table id="employee" class="table table-bordered table table-hover" cellspacing="0" width="100%">
                    <colgroup><col><col><col></colgroup>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th >Salary</th>
                            <th>Age</th>
                        </tr>
                    </thead>
                    <tbody id="emp_body">
                    </tbody>
                </table>
                <div id="pager">
                    <ul id="pagination" class="pagination-sm"></ul>
                </div>
-->




                </div>
            </div>

        </div>



    </div>

</div>




<%@include file="/views/evaluador/modal.jspf" %>
<%@include file="/views/evaluador/modal1.jspf" %>

<%@include file="/views/template/footer.jspf"%>  

<script src="assets/js/evaluator/addAjax.js"></script>
<script src="assets/js/evaluator/delUser.js"></script>
<script src="assets/js/evaluator/pagination.js"></script>
<script src="assets/js/validation.js"></script>
<script src="assets/js/pagination/jquery.twbsPagination.min.js"></script>



