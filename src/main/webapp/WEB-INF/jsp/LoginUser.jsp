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
		<form action="/LoginUser" method="post">
			<center><label><h2 style="color:red; ">${message}</h2></label></center>
			<center><label>Login User</label></center><br>
			<table>
			<tr>
			<td>
			<label>Username:</label>
			</td>
			<td>
			<input type="text" id="Username" name="Username" required/>
			</td>
			</tr>		
			<tr>
			<td>
			<label>First Password:</label>
			</td>
			<td>
			<input type="password" id="Password" name="Password" required/>
			</td>
			</tr>	
			<tr>
			<td>
			<label>Second Password:</label>
			</td>
			</tr>	
			<tr>
			<td>
			<select name="SecondPasswordQuestion1" id="SecondPassword1" onchange="onChangeField1()" style="width: 100px">
					<option
						value="What is the name of a college you applied to but didnt attend?">
						What is the name of a college you applied to but didnt attend?</option>
					<option
						value="What was the name of the first school you remember attending?">
						What was the name of the first school you remember attending?</option>
					<option
						value="Where was the destination of your most memorable school field trip?">
						Where was the destination of your most memorable school field trip?</option>
					<option
						value="What was your maths teachers surname in your 8th year of school?">
						What was your maths teachers surname in your 8th year of school?</option>
					<option
						value="What was the name of your first stuffed toy?">
						What was the name of your first stuffed toy?</option>
					<option
						value="What was your driving instructors first name?">
						What was your driving instructors first name?</option>
					<option
						value="Custom Question1">Custom Question1</option>
				</select><br>
				<input type="text" id="CustomQuestion1" name="CustomQuestion1" disabled="disabled"/>
			</td>
			<td>
			<input type="text" id="Answer1" name="SecondPasswordAnswer1" required="required"/>
			</td>
			</tr>		
			<tr>
			<td>
			<select name="SecondPasswordQuestion2"  id="SecondPassword2" onchange="onChangeField2()" style="width: 100px">
					<option
						value="What is the name of a college you applied to but didnt attend?">
						What is the name of a college you applied to but didnt attend?</option>
					<option
						value="What was the name of the first school you remember attending?">
						What was the name of the first school you remember attending?</option>
					<option
						value="Where was the destination of your most memorable school field trip?">
						Where was the destination of your most memorable school field trip?</option>
					<option
						value="What was your maths teachers surname in your 8th year of school?">
						What was your maths teachers surname in your 8th year of school?</option>
					<option
						value="What was the name of your first stuffed toy?">
						What was the name of your first stuffed toy?</option>
					<option
						value="What was your driving instructors first name?">
						What was your driving instructors first name?</option>
					<option
						value="Custom Question2">Custom Question2</option>
				</select><br>
				<input type="text" id="CustomQuestion2" name="CustomQuestion2" disabled="disabled"/>
			</td>
			<td>
			<input type="text" id="Answer2" name="SecondPasswordAnswer2"="required"/>
			</td>
			</tr>		
			<tr>
			<td>
			<select name="SecondPasswordQuestion3"  id="SecondPassword3" onchange="onChangeField3()" style="width: 100px">
					<option
						value="What is the name of a college you applied to but didnt attend?">
						What is the name of a college you applied to but didnt attend?</option>
					<option
						value="What was the name of the first school you remember attending?">
						What was the name of the first school you remember attending?</option>
					<option
						value="Where was the destination of your most memorable school field trip?">
						Where was the destination of your most memorable school field trip?</option>
					<option
						value="What was your maths teachers surname in your 8th year of school?">
						What was your maths teachers surname in your 8th year of school?</option>
					<option
						value="What was the name of your first stuffed toy?">
						What was the name of your first stuffed toy?</option>
					<option
						value="What was your driving instructors first name?">
						What was your driving instructors first name?</option>
					<option
						value="Custom Question3">Custom Question3</option>
				</select><br>
				<input type="text" id="CustomQuestion3" name="CustomQuestion3" disabled="disabled"/>
			</td>
			<td>
			<input type="text" id="Answer3" name="SecondPasswordAnswer3" required="required"/>
			</td>
			</tr>
			 <% List<Images> images = (List<Images>) request.getAttribute("images"); %>	
			<tr>
			<td>
			  <% for (Images image : images) { %>
    <input type="radio" name="ThirdPasswordCar" value="<%= image.getCarName()%>" required="required">
        <img src="data:image/png;base64, <%= new String(Base64.getEncoder().encode(image.getCar())) %>" style="height: 50px; width: 50px"/> 
           <% } %>
			<td>
			</tr>	
			<tr>			
			<td>			
		 <% for (Images image : images) { %>
          <input type="radio" name="ThirdPasswordTraffic" value="<%= image.getTrafficName()%>" required="required">
        <img src="data:image/png;base64, <%= new String(Base64.getEncoder().encode(image.getTraffic())) %>" style="height: 50px; width: 50px"/>  
            <% } %>
			</td>
			</tr>		
			<tr>			
			<td>		
			 <% for (Images image : images) { %> 
          <input type="radio" name="ThirdPasswordTree" value="<%= image.getTreeName()%>" required="required">
        <img src="data:image/png;base64, <%= new String(Base64.getEncoder().encode(image.getTree())) %>" style="height: 50px; width: 50px"/>      
    <% } %>
			</td>		
			</tr>
			<td>
			<a href="/ForgetPassword">ForgetPassword?</a>
			</td>
			<td>
			<input type="submit" value="submit"/>
			</td>
			</tr>			
			</table>		
			</form>
		</div>
	</div>
	<script>
  var passwordInput = document.getElementById("Password");
  passwordInput.setCustomValidity("Password should contain at least 8 characters, one uppercase letter, one lowercase letter, one symbol, and one number");
  passwordInput.addEventListener("input", function(event) {
    var password = passwordInput.value;
    var regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    if (regex.test(password)) {
      passwordInput.setCustomValidity("");
    }
  });
  function onChangeField1() {
	  var dropdown = document.getElementById("SecondPassword1");
	  var inputField = document.getElementById("CustomQuestion1");
	  if (dropdown.value === "Custom Question1") {
	    inputField.disabled = false;
	  } else {
	    inputField.disabled = true;
	  }
	}
  function onChangeField2() {
	  var dropdown = document.getElementById("SecondPassword2");
	  var inputField = document.getElementById("CustomQuestion2");
	  if (dropdown.value === "Custom Question2") {
	    inputField.disabled = false;
	  } else {
	    inputField.disabled = true;
	  }
	}
  function onChangeField3() {
	  var dropdown = document.getElementById("SecondPassword3");
	  var inputField = document.getElementById("CustomQuestion3");
	  if (dropdown.value === "Custom Question3") {
	    inputField.disabled = false;
	  } else {
	    inputField.disabled = true;
	  }
	}
  function check() {
	  var dropdown = document.getElementById("SecondPassword1");
	  var inputField1 = document.getElementById("CustomQuestion1");
	  var inputField2 = document.getElementById("CustomQuestion2");
	  var inputField3 = document.getElementById("CustomQuestion3");  
	  if (!inputField1.disabled && inputField1.value === "") {
		    alert("Custom Question1 cannot be empty!");
		    event.preventDefault(); // Prevents form submission
		  }
	  if (!inputField2.disabled && inputField2.value === "") {
		    alert("Custom Question2 cannot be empty!");
		    event.preventDefault(); // Prevents form submission
		  }
	  if (!inputField3.disabled && inputField3.value === "") {
		    alert("Custom Question3 cannot be empty!");
		    event.preventDefault(); // Prevents form submission
		  }
	}
</script>
</body> 
</html>