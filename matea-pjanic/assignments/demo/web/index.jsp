<%--
  Created by IntelliJ IDEA.
  User: Matea Pjanic
  Date: 27/02/2017
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="js/jquery.easy-autocomplete.js" type="text/javascript"></script>
  <script src="js/ajax.js" type="text/javascript"></script>
  <script src="js/bla.js" type="text/javascript"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="css/easy-autocomplete.css">
  <link rel="stylesheet" type="text/css" href="css/easy-autocomplete.themes.css">
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<jsp:include page="header.jsp" >
  <jsp:param name="info" value="<a class='headLink' href='#info'>Info</a>" />
  <jsp:param name="login" value="<a class='headLink' href='login.jsp'>Login</a>" />
  <jsp:param name="join" value="<a class='headLink' href='join.jsp'>Join</a>" />
  <jsp:param name="artists" value="<a class='headLink' href='#artists'>Top artists</a>" />
  <jsp:param name="tracks" value="<a class='headLink' href='#tracks'>Top tracks</a>" />
  <jsp:param name="events" value="<a class='headLink' href='#events'>Events</a>" />
  <jsp:param name="home" value="<a class='headLink' href='index.jsp'>Home</a>" />
</jsp:include>
<div class="container" id="content">
  <div class="container" id="news">
    <div class="container">
      <img src="img/ADVENTURES.jpg" class="newsPic"/>
      <h4>The Adventures: The Sea of Love (Expanded Edition)</h4>
      <p>For The Adventures, also read the likes of The Silencers and Love And Money, for bands of the late 1980s that developed a classy pop-rock sound but
        never matched the commercial success of, for example, Deacon Blue. Even with the backing of pop-supremo Simon Fuller, The Adventures peaked with this
        second album before eventually being dropped by their label two albums later.
        This is even more surprising given the strength of Sea of Love, the band's second album released in May 1988... </p>
      <p class="moreAdvP">Any music fan of the era will remember the striking, anthemic opening piano chords of Broken Land, ' +
        'a song partly inspired by The Troubles in their homeland, which became their biggest hit. Its dark verse pitched against a brighter, less despairing chorus, was
        almost too sophisticated for the Stock, Aitken and Waterman dominated charts of the time, but it still reached the top 20. ' +
        The cinematic feel is repeated throughout, with the wonderful Drowning in the Sea of Love and soaring When Your Heart Was Young almost as strong. There
        are impressive gear changes too, with the almost funky The Trip To Bountiful (When The Rain Comes Down)
        and the Simple Minds infused Hold Me Now hinting at greater things for The Adventures.
        The fact they didn't achieve those greater things can be partly explained by the excellent interview with the band's Pat Gribben on the sleevenotes.
        Here he seems to sneer at the 'enormous' production that was pushed forward for The Sea Of Love and he claims they fought against it. It makes you wonder
        just how big the production would have been as the album has a widescreen feel as it is. Gribben admits that their follow up (Trading Secrets With The Moon)
        was intended to be the complete opposite and perhaps it meant they lost any momentum built by Sea of Love. There are added tracks for this re-release,
        including the quaint folk of The Curragh of Kildare and a cover of Instant Karma but the fact there are also two other versions of Broken Land underlines how a
        band's career can often be shaped by one song.</p>
      <button class="btn btn-default btn-xs" id="moreAdvL">read more</button>
    </div>
    <div class="container">
      <img src="img/cornbury.jpg" class="newsPic"/>
      <h4>Win Cornubury Music Festival tickets!</h4>
      <p>Win a pair of tickets with weekend camping passes and parking worth over £400 to the last ever Cornbury Music Festival, Great Tew Oxfordshire.
        After 14 stellar years, the festival in the heart of the Cotswolds, nicknamed ‘Poshstock', are having their festival finale with a great big line up of
        their musical friends, many returning to the bill for a jolly good weekend this Summer 7th – 9th July. Headliner Bryan Adams will be joined by Kaiser Chiefs, ...</p>
      <p class="moreCornP">The Pretenders, Jools Holland, Tom Chaplin, Sophie Ellis Bextor, Jack Savoretti, Scouting For Girls, Midge Ure, Right Said Fred and plenty of country and folk
        newcomers such as Ward Thomas and The Pierce Brothers. Known also for being the friendliest festival in the UK, It’s definitely the festival to take your mum and dad to.. In fact, it’s one for the whole family as
        there’s something for everyone of all ages to enjoy in a safe environment, with a really relaxed and happy atmosphere all round! So if you fancy rubbing shoulders
        and getting down with Cameron and Clarkson.. Or maybe even the Beckhams answer this question: Can you tell us the name of Tom Chaplin’s former chart topping band? </p>
      <button class="btn btn-default btn-xs" id="moreCornL">read more</button>
    </div>
    <div class="container">
      <img src="img/johnleehooker.jpg" class="newsPic"/>
      <h4>John Lee Hooker 100th birthday celebration underway</h4>
      <p>John Lee Hooker was born on August 22, 1917 in Tutwiler, MS and, to celebrate the 100th year of his birth, Vee-Jay Records (a division of Concord Bicycle Music)
        is releasing a brand new compilation of some of his best music.
        Whiskey & Wimmen: John Lee Hooker’s Finest, out on March 31, includes material from throughout Hooker’s career including his time at Vee-Jay, Specialty, Riverside
        and Stax.</p>
      <p class="moreJohnP">John Lee Hooker began his recording career in 1948 and, the next year, he had the biggest selling R&B record of the year with Boogie Chillen’. Overall, he charted
        eight records on the R&B Singles chart including Crawlin’ King Snake, I’m in the Mood, I Love You Honey, No Shoes and Boom Boom, all of which are included on
        Whiskey & Wimmen. He later went on to chart seven albums on the Billboard 200 between 1971 and 1997.
        The sixteen tracks on the album show how an artist who started with literally nothing but his inspiration and talent was able to make such a lasting impact on music.
        His work for the Vee-Jay, Specialty and Riverside labels were many of the recordings his unshakeable legend was built on, and provide a sonic tour of what Hooker’s
        blues accomplished. Music journalist Bill Dahl contributes insightful new liner notes.
        In the proud history of American music there have been a handful of blues artists who really did shape what the music became. They took the primal forces of
        Mississippi country blues and twisted and turned it into their very own creation. To hear how John Lee Hooker did that over the course of these 16 songs is a
        blood-rushing history lesson of all that he created. And to have them all on a single disc is as convincing a collection as has ever been assembled that, indeed,
        John Lee Hooker will remain the “King of the Boogie” forever.
        Concord Bicycle Music’s Chief Catalog Officer Sig Sigworth said “When so much music of great importance exists, it’s thrilling to continually find ways to share
        that history with collections like this. It literally sounds like America at its most exciting, and honors someone who changed the way we hear and feel forever.”</p>
      <button class="btn btn-default btn-xs" id="moreJohnL">read more</button>
    </div>
  </div>
  <hr>

  <div class="container" id="artists">
    <h2>Top artists</h2>
    <div class="container">
      <div class="artistsPic" id="thunder">
        <p class="artistsPar">Thundercat</p>
      </div>
      <div class="artistsPic" id="weeknd">
        <p class="artistsPar">The Weeknd</p>
      </div>
      <div class="artistsPic" id="future">
        <p class="artistsPar">Future</p>
      </div>
      <div class="artistsPic" id="justin">
        <p class="artistsPar">Justin Hurwitz</p>
      </div>
      <div class="artistsPic" id="xx">
        <p class="artistsPar">The xx</p>
      </div>
      <div class="artistsPic" id="adele">
        <p class="artistsPar">Adele</p>
      </div>
      <div class="artistsPic" id="chain">
        <p class="artistsPar">Chainsmokers</p>
      </div>
      <div class="artistsPic" id="maus">
        <p class="artistsPar">Deadmaus5</p>
      </div>
      <div class="artistsPic" id="lana">
        <p class="artistsPar">Lana Del Ray</p>
      </div>
    </div>
  </div>

  <hr>
  <div class="container" id="tracks">
    <h2>Top tracks</h2>
    <table class="table table-hover">
      <tbody>
      <tr>
        <th>
          1 &nbsp;&nbsp;
          <span class="glyphicon glyphicon-play-circle" data-toggle="tooltip" title="play"></span>
          <span class="glyphicon glyphicon-heart-empty" data-toggle="tooltip" title="add to playlist"></span>
          &nbsp;&nbsp;&nbsp;&nbsp;Ed Sheeran: Shape Of You
        </th>

      </tr>
      <tr>
        <th>
          2 &nbsp;&nbsp;
          <span class="glyphicon glyphicon-play-circle" data-toggle="tooltip" title="play"></span>
          <span class="glyphicon glyphicon-heart-empty" data-toggle="tooltip" title="add to playlist"></span>
          &nbsp;&nbsp;&nbsp;&nbsp;The Weeknd: I Feel It Coming
        </th>
      </tr>
      <tr>
        <th>
          3 &nbsp;&nbsp;
          <span class="glyphicon glyphicon-play-circle" data-toggle="tooltip" title="play"></span>
          <span class="glyphicon glyphicon-heart-empty" data-toggle="tooltip" title="add to playlist"></span>
          &nbsp;&nbsp;&nbsp;&nbsp;The Weeknd: Sidewalks
        </th>
      </tr>
      <tr>
        <th>
          4 &nbsp;&nbsp;
          <span class="glyphicon glyphicon-play-circle" data-toggle="tooltip" title="play"></span>
          <span class="glyphicon glyphicon-heart-empty" data-toggle="tooltip" title="add to playlist"></span>
          &nbsp;&nbsp;&nbsp;&nbsp;Ryan Gosling: From "La La Land"
        </th>
      </tr>
      <tr>
        <th>
          5 &nbsp;&nbsp;
          <span class="glyphicon glyphicon-play-circle" data-toggle="tooltip" title="play"></span>
          <span class="glyphicon glyphicon-heart-empty" data-toggle="tooltip" title="add to playlist"></span>
          &nbsp;&nbsp;&nbsp;&nbsp;Thundercat: Uh Uh
        </th>
      </tr>
      <tr>
        <th>
          6 &nbsp;&nbsp;
          <span class="glyphicon glyphicon-play-circle" data-toggle="tooltip" title="play"></span>
          <span class="glyphicon glyphicon-heart-empty" data-toggle="tooltip" title="add to playlist"></span>
          &nbsp;&nbsp;&nbsp;&nbsp;The Chainsmokers: Something Just Like You
        </th>
      </tr>
      <tr>
        <th>
          7 &nbsp;&nbsp;
          <span class="glyphicon glyphicon-play-circle" data-toggle="tooltip" title="play"></span>
          <span class="glyphicon glyphicon-heart-empty" data-toggle="tooltip" title="add to playlist"></span>
          &nbsp;&nbsp;&nbsp;&nbsp;ThunderCat: Captain Stupido
        </th>
      </tr>
      <tr>
        <th>
          8 &nbsp;&nbsp;
          <span class="glyphicon glyphicon-play-circle" data-toggle="tooltip" title="play"></span>
          <span class="glyphicon glyphicon-heart-empty" data-toggle="tooltip" title="add to playlist"></span>
          &nbsp;&nbsp;&nbsp;&nbsp;The xx: Dangerous
        </th>
      </tr>
      <tr>
        <th>
          9 &nbsp;&nbsp;
          <span class="glyphicon glyphicon-play-circle" data-toggle="tooltip" title="play"></span>
          <span class="glyphicon glyphicon-heart-empty" data-toggle="tooltip" title="add to playlist"></span>
          &nbsp;&nbsp;&nbsp;&nbsp;John Legend: Start A Fire
        </th>
      </tr>
      <tr>
        <th>
          10 &nbsp;
          <span class="glyphicon glyphicon-play-circle" data-toggle="tooltip" title="play"></span>
          <span class="glyphicon glyphicon-heart-empty" data-toggle="tooltip" title="add to playlist"></span>
          &nbsp;&nbsp;&nbsp;&nbsp;Calvin Harris: Slide
        </th>
      </tr>
      </tbody>
    </table>
  </div>
  <hr>

  <div class="container" id="events">
    <h2>Events</h2>
    <div class="eventsPic">

    </div>
  </div>

</div>

<div class="container resultContainer">
</div>
<%@ include file="footer.jsp"%>
</body>
</html>
