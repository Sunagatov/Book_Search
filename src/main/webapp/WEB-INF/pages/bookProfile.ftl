<html>
<head>
    <meta http-equiv="Content-type" content="text/html;charset=utf-8">
    <link rel="stylesheet" type="text/css" href="css/mainStyle.css">
    <link rel="stylesheet" type="text/css" href="css/bookProfile.css">
    <link rel="stylesheet" type="text/css" href="css/review.css">
    <script type="text/javascript" src="../templates/signIn.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="header">
    <div class="logo">
        <h1>book_search</h1>
        <h2>easy way to find a favourite book</h2>
    </div>
    <div class="search">
        <div class="registrationButtons">
            <a href="#" onclick="document.getElementById('id01').style.display='block'">Sign in</a>
            <a href="#">Sign up</a>
        </div>
    </div>
</div>
<div class='navigation'>
    <ul>
        <li><a href="#"><span>Lists</span></a></li>
        <li><a href="#"><span>Writers</span></a></li>
        <li><a href="#"><span>Rewievs</span></a></li>
        <li><a href="#"><span>Ratings</span></a></li>
        <li><a href="#"><span>Info</span></a></li>
    </ul>
</div>
<div class="main">
    <div class="profile">
        <div class=" "></div>
        <h2 class="bookTitle">1984</h2>
        <hr id="line">
        <div class="ffff">
            <div class="photo">
                <img src="../templates/1984.jpg" alt="bookPhoto">
                <div class="evaluateBook">Evaluate this book:</div>
                <div id="reviewStars-input">

                    <input id="star-4" type="radio" name="reviewStars"/>
                    <label title="gorgeous" for="star-4"></label>

                    <input id="star-3" type="radio" name="reviewStars"/>
                    <label title="good" for="star-3"></label>

                    <input id="star-2" type="radio" name="reviewStars"/>
                    <label title="regular" for="star-2"></label>

                    <input id="star-1" type="radio" name="reviewStars"/>
                    <label title="poor" for="star-1"></label>

                    <input id="star-0" type="radio" name="reviewStars"/>
                    <label title="bad" for="star-0"></label>
                </div>
            </div>
            <div class="hrrrrr">
                <div class="wrapp">
                    <label>Average rating:</label>
                    <div class="averageRating">4.5</div>
                </div>
                <div class="wrapp">
                    <label>Author:</label>
                    <p>George Orwell</p>
                </div>
                <div class="wrapp">
                    <label>Country:</label>
                    <p>United Kingdom</p>
                </div>
                <div class="wrapp">
                    <label>Language:</label>
                    <p>English</p>
                </div>
                <div class="wrapp">
                    <label>Genre:</label>
                    <p>Dystopian</p>
                </div>
                <div class="wrapp">
                    <label>Publication date:</label>
                    <p>8 June 1949</p>
                </div>
                <div class="wrapp">
                    <label>Page:</label>
                    <p>350</p>
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
<footer>
    Made by Zufar
</footer>
<div id="id01" class="modal">
    <form class="modal-content animate" action="">
        <div class="imgcontainer">
            <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
        </div>
        <div class="container">
            <h1 style="text-align: center">Sign in</h1>
            <label><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="uname" required>

            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required>

            <button type="submit">Login</button>
            <input type="checkbox" checked="checked"> Remember me
        </div>
        <div class="container" style="background-color:#f1f1f1">
            <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">
                Cancel
            </button>
            <span class="psw">Forgot <a href="#">password?</a></span>
        </div>
    </form>
</div>
</body>
</html>