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
        <form action="home" method="get">
            <input id="mainButton" value="book_search" type="submit"/>
            <h2>easy way to find a favourite book</h2>
        </form>
    </div>
    <div class="search">
        <div class="registrationButtons">
            <a href="#" onclick="document.getElementById('id01').style.display='block'">Sign in</></a>
            <form action="registration" method="get">
                <input id="signUpButton" value="Sign up" type="submit"/>
            </form>
        </div>
    </div>
</div>
<div class='navigation'>
    <ul>
        <li>
            <form action="/reviews" method="post">
                <input id="menuButton" value="Reviews" type="submit"/>
            </form>
        </li>
        <li>
            <form action="/books" method="post">
                <input id="menuButton" value="Books" type="submit"/>
            </form>
        </li>
    </ul>
</div>
<div class="main">
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
                    </div>
                    <div class="learn">
                        <form action="author/${author.id}" method="get">
                            <input type="submit" value="Learn">
                        </form>
                    </div>
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