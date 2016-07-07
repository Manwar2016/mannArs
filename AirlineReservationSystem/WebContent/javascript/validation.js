 
 

function validateSignupForm(formObject)
{
	var validForm = true;
	var password = formObject[2].value;
	var confirmPassword = formObject[3].value;
	if(password != confirmPassword){
		alert("Password did not match")
		formObject[2].focus();
	    validForm = false;
	}		
	return validForm;
}













