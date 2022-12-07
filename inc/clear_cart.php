<?php
	session_start();
	unset($_SESSION['produs']);
	$_SESSION['message'] = 'Cart cleared successfully';
	$_SESSION['counter'] = 0;
	header('location: ../index.php');
?>