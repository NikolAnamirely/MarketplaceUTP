<%-- 
    Document   : admcatalogo
    Created on : 30 set. 2021, 13:07:55
    Author     : Lenovo
--%>
<%@page import="modelo.Detalle"%>
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
    <link rel="stylesheet" href="css/ownstyledetalle.css">

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
                    <h2>Administrar pedido</h2>
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
    String tienda = (String)request.getAttribute("txtTienda");  
    String us = (String)request.getAttribute("txtUsuario");
    
    List<Detalle> lista = (List<Detalle>)request.getAttribute("detalle");  
                            
    %>
<!-- Start tabla productos  -->
	<div class="contact-box-main">
            <div class="container">
                <div class="row">
                <%
                    String subtotal = (String)request.getAttribute("subtotal");
                    String igv = (String)request.getAttribute("igv");
                    String total = (String)request.getAttribute("total");
                %>
                    <div class="col-lg-4 col-sm-6">
                        Subtotal: <input type="text" style="font-size: 20px;border:0;" name="subtotal" value="<%=subtotal%>" readonly/>
                    </div>
                    <div class="col-lg-4 col-sm-6">
                        IGV: <input type="text" name="IGV"  style="font-size: 20px;border:0;" value="<%=igv%>" readonly/>
                    </div>
                    <div class="col-lg-4 col-sm-6">
                        Total: <input type="text" name="Total" style="font-size: 20px;border:0; " value="<%=total%>" readonly/>
                    </div>
                </div>
                <br>
                <table type="table table-hover" style="width: 100%;">
                    <thead>    
                        <tr class= "tablaspern" style="width: 100%;">
                            <th scope="col" ></th>
                            <th scope="col" >Imagen</th>
                            <th scope="col" >Nombre</th>
                            <th scope="col" >Costo</th>
                            <th scope="col" >Cantidad</th>
                            <th scope="col" >Total</th>
                            <th scope="col" >Editar</th>
                            <th scope="col" >Eliminar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int id=0;
                            if(lista != null)
                            {
                                for(Detalle aux :lista)
                                {
                                    id=id+1;
                                    
                        %>
                       
                                     <tr class="grilla_campo" align="center"> 
                                           <form action="ControladorEditarEliminarDetalleProducto" >
                                                <td style="border-left:1px solid white;border-right: 1px solid white;">
                                                    <%=id%>
                                                </td>
                                                <td style="border-left:1px solid white;border-right: 1px solid white;">
                                                     <img src="ControladorIMG?id=<%= aux.getCodproducto()%>" width="80" height="100">
                                                </td>
                                                <td style="border-left:1px solid white;border-right: 1px solid white;">
                                                    <%= aux.getProducto()%>
                                                </td>
                                                <td style="border-left:1px solid white;border-right: 1px solid white;">
                                                    <input style="border:0px; width: 45px" type="text" name="costo" value="<%= aux.getCosto()%>" readonly/>
                                                </td>
                                                <td style="border-left:1px solid white;border-right: 1px solid white;">
                                                    <input type="number" name="cantidad" min="0" max="300" step="0.01" value="<%= aux.getCantidad()%>"/>  <%= aux.getUnidades()  %>
                                                </td>
                                                <td style="border-left:1px solid white;border-right: 1px solid white;">
                                                    <input style="border: 0;width: 45px" type="number" name="total" value="<%= aux.getTotal()%>" align="center" readonly/>
                                                </td>
                                                <td style="border-left:1px solid white;border-right: 1px solid white;">
                                                     <button type="submit" style="border: 0;background: white;"><img src="imagenes/editardet.png"></button>
                                                </td>
                                                <td style="border-left:1px solid white;border-right: 1px solid white;">
                                                    <a href="ControladorEditarEliminarDetalleProducto?codprod=<%= aux.getCodproducto()%>&criterio=eliminar&idped=<%=aux.getPedido()%>&txtUsuario=<%=us%>&txtTienda=<%=tienda%>"><img src="imagenes/eliminardet.png"></a>
                                                </td>
                                           
                                                <input type="hidden" name="idped" value="<%=aux.getPedido()%>"/>
                                                <input type="hidden" name="txtTienda" value="<%=tienda%>"/>
                                                <input type="hidden" name="txtUsuario" value="<%=us%>" >
                                                <input type="hidden" name="codprod" value="<%= aux.getCodproducto()%>" readonly/>

                                                <input type="hidden" name="criterio" value="editar"/>
                                                
                                            </form> 
                                           </tr>
                                           
                        <%     }
                            }       %>	
                    </tbody>
                </table>
                            
                <br>
                <p></p>
                
                <div class="row">
                    <div class="col-lg-3 col-sm-1"></div>
                    <div class="col-lg-4 col-sm-4">
                        <p align="center" ><a href="ControladorFinalizarPedidoProd?idped=<%=codped%>&txtTienda=<%=tienda%>&txtUsuario=<%=us%>"><button style="color: white; width: 150%" class="btn hvr-hover" id="submit">Guardar Cambios Producto Pedido</button></a></p>
                    </div>
                    <div class="col-lg-3 col-sm-1"></div>
                </div>

                <br>
                <br>
                <p align="center"><a href="ControladorMostrarPedidos?txtTienda=<%=tienda%>&txtUsuario=<%=us%>"><img src="imagenes/atras.png"></a>&nbsp;&nbsp;&nbsp;<a href="index.jsp"><img src="imagenes/casa.png"></a></p>
                <br>
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
