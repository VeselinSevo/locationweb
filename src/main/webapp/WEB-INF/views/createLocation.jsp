<html>
   <head>
      <title>Create Location</title>
      <link href="style.css" rel="stylesheet"/>
   </head>

   <body>
      <h1>Create Location</h1>

      <form action = "/save-location" method = "post">
      <pre>
      Id: ${newLocationId}<br/>
      Name: <input type = "text" name = "name"><br/>
      Country: <input type = "text" name = "country"><br/>
      Post Number: <input type = "text" name = "postNumber"><br/>
      Type: Urban <input type = "checkbox" name = "type" value="URBAN"><br/>
            Rural <input type = "checkbox" name = "type" value="RURAL"><br/>
            <input type = "submit" value = "Create"><br/>
      </pre>
      </form>
      ${msg}

      <a href="display-locations">View All</a>

   </body>

</html>