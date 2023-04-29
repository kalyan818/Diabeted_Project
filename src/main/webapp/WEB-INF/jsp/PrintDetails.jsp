<%@page import="java.util.List"%>
<%@page import="com.example.demo4.FormModel"%>
<%@page isELIgnored="false" %> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html> 
<head>
<style>
		.container {
			display: flex;
			align-items: center;
			justify-content: center;
			height: 100vh; 
		}
	</style>
	

</head>
<body bgcolor="lavender"> 

<div class="container">
		<div>
		<center><label><h2 style="color:red; ">${message}</h2></label></center>
		 <table>
        <thead>
            <tr>
                <th>UserName</th>
                <th>Date</th>
                <th>BloodLevelBefore</th>
                <th>Breakfast</th>
                <th>Lunch</th>
                <th>Dinner</th>
                <th>BloodLevelAfter</th>
            </tr>
        </thead>
        <tbody>
		 <% 
            List<FormModel> Details = (List<FormModel>) request.getAttribute("UserDetails");
            for (FormModel data : Details) {
            %>
            
            <tr>
                <td><%= data.getUserName() %></td>
                <td><%= data.getDate() %></td>
                <td><%= data.getBloodLevelBefore() %></td>
                <td><%= data.getBreakfast()%></td>
                <td><%= data.getLunch() %></td>
                <td><%= data.getDinner()%></td>
                <td><%= data.getBloodLevelAfter()%></td>
            </tr>
            <% } %>
            </tbody>
    </table>
    <style>
  table {
    border: 1px solid black; /* sets a black border with 1px width */
    border-collapse: collapse; /* collapses the border into a single line */
  }
  th, td {
    border: 1px solid black; /* sets a black border with 1px width for table cells */
    padding: 10px; /* adds some padding to cells for better readability */
  }
</style>
		</div>
	</div>
</body> 
</html>