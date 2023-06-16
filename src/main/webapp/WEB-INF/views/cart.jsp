<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Giỏ hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<header>
    <%@include file="layout/header.jsp" %>
</header>
<div class="container">
    <h1>Giỏ hàng</h1>
    <table class="table">
        <tr>
            <th>STT</th>
            <th>Sản phẩm</th>
            <th>Số lượng</th>
            <th>Giá Bán</th>
            <th>Thành Tiền</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${cartDetail.list}" var="cd" varStatus="stt">
            <tr>
                <td>${stt.index + 1}</td>
                <td>${cd.productDetails.name}</td>
                <td>${cd.number}</td>
                <td><b>$${cd.productDetails.category.productLine.price}</b></td>
                <td><b>$${cd.number *cd.productDetails.category.productLine.price}</b></td>
                <td><a href="/cart/remove/${stt.index + 1}" role="button" class="btn btn-danger">Remove</a></td>
            </tr>
        </c:forEach>
    </table>
    <label>Tổng tiền: $${totalsAmount}</label>
    <br>
    <a href="/home" role="button" class="btn btn-outline-warning">Continue shopping</a>
    <c:if test="${shouldShowButtons == true}">
        <a href="/pay" role="button" class="btn btn-outline-success">Pay</a>
        <a href="/cart/remove-all" role="button" class="btn btn-outline-danger">Remove All</a>
    </c:if>

</div>
<footer>
    <%@include file="layout/footer.jsp" %>
</footer>
</body>
</html>