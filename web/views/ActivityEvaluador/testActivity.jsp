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
                    <h6 class="m-0 font-weight-bold text-primary">Calificar</h6>
                </div>
                <div class="card-body">

                    <form action="/SavPro/AddActivityE" method="POST" class="needs-validation" novalidate>
                        <input name="idAc" type="hidden" value="${ACTIVIDAD.actividadFormacionId}" maxlength="15">
                        <input name="idEv" type="hidden" value="${ACTIVIDAD.evaluadorId}" maxlength="15">
                        <div class="form-row">
                            
                            <div class="col-md-12 mb-3">
                                <label for="exampleFormControlSelect1">Nota:</label>
                                <select name="nota" class="form-control" id="exampleFormControlSelect1" tabindex="4" required>
                                      <option value="">No</option>
                                      <c:forEach var = "i" begin = "0" end = "100" step="10">

                                        <option value="${i}">${i}</option>
                                            
                                    </c:forEach>
                                </select>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Ingrese la nota del curso
                                </div>
                            </div>
                            

                            <div class="col-md-12 mb-3">
                                <label for="validationCustom02">Describa el curso:</label>
                                <textarea name="descripcion" class="form-control" id="validationCustom04" rows="5" id="comment" maxlength="1000" required></textarea>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Ingrese una descripción
                                </div>
                            </div>

                        </div>
               
                              

                        <button class="btn btn-success float-right" type="submit"><i class="fas fa-paper-plane"></i> Enviar</button>


                    </form>





                </div>
      
            
              <div class="col-lg-12 mb-4">
            <a href="/SavPro/ActivityAprendiz?id=${USER.idUsuario}" class="btn btn-primary m-4">
                <i class="fas fa-arrow-left"></i> Volver
            </a>
        </div>
            </div>

      
                                
        </div>

       

    </div>




</div>

<script src="assets/js/validation.js"></script>

<%@include file="/views/template/footer.jspf"%>  