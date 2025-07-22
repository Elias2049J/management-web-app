<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="head.jsp"></jsp:include>
</head>
<body>
    <div class="container">
        <div class="row mt-5 justify-content-center">
            <div class="col-lg-4 col-md-6 col-sm-12">
                <h1 class="text-center">PURCHASE</h1>
                <form action="sale" method="POST">
                    <div class="form-floating mb-3">
                        <select name="selProd" id="" class="form-select">
                            <option value="0">Primor</option>
                            <option value="1">Dulzura</option>
                            <option value="2">Tentacion</option>
                            <option value="3">Explosion</option>
                            <label for="productType">Tipo de Chocolate</label>
                        </select>
                    </div>

                    <div class="form-floating mb-3">
                        <input type="number" class="form-control" min="1" name="txtQuantity" placeholder="Example: 20">
                        <label for="">Quantity</label>
                    </div>

                    <div>
                        <input type="submit" class="btn btn-success w-100" value="processSale">
                    </div>
                </form>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
