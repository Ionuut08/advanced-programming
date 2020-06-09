<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>HPlus</title>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
</head>
<body>
<header id="home" class="header">
    <nav class="nav" role="navigation">
        <div class="container nav-elements">
            <ul class="navbar">
                <li><a href="/home">home</a></li>
                <li><a href="/logout">logout</a></li>
                <li><a href="/search">search</a></li>
                <li><a href="/redirectToLinkedIn">linkedin</a></li>
            </ul><!-- navbar -->

        </div><!-- container nav-elements -->
    </nav>
    <div class="container tagline">
        <h1 class="headline">Our Mission</h1>
        <em>Welcome, ${username}</em>
       
    </div><!-- container tagline -->
</header><!-- #home -->


<section id="search" class="section">
    <header class="imageheader"></header>
    <div class="container">
        <h2 class="headline">Search Products</h2>
        <form action="search" method="get">
            <label class="card-title">Search your product</label>
            <input type="search" name="search">
            <input type="submit" value="Search">
        </form>
    </div>
</section><!-- guarantee -->

</section>
</body>
</html>
