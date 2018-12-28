<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/resources/css/mainStyle.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/userProfile.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/review.css">
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
        <li>
            <form action="/books" method="get">
                <input id="menuButton" value="Books" type="submit"/>
            </form>
        </li>
    </ul>
</div>
<div class="main">
    <div class="profile">
        <h2>${author.nick_name}</h2>
        <hr id="line">
        <div class="ffff">
            <div class="photo">
                <img src="http://littramplin.ru/wp-content/uploads/2018/06/89.jpg" alt="userPhoto">
            </div>
            <div class="hrrrrr">
                <div class="wrapp">
                    <label>Books:</label>
                      <#list books as book>
                          <label>${book.title}</label>
                      </#list>
                </div>
                <div class="wrapp">
                    <label>First name:</label>
                    <p>${author.first_name}</p>
                </div>
                <div class="wrapp">
                    <label>Last name:</label>
                    <p>${author.last_name}</p>
                </div>
                <div class="wrapp">
                    <label>Patronymic:</label>
                    <p>${author.patronymic}</p>
                </div>
                <div class="wrapp">
                    <label>Country:</label>
                    <p>${author.country.name}</p>
                </div>
                <div class="wrapp">
                    <label>Gender:</label>
                    <p>Male</p>
                </div>
                <div class="wrapp">
                    <label>Birthday:</label>
                    <p>${author.birthday}</p>
                </div>
                <div class="wrapp">
                    <label>Deathday:</label>
                    <p>${author.deathday}</p>
                </div>
            </div>
        </div>
        <div class="Biography">
            <label>Biography:</label>
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
<footer>
    Made by Zufar
</footer>
</body>
</html>