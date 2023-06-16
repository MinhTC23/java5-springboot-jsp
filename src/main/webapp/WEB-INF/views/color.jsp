<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Color</title>
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
        <h1>Color</h1>
        <form:form action="/color/add" method="post" modelAttribute="cl">
            Code: <form:input path="code" class="form-control" type="text" aria-label="default input example"/>
            <form:errors path="code" cssStyle="color: red"/>
            <br>
            Name: <form:input path="name" class="form-control" type="text" aria-label="default input example"/>
            <form:errors path="name" cssStyle="color: red"/>
            <br>
            <form:button typy="submit" class="btn btn-success" id="addButton">Add</form:button>
        </form:form>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Code</th>
                <th scope="col">Name</th>
                <th scope="col">Date Create</th>
                <th scope="col">Date Correct</th>
                <th scope="col">Status</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${colors}" var="cl">
                <tr>
                    <td>${cl.id}</td>
                    <td>${cl.code}</td>
                    <td>${cl.name}</td>
                    <td>${cl.dateCreate}</td>
                    <td>${cl.dateCorrect}</td>
                    <td>${cl.status == 1 ? "Hoạt động" : "Không hoạt động"}</td>
                    <td>
                        <a href="/color/view-update/${cl.id}" class="btn btn-warning" role="button">Update</a>
                        <a href="/color/delete/${cl.id}" class="btn btn-danger" role="button"
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
