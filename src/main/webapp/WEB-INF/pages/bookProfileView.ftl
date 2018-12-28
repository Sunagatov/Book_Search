<html>
<head>
    <meta http-equiv="Content-type" content="text/html;charset=utf-8">
    <link rel="stylesheet" type="text/css" href="/resources/css/mainStyle.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bookProfile.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/review.css">
    <script type="text/javascript" src="/resources/js/signIn.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
        <li>
            <form action="/books" method="get">
                <input id="menuButton" value="Books" type="submit"/>
            </form>
        </li>
    </ul>
</div>
<div class="main">
    <div class="profile">
        <div class=" "></div>
        <h2 class="bookTitle">${book.title}</h2>
        <hr id="line">
        <div class="ffff">
            <div class="photo">
                <img src="https://st.depositphotos.com/1007168/1626/v/950/depositphotos_16268419-stock-illustration-happy-orange-book-mascot.jpg"
                     alt="bookPhoto">
            </div>
            <div class="hrrrrr">
                <div class="wrapp">
                    <label>Authors:</label>
                      <#list authors as author>
                          <label>${author.nick_name}</label><br>
                      </#list>
                </div>
                <div class="wrapp">
                    <label>Country:</label>
                    <p>${book.country.name}</p>
                </div>
                <div class="wrapp">
                    <label>Publication date:</label>
                    <p>${book.publication_date}</p>
                </div>
                <div class="wrapp">
                    <label>Page:</label>
                    <p>${book.page_count}</p>
                </div>
            </div>
        </div>
        <div class="briefInfo">
            <label>Brief info:</label>
            <p>
                Artistic style is a special style of speech that has become widely used both in the world literature
                literature in general and in copywriting in particular. He is characterized by high emotionality, direct
                speech, richness of colors, epithets and metaphors,
                and also called upon to influence the imagination of the reader and acts as a trigger for his
                imagination. So, today we consider in detail and illustrative examples the artistic style of texts and
                its application in copywriting. Artistic style
                is a special style of speech that has become widely used both in the world literature literature in
                general and in copywriting in particular. He is characterized by high emotionality, direct speech,
                richness of colors, epithets and metaphors,
                and also called upon to influence the imagination of the reader and acts as a trigger for his
                imagination. So, today we consider in detail and illustrative examples the artistic style of texts and
                its application in copywriting. Artistic style
                is a special style of speech that has become widely used both in the world literature literature in
                general and in copywriting in particular. He is characterized by high emotionality, direct speech,
                richness of colors, epithets and metaphors,
                and also called upon to influence the imagination of the reader and acts as a trigger for his
                imagination. So, today we consider in detail and illustrative examples the artistic style of texts and
                its application in copywriting.
            </p>
        </div>
    </div>
</div>
</body>
<footer>
    Made by Zufar
</footer>
</html>