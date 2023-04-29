<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
 pageEncoding="ISO-8859-1" isELIgnored="false"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<body style="background-color:lavender"> 
<h1><center> Welcome to Parcel Bill Generation </center></h1> <form:form method="post" action="/billDesk" modelAttribute="parcel"> 
<center> 
 <table> 
 <tr> 
 <td> 
 <form:label path="serviceType">Choose Service:</form:label> 
 </td> 
 <td> 
 <form:select path="serviceType" items="${serviceList}" id="serviceType" /> 
 </td> 
 </tr> 
 <tr> 
 <td> 
 <form:label path="weight">Weight</form:label> 
 </td> 
 <td> 
 <form:input path="weight" id="weight" /> 
 </td> 
 </tr> 
 <tr> 
 <td> 
 <input type="submit" name="submit" value="TotalCost"> 
 </td> 
 </tr> 
 </table> 
</center></form:form> 
</body></html>