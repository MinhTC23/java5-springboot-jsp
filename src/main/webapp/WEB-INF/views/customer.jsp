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
        <form:form action="/customer/add" method="post" modelAttribute="ct">
            Code: <form:input path="code" class="form-control" type="text" aria-label="default input example"/>
            <form:errors path="code" cssStyle="color: red"/>
            <br>
            Full Name: <form:input path="fullName" class="form-control" type="text" aria-label="default input example"/>
            <form:errors path="fullName" cssStyle="color: red"/>
            <br>
            Gender: <form:radiobutton path="gender" checked="true" value="1"/>Male
            <form:radiobutton path="gender" value="2"/>Female
            <br>
            Phone Number: <form:input path="phoneNumber" class="form-control" type="text"
                                      aria-label="default input example"/>
            <form:errors path="phoneNumber" cssStyle="color: red"/>
            <br>
            Address: <form:input path="address" class="form-control" type="text" aria-label="default input example"/>
            <form:errors path="address" cssStyle="color: red"/>
            <br>
            <form:button typy="submit" class="btn btn-success" id="addButton">Add</form:button>
        </form:form>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Code</th>
                <th scope="col">Name</th>
                <th scope="col">Gender</th>
                <th scope="col">Phone Number</th>
                <th scope="col">Address</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${customers}" var="ct">
                <tr>
                    <td>${ct.id}</td>
                    <td>${ct.code}</td>
                    <td>${ct.fullName}</td>
                    <c:if test="${ct.gender == 1}">
                        <td>Nam</td>
                    </c:if>
                    <c:if test="${ct.gender == 2}">
                        <td>Nữ</td>
                    </c:if>
                    <td>${ct.phoneNumber}</td>
                    <td>${ct.address}</td>
                    <td>
                        <a href="/customer/view-update/${ct.id}" class="btn btn-warning" role="button">Update</a>
                        <a href="/customer/delete/${ct.id}" class="btn btn-danger" role="button"
                           onclick="return deleteButton()">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>

<footer>
    <%@include file="layout/footer.jsp" %>
</footer>
</body>
<script>
    $(document).ready(function () {
        $('#addButton').click(function () {
            var confirmed = confirm("Bạn có chắc chắn muốn thêm?");

            if (!confirmed) {
                return false; // Ngăn không cho form submit nếu không xác nhận
            }
        });
    });

    function deleteButton() {
        var confirmed = confirm("Bạn có chắc chắn muốn xóa?");
        if (confirmed) {
            return true;
        } else {
            return false;
        }
    }
</script>
</html>
