<%-- 
    Document   : utenti
    Created on : 12-gen-2017, 19.54.18
    Author     : claar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <link rel="stylesheet" href="utente.css" type="text/css"/>
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
                <aside class="sidelft">                    
                    <button onclick="document.getElementById('lg').style.display='block'" style="width: 120px;">Login</button>
                        <div id="lg" class="form-modale">
                            <form class="modulo animato" action="Login" method="post">
                                <div class="immagine">
                                    <span onclick="document.getElementById('lg').style.display='none'" class="chiudi" title="chiudi form">&times;</span>
                                    <img src="Immagini/utenti2.png" alt="utente" class="utente">
                                </div>
                                <div class="scatola">
                                    <label><b>Username</b></label>
                                        <input type="text" placeholder="Enter Username" name="uname" required>
                                    <label><b>Password</b></label>
                                        <input type="password" placeholder="Enter Password" name="psw" required>        
                                    <button type="submit" name="conferma" value="Login">Login</button>
                                    <input type="checkbox" checked="checked"> Ricordami
                                </div>
                                <div class="scatola" style="background-color:#f1f1f1">
                                    <button type="button" onclick="document.getElementById('lg').style.display='none'" class="cancelbtn">Cancella</button>
                                    <span class="psw"><a href="#">password</a> dimenticata?</span>
                                </div>
                            </form>
                        </div>
                    <!--/*per mandare a capo il secondo bottone */-->
                    <br>
                    <button onclick="document.getElementById('rg').style.display='block'" style="width: 120px;">Registrati</button> 
                        <div id="rg" class="form-modale">
                            <form class="modulo animato" action="Registrazione.java" method="POST">
                                <div class="immagine">
                                    <span onclick="document.getElementById('rg').style.display='none'" class="chiudi" title="chiudi modale">&times;</span>
                                    <img src="Immagini/utenti2.png" alt="utente" class="utente">
                                </div>
                                <div class="scatola">
                                    ${cliente.nomeCliente} ${cliente.cognomeCliente} ${cliente.indirizzoCliente} ${cliente.capCliente} ${cliente.cittaCliente} 
                                    ${cliente.emailCliente} ${cliente.usernameCliente} ${cliente.passwordCliente} ${cliente.c_passwordCliente}
                                    <input type="hidden" name="clienteId" id="id" value="${cliente.idCliente}"
                                    <label><b>Nome</b></label>
                                        <input type="text" placeholder="Enter Name" name="name" required>
                                    <label><b>Cognome</b></label>
                                        <input type="text" placeholder="Enter Surname" name="sname" required>
                                    <label><b>Indirizzo</b></label>
                                        <input type="text" placeholder="Enter Address" name="address" required>
                                    <label><b>CAP</b></label>
                                        <input type="number" placeholder="Enter CAP" name="cap" required>
                                    <label><b>Citt&agrave;</b></label>
                                    <input type="text" placeholder="Citt&agrave;" name="city" required>
                                    <label><b>Indirizzo e-mail</b></label>
                                        <input type="email" placeholder="Enter E-Mail" name="e-mail" required>
                                    <label><b>Username</b></label>
                                        <input type="text" placeholder="Choose Username" name="u_name" required>
                                    <label><b>Password</b></label>
                                        <input type="password" placeholder="Enter Password" name="psw" required>
                                    <label><b>Conferma Password</b></label>
                                        <input type="password" placeholder="Enter Password Again" name="conferma_psw" required>
                                    <button type="submit" name="conferma">Registrati</button>
                                    <input type="checkbox" checked="checked"> Accetto i termini di contratto
                                </div>
                                <div class="scatola" style="background-color:#f1f1f1">
                                    <button type="button" onclick="document.getElementById('rg').style.display='none'" class="cancelbtn">Cancella</button>
                                </div>
                            </form>
                        </div>
                    <ul class="asidebar">    
                        <li><a href="#">###</a></li>
                        <li><a href="#">###</a></li>
                        <li><a href="#">###</a></li>
                        <li><a href="#">###</a></li>
                    </ul>
                </aside>
                <div id="contenutouser">
                    <h1>Benvenuto nella pagina Botell&oacute;n Users</h1>
                    <p>Sei in cerca di qualche articolo per il tuo botell&oacute;n?</p>
                    <p>Registrati subito o fai il login per acquistare i nostri prodotti e 
                    per approfittare delle nostre offerte</p>
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
        
        <script>
        // acquisizione form modale
            var modal = document.getElementById('lg');

        // la finestra si chiude cliccando da qualsiasi altra parte
            window.onclick = function(event) {
                if (event.target === modal) {
                    modal.style.display = "none";
                }
            };
        </script>
        
        <script>
        // acquisizione form modale
            var modal = document.getElementById('rg');

        // la finestra si chiude cliccando da qualsiasi altra parte
            window.onclick = function(event) {
                if (event.target === modal) {
                    modal.style.display = "none";
                }
            };
        </script>
    </body>
</html>
