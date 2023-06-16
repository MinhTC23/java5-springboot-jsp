<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Category</title>
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
        <h1>Category</h1>
        <form:form action="/category/update/${category.id}" method="post" modelAttribute="ct">
            Code: <form:input value="${category.code}" path="code" class="form-control" type="text"
                              aria-label="default input example"/>
            <form:errors path="code" cssStyle="color: red"/>
            <br>
            Name: <form:input value="${category.name}" path="name" class="form-control" type="text"
                              aria-label="default input example"/>
            <form:errors path="name" cssStyle="color: red"/>
            <br>
            ID Color: <form:select path="color" class="form-control">
            <c:forEach items="${colors}" var="cl">
                <form:option value="${cl.id}">${cl.name}</form:option>
            </c:forEach>
        </form:select>
            <br>
            ID Capacity: <form:select path="capacity" class="form-control">
            <c:forEach items="${capacitys}" var="cp">
                <form:option value="${cp.id}">${cp.name}</form:option>
            </c:forEach>
        </form:select>
            <br>
            ID Product Line: <form:select path="productLine" class="form-control">
            <c:forEach items="${productLines}" var="pl">
                <form:option value="${pl.id}">${pl.name}</form:option>
            </c:forEach>
        </form:select>
            <br>
            <form:button typy="submit" class="btn btn-success" id="updateButton">Update</form:button>
        </form:form>
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
