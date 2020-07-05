function validatePassword() {
	var password = document.getElementById("password");
	var confirmPassword = document.getElementById("confirmPassword");
	
	if(password.value != confirmPassword.value) {
		console.log("validate_if");
		confirmPassword.setCustomValidity("Passwords Don't Match");
		confirmPassword.classList.add("inputError");
  } else {
	  console.log("validate_else");
	  confirmPassword.setCustomValidity('');
	  confirmPassword.classList.remove("inputError");
  }
}