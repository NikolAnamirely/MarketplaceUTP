<%-- 
    Document   : admcatalogo
    Created on : 30 set. 2021, 13:07:55
    Author     : Lenovo
--%>
<%@page import="modelo.Pedido"%>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.RequestDispatcher"%>
<%@page import="javax.servlet.http.HttpSession"%>";
<%
    String txtienda = String.valueOf(request.getAttribute("idTienda"));
    List<Pedido> lista = (List<Pedido>) request.getAttribute("listPed");
    String tienda = (String) request.getAttribute("txtTienda");
    HttpSession sesion = request.getSession(true);
    sesion.setAttribute("lista", lista);
    
%>
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
                        <a class="navbar-brand" href="index.jsp"><img src="images/logo.png" class="logo" alt=""></a>
                    </div>
                    <!-- End LOGO -->
                    <div class="collapse navbar-collapse" id="navbar-menu">
                        <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                            <li class="nav-item active"><a class="nav-link" href="index.jsp">Inicio</a></li>
                            <li class="nav-item"><a class="nav-link" href="nosotros.jsp">Nosotros</a></li>
                            <li class="nav-item"><a class="nav-link" href="ControladorCargarCriteriosCliente">Registrarme</a></li>                        
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
                        <h2>Administrar Pedidos</h2>
                    </div>
                </div>
            </div>
        </div>
        <!-- End All Title Box -->

        <!-- Start tabla productos  -->
        <div class="contact-box-main">

            <div class="container">
                <form action="ControladorMostrarReportes">
                    <h3>FILTROS</h3>
                    <input type="hidden" name="metodo" value="filtrar"><input type="hidden" name="txtTienda" value="<%=txtienda%>">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="cliente-tab" data-toggle="tab" href="#cliente" role="tab" aria-controls="cliente" aria-selected="true">Cliente</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="fecha-tab" data-toggle="tab" href="#fecha" role="tab" aria-controls="fecha" aria-selected="false">Fecha</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="monto-tab" data-toggle="tab" href="#monto" role="tab" aria-controls="monto" aria-selected="false">Monto</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="estado-tab" data-toggle="tab" href="#estado" role="tab" aria-controls="estado" aria-selected="false">Estado</a>
                        </li>
                        <li class="nav-item">
                            <input type="submit" class="btn btn-danger" value="FILTRAR">
                        </li>
                        <li class="nav-item">
                            <a href="ControladorMostrarReportes?metodo=listar&txtTienda=<%=txtienda%>"><button type="button" class="btn btn-primary">RESTABLECER</button></a>
                        </li>
                    </ul>
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="cliente" role="tabpanel" aria-labelledby="cliente-tab">

                            Nombre de cliente: <input type="text" name="cliente">


                        </div>
                        <div class="tab-pane fade" id="fecha" role="tabpanel" aria-labelledby="fecha-tab">

                            Fecha de Inicio: <input type="date" id="inicio"name="fInicio" >
                            Fecha de Fin  : <input type="date" id="fin"name="fFin" >


                        </div>
                        <div class="tab-pane fade" id="monto" role="tabpanel" aria-labelledby="monto-tab">
                            <select name="comp">
                                <option value="=" selected>Igual a: S/.</option>
                                <option value="<=">Hasta: S/.</option>
                                <option value=">=">Desde: S/.</option>                                
                            </select>
                            <input type="number" id="monto" name="monto" min="0" step="any">                            


                        </div>

                        <div class="tab-pane fade" id="estado" role="tabpanel" aria-labelledby="estado-tab">
                            <select name="estado">
                                <option value="" selected>Todos</option>
                                <option value="1" >Activo</option>
                                <option value="2">Atendido</option>
                                <option value="3">Entregado</option>                                
                            </select>

                        </div>
                    </div>
                </form>
                <br>
                <div class="d-flex justify-content-center">
                    <a href="ControladorEnviarReporte">
                        <button type="button" class="btn btn-secondary btn-lg" >GENERAR REPORTE</button>
                    </a>

                </div>


                <table style="width: 100%; border: 1px solid #ced4da;">
                    <tr class= "tablaspern" style="width: 100%;background: #495057;">
                        <td style="width: 5%;">Codigo</td>
                        <td style="width: 10%;">Estado</td>
                        <td style="width: 10%;">Subtotal</td>
                        <td style="width: 10%;">Igv</td>
                        <td style="width: 10%;">Total</td>
                        <td style="width: 10%;">Fecha creación</td>
                        <td style="width: 10%;">Fecha entrega</td>
                        <td style="width: 10%;">Hora entrega</td>
                        <td style="width: 10%;">Tipo Pago</td>
                        <td style="width: 15%;">Cliente</td>

                    </tr> 
                    <%

                        if (lista != null) {
                            for (Pedido aux : lista) {
                                String es;
                                if (aux.getEstado().equals("1")) {
                                    es = "Activo";
                                } else if (aux.getEstado().equals("2")) {
                                    es = "Atendido";
                                } else {
                                    es = "Entregado";
                                }


                    %>
                    <tr class="grilla_campo"> 
                        <td style="text-align: center"><%= aux.getId()%></td>
                        <td style="text-align: center"><%=es%></td>
                        <td style="text-align: center"><%= aux.getSubtotal()%></td>
                        <td style="text-align: center"><%= aux.getIgv()%></td>
                        <td style="text-align: center"><%= aux.getTotal()%></td>
                        <td style="text-align: center"><%= aux.getFecha_creacion()%></td>
                        <td style="text-align: center"><%= aux.getFecha_entrega()%></td>
                        <td style="text-align: center"><%= aux.getHora()%></td>
                        <td style="text-align: center"><%= aux.getTipoPago()%></td>
                        <td style="text-align: center"><%= aux.getId_usuario()%></td>

                    </tr>
                    <%      }
                        }%>

                </table>
                <br>
                <br>
                <!-- End buscar productos  -->
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
