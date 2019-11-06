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
                    <h6 class="m-0 font-weight-bold text-primary">Editar</h6>
                </div>
                <div class="card-body">

                    <form action="/SavPro/EditCompany" method="POST" class="needs-validation" novalidate>
                        <input name="id" type="hidden" value="${EMPRESA.idEmpresa}" maxlength="15">
                        <div class="form-row">



                            <div class="col-md-6 mb-3">
                                <label for="validationCustom01">Nombre:</label>
                                <input name="nombre" value="${EMPRESA.nombreEmpresa}" class="form-control" id="validationCustom01" maxlength="15" placeholder="nombre empresa" pattern="[A-Za-z]{3+}" required>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Ingrese un nombre válido
                                </div>
                            </div>

                            <div class="col-md-6 mb-3">
                                <label for="validationCustom02">Nit:</label>
                                <input name="nit" type="text" value="${EMPRESA.nitEmpresa}" class="form-control" id="validationCustom02" maxlength="15" placeholder="nit empresa" pattern=".{6,}" required>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Ingrese un nit válido
                                </div>
                            </div>

                            <div class="col-md-6 mb-3">
                                <label for="validationCustom01">Dirección:</label>
                                <input name="direccion" type="text" value="${EMPRESA.dirreccion}" class="form-control" id="validationCustom01" maxlength="100" placeholder="dirección empresa" pattern="[A-Za-z]{3+}" required>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Ingrese una dirección válida
                                </div>
                            </div>

                            <div class="col-md-6 mb-3">
                                <label for="validationCustom04">Teléfono</label>
                                <input name="telefono" type="text" value="${EMPRESA.telefono}" class="form-control" id="validationCustom04" maxlength="15" placeholder="telefono" required>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Ingrese un teléfono válido
                                </div>
                            </div>

                            <div class="col-md-6 mb-3">

                                <label for="validationCustom04" for="comment">Descipcion:</label>
                                <textarea name="descripcion" class="form-control" id="validationCustom04" rows="5" id="comment" maxlength="1000" required>${EMPRESA.descripcion}</textarea>

                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Ingrese una descripción válida
                                </div>
                            </div>

                        </div>
                        <div class="form-row">



                            <div class="col-md-6 mb-3 mb-3">
                                <label for="exampleFormControlSelect1">Tipo Entidad</label>
                                <select name="tipoEntidad" class="form-control" id="exampleFormControlSelect1" tabindex="4" required>
                                    <option value="${EMPRESA.tipoEntidad.tipoEntidad}">${EMPRESA.tipoEntidad.nombre}</option>
                                    <c:forEach items="${TIPOENTIDADES}" var="tipoentidades">

                                        <option value="${tipoentidades.tipoEntidad}">${tipoentidades.nombre}</option>


                                    </c:forEach>
                                </select>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Seleccione el tipo de entidad
                                </div>
                            </div>

                            <c:if test="${USER.perfil == 1}">

                                <div class="col-md-6 mb-3 mb-3">
                                    <label for="exampleFormControlSelect1">Usuario</label>
                                    <select name="usuario" class="form-control" id="exampleFormControlSelect1" tabindex="4" required>
                                        <option value="${EMPRESA.usuario.idUsuario}">${EMPRESA.usuario.email}</option>
                                        <c:forEach items="${USUARIOS}" var="usuarios">

                                            <option value="${usuarios.idUsuario}">${usuarios.email}</option>


                                        </c:forEach>
                                    </select>
                                    <div class="valid-feedback">
                                        Correcto
                                    </div>
                                    <div class="invalid-feedback">
                                        Seleccione el usuario

                                    </div>
                                </div>
                            </c:if>

                            <div class="col-md-6 mb-3 mb-3">
                                <label for="exampleFormControlSelect1">Tamaño:</label>
                                <select name="tamano" class="form-control" id="exampleFormControlSelect1" tabindex="4" required>
                                    <option value="${EMPRESA.tamano.idTamano}">${EMPRESA.tamano.nombre}</option>
                                    <c:forEach items="${TAMANOS}" var="tamanos">

                                        <option value="${tamanos.idTamano}">${tamanos.nombre}</option>


                                    </c:forEach>

                                </select>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Seleccione un tamaño
                                </div>
                            </div>

                            <div class="col-md-6 mb-3">
                                <label for="validationCustom03">Sector économico</label>
                                <input name="sector" type="text" value="${EMPRESA.sectorEconomico}" class="form-control" id="validationCustom03" maxlength="20" placeholder="Sector de la empresa" required>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Ingrese una sector.
                                </div>
                            </div>

                            <div class="col-md-6 mb-3">
                                <label for="validationCustom03">Página Web:</label>
                                <input name="page" type="text" value="${EMPRESA.paginaWeb}" class="form-control" id="validationCustom03" maxlength="50" placeholder="www.mycompany.co" required>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Ingrese la pagina.
                                </div>
                            </div>

                            <div class="col-md-6 mb-3">
                                <label for="validationCustom03">Razón social:</label>
                                <input name="razon" type="text" value="${EMPRESA.razonSocial}" class="form-control" id="validationCustom03" maxlength="50" placeholder="razón social empresa" required>
                                <div class="valid-feedback">
                                    Correcto
                                </div>
                                <div class="invalid-feedback">
                                    Ingrese la razón social por favor.
                                </div>
                            </div>

                        </div>

                        <button class="btn btn-success float-right" type="submit"><i class="fas fa-paper-plane"></i> Enviar</button>


                    </form>





                </div>
      
            
              <div class="col-lg-12 mb-4">
            <a href="/SavPro/Companys" class="btn btn-primary m-4">
                <i class="fas fa-arrow-left"></i> Volver
            </a>
        </div>
            </div>

      
                                
        </div>

       

    </div>




</div>

<script src="js/validation.js"></script>

<%@include file="/views/template/footer.jspf"%>  