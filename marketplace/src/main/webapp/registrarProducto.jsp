<%-- 
    Document   : registrarprod
    Created on : 30 set. 2021, 13:31:41
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Seleccionar"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    <!-- Style special -->
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
                                <li>
                                    <i class="fab fa-opencart"></i> 50% - 80% 
                                </li>
                                <li>
                                    <i class="fab fa-opencart"></i> 20% 
                                </li>
                                <li>
                                    <i class="fab fa-opencart"></i> 50%! 
                                </li>
                                <li>
                                    <i class="fab fa-opencart"></i> 10%! 
                                </li>
                                <li>
                                    <i class="fab fa-opencart"></i> 50% - 80%
                                </li>
                                <li>
                                    <i class="fab fa-opencart"></i> 20% 
                                </li>
                                <li>
                                    <i class="fab fa-opencart"></i> 50%!
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
                            <li><a href="contact-us.jsp">Contactanos</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
<!-- BARRA NAVEGACIÓN-->
    <header class="main-header">
        <!-- Start Navigation -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
            <div class="container">
                <!-- Start LOGO -->
                <div class="navbar-header">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                    <a class="navbar-brand" href="./index.jsp"><img src="images/logo.png" class="logo" alt=""></a>
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
                    <h2>Registrar producto</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="AdmTienda.jsp">Administrar tienda</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
<!-- End All Title Box -->

<!-- Start tabla productos  -->
	<div class="contact-box-main">
            <div class="container">
                        <form action="ControladorAgregarProd" method="POST" enctype="multipart/form-data">
                            <div class="row">
                                <div class="col-md-12">
                                <%
                                    String codigoTi = (String)request.getAttribute("CodTienda");  
                                    String us = (String)request.getAttribute("txtUsuario");
                                %>    
                                <input type="hidden" name="tienda" value="<%=codigoTi%>"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Nombre" name="nombre" pattern="[a-zA-Z]+"  minlength="3" maxlength="20" required data-error="Porfavor ingresa un nombre" required>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <select class="combo" name="categoria" required>
                                            <option value="">Selecciona las categoria</option>
                                        <%  //OBTENGO DATOS PARA COMBO UNIDADES
                                            List<Seleccionar> list = (List<Seleccionar>)request.getAttribute("cmbcategoria");   
                                            if(list != null)
                                            {
                                                for(Seleccionar aux :list)
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
                                        <input type="text" placeholder="Ingresa una pequeña descripción" class="form-control" name="descripcion"  minlength="5" maxlength="490" required data-error="Porfavor ingresa una descripción" required>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <input type="number" placeholder="Costo" class="form-control" name="costo" step="0.01" required data-error="Porfavor ingresa costo valido" required>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <select class="combo" name="marca" required>
                                            <option value="">Selecciona la marca</option>
                                        <%  //OBTENGO DATOS PARA COMBO UNIDADES
                                            List<Seleccionar> lis = (List<Seleccionar>)request.getAttribute("cmbmarca");   
                                            if(lis != null)
                                            {
                                                for(Seleccionar aux :lis)
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
                                        <select class="combo" name="unidad" required>
                                            <option value="">Selecciona la unidad</option>
                                        <%  //OBTENGO DATOS PARA COMBO UNIDADES
                                            List<Seleccionar> li = (List<Seleccionar>)request.getAttribute("cmbunidades");   
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
                                        <select class="combo" name="estado" required>
                                            <option value="">Selecciona el estado del producto</option>
                                            <option value="En stock">En stock</option>
                                            <option value="Agotado">Agotado</option>
                                        </select>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                </div> 
                                <div class="col-md-12">
                                    <div class="form-group">
                                        Ingresa una imagen referencial de tu producto:
                                        <br>
                                        <input type="file" name="fileFoto" required>  
                                    </div>
                                </div> 
                                <div class="col-md-12">
                                    <div class="submit-button text-center">
                                        <input type="hidden" class="form-control" name="txtUsuario" value="<%=us%>" >
                                        <button class="btn hvr-hover" id="submit" type="submit">Crear</button>
                                        <div id="msgSubmit" class="h3 text-center hidden"></div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>                     
                            </div>
                        </form>
                <br>
                <br>
                <p align="center"><a href="login.jsp"><img src="./imagenes/atras.png"></a>&nbsp;&nbsp;&nbsp;<a href="../index.jsp"><img src="./imagenes/casa.png"></a></p>
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
                            <p>Ser la principal plataforma virtual de comercio para las microempresas del sector comercio de la región sur y la principal solución tecnológica para las personas que desean comprar productos de primera necesidad por internet.
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


