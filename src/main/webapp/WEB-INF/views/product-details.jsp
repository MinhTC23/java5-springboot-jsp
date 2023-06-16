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
        <form method="POST" action="/product-details/add" enctype="multipart/form-data">
            Code: <input name="code" class="form-control" type="text" aria-label="default input example"/>
            Name: <input name="name" class="form-control" type="text" aria-label="default input example"/>
            Number: <input name="number" class="form-control" type="number" aria-label="default input example"/>
            ID Category: <select name="category" class="form-control">
            <c:forEach items="${categorys}" var="ct">
                <option value="${ct.id}">${ct.name}</option>
            </c:forEach>
        </select>
            Image: <input type="file" name="images" accept="image/*" class="form-control"/>
            <button type="submit" class="btn btn-success" id="addButton">Add</button>
        </form>

        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Code</th>
                <th scope="col">Name</th>
                <th scope="col">Status</th>
                <th scope="col">Number</th>
                <th scope="col">ID Category</th>
                <th scope="col">Images</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${productDetailss}" var="pd">
                <tr>
                    <td>${pd.id}</td>
                    <td>${pd.code}</td>
                    <td>${pd.name}</td>
                    <td>${pd.status == 1 ? "Hoạt động" : "Không hoạt động"}</td>
                    <td>${pd.number}</td>
                    <td>${pd.category.name}</td>
                    <td>
                        <img src="/image/${pd.images}" width="100px"/>
                    </td>
                    <td>
                        <a href="/product-details/view-update/${pd.id}" class="btn btn-warning" role="button">Update</a>
                        <a href="/product-details/delete/${pd.id}" class="btn btn-danger" role="button"
                           onclick="return deleteButton()">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="pageing">
            <nav aria-label="Page navigation example" class="title">
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link" href="/product-details/view-all?page=0" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach begin="0" end="${totalPages - 1}" var="pageNumber">
                        <li class="page-item"><a class="page-link"
                                                 href="/product-details/view-all?page=${pageNumber}">${pageNumber + 1}</a>
                        </li>
                    </c:forEach>
                    <li class="page-item">
                        <a class="page-link" href="/product-details/view-all?page=${totalPages - 1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
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
