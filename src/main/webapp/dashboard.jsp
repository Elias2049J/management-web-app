<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.elias.clase1jsp.controller.LoginServlet" %>
<html>
<jsp:include page="head.jsp"></jsp:include>
    <body>
    <div class="table-responsive">
        <table class="table table-striped table-bordered">
            <thead>
            <tr class="table-dark">
                <th scope="col">#</th>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">Handle</th>
                <th scope="col">Editar</th>
                <th scope="col">Eliminar</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
                <td class="text-center">
                    <i class="bi bi-pencil-square text-primary" role="button"></i>
                </td>
                <td class="text-center">
                    <i class="bi bi-trash text-danger" role="button"></i>
                </td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
                <td class="text-center">
                    <i class="bi bi-pencil-square text-primary" role="button"></i>
                </td>
                <td class="text-center">
                    <i class="bi bi-trash text-danger" role="button"></i>
                </td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td colspan="2">Larry the Bird</td>
                <td>@twitter</td>
                <td class="text-center">
                    <i class="bi bi-pencil-square text-primary" role="button"></i>
                </td>
                <td class="text-center">
                    <i class="bi bi-trash text-danger" role="button"></i>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
