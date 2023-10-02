<?php
    if(isset($_POST['name'])){
    $server = "localhost";
    $username = "root";
    $password = "";

    $con=mysqli_connect($server,$username,$password);
    if(!$con){
        die("connection to this database failed due to".mysqli_connect_error());
    }
    $name=$_POST['name'];
    $phone=$_POST['phone'];
    $email=$_POST['email'];
    $text=$_POST['text'];
    $sql=" INSERT INTO `vijay`.`index` (`Name`, `Phone`, `email`, `des`) VALUES ('$name', '$phone', '$email', '$text');";
    if($con->query($sql)==true){
        //echo "successfully inserted";
    }
    else{
        echo "error:$sql<br> $con->error";
    }
    $con->close();
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="vijay.css">
    <title>iEducate-Transforming Online Education</title>
</head>
<body>
    <nav class="navbar background">
        <ul class="nav-list">
            <div class="logo"><img src="com.jpeg" alt="Logo"></div>
            <li><a href="#home">Home</a></li>
            <li><a href="services.html">Services</a></li>
            <li><a href="courses.html">Courses</a></li>
        </ul>
    </nav>
</section>
<section id="home">
    <section class="background firstsection">
        <div class="box-main">
            <div class="firsthalf">
                <p class="text-big">The future of education is here</p>
                <p class="text-small">The man who does not read books has no advantage over the one who cannot read them.” —Mark Twain
                </p>
            <div class="buttons">
                <a href="https://www.youtube.com/@Round2hell/featured"><button class="btn">subscribe</button></a>
                <a href="https://youtu.be/irDToH4YXzM?si=XHOHgNcru8EQ33JD"><button class="btn">watch video</button></a>
            </div>
        </div>
            <div class="secondhalf">
                <img src="mark.jpeg" alt="building img">
            </div>
        </div>
    </section>
</section>
    <footer>
        copyright &copy; 2027 - All Rights Reserved
    </footer>
</body>
</html>