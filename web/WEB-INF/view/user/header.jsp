<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>Etyme Dashboard</title>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="<c:url value="/resources/js/html5shiv.js"/>"></script>
      <script src="<c:url value="/resources/js/respond.min.js"/>"></script>
    <![endif]-->
    
    <script src="<c:url value="/resources/js/jquery1.10.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
    <link href="<c:url value="/resources/js/select2/select2.css"/>" rel="stylesheet">
    <script src="<c:url value="/resources/js/select2/select2.js"/>"></script>
    <style>
	  body {
	    padding-top: 60px;
	  }
	</style>
  </head>
  
  <body>
  
	<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Etyme</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Dashboard</a></li>
            <li><a href="jobs">Jobs</a></li>
            <li><a href="candidates">Candidates</a></li>
            <li><a href="#contact">Contacts</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>