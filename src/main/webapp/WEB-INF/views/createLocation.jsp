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
      Name: <input type = "text" class ="form__input" name = "name" placeholder="Name"><br/>
      Country: <input type = "text" class ="form__input" name = "country" placeholder="Country"><br/>
      Post Number: <input type = class ="form__input" "text" name = "postNumber" placeholder=Post Number><br/>
      Type: Urban <input type = "checkbox" id = "urban" name = "type" value="URBAN"><br/>
            Rural <input type = "checkbox" id = "rural" name = "type" value="RURAL"><br/>
      Email: <input type = "text" class ="form__input" name = "email" placeholder="Email" required="false"><br/>
            <input type = "submit" value = "Create"><br/>
      </pre>
      </form>

      ${msg}

      <a href="display-locations">View All</a>

   </body>

</html>