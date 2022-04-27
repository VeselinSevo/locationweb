<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<html>
   <head>
      <title>Display Locations</title>
   </head>



   <body>
   <h1>Search Location</h1>

         <form action = "search-location-by-name">
             <pre>
             Search by Name: <input type = "text" name = "name" value="insert name here"><br/>
             <input type = "hidden" name = "sort" value = "true">
             <input type = "submit" value = "Search"><br/>
             </pre>
             </form>
         <form action = "search-location-by-country">
              <pre>
              Search by Name: <input type = "text" name = "country" value="insert country here"><br/>
              <input type = "hidden" name = "sort" value = "true">
              <input type = "submit" value = "Search"><br/>
              </pre>
              </form>
         <form action = "display-locations">
              <pre>
              <input type = "submit" value = "Go Back To All Locations"><br/>
              </pre>
         </form>

      <h1>Locations:</h1>
      <table>
      <tr>
         <th>
         <button type="button" onclick="/sort-location-by-id">Sort</button>
         Id
         </th>
         <th>Post Number</th>
         <th>Name</th>
         <th>Country</th>
         <th>Type</th>
      </tr>

      <core:forEach items="${locations}" var="location">
         <tr>
            <td>${location.id}</td>
            <td>${location.post_number}</td>
            <td>${location.name}</td>
            <td>${location.country}</td>
            <td>${location.type}</td>
            <td><a href="delete-location?id=${location.id}">delete</a></td>
            <td><a href="edit-location?id=${location.id}">edit</a></td>
         </tr>
      </core:forEach>
      </table>

      <a href="show-create">Add Record</a>

   </body>

</html>