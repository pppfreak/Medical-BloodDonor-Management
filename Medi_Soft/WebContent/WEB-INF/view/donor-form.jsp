<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>

<head>

     <title>Save Donor</title>
  <style>
       
       .error{color: red}

       </style>
</head>
<body>
        
        <div id="wrapper">
            <div id="header">
            <h2>Donor Relationship Manager</h2>
                      
            </div>        
        
        </div>
        <div id=container>
        
         <h3>Save Donor</h3>
        <form:form action="saveDonor" modelAttribute="donor" method="POST">
          <form:hidden path="id"/>
            <table>
                 <tbody>
                        <tr>
                             <td><label>First name:</label></td>
                             <td><form:input path="firstName"/>
                              <form:errors path = "firstName" cssClass = "error"></form:errors>
                              </td>
                        </tr>
                        
                        <tr>
                             <td><label>Last name:</label></td>
                             <td><form:input path="lastName"/>
                              <form:errors path = "lastName" cssClass = "error"></form:errors>
                              </td>
                        </tr>
                        
                        <tr>
                             <td><label>Phone number:</label></td>
                             <td><form:input path="phoneNumber"/>
                              <form:errors path = "phoneNumber" cssClass = "error"></form:errors>
                              </td>
                        </tr>
                        
                        <tr>
                             <td><label>Blood group:</label></td>
                             <td><form:input path="bloodGroup"/>
                              <form:errors path = "bloodGroup" cssClass = "error"></form:errors>
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
                   <a href="/Medi_Soft/donor/list">Back to list></a>
                 
                </p>
        </div>

</body>



</html>
