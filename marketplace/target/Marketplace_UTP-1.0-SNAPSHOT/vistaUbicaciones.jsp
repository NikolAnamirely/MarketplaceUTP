<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page import="modelo.Tienda"%>
<%@page import="modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Seleccionar"%>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.http.HttpSession"%>
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
        <!-- google maps -->
        <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
        <link rel="stylesheet" type="text/css" href="./css/map.css" />
        <script language="javascript">
            function url(uri) {
                location.href = uri;
            }
        </script>

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
        <!-- BARRA NAVEGACI脫N-->
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
        <!-- End Main Top -->

        

        <!-- Start seleccion  -->
        <div class="contact-box-main">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-sm-12">
                        <div class="contact-form-right">
                            <h2>Escribe tu distrito y ubica un establecimiento cercano</h2>
                            <form id="contactForm">
                                <div class="row">
                                    <select class="col" name="id_distrito" onchange="url(this.value);">
                                        <option value="#">--ESCOGE TU DISTRITO--</option>
                                        <%  //OBTENGO DATOS PARA COMBO UNIDADES
                                            List<Seleccionar> li2 = (List<Seleccionar>)request.getAttribute("listaDistritos");   
                                            if(li2 != null)
                                            {
                                                for(Seleccionar aux2 :li2)
                                                {
                                        %>
                                        <option value="ControladorListarPorDistrito?id_distrito=<%=aux2.getId()%>"><%=aux2.getNombre()%></option>
                                        <%
                                                }
                                            }
                                        %>
                                    </select>
                                    <% String usu = String.valueOf(session.getAttribute("currentUser")); %>
                                    <a href="ControladorListarTiendas?txtUsuario=<%=usu%>" class="col-3">
                                        <input type="button" value="Tu ubicacion" >
                                    </a>
                                
                            </form>

                            <div >
                                <div class="container">
                                    <div class="row">
                                        <p align="center"><div id="map"></div></p>
                                    </div>

                                </div>
                                <div><%=request.getAttribute("inicioLatitud")%></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>

        <!-- Start Instagram Feed  -->
        <div class="instagram-box">
            <div class="main-instagram owl-carousel owl-theme">
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="imagenes/logo4.jpeg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="imagenes/logo4.jpeg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="imagenes/logo4.jpeg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="imagenes/logo4.jpeg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="imagenes/logo4.jpeg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="imagenes/logo4.jpeg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="imagenes/logo4.jpeg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="imagenes/logo4.jpeg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="imagenes/logo4.jpeg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="ins-inner-box">
                        <img src="imagenes/logo4.jpeg" alt="" />
                        <div class="hov-in">
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <footer>
            <div class="footer-main">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 col-md-12 col-sm-12">
                            <div class="footer-widget">
                                <h4>Vision</h4>
                                <p>Ser la principal plataforma virtual de comercio para las microempresas del sector comercio de la regi贸n sur y la principal soluci贸n tecnol贸gica para las personas que desean comprar productos de primera necesidad por internet.
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
                                        <p><i class="fas fa-map-marker-alt"></i>Direcci贸n: Michael I. Days 3756 <br>Preston Street Wichita,<br> KS 67213 </p>
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
        <script>
            <%
            ArrayList<Tienda> lista = (ArrayList<Tienda>)session.getAttribute("ubicaciones");
            String pedido = (String)session.getAttribute("codpedido");
            String iduser = (String)session.getAttribute("iduser");
            System.out.println("\nUSUARIOMAPA: " + iduser);
            
            %>
                                        var marker;//variable del marcador
                                        var marker2 = [];//variable del marcador
                                        var coords = {};    //coordenadas obtenidas con la geolocalizaci髇
                                        var id = [];
                                        var nombre = [];
                                        var postienda = [];
                                        var contentString = [];
            <% 
            for(int i=0;i<lista.size();i++){
            %>
                                        id[<%=i%>] = <%=lista.get(i).getId()%>;
                                        nombre[<%=i%>] = ' <%=lista.get(i).getNombre()%> ';
                                        postienda[<%=i%>] = {lat: <%=Float.parseFloat(lista.get(i).getLatitud())%>, lng: <%=Float.parseFloat(lista.get(i).getLongitud())%>};


                                        contentString[<%=i%>] = '<div class="info_content">' +
                                                '<h3>' + nombre[<%=i%>] + '</h3>' +
                                                '<p><a href="ControladorProductoCatalogo?user=<%=iduser%>&txtTienda=<%=lista.get(i).getId()%>&codped=<%=pedido%>">Tienda</a></p>' + '</div>';
            <% } %>

                                        //Funcion principal
                                        initMap = function ()
                                        {

                                            //usamos la API para geolocalizar el usuario
                                            navigator.geolocation.getCurrentPosition(
                                                    function (position) {
                                                        coords = {
                                                            lng: position.coords.longitude,
                                                            lat: position.coords.latitude
                                                        };
                                                        setMapa(coords);  //pasamos las coordenadas al metodo para crear el mapa


                                                    }, function (error) {
                                                console.log(error);
                                            });

                                        };



                                        function setMapa(coords)
                                        {
                                            //Se crea una nueva instancia del objeto mapa
                                            var map = new google.maps.Map(document.getElementById('map'),
                                                    {
                                                        zoom: 17,
                                                        center: new google.maps.LatLng(coords.lat, coords.lng)

                                                    });

                                            //Creamos el marcador en el mapa con sus propiedades
                                            //para nuestro obetivo tenemos que poner el atributo draggable en true
                                            //position pondremos las mismas coordenas que obtuvimos en la geolocalizaci髇
                                            marker = new google.maps.Marker({
                                                map: map,
                                                draggable: true,
                                                animation: google.maps.Animation.DROP,
                                                position: new google.maps.LatLng(coords.lat, coords.lng)

                                            });
                                            var infowindow = [];
            <%
            for(int i=0;i<lista.size();i++){
            %>
                                            marker2[<%=i%>] = new google.maps.Marker({
                                                position: postienda[<%=i%>],
                                                map,
                                                title: "Tienda"
                                            });
                                            infowindow[<%=i%>] = new google.maps.InfoWindow({
                                                content: contentString[<%=i%>]
                                            });
                                            marker2[<%=i%>].addListener("click", () => {
                                                infowindow[<%=i%>].open({
                                                    anchor: marker2[<%=i%>],
                                                    map,
                                                    shouldFocus: false
                                                });
                                            });
            <% } %>
                                            //agregamos un evento al marcador junto con la funcion callback al igual que el evento dragend que indica 
                                            //cuando el usuario a soltado el marcador
                                            marker.addListener('click', toggleBounce);

                                            marker.addListener('dragend', function (event)
                                            {
                                                //escribimos las coordenadas de la posicion actual del marcador dentro del input #coords
                                                document.getElementById("lat").value = this.getPosition().lat();
                                                document.getElementById("long").value = this.getPosition().lng();
                                            });
                                        }

//callback al hacer clic en el marcador lo que hace es quitar y poner la animacion BOUNCE
                                        function toggleBounce() {
                                            if (marker.getAnimation() !== null) {
                                                marker.setAnimation(null);
                                            } else {
                                                marker.setAnimation(google.maps.Animation.BOUNCE);
                                            }
                                        }

        </script>
        <script
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAYbevfQim4GZBSYkHDvjW_6DcXkI50Kt8&callback=initMap&v=weekly"
            async
        ></script>
    </body>
</html>


