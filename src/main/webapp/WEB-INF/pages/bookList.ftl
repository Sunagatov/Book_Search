<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html"/>
    <meta name="author" content=""/>
    <link rel="stylesheet" type="text/css" href="css/mainStyle.css">
    <link rel="stylesheet" type="text/css" href="css/booklist.css">
    <script type="text/javascript" src="signIn.js"></script>
</head>
<body>
<div class="header">
    <div class="logo">
        <h1>book_search</h1>
        <h2>easy way to find a favourite book</h2>
    </div>
    <div class="search">
        <div class="registrationButtons">
        </div>
    </div>
</div>
<div class='navigation'>
    <ul>
        <li>
        <li>
            <form action="authors" method="post">
                <input id="menuButton" value="Authors" type="submit"/></form>
        </li>
        <li>
            <form action="reviews" method="post">
                <input id="menuButton" value="Reviews" type="submit"/></form>
        </li>
        <li>
            <form action="home" method="post">
                <input id="menuButton" value="Main" type="submit"/></form>
        </li>
    </ul>
</div>
<div class="main">
    <div class="searchCenter">
        <form id="searchthis" action="/Search" style="display:inline;" method="post">
            <input id="search-box" name="nameBook" size="40" type="text" placeholder="..."/>
            <input id="search-btn1" value="Search" type="submit"/>
        </form>
    </div>
    <div class="searchCenter">
        <label>Genres:</label>
        <select name="genres" id="genres">
            <option value="-1">Genres:</option>
            <option value="Romantic">Romantic</option>
            <option value="Fiction">Fiction</option>
            <option value="Thriller">Thriller</option>
            <option value="Comedy">Comedy</option>
            <option value="Drama">Drama</option>
            <option value="Melodrama">Melodrama</option>
            <option value="Prose">Prose</option>
        </select>
    </div>
    <main class="cards">
        <article class="card">
            <img src="https://flytothesky.ru/wp-content/uploads/2014/10/242.jpg" alt="Sample photo">
            <div class="text">
                <div class="info">
                    <h3>Name:</h3>
                    <p>${books.name}</p>
                    <h3>Author:</h3>
                    <p>${books.author}</p>
                    <h3>publicationDate:</h3>
                    <p>${books.publicationDate}</p>
                    <h3>country:</h3>
                    <p>${books.country}</p>
                    <h3>language:</h3>
                    <p>${books.language}</p>
                    <h3>pages:</h3>
                    <p>${books.pages}</p>
                    <h3>genres:</h3>
                    <p>${books.genres}</p>
                </div>
                <div class="learn">
                    <input type="submit" value="Learn">
                </div>
            </div>
        </article>
    </main>
</div>
<footer>
    Made by ZufarANDSergey
</footer>
</body>
</html>