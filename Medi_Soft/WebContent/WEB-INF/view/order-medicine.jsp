<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
     
        <title>Medicine Center</title>

</head>

<body>

      <div id="wrapper">
         <div id="header">
              <h2>Medical Service  </h2>
         
         </div>
              
       </div>
       <div id ="container">
       
       <div id ="content">
       
        
       <!--  add out html table here -->
       
       
       <table>
             <tr>
                  <th>Medicine Name</th>
                  <th>Price Per </th>                 
             </tr>
             
             <c:forEach var="tempMedicine" items="${medicines}">   
             
                <c:url var="addToCartLink" value="/medicine/addToCart">
             <c:param name="medicineId" value="${tempMedicine.id}"/>
             </c:url>      
             
             <tr>
            
                 <td>${tempMedicine.medi_name }</td>
                 <td>${tempMedicine.price} BDT</td>
              <td>
               
                  
                  <a href="${addToCartLink }"
                  
                  onclick="if(!(confirm('Are you sure you want to purchased this medicine? ')))return false">Add To Cart</a>
                  
             </td>
             </tr>
            
            </c:forEach>
       
       </table>
       
       </div>
       
       </div>
  

</body>





</html>