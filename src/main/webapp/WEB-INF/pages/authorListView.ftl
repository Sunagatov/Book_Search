<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html"/>
    <meta name="author" content=""/>
    <link rel="stylesheet" type="text/css" href="/resources/css/mainStyle.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/booklist.css">
    <script type="text/javascript" src="/resources/js/signIn.js"></script>
</head>
<body>
<div class="header">
    <div class="logo">
        <form action="/home" method="get">
            <input id="mainButton" value="book_search" type="submit"/>
            <h2>easy way to find a favourite book</h2>
        </form>
    </div>
</div>
<div class='navigation'>
    <ul>
        <li>
            <form action="/books" method="get">
                <input id="menuButton" value="Books" type="submit"/>
            </form>
        </li>
    </ul>
</div>
<div class="main">
    <div class="text">
        <form action="getAddAuthorView" method="get">
            <input type="submit" value="Add">
        </form>
    </div>
    <main class="cards">
        <#list authors as author>
            <article class="card">
                <img src="http://littramplin.ru/wp-content/uploads/2018/06/89.jpg" alt="Sample photo">
                <div class="text">
                    <div class="info">
                        <h3>Name:</h3>
                        <p>${author.first_name}</p>
                        <h3>Surname:</h3>
                        <p>${author.last_name}</p>
                        <h3>Nickname:</h3>
                        <p>${author.nick_name}</p>
                        <h3>Country:</h3>
                        <p>${author.country.name}</p>
                    </div>
                    <div class="learn">
                        <form action="/author/${author.id}" method="get">
                            <input type="submit" value="Learn">
                        </form>
                    </div>
                    <form action="" method="get">
                        <input type="submit" value="Delete">
                    </form>
                </div>
            </article>
        </#list>
    </main>
</div>
<footer>
    Made by Zufar
</footer>
</body>
</html>