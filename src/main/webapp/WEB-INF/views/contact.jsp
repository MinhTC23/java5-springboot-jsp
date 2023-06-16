<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/home.css">
</head>
<body>
<header>
    <%@include file="layout/header.jsp" %>
</header>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <h1>Contact</h1> <br>
            <b>Address: </b><span>386 Đ. Cầu Giấy, Dịch Vọng, Cầu Giấy, Hà Nội, Việt Nam</span><br> <br>
            <b>Email: </b><span>shopdunk@gmail.com</span><br> <br>
            <b>Call to buy : </b><span>0123456789</span><br> <br>
            <b>Call for warranty : </b><span>0987654321</span><br> <br>
            <div class="input-group mb-3">
                <span class="input-group-text" id="inputGroup-sizing-default">Name</span>
                <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="inputGroup-sizing-default">Email</span>
                <input type="email" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="inputGroup-sizing-default">Content</span>
                <textarea class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default"></textarea>
            </div>
            <button type="button" class="btn btn-danger">Send Contact</button>
        </div>
        <div class="col-lg-6">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3723.913270769773!2d105.78838147512934!3d21.036155980614982!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab38a46072cf%3A0x7bc4a909511c2b2a!2sShopDunk!5e0!3m2!1svi!2s!4v1686288800437!5m2!1svi!2s"
                    width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"
                    referrerpolicy="no-referrer-when-downgrade"></iframe>
        </div>
    </div>
</div>
<footer>
    <%@include file="layout/footer.jsp" %>
</footer>
</body>
</html>