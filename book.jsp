<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>new registration</title>

</head>
<body>
<div id="wrapper">

<div id="login_form">
 <h1>LOGIN FORM</h1>
 <p id="login_label">Email : demo@demo.com | Password : demo</p>
 <form>
  <input type="text" name="emailid" id="emailid" placeholder="Enter Email">
  <br>
  <input type="password" name="password" id="password" placeholder="***********">
  <br>
  <input type="button" name="login" value="DO LOGIN" id="login_button" onClick="loginBtn()">
 </form>
</div>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
function loginBtn()
{
	 var username = $("#emailid").val().trim();
     var password = $("#password").val().trim();
     console.log("Clicked")

     if( username != "" && password != "" ){
     	let link='http://localhost:8080/Demo/Login?username='+username+'&password='+password
     	console.log(link)
         var aa=$.ajax({
             url:link,
             type:'GET',
         
             success:function(response){
             	console.log(response)
                 var msg = "";
                 if(response == "1"){
                    alert("success" + response)
                    window.location="/Demo/index.html"
                 }else{
                     alert("Invalid username and password!" + response);
                 }
             }
         
         });
     }
}
</script>
</body>
</html>