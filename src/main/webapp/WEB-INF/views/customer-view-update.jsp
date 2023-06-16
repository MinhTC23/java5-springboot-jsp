<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer</title>
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
        <h1>Customer</h1>
        <form:form action="/customer/update/${customer.id}" method="post" modelAttribute="ct">
            Code: <form:input value="${customer.code}" path="code" class="form-control" type="text"
                              aria-label="default input example"/>
            <form:errors path="code" cssStyle="color: red"/>
            <br>
            Full Name: <form:input value="${customer.fullName}" path="fullName" class="form-control" type="text"
                                   aria-label="default input example"/>
            <form:errors path="fullName" cssStyle="color: red"/>
            <br>
            Gender: <form:radiobutton path="gender" checked="true" value="1"/>Male
            <form:radiobutton path="gender" value="2"/>Female
            <br>
            Phone Number: <form:input path="phoneNumber" value="${customer.phoneNumber}" class="form-control"
                                      type="text" aria-label="default input example"/>
            <form:errors path="phoneNumber" cssStyle="color: red"/>
            <br>
            Address: <form:input path="address" value="${customer.address}" class="form-control" type="text"
                                 aria-label="default input example"/>
            <form:errors path="address" cssStyle="color: red"/>
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
