<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>

  <title>List Donor</title>

</head>

<body>

       <div id="wrapper">
         <div id="header">
              <h2>MOS-Medical Online Service</h2>
         
         </div>
              
       </div>
       <div id ="container">
       
       <div id ="content">
       
         <input type="button" value="Add Donor"
                onClick="window.location.href='showFormForAdd'; return false;"/>
       <!--  add out html table here -->
       
       <table>
             <tr>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Phone Number</th>
                  <th>Blood Group</th>
             </tr>
             
             <c:forEach var="tempDonor" items="${donors}">
             
             
             <c:url var="updateLink" value="/donor/showFormForUpdate">
             <c:param name="donorId" value="${tempDonor.id}"/>
             </c:url>
             
             
             <c:url var="deleteLink" value="/donor/delete">
             <c:param name="donorId" value="${tempDonor.id}"/>
             </c:url>
             
             <tr>
             
                 <td>${tempDonor.firstName }</td>
                 <td>${tempDonor.lastName }</td>
                 <td>${tempDonor.phoneNumber }</td>
                 <td>${tempDonor.bloodGroup }</td>            
             
             <td>
                  <a href="${updateLink }">Update</a>
                  |
                  <a href="${deleteLink }"
                  onclick="if(!(confirm('Are you sure you want to delete this donor? ')))return false">Delete</a>
             </td>
             
             </tr>
             
            </c:forEach>
       
       </table>
       
       </div>
       
       
       </div>


</body>






</html>