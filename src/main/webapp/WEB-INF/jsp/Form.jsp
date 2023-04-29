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
		<form action="/FillForm" method="post">
			<center><label>Diabetes</label></center><br>
			<table>
			<tr>
			<td>
			<label>Date:</label>
			</td>
			 
			<td>
			<input type="date" id="Date" name="Date"/>
			</td>
			</tr>
			<tr>
			<td>
			<label>Time:</label>
			</td>
			
			<td>
			<input type="time" id="TimeBefore" name="TimeBefore"/>
			</td>
			</tr>
			<tr>
			<td>
			<label>BloodSugar Level in AM:</label>
			</td>
			
			<td>
			<input type="number" id="BloodLevelBefore" name="BloodLevelBefore" />
			</td>
			</tr>
			
			<tr>
			<td>
			<label>Time:</label>
			</td>
			
			<td>
			<input type="time" id="TimeAfter" name="TimeAfter"/>
			</td>
			</tr>
			<tr>
			<td>
			<label>BloodSugar Level in PM:</label>
			</td>
			
			<td>
			<input type="number" id="BloodLevelAfter" name="BloodLevelAfter"/>
			</td>
			</tr>
			
			
			
			<tr>
			<td>
			<label>Breakfast:</label>
			</td>
			
			<td>
			<input type="text" id="Breakfast" name="Breakfast" maxlength="254"/>
			</td>
			</tr>
			
			<tr>
			<td>
			<label>Lunch:</label>
			</td>
			
			<td>
			<input type="text" id="Lunch" name="Lunch" maxlength="254"/>
			</td>
			</tr>
			
			<tr>
			<td>
			<label>Dinner:</label>
			</td>
			
			<td>
			<input type="text" id="Dinner" name="Dinner" maxlength="254"/>
			</td>
			</tr>
			
			
			
			
			
			
			<input type="hidden" name="UserName" id="UserName" value="${UserName}"/>
			</table>
			
			
			<input type="submit" value="submit"/>
			</form>
		</div>
	</div>
<script>
	 var passwordInput = document.getElementById("NewPassword");
	  passwordInput.setCustomValidity("Password should contain at least 8 characters, one uppercase letter, one lowercase letter, one symbol, and one number");
	  passwordInput.addEventListener("input", function(event) {
	    var password = passwordInput.value;
	    var regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
	    if (regex.test(password)) {
	      passwordInput.setCustomValidity("");
	    }
	  });
	  </script>
</body> 
</html>