// Terms of Use Checkmark

var submit = document.getElementById('termsChecked'),
    checkbox = document.getElementById('accept_checked'),
    disableSubmit = function(e) {
        submit.disabled = this.checked
    };

checkbox.addEventListener('change', disableSubmit);

// Register email/password verification

emailcheck = function (validate) {

var str2 = document.getElementById('email').value;
	if(str2.search(/^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/) == -1) {

		document.getElementById("result2").innerHTML = "Email address is invalid!"
		document.getElementById("result2").style.color = "Red";
	}
	else{
		document.getElementById("result2").innerHTML = "Successful"
		document.getElementById("result2").style.color = "Green";
		return("ok");
	}
}

pwdcheck = function (validate){

var str = document.getElementById('pwd').value;
	if(str.length < 8) {

		document.getElementById("result").innerHTML = "Password length must be at least eight characters!"
		document.getElementById("result").style.color = "Red";
		return("too_short");
	}

	else if (str.search(/[0-9]/) == -1) {
		document.getElementById("result").innerHTML = "At least one numeric value must be entered!"
		document.getElementById("result").style.color = "Red";
		return("no_number");
	}

	else if (str.search(/[a-z]/) == -1) {
		document.getElementById("result").innerHTML = "At least one lowercase letter must be entered!"
		document.getElementById("result").style.color = "Red";
		return("no_lower_letter");
	}

	else if (str.search(/[A-Z]/) == -1) {
		document.getElementById("result").innerHTML = "At least one uppercase letter must be entered!"
		document.getElementById("result").style.color = "Red";
		return("no_upper_letter");
	}

	else if (str.search(/[!\@\#\$\%\^\&\*\:\,\;]/) == -1) {
		document.getElementById("result").innerHTML = "At least one special character must be entered!"
		document.getElementById("result").style.color = "Red";
		return("no_special_char");
	}

		document.getElementById("result").innerHTML = "Password validation successful."
		document.getElementById("result").style.color = "Green";
		return("ok");

}

confirmcheck = function (validate) {

var str3 = document.getElementById('pwd2').value;
var str4 = document.getElementById('pwd').value;
	if(str3 != str4) {

		document.getElementById("result3").innerHTML = "Passwords do not match!"
		document.getElementById("result3").style.color = "Red";
	}
	else {
		document.getElementById("result3").innerHTML = "Passwords match."
		document.getElementById("result3").style.color = "Green";
		return("ok");
	}
}
