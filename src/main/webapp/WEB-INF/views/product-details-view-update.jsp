<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Product Details</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"
    />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<header>
    <%@include file="layout/header.jsp" %>
</header>

<section>
    <div class="container">
        <h1>Product Details</h1>
        <form method="POST" action="/product-details/update/${productDetails.id}">
            Code: <input name="code" value="${productDetails.code}" class="form-control" type="text"
                         aria-label="default input example"/>
            Name: <input name="name" value="${productDetails.name}" class="form-control" type="text"
                         aria-label="default input example"/>
            Number: <input name="number" value="${productDetails.number}" class="form-control" type="number"
                           aria-label="default input example"/>
            ID Category: <select name="category" class="form-control">
            <c:forEach items="${categorys}" var="ct">
                <option value="${ct.id}">${ct.name}</option>
            </c:forEach>
        </select>
            <button type="submit" class="btn btn-warning" id="updateButton">Update</button>
        </form>
    </div>
</section>

<footer>
    <%@include file="layout/footer.jsp" %>
</footer>
</body>
<script>
    $(document).ready(function () {
        $('#updateButton').click(function () {
            var confirmed = confirm("Bạn có chắc chắn muốn sửa?");

            if (!confirmed) {
                return false; // Ngăn không cho form submit nếu không xác nhận
            }
        });
    });
</script>
</html>
