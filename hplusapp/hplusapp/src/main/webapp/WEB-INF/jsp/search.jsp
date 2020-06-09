<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>H+ Sport</title>
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<header id="home" class="header">
    <nav class="nav" role="navigation">
        <div class="container nav-elements">
            <div class="branding">
                <a href="home"><img src="images/hpluslogo.svg"
                                    alt="Logo - H Plus Sports"></a>
            </div>
            <!-- branding -->
            <ul class="navbar">
                <li><a href="/home">home</a></li>
                <li><a href="/login">login</a></li>
                <li><a href="/goToSearch">search</a></li>
                <li><a href="/redirectToLinkedIn">linkedin</a></li>
            </ul><!-- navbar -->
            <!-- navbar -->
        </div>
        <!-- container nav-elements -->
    </nav>
</header>
<!-- #home -->

<section id="search" class="section">
    <header class="imageheader"></header>
    <div class="container">
        <h2 class="headline">Search Products</h2>
        <form action="/search" method="get">
            <label class="card-title">Search your product</label>
            <input path="search" name="search" value="">
            <input type="submit" value="Search">
        </form>
    </div>
</section>
<!-- guarantee -->
<c:if test="${!empty(products)}">

    <c:forEach var="product" items="${products}">


        <section id="products" class="section">

        <div class="productContainer">

        <div class="productContainerItem">
            <img id="pic1" src="${product.imagePath}">
            <input type="text" name="product"
                   value="${product.name}"><br/>

        </div>

    </c:forEach>
    </div>

    </section>
</c:if>
</body>
</html>