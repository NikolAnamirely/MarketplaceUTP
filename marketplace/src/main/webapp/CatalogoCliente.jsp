<%-- 
    Document   : admcatalogo
    Created on : 30 set. 2021, 13:07:55
    Author     : Lenovo
--%>
<%@page import="modelo.Producto"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

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
    <link rel="stylesheet" href="css/ownstyle.css">

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
                            <li><a href="/contact-us.jsp">Contactanos</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
<!-- BARRA NAVEGACI�N-->
    <header class="main-header">
        <!-- Start Navigation -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
            <div class="container">
                <!-- Start LOGO -->
                <div class="navbar-header">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                    <a class="navbar-brand" href="index.jsp"><img src="images/logo.png" class="logo" alt=""></a>
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
<!-- End Main Top -->
<!-- Start All Title Box -->
    <div class="all-title-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>Catalogo de productos</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index.jsp">Inicio</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
<!-- End All Title Box -->
<%
    String codped = (String)request.getAttribute("codpedido");
    String codtien = (String)request.getAttribute("codtienda");
    String user = (String)request.getAttribute("user");
    %>
<!-- Start tabla productos  -->
	<div class="contact-box-main">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-sm-3"></div>
                    <div class="col-lg-4 col-sm-4">
                        <form action="ControladorRegistrarPedidoPorCod" >
                            <input type="hidden" name="codigoPed" value="<%=codped%>"/>
                            <p align="center"><input  style="color: white; width: 150%; align-items: center" class="btn hvr-hover" type="submit" id="submit" value="Detalles del pedido"></p>
                        </form>
                        
                    </div>
                     <div class="col-lg-4 col-sm-4"></div>
                </div>
                
                <br>
                <form  action="ControladorBuscarCatalogo" >
                    <div class="row">
                        <div class="col-lg-10 col-sm-1">       
                            <input type="text" class="form-control" id="name" name="txtTermino" placeholder="Buscar" required data-error="Ingrese un valor">
                        </div>
                        <div class="col-lg-2 col-sm-1">
                            <button class="btn hvr-hover" style="color: white; width: 100%" id="submit" type="submit">Buscar</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-10 col-sm-1">
                            <input type="hidden" name="txtTienda" value="<%=codtien%>"/>
                        </div>
                        <div class="col-lg-10 col-sm-1">
                            <input type="hidden" name="txtPedido" value="<%=codped%>"/>
                        </div>
                        <div class="col-lg-2 col-sm-1">
                                <select class="combo" name="criterio">
                                    <option selected hidden>Criterio</option>
                                    <option value="p.nombre">Nombre</option>
                                    <option value="m.nombre">Marca</option>
                                </select>
                        </div>
                    </div>
                    
                </form>
                <br>
                <div class="row row-cols-1 row-cols-md-2 g-4">
                <%
                    
                    List<Producto> lista = (List<Producto>)request.getAttribute("prod");  
                    String codigo;
                    double cos;
                    if(lista != null)
                    {
                        for(Producto aux :lista)
                        {
                            codigo=aux.getCodigo();
                            cos=aux.getCosto();
                %>
                        <div class="col-md-4">
                            <div class="card">
                                <form action="ControladorAgregarDetalle" > 
                                    <img src="ControladorIMG?id=<%= aux.getCodigo()%>" class="card-img-top" width="600" height="200">
                                    <div class="card-body">
                                        <h5 class="card-title" style="font-size: 25px">
                                            <input style="border: 0;" type="text" name="nombre" value="<%= aux.getNombre()%>"/>
                                        </h5>
                                        <p class="card-text">
                                            <input type="hidden" name="codpr" value="<%= aux.getCodigo()%>"/>
                                            Costo: <input style="border: 0" step='0.01' type="text" name="costo" value="<%= aux.getCosto()%>"/><br>
                                            Descripci�n:<%= aux.getDescripcion() %><br>
                                            Marca:<%= aux.getMarca() %> <br>
                                            Unidad: <%= aux.getUnidades()%><br>
                                            Cantidad:<input type="number" step="0.01" min="0" max="50" name="cantidad" required/><%= aux.getUnidades()%><br>
                                            <input type="hidden" name="codp" value="<%=codped%>"/>
                                            <input type="hidden" name="coti" value="<%=codtien%>"/>
                                            <a href="ControladorVistaProducto?idprod=<%= aux.getCodigo()%>&tien=<%=codtien%>&crit=1&codp=<%=codped%>" class="btn btn-primary" style="background:#cccdd7; border:0;border-color: white; color:black; border-radius: 5px; width: 71%;height: 35px;">Vista Rapida</a>
                                            <input type="submit" style="background:#d43b33; border:0;border-color: white; color:white; border-radius: 5px; width: 71%;height: 35px;" value="Agregar">
                                        </p>
                                    </div>
                                </form>
                            </div>
                        </div>
                        
                             
                    <%      }
                        } %>
                </div>
                <br>
                <p></p>
                <br>
                <!-- Start buscar productos  -->
                
                <br>
                <div class="row">
                    <div class="col-lg-3 col-sm-3"></div>
                    <div class="col-lg-4 col-sm-4">
                        <form action="ControladorCalificacion" >
                            <input type="text" name="user" value="<%=user%>"/>
                            <input type="hidden" name="txtTienda" value="<%=codtien%>"/>
                            <input type="hidden" name="action" value="1"/>
                            <p align="center"><input  style="color: white; width: 150%; align-items: center" class="btn hvr-hover" type="submit" id="submit" value="Califica la Tienda"></p>
                        </form>
                        
                    </div>
                     <div class="col-lg-4 col-sm-4"></div>
                </div>
                <p align="center"><a href="login.jsp"><img src="imagenes/atras.png"></a>&nbsp;&nbsp;&nbsp;<a href="index.jsp"><img src="imagenes/casa.png"></a></p>
            </div>
	</div>
<!-- End tabla productos  -->
    
<!-- Start Instagram Feed  -->
<!-- End Instagram Feed  -->

    <footer>
        <div class="footer-main">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-12 col-sm-12">
                        <div class="footer-widget">
                            <h4>Vision</h4>
                            <p>Ser la principal plataforma virtual de comercio para las microempresas del sector comercio de la regi�n sur y la principal soluci�n tecnol�gica para las personas que desean comprar productos de primera necesidad por internet.
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
                                <li><a href="https://drive.google.com/file/d/17V-rwd0s3H4EJqGZ3NCen2gyE0GqvHEX/view?usp=sharing">Terms &amp; Conditions</a></li>
                                <li><a href="https://drive.google.com/file/d/17V-rwd0s3H4EJqGZ3NCen2gyE0GqvHEX/view?usp=sharing">Privacy Policy</a></li>
                                <li><a href="https://drive.google.com/file/d/17V-rwd0s3H4EJqGZ3NCen2gyE0GqvHEX/view?usp=sharing">Delivery Information</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-12 col-sm-12">
                        <div class="footer-link-contact">
                            <h4>Contact Us</h4>
                            <ul>
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

    <!-- Start copyright  -->
    <div class="footer-copyright">
        <p class="footer-company">Todos los derechos reservados. &copy; 2021</p>
    </div>
    <!-- End copyright  -->

    <a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

    <!-- ALL JS FILES -->
    <script src="js/jquery-3.2.1.min.js"></script>
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
