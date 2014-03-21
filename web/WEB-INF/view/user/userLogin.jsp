<%@include file="publicHeader.jsp" %>  
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    <div class="container">

      <form:form class="form-signin" commandName="user">
        <br>
        <a class="btn btn-lg btn-success btn-block" href="userSignUp" type="submit">Sign Up</a>
        <br>
        <br>
        <h2 class="form-signin-heading">Please sign in</h2>
        <form:errors path="userEmail"></form:errors>
        <form:errors path="userPassword"></form:errors>
        <form:input type="text" path="userEmail" class="form-control" placeholder="Email address" ></form:input>
        <form:input type="password" path="userPassword" class="form-control" placeholder="Password"></form:input>
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me 
          
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        
      </form:form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>