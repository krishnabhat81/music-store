<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container" >
        <div class="page-header">
            <h1>All Products</h1>

            <p class="lead">Checkout all the awesome products available now</p>
        </div>
        <table class="table table-striped table-hover">
            <thead>
                <tr class="bg-success">
                    <th>Photo thumb</th>
                    <th>Product Name</th>
                    <th>Category</th>
                    <th>Condition</th>
                    <th>Price</th>
                </tr>
            </thead>
            <c:forEach var="product" items="${products}" >
                <tr>
                    <td><img src="#" alt="Image" /></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice} USD</td>
                </tr>
            </c:forEach>
        </table>
<%@include file="/WEB-INF/views/template/footer.jsp"%>