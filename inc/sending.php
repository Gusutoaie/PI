<?php 
include 'data.php';
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="../vizualizare/sending.css">
    <link rel="stylesheet" href="../vizualizare/responsive.css">
    <script src="https://kit.fontawesome.com/016d9a1a71.js" crossorigin="anonymous"></script>
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
     
    <div class="sending-container">
    <div class="sending-second">
        <?php 
            if(empty($_SESSION['email'])):
        ?>
            <div class="sending-cont">
            <form action="" id="login-form" method="post">
             <label for="">Email</label>
             <input type="text" name="email"><br>
             <label for="">Parola</label>
             <input type="password" name="parola">  <br>
             <button  name="logare-btn" type="submit" id="logare-btn">Logare</button>
             <a class="a-ai-uitat" href="#"><p>Ai uitat parola?</p></a>
             </form>
            </div>
            <?php else:?>
                <label for="">Email</label>
                <input type="text" name="" id="" value="<?php echo $_SESSION['email']; ?>"disabled>  
            <?php endif;?>
            <form action="" method="post">
                <label for="">Nume de familie</label>
                <input type="text"> <br>
                <label for="">Prenume</label>
                <input type="text"> <br/>
                <label for="">Numar de telefon</label>
                <input type="text"> <br>
                <label for="">Adresa</label>
                <input type="text"> <br>
                <label for="">Judet</label>
                <input type="text"> <br>
                <label for="">Localitatea</label>
                <input type="text"> <br>
                <button type="submit" name="trimite-btn" id="trimite-btn">Trimite comanda</button>
            </form>
    </div>
    <?php 
        if(isset($_POST['trimite-btn'])){
            header('location: ../index.php?comanda-trimisa-cu-succes');
        }

    
    ?>
        <div class="sending-main">
        <?php 
            if(!empty($_SESSION['produs']))
            {

                $in = implode(',',$_SESSION['produs']);
                $extrage_produs = "SELECT * FROM produse WHERE id IN($in)";
                $result = mysqli_query($conn, $extrage_produs);
                while ($row = mysqli_fetch_assoc($result)) 
                {
                    ?>
        
        <div class="container-produse">
            <form action="" method="post"></form>
            <div class="cart-item item-img">
                <img src="../img/<?php echo $row['imagine'];?> " alt="">
            </div>
            <div class="cart-item item1">
                <?php echo $row['pret'] ;?> RON
            </div>
            <div class="cart-item item2">
                <p> <?php echo $row['descriere'];?> </p>
            </div>
            <input type='hidden' name='id' value="<?php echo $row['id']; ?>" />
        </form>
    </div>
    <?php 
        }} ?>
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
    <script src="../script.js"></script>
</body>
</html>