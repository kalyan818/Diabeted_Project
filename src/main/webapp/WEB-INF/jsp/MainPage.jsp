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
			<center><label><h2 style="color:red; ">Welcome ${UserName}</h2></label></center>	
			<a href="/FillForm?UserName=${UserName}"><input type="button" value="Fill the Form"/></a><br>
			<a href="/PrintDetails?UserName=${UserName}"><input type="button" value="Print the Details"/></a>
		</div>
	</div>

</body> 
</html>