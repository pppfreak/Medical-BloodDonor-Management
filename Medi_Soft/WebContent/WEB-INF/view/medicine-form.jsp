<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>

<head>

     <title>Save Medicine</title>
  <style>
       
       .error{color: green}

       </style>
</head>
<body>
        
        <div id="wrapper">
            <div id="header">
            <h2>Medicine Provider form</h2>
                      
            </div>        
        
        </div>
        <div id=container>
        
         <h3>Save Medicine</h3>
        <form:form action="saveMedicine" modelAttribute="medicine" method="POST">
          <form:hidden path="id"/>
            <table>
                 <tbody>
                        <tr>
                             <td><label>Medicine name:</label></td>
                             <td><form:input path="medi_name"/>
                              <form:errors path = "medi_name" cssClass = "error"></form:errors>
                              </td>
                        </tr>
                        
                        <tr>
                             <td><label>Price:</label></td>
                             <td><form:input path="price"/>
                              <form:errors path = "price" cssClass = "error"></form:errors>
                              </td>
                        </tr>                        
                                        
                        <tr>
                             <td><label></label></td>
                             <td><input type="submit" value="Save"/></td>
                        </tr>
                 </tbody>                    
            
            </table>
            </form:form>
                <p>
                   <a href="/Medi_Soft/medicine/list">Back to list></a>
                 
                </p>
        </div>

</body>



</html>
