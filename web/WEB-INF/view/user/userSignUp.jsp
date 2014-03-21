<%@include file="publicHeader.jsp" %>  
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    <div class="container">

      <form:form class="form-signin" commandName="userForm" method="POST" action="userSignUp">
        <h3>Please fill in your details to sign up</h3>
        
		<div class="form-group">
			<form:label for="name" path="userName">Name:</form:label>
			<form:input type="text" path="userName" class="form-control" id="name" placeholder="Full Name" />
			<form:errors path="userName" cssClass="errors"></form:errors>
		</div>
		<div class="form-group">
			<form:label for="email" path="userEmail">Email:</form:label>
			<form:input type="text" path="userEmail" class="form-control" id="email" placeholder="Email" />
			<form:errors path="userEmail" cssClass="errors"></form:errors>
		</div>
		<div class="form-group">
			<form:label for="pass" path="userPassword">Password:</form:label>
			<form:input type="password" path="userPassword" class="form-control" id="pass" placeholder="Password" />
			<form:errors path="userPassword"></form:errors>
		</div>
		<div class="form-group">
			<form:label for="passconfirm" path="userConfirmPassword">Confirm Password:</form:label>
			<form:input type="password" path="userConfirmPassword" class="form-control" id="passconfirm" placeholder="Confirm Password" />
			<form:errors path="userConfirmPassword"></form:errors>
		</div>
        <button class="btn btn-lg btn-primary" type="submit">Sign Up</button>
        
      </form:form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>