<?php
session_start();
 include 'config.php';
    if(isset($_POST['nameform']))
    {
        $errors = []; 

        $numedefamilie = htmlspecialchars($_POST['numefamilie']);
        $prenume  = htmlspecialchars($_POST['prenume']);
        $email  = htmlspecialchars($_POST['email']);
        $parola  = htmlspecialchars($_POST['parola']);
        $repetareparola  = htmlspecialchars($_POST['rparola']);
        
        if (empty($numedefamilie)) { array_push($errors, "Numele este necesar!"); }
        if (empty($prenume)) { array_push($errors, "Prenumele este necesar!"); }
        if (empty($email)) { array_push($errors, "Email-ul este necesar!"); }
        if (empty($parola)) { array_push($errors, "Parola este necesara!"); }
        if ($parola != $repetareparola) {
          array_push($errors, "Parolele nu se potrivesc!"); }

        $verifica_utilizatori = "SELECT * FROM utilizatori WHERE email='$email' LIMIT 1";   
        $rezultat = mysqli_query($conn, $verifica_utilizatori);
        $utilizator = mysqli_fetch_assoc($rezultat);
        
        if($utilizator)
        {
            if($utilizator['email'] === $email)
            {
                array_push($errors, "Email-ul exista deja!");
            }
        }

        if(count($errors)==0)
        {
            $parola = md5($parola);
            $query = "INSERT INTO utilizatori (nume, prenume, email, parola) VALUES ('$numedefamilie', '$prenume', '$email', '$parola')";
            $conn->query($query);
            $_SESSION['email'] = $email;
            $_SESSION['succes'] = "Acum esti conectat cu succes!";
            header('location:index.php');
        }
    }
    $eroriLogin = array(); 
    if(isset($_POST['logare-btn']))
    {
        $email  = htmlspecialchars($_POST['email']);
        $parola  = htmlspecialchars($_POST['parola']);
        if(empty($email))
        {
            array_push($eroriLogin, "Email-ul este necesar");
        }
        if(empty($parola))
        {
            array_push($eroriLogin, "Parola este necesara");
        }
        if(empty($eroriLogin))
        {
            $parola = md5($parola);
            $query = "SELECT * FROM utilizatori WHERE email='$email' AND parola='$parola'";
            $rezultat = $conn->query($query);
            $randuri = $rezultat->num_rows;
            if($randuri > 0)
            {
                $_SESSION['email'] = $email;
            }
            else {
                array_push($eroriLogin, "Eroare la email sau parola");
            }
        }
    }
    //butonul de logout
    if(isset($_GET['delogare'])){
        unset($_SESSION['email']);
    }
    ?>