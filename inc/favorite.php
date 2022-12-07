<?php 
include 'data.php';
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/web/vizualizare/cart.css">
    <link rel="stylesheet" href="/web/vizualizare/responsive.css">
    <script src="https://kit.fontawesome.com/016d9a1a71.js" crossorigin="anonymous"></script>
    <title>Cosul meu</title>
</head>
<body>
    <div class="header">
        <div class="navbar">
            <div class="unu">
            <a href="../index.php"><img src="../img/resinLOGO.jpg" alt=""></a>
               <!-- <a class="t-responsive" href="#">&#9776;</a> -->
               <div class="responsive-unu">
               <!-- <a href="inc/cart.php"><button class="button-clasa-trei"><i class="fa-solid fa-cart-shopping"><span class="counter-button"><?php echo $_SESSION['counter'];?></span> </i></button></a></li> -->
               <a href="#"><i class="fa-regular fa-heart"></i> </a>
               <?php if(!empty($_SESSION['email'])): ?>
                <button class="button-clasa-trei" onclick="estiInregistrat()"><i class="fa-solid fa-user"></i></button>
               <?php else: ?>
                <button class="button-clasa-trei" onclick="OpenModal()"><i class="fa-solid fa-user"></i></button>
                <?php endif; ?>
            </div>
               </div>
            <div class="doi">
                <form class="test" action="" >
                    <div class="div-cautare">
                        <input type="text" placeholder="Cautare.." name="search">
                        <button class="button-cautare"type="submit">Cauta</button>
                    </div>
                </div>
            </form>
            <ul class="trei">
                <a href=""><li>Favorite <i class="fa-regular fa-heart"></i></li> </a> 
                <li><button class="button-clasa-trei" onclick="OpenModal()">Contul meu<i class="fa-solid fa-cart-shopping"></i></button></li>
            </ul>
        </div>     
    </div>
    <div class="overlay" id="overlay">
        <div class="popup">
            <div onclick="CloseModal()" class="CloseIcon">&#10006;</div>
            <div class="container-inregistrare">
                <form action="" method="post">
                    <label for="">Email</label>
                    <input type="text"><br>
                    <label for="">Parola</label>
                    <input type="text">
                    <button type="submit">Logare</button>
                    <a class="a-ai-uitat" href=""><p>Ai uitat parola?</p></a>
                </form>
            </div>
        </div>
    </div>
    <div class="imagine-header">
        <p>Ai nevoie de o oferta personalizata?</p>
        <p>Nu ezita sa ne contactezi prin wapp la 0773481931 sau prin E-mail</p>
    </div>
    