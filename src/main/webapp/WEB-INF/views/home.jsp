<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/home.css">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
<header>
    <%@include file="layout/header.jsp" %>
</header>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div id="carouselExampleRide" class="carousel slide" data-bs-ride="true">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="/banner/banner-1.png" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="/banner/banner-2.png" class="d-block w-100" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleRide" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleRide" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <div>
                <h3 class="title">All Product</h3>
            </div>
        </div>
    </div>

    <div class="row">
        <c:forEach items="${productDetailss}" var="pd">
            <div
                    class="col-xl-3 col-lg-4 col-md-6"
                    id="cardd"
            >
                <div class="card" style="width: 262.5px; border: white">
                    <a href=""
                    ><img src="/image/${pd.images}" class="card-img-top" alt="..."
                    /></a>
                    <div class="card-body">
                        <p class="card-text">
                                ${pd.name} <br/>
                            <b>$${pd.category.productLine.price}</b>
                        </p>
                        <a href="/buy-now/${pd.id}"
                        >
                            <button type="button" class="btn btn-outline-success">
                                Buy now
                            </button>
                        </a
                        >
                        <a href="/cart/add/${pd.id}" onclick="return messageAddCart()">
                            <button
                                    type="button"
                                    class="btn btn-outline-success"
                                    style="float: right"
                            >
                                Add to cart
                            </button>
                        </a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="pageing">
        <nav aria-label="Page navigation example" class="title">
            <ul class="pagination">
                <li class="page-item">
                    <a class="page-link" href="/home?page=0" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="0" end="${totalPages - 1}" var="pageNumber">
                    <li class="page-item"><a class="page-link"
                                             href="/home?page=${pageNumber}">${pageNumber + 1}</a></li>
                </c:forEach>
                <li class="page-item">
                    <a class="page-link" href="/home?page=${totalPages - 1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<footer>
    <%@include file="layout/footer.jsp" %>
</footer>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
<script>
    function messageAddCart() {
        alert("Add to cart success");
        // var quantity = prompt("Nhập số lượng:");
        // if (quantity != null) {
        //     // Xử lý số lượng được nhập ở đây
        //     console.log("Số lượng đã nhập: " + quantity);
        //     alert("Add to cart success");
        //     sendQuantityToController(quantity);
        //     return true;
        // }else {
        //     return false;
        // }
        // function sendQuantityToController(quantity) {
        //     fetch('http://localhost8080/cart/add/1', {
        //         method: 'GET',
        //         headers: {
        //             'Content-Type': 'application/json',
        //         },
        //         body: JSON.stringify({ quantity: quantity }),
        //     })
        //         .then(response => {
        //             if (response.ok) {
        //                 console.log('Số lượng đã được gửi thành công đến controller');
        //             } else {
        //                 console.log('Có lỗi xảy ra khi gửi số lượng đến controller');
        //             }
        //         })
        //         .catch(error => {
        //             console.log('Lỗi kết nối');
        //         });
        // }
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>
</html>
