<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Pedido"%>
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
        <title>Registrar Pedido</title>

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
                        <li class="nav-item"><a class="nav-link" href="registrar.jsp">Registrarme</a></li>                        
                        <li class="nav-item"><a class="nav-link" href="login.jsp">Iniciar sesion</a></li>
                    </ul>
                </div>

            </div>
            
        </nav>
        <!-- End Navigation -->
    </header>
   
        <!-- REGISTRO FORMULARIO PEDIDOS -->
    <%
        String codigop = (String)request.getAttribute("codpedido");  
    %> 
    <!-- Start Insertar formulario -->
    	<div class="contact-box-main">
            <div class="container">
            <%
                Pedido lista = (Pedido)request.getAttribute("edit");  
                if(lista!= null)
                {

            %>         
                <form action="ControladorRegistrarPedidoNuevo" >
                    <div class="row">	       
                        <div class="col-md-12">
                            <div class="form-group">
                                <input type="hidden" name="id_pedido" value="<%=codigop%>">
                                <div class="help-block with-errors"></div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <p>Subtotal: </p>
                                <input style="border:0" type="text" class="form-control" name="subtotal" value="<%=lista.getSubtotal()%>" readonly>
                                <div class="help-block with-errors"></div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <p>Igv: </p>
                                <input style="border:0" type="text" class="form-control" name="igv" value="<%=lista.getIgv()%>" type="hidden" readonly>
                                <div class="help-block with-errors"></div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <p>Total: </p>
                                <input style="border:0" type="text" class="form-control" name="total" value="<%=lista.getTotal()%>" type="hidden" readonly>
                                <div class="help-block with-errors"></div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <input class="form-control" name="fechacreacion" value="<%=lista.getFecha_creacion()%>" type="hidden" readonly>
                                <div class="help-block with-errors"></div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <p>Fecha Entrega: </p>
                                <input type="date" class="form-control" name="fechaentrega" value="<%=lista.getFecha_entrega()%>" type="hidden" readonly>
                                <div class="help-block with-errors"></div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <p>Hora Entrega: </p>
                                <input type="time" class="form-control" name="horaentrega" value="<%=lista.getHora()%>" type="hidden" readonly>
                                <div class="help-block with-errors"></div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                            Tipo Pago:
                            <select class="combo" name="tipopago">
                                    <option value="<%=lista.getTipoPago()%>"><%=lista.getTipoPago()%></option>
                                </select>
                            </div>
                        </div> 
                        <div class="col-md-12">
                            <div class="form-group">
                                <input type="hidden" name="repartidor" value="null">
                                <div class="help-block with-errors"></div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="submit-button text-center">
                                <button class="btn hvr-hover" id="submit" type="submit">Confirmar cambios</button>
                                <div id="msgSubmit" class="h3 text-center hidden"></div>
                                <div class="clearfix"></div>
                            </div>
                        </div> 
                    <%--INPUTS OCULTOS--%>
                        <div class="col-md-12">
                            <div class="form-group">
                                <input type="hidden" name="estado" value="1" >
                                <div class="help-block with-errors"></div>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <input name="id_usuario" value="<%=lista.getId_usuario()%>" type="hidden">
                                <div class="help-block with-errors"></div>
                            </div>
                        </div>
                    </div>
                </form>
                <%      
                    } %>
                <br>
                <br>
                <p align="center"><a href="login.jsp"><img src="imagenes/atras.png"></a>&nbsp;&nbsp;&nbsp;<a href="index.jsp"><img src="imagenes/casa.png"></a></p>
            </div>
	</div>
    
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
    </body>
</html>
