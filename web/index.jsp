
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty USER.perfil}">
    <c:redirect url="/Home"/>
</c:if>

<%@include file="/views/template/head.jspf"%>

<body class="gradient">
    <div class="animated fadeInDown delay-1s">
    <div class="container">
        <div class="container p-4">
            <div class="row">
                <div class="col-md-5 mx-auto">
                    <div class="card text-center">
                        <div class="card-header">
                            <h3><i class="fas fa-sign-in-alt"></i> Ir a SavPro</h3>
                        </div>
                        <div class="card-body">
                            <img src="assets/img/Untitled.png" alt="" class="card-img-top mx-auto m-2 rounded-circle w-50 p-1">
                            <form action="/SavPro/Login" method="POST" class="needs-validation" novalidate>

                                <div class="form-group">
                                    <div class="input-group">
                                    <input name="user" type="email" class="form-control" id="validationCustom01" maxlength="100" placeholder="user@misena.edu.co" required autofocus="true">
                                    <div class="input-group-append">
                                       <button class="btn btn-primary" type="button" id="inputGroupFileAddon04"><i class="far fa-user"></i> </button>
                                    </div>    
                                    <div class="valid-feedback">
                                        Ok
                                    </div>
                                    <div class="invalid-feedback">
                                        Ingrese un Correo válido
                                    </div>
                                </div>
                                </div>

                                <div class="form-group">
                                     <div class="input-group">
                                    <input name="pass" type="password" class="form-control" id="validationCustom02" maxlength="100" placeholder="**********" required>
                                    <div class="input-group-append">
                                       <button class="btn btn-primary" type="button" id="inputGroupFileAddon04"><i class="fas fa-key"></i> </button>
                                    </div> 
                                    <div class="valid-feedback">
                                        Ok
                                    </div>
                                    <div class="invalid-feedback">
                                        Ingrese una contraseña válida
                                    </div>
                                </div>
                                </div>



                                <div class="custom-control custom-checkbox mb-3">
                                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                                    <label class="custom-control-label" for="customCheck1">Recordar Contraseña</label>
                                </div>

                                <c:if test="${not empty MESSAGE}">


                                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                        <strong>Ups!</strong> ${MESSAGE}
                                    </div>
                                </c:if>
                                
                                

                                <div class="form-group">
                                    <button class="btn btn-success btn-block"><i class="fas fa-user-lock"></i> Entrar</button>
                                </div>

                            </form>
                            
                        </div>
                        
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="assets/js/validation_1.js"></script>

