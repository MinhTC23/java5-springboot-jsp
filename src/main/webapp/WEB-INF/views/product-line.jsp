<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Product Line</title>
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
        <h1>Product Line</h1>
        <form:form action="/product-line/add" method="post" modelAttribute="pl">
            Code: <form:input path="code" class="form-control" type="text" aria-label="default input example"/>
            <form:errors path="code" cssStyle="color: red"/>
            <br>
            Name: <form:input path="name" class="form-control" type="text" aria-label="default input example"/>
            <form:errors path="name" cssStyle="color: red"/>
            <br>
            Import Price: <form:input path="importPrice" class="form-control" type="number"
                                      aria-label="default input example"/>
            <form:errors path="importPrice" cssStyle="color: red"/>
            <br>
            Price: <form:input path="price" class="form-control" type="number" aria-label="default input example"/>
            <form:errors path="price" cssStyle="color: red"/>
            <br>
            ID Manufacturer: <form:select path="manufacturer" class="form-control">
            <c:forEach items="${manufacturers}" var="mn">
                <form:option value="${mn.id}">${mn.nameManufacturer}</form:option>
            </c:forEach>
        </form:select>
            <br>
            <form:button typy="submit" class="btn btn-success" id="addButton">Add</form:button>
        </form:form>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Code</th>
                <th scope="col">Name</th>
                <th scope="col">Import Price</th>
                <th scope="col">Price</th>
                <th scope="col">Date Create</th>
                <th scope="col">Date Correct</th>
                <th scope="col">Status</th>
                <th scope="col">ID Manufacturer</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${productLines}" var="pl">
                <tr>
                    <td>${pl.id}</td>
                    <td>${pl.code}</td>
                    <td>${pl.name}</td>
                    <td>${pl.importPrice}</td>
                    <td>${pl.price}</td>
                    <td>${pl.dateCreate}</td>
                    <td>${pl.dateCorrect}</td>
                    <td>${pl.status == 1 ? "Hoạt động" : "Không hoạt động"}</td>
                    <td>${pl.manufacturer.nameManufacturer}</td>
                    <td>
                        <a href="/product-line/view-update/${pl.id}" class="btn btn-warning" role="button">Update</a>
                        <a href="/product-line/delete/${pl.id}" class="btn btn-danger" role="button"
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
