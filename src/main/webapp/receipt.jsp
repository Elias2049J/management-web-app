<%@ page import="org.elias.clase1jsp.dto.PurchaseDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="head.jsp"></jsp:include>
    <%
        PurchaseDTO purchase = (PurchaseDTO) request.getAttribute("purchaseDTO");
    %>
</head>
<body>

<div class="row justify-content-center mt-3">
    <div class="col-sm-12 col-md-6 col-lg-3">
        <h1 class="text-center">SALE RECEIPT</h1>
        <div class="container">
            <div class="table-responsive">
                <table class="table table-bordered table-striped">
                    <thead class="table-dark">
                    <tr>
                        <th>CONCEPTO</th>
                        <th>S/.</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Importe de la compra</td>
                        <td><%= purchase.getRawTotal()%></td>
                    </tr>
                    <tr>
                        <td>Importe del descuento</td>
                        <td><%= purchase.getDiscount()%></td>
                    </tr>
                    <tr>
                        <td>Importe a pagar</td>
                        <td><%= purchase.getFinalTotal()%></td>
                    </tr>
                    <tr>
                        <td>Caramelos de obsequio</td>
                        <td><%= purchase.getCandies()%></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>
    <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
