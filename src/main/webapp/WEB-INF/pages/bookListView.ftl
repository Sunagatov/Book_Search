<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
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
            <form action="/authors" method="get">
                <input id="menuButton" value="Authors" type="submit"/>
            </form>
        </li>
    </ul>
</div>
<div class="main">
    <div class="addNewItem">
        <form action="getAddBookView" method="get">
            <input type="submit" value="Add new Book">
        </form>
    </div>
    <main class="cards">
         <#list books as book>
             <article class="card">
                 <img src="https://st.depositphotos.com/1007168/1626/v/950/depositphotos_16268419-stock-illustration-happy-orange-book-mascot.jpg"
                      alt="Sample photo">
                 <div class="text">
                     <div class="info">
                         <h3>Title:</h3>
                         <p>${book.title}</p>
                         <h3>Publication date:</h3>
                         <p>${book.publication_date}</p>
                         <h3>Country:</h3>
                         <p>${book.country.name}</p>
                     </div>
                     <div class="learn">
                         <form action="/book/${book.id}" method="get">
                             <input type="submit" value="Learn">
                         </form>
                     </div>
                     <div class="learn">
                         <form action="/updateBookView/${book.id}" method="get">
                             <input type="submit" value="Update">
                         </form>
                     </div>
                     <div class="learn">
                         <form action="/deleteBook/${book.id}" method="get">
                             <input type="submit" value="Delete">
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