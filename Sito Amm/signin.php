<?php
$nomehost = "localhost";
$nomeuser = "root";
$password = "";
$dbname= "utenti";
$connessione = mysql_connect($nomehost,$nomeuser,$password);

//controllo della connessione al database
if($connessione==0){
    echo "connessione fallita";
}

//selezione del database
$database_select = mysql_select_db($dbname,$connessione);
//controllo se la selezione del database è riuscita
if($database_select==0){
    echo "selezione non riuscita";
}
//inserisco i dati provenienti dal form con il metodo POST
$nome = ($_POST['name']);
$cognome = ($_POST['sname']);
$indirizzo = ($_POST['address']);
$cap = ($_POST['cap']);
$citta = ($_POST['city']);
$mail = ($_POST['e-mail']);
$username = ($_POST['u_name']);
$p_word = ($_POST['psw']);
$c_psw = ($_POST['conferma_psw']);


    
//controllo che le password inserite coincidano   
if($p_word!=$c_psw){
    echo "ricontrolla i campi delle password";
} else {
    if ($nome == '' or $cognome == '' or $username == '' or $psw == '') {
        echo "tutti i campi sono obbligatori";
    } else { //inserisco i dati $dato nei campi della tabella
        $query = "INSERT INTO 'utenti' ('name', 'sname', 'address', 'cap', 'city', 'email', 'username', 'password', 'c_pass') "
                . "VALUES ('$nome', '$cognome', '$indirizzo', '$cap', '$citta', '$mail', '$username', '$p_word', '$c_psw')";
        $result=mysql_query($query,$connessione); 
        if($result==0) {
            die ("errore di registrazione");
        } else {
            header ('location: utenti.html');
        }
    }
}
?>
