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
		<center><label>Forget Password</label></center>
		<form action="/ForgetPassword" method="post">
		<table>
		<tr>
		<td>
		<label>Email:</label>
		</td>
		<td>
		<input type="email" id="Email" name="Email" required="required"/>
		</td>
		</tr>
		<tr>
		<td>
		<input type="submit" value="submit"/>
		</td>
		</tr>
		</table>
			</form>
		</div>
	</div>

</body> 
</html>