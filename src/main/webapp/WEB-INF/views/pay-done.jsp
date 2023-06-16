<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thanh toán thành công</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/home.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/pay-done.css">
</head>
<body>
<header>
    <%@include file="layout/header.jsp" %>
</header>
<div class="container">
    <div class="ctn2">
        <h1>Thanh toán thành công</h1>
        <img src="/image/done-pay.png" alt="Dấu tích" width="100px">
        <p>Cảm ơn bạn đã thực hiện thanh toán.</p>
        <p>Chi tiết thanh toán:</p>
        <ul>
            <li>Mã bill: ${billProduct.bill.code}</li>
            <li>Tổng tiền: $${totalsAmount}</li>
            <li>Ngày thanh toán: ${billProduct.bill.purchaseDate}</li>
        </ul>
    </div>
</div>
<footer>
    <%@include file="layout/footer.jsp" %>
</footer>
</body>
</html>
