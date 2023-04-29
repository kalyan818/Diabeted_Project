<%@page import="java.util.Base64"%>
<%@page import="com.example.demo4.Images"%>
<%@page import="java.util.List"%>
<%@page isELIgnored="false" %> 
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
		<form action="/ShowImage" method="post">
			<center><label>Images</label></center><br>
			 <table>
          <h1>Images</h1>
          
          
     
    <% List<Images> images = (List<Images>) request.getAttribute("images"); %>
    
    <% for (Images image : images) { %>
    <input type="radio" name="Car" value="<%= image.getCarName()%>" required="required">
        <img src="data:image/png;base64, <%= new String(Base64.getEncoder().encode(image.getCar())) %>" style="height: 50px; width: 50px"/> 
           <% } %> <br>
            <% for (Images image : images) { %>
          <input type="radio" name="Traffic" value="<%= image.getTrafficName()%>" required="required">
        <img src="data:image/png;base64, <%= new String(Base64.getEncoder().encode(image.getTraffic())) %>" style="height: 50px; width: 50px"/>  
            <% } %> <br>
            <% for (Images image : images) { %> 
          <input type="radio" name="Tree" value="<%= image.getTreeName()%>" required="required">
        <img src="data:image/png;base64, <%= new String(Base64.getEncoder().encode(image.getTree())) %>" style="height: 50px; width: 50px"/>      
    <% } %>
    </table>
			
			
			<input type="submit" value="submit"/>
			</form>
		</div>
	</div>
</body> 
</html>