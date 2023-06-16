<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Giỏ hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<header>
    <%@include file="layout/header.jsp" %>
</header>
<div class="container">
    <h1>Buy</h1>
    <div class="row">
        <div class="col-lg-7">
            <form:form action="/buy" method="post" modelAttribute="bill">
                Phone Number: <form:input path="phoneNumber" class="form-control"/>
                <form:errors path="phoneNumber" cssStyle="color: red"/>
                <br>
                Address: <form:input path="adrress" class="form-control"/>
                <form:errors path="adrress" cssStyle="color: red"/>
                <br>
                <form:button type="submit" class="btn btn-success" id="addButton">Buy</form:button>
            </form:form>
        </div>
        <div class="col-lg-5">
            <h1>Sản phẩm</h1>
            <table class="table">
                <tr>
                    <th>Sản phẩm</th>
                    <th>Giá Bán</th>
                    <th>Thành Tiền</th>
                </tr>
                <tr>
                    <td>${billProduct.productDetails.name}</td>
                    <td><b>$${billProduct.productDetails.category.productLine.price}</b></td>
                    <td><b>$${billProduct.number * billProduct.productDetails.category.productLine.price}</b></td>
                </tr>
            </table>
        </div>
    </div>
</div>
<footer>
    <%@include file="layout/footer.jsp" %>
</footer>
</body>
<script>
    $(document).ready(function () {
        $('#addButton').click(function () {
            var confirmed = confirm("Bạn có chắc chắn muốn thanh toán?");

            if (!confirmed) {
                return false; // Ngăn không cho form submit nếu không xác nhận
            }
        });
    });
</script>
</html>