<?php 
session_start();
if(empty($_SESSION['produs'])){
    $_SESSION['produs'] = array();
    $numar=0;
}
array_push($_SESSION['produs'], $_POST['id']);
if(isset($_POST['adauga-produs'])) {
    ++$_SESSION['counter'];
}    
header('location: ./cart.php');

?>