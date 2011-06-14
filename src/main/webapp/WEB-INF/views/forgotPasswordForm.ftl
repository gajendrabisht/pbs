<#import "spring.ftl" as spring/>
<html>
	<title>Forgot Password</title>
<body>
<h1>Forgot Password</h1>
<form name="forgotPassword" method="post">
	<label>Email</label>
	<@spring.formInput "forgotPassword.email"/>
	<input type="submit" value="SUBMIT"/>
	<@spring.showErrors "<br/>"/>
</form>
</body>
</html>
