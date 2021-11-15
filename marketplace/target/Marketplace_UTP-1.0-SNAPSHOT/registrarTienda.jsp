<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Seleccionar"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Script para mostrar las coordenadas-->
		<script src="js/obtienelatitud.js"></script>
        <title>Registrar Tienda</title>

        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">
        <!-- Site Icons -->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="css/estilosRegPed.css">
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Site CSS -->
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/ownstyle.css">
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/custom.css">
        <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
        <link rel="stylesheet" type="text/css" href="./css/map.css" />
        <script src="./js/map.js"></script>
    </head>
    <body>
        <!-- BARRA NAVEGACIÃN-->
    <header class="main-header">
        <!-- Start Navigation -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
            <div class="container">
                <!-- Start LOGO -->
                <div class="navbar-header">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                    <a class="navbar-brand" href="index.html"><img src="images/logo.png" class="logo" alt=""></a>
                </div>
                <!-- End LOGO -->
                <div class="collapse navbar-collapse" id="navbar-menu">
                        <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                            <li class="nav-item active"><a class="nav-link" href="index.jsp">Inicio</a></li>
                            <li class="nav-item"><a class="nav-link" href="nosotros.jsp">Nosotros</a></li>
                            <li class="nav-item"><a class="nav-link" href="ControladorCargarCriteriosCliente">Registrar cliente</a></li>  
                            <li class="nav-item"><a class="nav-link" href="ControladorCargarCriteriosVendedor">Registrar vendedor</a></li> 
                            <li class="nav-item"><a class="nav-link" href="login.jsp">Iniciar sesion</a></li>
                        </ul>
                    </div>

            </div>
            
        </nav>
        <!-- End Navigation -->
    </header>
    <!-- REGISTRO FORMULARIO TIENDA -->     
        <form action="ControladorTiendaNuevo" method="POST">
        <div class="form">
            <h1>Formulario de Registro de Tiendas</h1>
            <div class="grupo">
                <input minlength="5" maxlength="20" type="text" name="nombre" id="nombret" required="" pattern="[a-z,A-Z,0-9, ,]+"><span class="barra"></span>
                <label for="">Nombre de la tienda</label>
                <div class="help-block with-errors"></div>
            </div>
            <div class="grupo">
                <input minlength="8" maxlength="25" type="text" name="direccion" id="direccion" required><span class="barra"></span>
                <label for="">Dirección de la tienda</label>
                <div class="help-block with-errors"></div>
            </div>
            <div class="grupo">
                <input type="hidden" name="activo" id="activo" value="1" required><span class="barra"></span>
                <label for="">Activo</label>
                <div class="help-block with-errors"></div>
            </div>
            <div class="grupo">
                <div id="map"></div>
                    <input type="hidden" id="lat" name="latitud">
                    <input type="hidden" id="long" name="longitud">
                <div class="help-block with-errors"></div>
            </div>
            <!-- Calificacion Modificar -->
            <div class="grupo">
                <input type="hidden" name="calificacion" id="calificacion" value="5" required><span class="barra"></span>
            </div>
            
            <div class="grupo">
               Selecciona tu distrito
                <select class="combo" name="id_distrito">
                    <option value="" selected=>Escoja el distrito</option>
                <%  //OBTENGO DATOS PARA COMBO UNIDADES
                    List<Seleccionar> li = (List<Seleccionar>)request.getAttribute("cmbdistritos");   
                    if(li != null)
                    {
                        for(Seleccionar aux :li)
                        {
                %>
                            <option value="<%=aux.getId()%>"><%=aux.getNombre()%></option>
                <%
                        }
                    }
                %>
                </select>
                <div class="help-block with-errors"></div>
            </div>
            <div class="grupo">
                Selecciona tu tipo de dirección
                <select class="combo" name="id_tipodireccion">
                    <option value="" selected=>Escoja el tipo de dirección</option>
                <%  //OBTENGO DATOS PARA COMBO UNIDADES
                    List<Seleccionar> li2 = (List<Seleccionar>)request.getAttribute("cmbtipodireccion");   
                    if(li2 != null)
                    {
                        for(Seleccionar aux2 :li2)
                        {
                %>
                            <option value="<%=aux2.getId()%>"><%=aux2.getNombre()%></option>
                <%
                        }
                    }
                %>
                </select>
                <div class="help-block with-errors"></div>
            </div>
            <button type="submit">Registar Tienda</button>
        </div>
        </form>
        <script src="main.js"></script>
    <br><br>
    <!-- End Main Top -->
    <footer>
        <div class="footer-main">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-12 col-sm-12">
                        <div class="footer-widget">
                            <h4>Vision</h4>
                            <p>Ser la principal plataforma virtual de comercio para las microempresas del sector comercio de la regiÃ³n sur y la principal soluciÃ³n tecnolÃ³gica para las personas que desean comprar productos de primera necesidad por internet.
                                </p>
                            <ul>
                                <li><a href="#"><i class="fab fa-facebook" aria-hidden="true"></i></a></li>
                                <li><a href="#"><i class="fab fa-twitter" aria-hidden="true"></i></a></li>
                                <li><a href="#"><i class="fab fa-whatsapp" aria-hidden="true"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12 col-sm-12">
                        <div class="footer-link">
                            <h4>Information</h4>
                            <ul>
                                <li><a href="login.jsp">Nosotros</a></li>
                                <li><a href="login.jsp">Vendedor</a></li>
                                <li><a href="login.jsp">Administrador</a></li>
                                <li><a href="#">Terms &amp; Conditions</a></li>
                                <li><a href="#">Privacy Policy</a></li>
                                <li><a href="#">Delivery Information</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12 col-sm-12">
                        <div class="footer-link-contact">
                            <h4>Contact Us</h4>
                            <ul>
                                <li>
                                    <p><i class="fas fa-map-marker-alt"></i>DirecciÃ³n: Michael I. Days 3756 <br>Preston Street Wichita,<br> KS 67213 </p>
                                </li>
                                <li>
                                    <p><i class="fas fa-phone-square"></i>Telefono: <a href="tel:+51 980758365">+51 980758365</a></p>
                                </li>
                                <li>
                                    <p><i class="fas fa-envelope"></i>Email: <a href="mailto:contactinfo@gmail.com">contactinfo@gmail.com</a></p>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- End Footer  -->
     <script
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAYbevfQim4GZBSYkHDvjW_6DcXkI50Kt8&callback=initMap&v=weekly"
            async
    ></script>
    </body>
</html>
