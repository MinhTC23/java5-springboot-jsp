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
    <form action="/bill-search" method="get">
        Phone Number: <input type="text" name="phoneNumber" class="form-control">
        <br>
        <button type="submit" class="btn btn-success">Search</button>
    </form>
    <table class="table">
        <tr>
            <th>STT</th>
            <th>Ngày mua</th>
            <th>Sản phẩm</th>
            <th>Số lượng</th>
            <th>Giá Bán</th>
            <th>Thành Tiền</th>
        </tr>
        <c:forEach items="${billSearchs}" var="bs" varStatus="stt">
            <tr>
                <td>${stt.index + 1}</td>
                <td>${bs.bill.purchaseDate}</td>
                <td>${bs.productDetails.name}</td>
                <td>${bs.number}</td>
                <td><b>$${bs.unitPrice}</b></td>
                <td><b>$${bs.amount}</b></td>
            </tr>
        </c:forEach>
    </table>
</div>
<footer>
    <%@include file="layout/footer.jsp" %>
</footer>
</body>
</html>