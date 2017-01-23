<%-- 
    Document   : Vini
    Created on : 23-gen-2017, 22.36.39
    Author     : claar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <link rel="stylesheet" href="prodotti.css" type="text/css"/>
        <title>Botell&oacute;n</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="Immagini/favicon.ico"/>
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
                    <li><a href="utente.jsp">Utente</a></li> 
                    <li id="carrello"><a href="#Carrello">Carrello</a></li>
                    <li class="resp">
                        <a href="javascript:void(0);" style="font-size:15px;" 
                           onclick="funzres()">=</a>
                    </li>                    
                </ul>                
            </nav>
            <div class="container">

                <div id="contenutoprodotti">
                     <h1>Viniamo Insieme</h1>
                    <p>Sei entrato nella categoria vini</p>
                    <ul class="prodotti">
                        Lista prodotti:
                        <c:forEach var="merce" items="${prodotti.ListaProdotti}">
                            <li><img src="Immagini/bottvino2.jpg" width="300" alt="birra" class="prodotto"></li>  
                                <li>${merce.tipo} ----- ${merce.prezzo}</li>
                        </c:forEach>                      
                    </ul>
                </div>
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