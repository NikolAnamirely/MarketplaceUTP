<%-- 
    Document   : prueba2
    Created on : 2 dic. 2021, 23:29:13
    Author     : myers
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>si llega</h1>
        <h2><%=request.getAttribute("idtienda")%></h2><br>
        <h2><%=request.getAttribute("cliente")%></h2><br>
        <h2><%=request.getAttribute("inicio")%></h2><br>
        <h2><%=request.getAttribute("fin")%></h2><br>
        <h2><%=request.getAttribute("comp")%></h2><br>
        <h2><%=request.getAttribute("monto")%></h2><br>
        <h2><%=request.getAttribute("estado")%></h2><br>
        <h2><%=request.getAttribute("parametro")%></h2><br>
    </body>
</html>
