<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="container">
    <div class="row justify-content-center mt-3">
        <div class="col-sm-12 col-md-6 col-lg-3">
            <h1 class="text-center">LOGIN</h1>

            <form action="login" method="POST">
                <div class="form-floating mb-3">
                    <input class="form-control" type="text" name="txtName" placeholder="" autofocus required>
                    <label>USUARIO</label>
                </div>
                <div class="form-floating mb-3">
                    <input class="form-control" type="password" name="txtPass" placeholder="" required>
                    <label>CONTRASEÑA</label>
                </div>
                <div class="mb-3">
                        <input class="btn btn-success d-block mx-auto" name="btnLogin" type="submit" value="INICIAR SESIÓN">
                </div>
                <div class="mb-3">
                    <a class="btn btn-primary text-decoration-none d-block mx-auto" href="register.jsp">REGISTRARSE</a>
                </div>
            </form>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
