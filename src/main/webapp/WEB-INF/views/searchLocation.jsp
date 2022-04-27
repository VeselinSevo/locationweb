<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<html>
   <head>
      <title>Create Location</title>
      <link href="style.css" rel="stylesheet"/>
   </head>

   <body>
      <h1>Search Location</h1>

      <form action = "search-location">
      <pre>
      Search by Name: <input type = "text" name = "name" value="insert name here"><br/>
      <input type = "submit" value = "Search"><br/>
      </pre>
      </form>
      <h1>Locations:</h1>
            <table>
            <tr>
               <th>Id</th>
               <th>Post Number</th>
               <th>Name</th>
               <th>Country</th>
               <th>Type</th>
            </tr>
            <core:forEach items="${locations}" var="location">
            <tr>
               <td>${location.id}</td>
               <td>${location.postNumber}</td>
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