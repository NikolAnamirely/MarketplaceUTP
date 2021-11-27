
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Tienda"%>
<%@page import="modelo.Seleccionar"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Script para mostrar las coordenadas-->
    <script src="js/obtienelatitud.js"></script>
    <!-- Site Metas -->
    <title>Marketplace UTP</title>

    <!-- Site Icons -->
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Site CSS -->
    <link rel="stylesheet" href="css/style.css">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/custom.css">
    <!-- Style special -->
    <link rel="stylesheet" href="css/ownstyle.css">
    
    <link rel="stylesheet" href="css/pops.css">
    <link rel="stylesheet" type="text/css" href="./css/map.css" />
    <script src="./js/map.js"></script>
</head>

<body>
<!-- BARRA NEGRA PUBLICIDAD -->
    <div class="main-top">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                    <div class="text-slid-box">
                        <div id="offer-box" class="carouselTicker">
                            <ul class="offer-box">
                                <li>
                                    <i class="fab fa-opencart"></i> 10%! 
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                    <div class="right-phone-box">
                        <p>Llamanos:<a href="#"> +51 980758365</a></p>
                    </div>
                    <div class="our-link">
                        <ul>
                            <li><a href="./contact-us.html">Contactanos</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
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
                            <li class="nav-item"><a class="nav-link" href="login.jsp">Iniciar sesion</a></li>
                        </ul>
                    </div>
            </div>
            
        </nav>
        <!-- End Navigation -->
    </header>
<%
                        Tienda lista = (Tienda)request.getAttribute("edit");  
                        if(lista!= null)
                        {
                            
                    %> 
    <!-- Start editar formulario -->
    	<div class="contact-box-main">
            <div class="container">
                       
                        <form action="ControladorEditarTienda">
                        
                            <div class="row">	       
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <input  name="id_tienda" value="<%=lista.getId()%>" type="hidden">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <p>Nombre: </p>
                                        <input type="text" class="form-control" name="nombre" value="<%=lista.getNombre()%>" pattern="[a-zA-Z-ch-ll]+"  minlength="3" maxlength="20" required data-error="Porfavor ingresa un nombre" required>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <p>Dirección: </p>
                                        <input type="text" class="form-control" name="direccion" value="<%=lista.getDireccion()%>" minlength="3" maxlength="25" required data-error="Porfavor ingresa un nombre" required>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <div id="map"></div>
                                        <p>Latitud:</p>
                                        <input value="<%=lista.getLatitud()%>" type="text" id="lat" name="latitud">
                                        <p>Longitud: </p>
                                        <input value="<%=lista.getLongitud()%>" type="text" id="long" name="longitud">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        Seleccione el distrito:
                                        <select class="form-control" name="id_distrito">
                                                <option value=""><%=lista.getId_distrito()%></option>
                                                <%  //OBTENGO DATOS PARA COMBO
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
                                </div>  
                                <div class="col-md-12">
                                    <div class="form-group">
                                        Seleccione el tipo de dirección:
                                        <select class="form-control" name="id_tipodireccion">
                                                <option value=""><%=lista.getId_tipodir()%></option>
                                                <%  //OBTENGO DATOS PARA COMBO
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
                                </div>
                                
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <input  name="activo" value="<%=lista.getActivo()%>" type="hidden">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <input  name="calificacion" value="<%=lista.getCalificacion()%>" type="hidden">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <input  name="id_persona" value="<%=lista.getId_persona()%>" type="hidden">
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="submit-button text-center">
                                        <button class="btn hvr-hover" id="submit" type="submit">Actualizar cliente</button>
                                        <div id="msgSubmit" class="h3 text-center hidden"></div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div> 
                                
                            </div>
                        </form>
                         <script src="main.js"></script>
                <br>
                <br>
                <p align="center"><a href="login.jsp"><img src="imagenes/atras.png"></a>&nbsp;&nbsp;&nbsp;<a href="index.jsp"><img src="imagenes/casa.png"></a></p>
            </div>
	</div>
    <%      
                    } %>
    <!-- End editar formulario -->
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
    <!-- Start copyright  -->
    <div class="footer-copyright">
        <p class="footer-company">Todos los derechos reservados. &copy; 2021</p>
    </div>
    <!-- End copyright  -->

    <a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

    <!-- JS VENTANA EMERGENTE -->
    <script src="js/popup.js"></script>
    <!-- ALL JS FILES -->
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- ALL PLUGINS -->
    <script src="js/jquery.superslides.min.js"></script>
    <script src="js/bootstrap-select.js"></script>
    <script src="js/inewsticker.js"></script>
    <script src="js/bootsnav.js."></script>
    <script src="js/images-loded.min.js"></script>
    <script src="js/isotope.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/baguetteBox.min.js"></script>
    <script src="js/form-validator.min.js"></script>
    <script src="js/contact-form-script.js"></script>
    <script src="js/custom.js"></script>
</body>
</html>