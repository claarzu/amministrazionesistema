<?php
session_start(); //avvio la sessione
$nomehost = "localhost";
$nomeuser = "root";
$password = "";
$dbname= "utenti";
$user_username=($_POST['uname']);
$user_password=($_POST['psw']);
if ($user_username=="" or $user_password=="") {
    die ("compila tutti i campi");
}
$connessione = mysql_connect($nomehost,$nomeuser,$password);

if($connessione==0){
    echo "coemmessione fallita";
}

$database_select=mysql_select_db($dbname,$connessione);

if($database_select==0){
    echo "selezione database non riuscita";
}
//si connette, sceglie il databse e adesso la tabella e controlla 1 x 1 tutti i valori dei campi

//se nel campo username "1" il valore è uguale a $user_username e nel campo password cè un valore uguale a $user_password allora count risulterà 1 e quindi si procede:
$sql= "SELECT *FROM utenti WHERE uname='$user_username' and password='$user_password'";
$result = mysql_query($sql);
if ($result == false) {
    echo "fallito";
} else {
    if ($ris==true) {
    echo "richiesta andata a buon fine";} 
}

$count=mysql_num_rows($result);
$_SESSION['uname'] = $user_username;
// e quindi registrerà la sessione d login e a quel punto in ogni pagina in cui metteremo session_start(); risulteremo loggati fino a quando non creeremo il
// session_destroy (); che distruggerà la sessione creata e quindi il logout:
if($count==1){
session_register("user_username");
session_register("user_password");
echo "Benvenuto $uname, hai effettuato il login con successo";
} else{
    echo "login non riuscito";
}
?>