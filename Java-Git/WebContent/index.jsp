<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Taller Mecánico - Iniciar sesión</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/cover/">
    <link rel="shortcut icon" href="style/img/logo.png">

    <!-- Bootstrap core CSS -->
    <link href="style/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/css/inicio.css" rel="stylesheet">
  </head>
  <body class="text-center">        
    <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">    
      <header class="masthead mb-auto">
        <div class="inner">
          <h3 class="masthead-brand">Taller mecánico</h3>
          <nav class="nav nav-masthead justify-content-center">
            <a class="nav-link active" href="#">Iniciar sesión</a>
            <a class="nav-link" href="#">Nosotros</a>
            <a class="nav-link" href="#">Contacto</a>
          </nav>
        </div>
      </header>
      <main>
        <div class="container-fluid">
          <div class="col-lg-8 cover-text">    
            <h1 class="cover-heading">Taller mecánico</h1>
            <p class="lead">Inicie sesión para administrar las reparaciones, los vehículos y la facturación del taller.</p>
          </div>    
          <div class="col-lg-3 form-login">
            <form class="form-signin" method="POST" action="Login">
              <img class="mb-4 rounded" src="style/img/logo.png" alt="Logotipo del taller" width="72" height="72">
              <h1 class="h3 mb-3 font-weight-normal">Ingrese sus datos</h1>
              <!-- Email de acceso -->
              <label for="inputEmail" class="sr-only">Correo electrónico</label>
              <input type="email" name = "Email" id="inputEmail" class="form-control" placeholder="Correo electrónico" required>
              <!-- Password -->
              <label for="inputPassword" class="sr-only">Contraseña</label>
              <input type="password" name = "Password" id="inputPassword" class="form-control" placeholder="Contraseña" required>
              <div class="checkbox mb-3">
                <label>
                  <input type="checkbox" value="remember-me"> Recuérdame
                </label>
              </div>
              <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
              <p class="mt-5 mb-3 text-muted">&copy; 2017-2019</p>
            </form>
          </div>
        </div>
      </main>
      <footer class="mastfoot mt-auto">
        <div class="inner">
          <p>Cover template for <a href="https://getbootstrap.com/">Bootstrap</a>, by <a href="https://twitter.com/mdo">@mdo</a>.</p>
        </div>
      </footer>
    </div>
  </body>
</html>