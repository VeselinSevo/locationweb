<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<html>
   <head>
      <title>Create Location</title>
   </head>

   <body>
      <h1>Create Location</h1>
      <form action = "update-location" method = "post">
      <pre>
      Id: <input type = "text" name = "id" value="${location.id}" readonly="true"><br/>
      Post Number: <input type = "text" name = "post_number" value="${location.post_number}"><br/>
      Name: <input type = "text" name = "name" value="${location.name}"><br/>
      Country: <input type = "text" name = "country" value="${location.country}"><br/>
      Type: Urban <input type = "checkbox" name = "type" value="URBAN" ${location.type=='URBAN'?'checked':''}><br/>
            Rural <input type = "checkbox" name = "type" value="RURAL" ${location.type=='RURAL'?'checked':''}><br/>
            <input type = "submit" value = "Create"><br/>
      </pre>
      </form>
   </body>

</html>