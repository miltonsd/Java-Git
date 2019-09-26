<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Login</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/sign-in/">

    <!-- Bootstrap core CSS -->
<link href="style/css/bootstrap.min.css" rel="stylesheet">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="style/css/signin.css" rel="stylesheet">

  </head>
  <body class="text-center">
  
<form class="form-signin" method="POST" action="ControladorLogin">
  <img class="mb-4" src="https://getbootstrap.com/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
  <h1 class="h3 mb-3 font-weight-normal">Ingrese su correo</h1>
  <!-- Email de acceso -->
  <label for="inputEmail" class="sr-only">Email address</label>
  <input type="email" name = "Email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
  <!-- Password -->
  <label for="inputPassword" class="sr-only">Password</label>
  <input type="password" name = "Password" id="inputPassword" class="form-control" placeholder="Password" required>
  
  
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> Remember me
    </label>
  </div>
  
  <button class="btn btn-lg btn-primary btn-block" type="submit">Acceder</button>
  <p class="mt-5 mb-3 text-muted">&copy; 2017-2019</p>
  
</form>

</body>
</html>