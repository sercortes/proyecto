<%-- 
    Document   : index
    Created on : 10/08/2019, 06:41:15 PM
    Author     : smart
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/views/template/head.jspf"%>
<%@include file="/views/template/menu.jspf"%>



<div class="container-fluid">

    <div class="row">

        <div class="col-lg-12 mb-4">

            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Bienvenidos</h6>
                </div>
                <div class="card-body">
                    <p>Sistema de gestión de proyecto SAV PRO</p>
                    <p>Bienvenido ${USER.nombre}</p>
                    <c:choose>

                        <c:when test="${USER.perfil == 3}">

                            <p class="font-weight-bold">Por favor califica las actividades  de formación para que puedas certificarte</p>
                            <a href="/SavPro/ActivityAprendiz?id=${USER.idUsuario}" class="btn btn-danger" role="button">
                                <i class="fas fa-exclamation-circle"></i> Calificar Actividades de formación</a>

                        </c:when>
                             <c:when test="${USER.perfil == 3}">

                            <p class="font-weight-bold">No tienes calificaciones pendientes</p>

                        </c:when>
                        <c:otherwise>
                            
                            
                        </c:otherwise>
                    </c:choose>
                            
          <div class="row">


            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-success text-uppercase mb-1">Proyectos</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">34</div>
                    </div>
                    <div class="col-auto">
                                                <i class="fas fa-paste fa-2x orange"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-info shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Calificaciones</div>
                      <div class="row no-gutters align-items-center">
                        <div class="col-auto">
                          <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">139</div>
                        </div>
                        <div class="col">
                          <div class="progress progress-sm mr-2">
                            <div class="progress-bar bg-info" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-auto">
                        <i class="fas fa-check-double fa-2x text-success"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- Pending Requests Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-danger shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">Fecha límite</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">8</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-calendar fa-2x text-warning"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

                            

                </div>
            </div>

        </div>


    </div>

</div>



<%@include file="/views/template/footer.jspf"%>  



