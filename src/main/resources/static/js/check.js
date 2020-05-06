// Terms of Use Checkmark

// var submit = document.getElementById("termsChecked"),
//   checkbox = document.getElementById("accept_checked"),
//   disableSubmit = function (e) {
//     submit.disabled = this.checked;
//   };

// checkbox.addEventListener("change", disableSubmit);

// Register email/password verification
const email = document.getElementById("email");
console.log(email);
email.addEventListener("change", checkEmail);
function checkEmail() {
  var str2 = document.getElementById("email").value;
  if (
    str2.search(/^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/) ==
    -1
  ) {
    document.getElementById("validationEmail").innerHTML =
      "Email address is invalid!";
    //  document.getElementById("validationEmail").style.color = "Red";
  } else {
    document.getElementById("validationEmail").innerHTML = "";
  }
}
document
  .getElementById("confirmEmail")
  .addEventListener("change", checkIfBothEmailsAreCorect);
function checkIfBothEmailsAreCorect() {
  var secondEmail = document.getElementById("confirmEmail").value;
  if (secondEmail != document.getElementById("email").value) {
    // in real world you should do the opposite and make sure it equals and reject everything else.
    document.getElementById("validationEmailVerify").innerHTML =
      "Emails do not match!";
  } else document.getElementById("validationEmailVerify").innerHTML = "";
}

document.getElementById("password").addEventListener("change", pwdcheck);
function pwdcheck() {
  var str = document.getElementById("password").value;
  if (str.length < 8) {
    document.getElementById("passwordError").innerHTML =
      "Password length must be at least eight characters!";
  } else if (str.search(/[0-9]/) == -1) {
    document.getElementById("passwordError").innerHTML =
      "At least one numeric value must be entered!";
    return "no_number";
  } else if (str.search(/[a-z]/) == -1) {
    document.getElementById("passwordError").innerHTML =
      "At least one lowercase letter must be entered!";
    return "no_lower_letter";
  } else if (str.search(/[A-Z]/) == -1) {
    document.getElementById("passwordError").innerHTML =
      "At least one uppercase letter must be entered!";
    return "no_upper_letter";
  } else if (str.search(/[!\@\#\$\%\^\&\*\:\,\;]/) == -1) {
    document.getElementById("passwordError").innerHTML =
      "At least one special character must be entered!";
    return "no_special_char";
  } else {
    document.getElementById("passwordError").innerHTML = "";
  }
}
document
  .getElementById("confirmPassword")
  .addEventListener("change", confirmcheck);
function confirmcheck() {
  var pass = document.getElementById("password");
  var cpass = document.getElementById("confirmPassword");
  if (pass.value != cpass.value) {
    document.getElementById("confirmPasswordError").innerHTML =
      "Passwords do not match!";
  } else {
    document.getElementById("confirmPasswordError").innerHTML = "";
  }
}
document.getElementById("sButton").addEventListener("click", (e) => {
  const terms = document.getElementById("terms");
  if (!terms.checked) {
    document.getElementById("termError").value = "Please check our terms.";
    e.preventDefault();
  } else {
    document.getElementById("termError").value = "";
  }
});
