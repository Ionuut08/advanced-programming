<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
    <meta charset="UTF-8">
    <title>HPlus</title>
    <link rel="stylesheet" href="<spring:theme code='stylesheet'/>" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<header id="home" class="header">
    <nav class="nav" role="navigation">
        <div class="container nav-elements">
            <ul class="navbar">
                <li><a href="/home"><spring:message code="label.home"/></a></li>
                <li><a href="/goToLogin"><spring:message code="label.login"/></a></li>
                <li><a href="/goToSearch"><spring:message code="label.search"/></a></li>
                <li><a href="/redirectToLinkedIn"><spring:message code="label.linkedin"/></a></li>
            </ul><!-- navbar -->
        </div><!-- container nav-elements -->
    </nav>
</header><!-- #home -->

</body>
</html>
