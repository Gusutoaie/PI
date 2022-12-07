<?php 
include 'inc/data.php';
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="../web/vizualizare/responsive.css">
    <script src="https://kit.fontawesome.com/016d9a1a71.js" crossorigin="anonymous"></script>
    <title>Document</title>
</head>
<body>

<div class="header">
        <div class="navbar">
           <div class="unu">
               <a href="index.php"><img src="img/resinLOGO.jpg" alt=""></a>
               <!-- <a class="t-responsive" href="#">&#9776;</a> -->
               <div class="responsive-unu">
               <a href="inc/cart.php"><button class="button-clasa-trei"><i class="fa-solid fa-cart-shopping"><span class="counter-button"><?php echo $_SESSION['counter'];?></span> </i></button></a></li>
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
                <li> <a href="inc/cart.php"><button class="button-clasa-trei">Cosul meu <i class="fa-solid fa-cart-shopping"><span class="counter-button"><?php echo $_SESSION['counter'];?></span> </i></button></a></li>
               <a href="inc/favorite.php"><li>Favorite <i class="fa-regular fa-heart"></i></li> </a> 
               <?php if(!empty($_SESSION['email'])): ?>
                <li><button class="button-clasa-trei" onclick="estiInregistrat()">Contul meu <i class="fa-solid fa-user"></i></button></li>
               <?php else: ?>
                <li><button class="button-clasa-trei" onclick="OpenModal()">Contul meu <i class="fa-solid fa-user"></i></button></li>
                <?php endif; ?>
            </ul>
        </div>     
    </div>
    <?php if(!empty($_SESSION['email'])):?>
    <div class="esti-inregistrat" id="esti-inregistrat">
        <div class="esti-inregistrat-1">
        <div onclick="inchideInregistrat()" class="CloseIcon">&#10006;</div>
        <a href="#">Informatii cont</a>
        <a href="#">Comenzi</a>
        <a href="#">Seziari si reclamatii</a>
        <a href="?delogare" >Iesi din cont</a>
        </div>
    </div>
    <?php else: ?>
    <div class="overlay" id="overlay">
      <div class="popup">
        <div onclick="CloseModal()" class="CloseIcon">&#10006;</div>
        <div class="container-inregistrare">
            <div class="inregistrare">
                 <a class="teasda" href="inregistrare.php">Inregistrare</a>
            </div>
            <?php include ('inc/errors.php') ?>
            <form action="" id="login-form" method="post">
             <label for="">Email</label>
             <input type="text" name="email"><br>
             <label for="">Parola</label>
             <input type="password" name="parola">
             <button  name="logare-btn" type="submit" id="logare-btn">Logare</button>
             <a class="a-ai-uitat" href="#"><p>Ai uitat parola?</p></a>
             </form>
        </div>
      </div>
    </div>
    <?php endif; ?>
    <div class="imagine-header">
        <div class="imagine-header-container">
            <div class="dropdown-imagine-header"> 
           <span class="imagine-header-produse"><i class="fa-solid fa-align-justify"></i>Produse</span>
           <ul class="imagine-header-ul">
                    <li><a href="category.php?data=semne">Semne de carte</a></li>
                    <li><a href="category.php?data=ursuleti">Ursuleti</a></li>
                    <li><a href="category.php?data=inimi">Inimi</a></li>
                    <li><a href="category.php?data=trandafiri">Trandafiri</a></li>
                    <li><a href="category.php?data=jucari">Jucari</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="left-side">
        </div>
        <div class="main-center">
    <?php
        if (isset($_GET["data"]))
        {
            $data = $_GET["data"];
        }
        $sql = "SELECT * FROM produse WHERE categorie='$data'";
        $rezultate = $conn->query($sql);
        if(! empty($rezultate))
        {
            foreach($rezultate as $value)
            {
           
    ?>
          <div class="product">
          <div class="produs-favorit">
              <h3>-32%</h3>
          </div>
              <form action="inc/add_cart.php" method="post">
              <ul class="ul-produs">
                <img src="img/<?php echo $value['imagine']; ?>" alt="">
              <li class="produs-descriere"><?php echo $value['descriere']; ?></li>
               <li class="produs-pret"><?php echo $value['pret']; ?> RON  <span class="reducere">75 RON</span></li>
               <input type='hidden' name='id' value="<?php echo $value['id']; ?>" />
               <button name="adauga-produs" type="submit" class="button-produs">Adauga in cos</button>
              </ul>
              </form>
          </div>
          <?php } } ?>
            </div>
            </div>
            <footer>
          <div class="footer-container">
              <div class="footer-meniu">
                  <ul>
                      <li><a href="#">Contactati-ne</a></li>
                      <li><a href="#">Despre noi</a></li>
                      <li><a href="#">Regulament</a></li>
                  </ul>
              </div>
          </div>
    </footer>
</body>
</html>