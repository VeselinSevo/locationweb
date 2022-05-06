<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<html>
   <head>
      <title>Display Locations</title>
      <link href="style.css" rel="stylesheet"/>
   </head>

   <body>
   <h1>Search Location</h1>

         <form action = "/search-location-by-name">
             <pre>
             Search by Name: <input type = "text" name = "name" value="insert name here"><br/>
             <input type = "hidden" name = "sort" value = "true">
             <input type = "submit" value = "Search"><br/>
             </pre>
             </form>
         <form action = "/search-location-by-country">
              <pre>
              Search by Country: <input type = "text" name = "country" value="insert country here"><br/>
              <input type = "hidden" name = "sort" value = "true">
              <input type = "submit" value = "Search"><br/>
              </pre>
              </form>
         <form action = "/display-locations">
              <pre>
              <input type = "submit" value = "Go Back To All Locations"><br/>
              </pre>
         </form>

      <h1>Locations:</h1>
      <table>
      <tr>
          <th><button class="btn" type="button" onclick="location.href='/sort-location-by-id'">Sort</button></th>
          <th><button class="btn" type="button" onclick="location.href='/sort-location-by-name'">Sort</button></th>
          <th><button class="btn" type="button" onclick="location.href='/sort-location-by-country'">Sort</button></th>
          <th><button class="btn" type="button" onclick="location.href='/sort-location-by-postNumber'">Sort</button></th>
          <th><button class="btn" type="button" onclick="location.href='/sort-location-by-type'">Sort</button></th>
      </tr>
     <tr>
         <th>Id< /th>
         <th>Name</th>
         <th>Country</th>
         <th>Post Number</th>
         <th>Type</th>
      </tr>

      <core:forEach items="${locations}" var="location">
      <tr>
            <td>${location.id}</td>
            <td>${location.name}</td>
            <td>${location.country}</td>
            <td>${location.postNumber}</td>
            <td>${location.type}</td>
            <td><a href="/delete-location?id=${location.id}">delete</a></td>
            <td><a href="/edit-location?id=${location.id}">edit</a></td>
      </tr>
      </core:forEach>
      </table>

      <a href="show-create">Add Record</a><br/>
      <button type="button" onclick="location.href='/generate-report'">View Chart</button>

   </body>
</html>