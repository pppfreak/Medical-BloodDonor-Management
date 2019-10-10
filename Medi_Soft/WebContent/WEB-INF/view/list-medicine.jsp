<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
     
        <title>Medicine Center For Developer</title>

</head>

<body>

      <div id="wrapper">
         <div id="header">
              <h2>MOS-Medical Online Service</h2>
         
         </div>
              
       </div>
       <div id ="container">
       
       <div id ="content">
       
         <input type="button" value="Add Medicine"
                onClick="window.location.href='showFormForAdd'; return false;"/>
       <!--  add out html table here -->
       
       <table>
             <tr>
                  <th>Medicine Name</th>
                  <th>Price Per medicine</th>                 
             </tr>
             
             <c:forEach var="tempMedicine" items="${medicines}">
             
             
             <c:url var="updateLink" value="/medicine/showFormForUpdate">
             <c:param name="medicineId" value="${tempMedicine.id}"/>
             </c:url>
             
             
             <c:url var="deleteLink" value="/medicine/delete">
             <c:param name="medicineId" value="${tempMedicine.id}"/>
             </c:url>
             
             <tr>
             
                 <td>${tempMedicine.medi_name }</td>
                 <td>${tempMedicine.price} BDT</td>
                 
                       
             
             <td>
                  <a href="${updateLink }">Update</a>
                  |
                  <a href="${deleteLink }"
                  onclick="if(!(confirm('Are you sure you want to delete this medicine? ')))return false">Delete</a>
             </td>
             
             </tr>
             
            </c:forEach>
       
       </table>
       
       </div>
       
       
       </div>
  

</body>





</html>