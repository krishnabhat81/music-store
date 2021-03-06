<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1> Edit Product</h1>

            <p class="lead">Edit the following form</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/admin/productInventory/editProduct" method="post"
                   commandName="product" enctype="multipart/form-data">

        <form:hidden path="productId"></form:hidden>

        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="productName" id="name" cssClass="form-control"></form:input>
            <form:errors path="productName" cssStyle="color: red" />
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="instrument" />Instrument</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="record" />Record</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="accessory" />Accessory</label>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="productDescription" id="description" cssClass="form-control"></form:textarea>
        </div>

        <div class="form-group">
            <label for="price">Price</label>
            <form:input path="productPrice" id="price" cssClass="form-control"></form:input>
            <form:errors path="productPrice" cssStyle="color: red" />
        </div>

        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="new" checked="checked"/>New</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="used" />Used</label>
        </div>

        <div class="form-group">
            <label for="status">Status</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="active" checked="checked" />Active</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="inactive" />Inactive</label>
        </div>

        <div class="form-group">
            <label for="unitInStock">Unit In Stock</label>
            <form:input path="unitInStock" id="unitInStock" cssClass="form-control"></form:input>
            <form:errors path="unitInStock" cssStyle="color: red" />
        </div>

        <div class="form-group">
            <label for="manufacture">Manufacture</label>
            <form:input path="productManufacturer" id="manufacture" cssClass="form-control"></form:input>
        </div>

        <div class="form-group">
            <label class="control-label" for="productImage">Upload File</label>
            <form:input path="productImage" id="productImage" type="file" cssClass="form:input-large"></form:input>
        </div>
        <br />

        <input type="submit"  value="Submit" class="btn btn-default">
        <a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>

        </form:form>
        <%@include file="/WEB-INF/views/template/footer.jsp" %>


