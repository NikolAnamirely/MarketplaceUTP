<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page import="modelo.Seleccionar"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
    <!-- Basic -->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- SCRIPT PARA REDIRECCIONAR COMBO -->
        <script language="javascript">
            function url(uri) {
                location.href = uri;
            }
        </script>
        <!-- FIN SCRIPT -->
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
        <link rel="stylesheet" href="css/ownstyle.css">
        <!-- Responsive CSS -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/custom.css">
        <!-- Script para mostrar las coordenadas-->
        <script src="js/obtienelatitud.js"></script>
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
                                <li><a href="./contact-us.html">Contactanos</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- BARRA NAVEGACIÃ“N-->
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
        <!-- Start Contact Us  -->
        <div class="contact-box-main">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-sm-12">
                        <div class="contact-info-left">
                            <h2>CONTACT INFO</h2>
                            <p>Ser la principal plataforma virtual de comercio para las microempresas del sector comercio de la región sur y la principal solucion tecnologica para las personas que desean comprar productos de primera necesidad por internet.</p>
                            <ul>
                                <li>
                                    <p><i class="fas fa-phone-square"></i>Telefono: <a href="tel:+51 980758365">+51 980758365</a></p>
                                </li>
                                <li>
                                    <p><i class="fas fa-envelope"></i>Email: <a href="mailto:marketplaceutp@gmail.com">:marketplaceutp@gmail.com</a></p>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-8 col-sm-12">
                        <div class="contact-form-right">
                            <h2>REGISTRARME</h2>
                            <p>Se el administrador de tu propio negocio o compra con nosotros</p>
                            <form action="ControladorVendedorNuevo" method="POST">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <input minlength="3" maxlength="20" type="text" class="form-control" id="name" name="nombre" placeholder="Nombre" required="" pattern="[a-zA-Z]+" required data-error="Porfavor ingresa tu nombre">
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <input minlength="3" maxlength="15" type="text" placeholder="Apellido paterno" id="Apellido paterno" class="form-control" name="primerapellido" required="" pattern="[a-zA-Z]+" required data-error="Porfavor ingresa tu apellido paterno"">
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <input minlength="3" maxlength="15" type="text" placeholder="Apellido materno" id="email" class="form-control" name="segundoapellido" required="" pattern="[a-zA-Z]+" required data-error="Porfavor ingresa tu Apellido materno"">
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>                                
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <input minlength="9" maxlength="12" type="text" placeholder="Telefono" id="Telefono" class="form-control" name="telefono" required="" pattern="[+,0-9]+" required data-error="Porfavor ingresa tu Telefono">
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <input minlength="10" maxlength="50" type="text" placeholder="Dirección" id="direccion" class="form-control" name="direccion" required data-error="Porfavor ingresa tu dirección">
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>                               
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            Selecciona tu tipo de dirección
                                            <select class="form-control" name="id_tipodireccion">
                                                <option value="" selected=>Escoja el tipo de dirección</option>
                                                <%  //OBTENGO DATOS PARA COMBO UNIDADES
                                                    List<Seleccionar> li = (List<Seleccionar>)request.getAttribute("cmbtipodireccion");   
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
                                            Selecciona tu distrito
                                            <select class="form-control" name="id_distrito">
                                                <option value="" selected=>Escoja el distrito</option>
                                                <%  //OBTENGO DATOS PARA COMBO UNIDADES
                                                    List<Seleccionar> li2 = (List<Seleccionar>)request.getAttribute("cmbdistritos");   
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
                                            <input minlength="11" maxlength="20" type="email" placeholder="Correo" id="email" class="form-control" name="email" required data-error="Porfavor ingresa tu correo">
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <input minlength="8" maxlength="20" type="password" placeholder="Contraseña" id="password" class="form-control" name="password" required data-error="Porfavor ingrese su contraseña">
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <input type="hidden"  id="activo" class="form-control" name="activo" value="1" required data-error="Porfavor ingresa tu dirección">
                                            <div class="help-block with-errors"></div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="submit-button text-center">
                                            <input  class="btn hvr-hover" type="submit" value="Registrar Vendedor">
                                        </div>
                                    </div>                     
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Cart -->

        <!-- Start Instagram Feed  -->
        <div class="instagram-box">
            <div class="main-instagram owl-carousel owl-theme">
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/instagram-img-01.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/instagram-img-02.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/instagram-img-03.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/instagram-img-04.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/instagram-img-05.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/instagram-img-06.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/instagram-img-07.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/instagram-img-08.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/instagram-img-09.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="images/instagram-img-05.jpg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Instagram Feed  -->


        <!-- FOOTER  -->
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
                                        <p><i class="fas fa-map-marker-alt"></i>Dirección: Michael I. Days 3756 <br>Preston Street Wichita,<br> KS 67213 </p>
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