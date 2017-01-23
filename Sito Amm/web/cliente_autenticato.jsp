<%-- 
    Document   : cliente_autenticato
    Created on : 19-gen-2017, 20.21.21
    Author     : claar
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <title>Botell&oacute;n</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="Immagini/favicon.ico" />
    </head>
    <body>
        <div class="generale">
            <header id="testata">                       
                <h1>Botell&oacute;n</h1>
                <p>e-commerce universitario</p>
            </header>
            <nav>
                <ul class="navbar" id="barra">
                    <li><a href="index.html">Home</a></li>
                    <li class="menu">
                        <a href="#" class="bmenu">Prodotti</a>                       
                            <ul class="cont-menu">
                                <li><a href="birre.jsp">Birre</a></li>
                                <li><a href="Vini.jsp">Vini</a></li>
                                <li><a href="#">Alcolici</a></li>
                            </ul>                                                  
                    </li>                                                     
                    <li><a href="contattaci.html">Contattaci</a></li> 
                    <li><a href="utenti.jsp">Utente</a></li> 
                    <li id="carrello"><a href="#Carrello">Carrello</a></li>
                    <li class="resp">
                        <a href="javascript:void(0);" style="font-size:15px;" 
                        onclick="funzres()">=</a>
                    </li>                    
                </ul>                
            </nav>
            
            <div id="contenuto">
                <h1><center>Botell&oacute;n</center></h1>
                <p><center>Benvenuto ${cliente.nome} ${cliente.cognome}</center></p>
            <ul>
                Il tuo carrello:
                <c:forEach var="prodotto" items="${cliente.Carrello}">
                        <li>${prodotto.carrello.tipo} - ${prodotto.carrello.prezzo}</li>
                </c:forEach>
            </ul>
            
                <p><center></center></p>
            </div>
        </div>
                
        <script>
            function funzres() {
                var x = document.getElementById("barra");
                if (x.className === "navbar") {
                    x.className += " responsive";
                } else {
                    x.className = "navbar";
                }
            }
        </script>
    </body>
</html>