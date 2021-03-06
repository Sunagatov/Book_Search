<html>
<head>
    <meta http-equiv="content-type" content="text/html"/>
    <meta name="author" content=""/>
    <link rel="stylesheet" type="text/css" href="/resources/css/mainStyle.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/registration.css">
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
        <li>
            <form action="/authors" method="get">
                <input id="menuButton" value="Authors" type="submit"/>
            </form>
        </li>
    </ul>
</div>
<div class="main">
    <form action="addAuthor" method="post">
        <div class="registration">
            <h2>Add new author</h2>
            <hr id="line">
            <label for="fname">First Name:</label>
            <input type="text" id="fname" name="first_name" placeholder="Your first name..">
            <label for="lname">Last Name:</label>
            <input type="text" id="lname" name="last_name" placeholder="Your last name..">
            <label for="patronymic">Patronymic:</label>
            <input type="text" id="patronymic" name="patronymic" placeholder="Your patronymic..">
            <label for="nickname">Nickname:</label>
            <input type="text" id="nickname" name="nickname" placeholder="Your nickname..">
            <label for="countryName">Country:</label>
            <select id="countryName" name="country">
                <option value="-1">Country:</option>
                <#list countries as country>
                    <option value="${country.id}">${country.name}</option>
                </#list>
            </select>
            <label for="books">Books:</label>
            <select name="books" multiple>
                <option value="-1">Books:</option>
                <#list books as book>
                    <option value="${book.id}">${book.title}</option>
                </#list>
            </select>
            <label>Birthday:</label>
            <div class="publicationDate">
                <div class="publicationDate_Day">
                    <select name="birthDay">
                        <option value="-1">Day:</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="1">5</option>
                        <option value="2">6</option>
                        <option value="3">7</option>
                        <option value="1">8</option>
                        <option value="2">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                    </select>
                </div>
                <div class="publicationDate_Month">
                    <select name="birthMonth">
                        <option value="-1">Month:</option>
                        <option value="1">Jan</option>
                        <option value="2">Feb</option>
                        <option value="3">Mar</option>
                        <option value="4">Apr</option>
                        <option value="5">May</option>
                        <option value="6">Jun</option>
                        <option value="7">Jul</option>
                        <option value="8">Aug</option>
                        <option value="9">Sep</option>
                        <option value="10">Oct</option>
                        <option value="11">Nov</option>
                        <option value="12">Dec</option>
                    </select>
                </div>
                <div class="publicationDate_Year">
                    <select name="birthYear">
                        <option value="-1">Year:</option>
                        <option value="2012">2012</option>
                        <option value="2011">2011</option>
                        <option value="2010">2010</option>
                        <option value="2009">2009</option>
                        <option value="2008">2008</option>
                        <option value="2007">2007</option>
                        <option value="2006">2006</option>
                        <option value="2005">2005</option>
                        <option value="2004">2004</option>
                        <option value="2003">2003</option>
                        <option value="2002">2002</option>
                        <option value="2001">2001</option>
                        <option value="2000">2000</option>
                        <option value="1999">1999</option>
                        <option value="1998">1998</option>
                        <option value="1997">1997</option>
                        <option value="1996">1996</option>
                        <option value="1995">1995</option>
                        <option value="1994">1994</option>
                        <option value="1993">1993</option>
                        <option value="1992">1992</option>
                        <option value="1991">1991</option>
                    </select>
                </div>
            </div>
            <label>Deathday:</label>
            <div class="publicationDate">
                <div class="publicationDate_Day">
                    <select name="deathDay">
                        <option value="-1">Day:</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="1">5</option>
                        <option value="2">6</option>
                        <option value="3">7</option>
                        <option value="1">8</option>
                        <option value="2">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                    </select>
                </div>
                <div class="publicationDate_Month">
                    <select name="deathMonth">
                        <option value="-1">Month:</option>
                        <option value="1">Jan</option>
                        <option value="2">Feb</option>
                        <option value="3">Mar</option>
                        <option value="4">Apr</option>
                        <option value="5">May</option>
                        <option value="6">Jun</option>
                        <option value="7">Jul</option>
                        <option value="8">Aug</option>
                        <option value="9">Sep</option>
                        <option value="10">Oct</option>
                        <option value="11">Nov</option>
                        <option value="12">Dec</option>
                    </select>
                </div>
                <div class="publicationDate_Year">
                    <select name="deathYear">
                        <option value="-1">Year:</option>
                        <option value="2012">2012</option>
                        <option value="2011">2011</option>
                        <option value="2010">2010</option>
                        <option value="2009">2009</option>
                        <option value="2008">2008</option>
                        <option value="2007">2007</option>
                        <option value="2006">2006</option>
                        <option value="2005">2005</option>
                        <option value="2004">2004</option>
                        <option value="2003">2003</option>
                        <option value="2002">2002</option>
                        <option value="2001">2001</option>
                        <option value="2000">2000</option>
                        <option value="1999">1999</option>
                        <option value="1998">1998</option>
                        <option value="1997">1997</option>
                        <option value="1996">1996</option>
                        <option value="1995">1995</option>
                        <option value="1994">1994</option>
                        <option value="1993">1993</option>
                        <option value="1992">1992</option>
                        <option value="1991">1991</option>
                    </select>
                </div>
            </div>
            <div class="SubmitButton">
                <input type="submit" value="add">
            </div>
        </div>
    </form>
</div>
<footer>
    Made by Zufar
</footer>
</body>
</html>