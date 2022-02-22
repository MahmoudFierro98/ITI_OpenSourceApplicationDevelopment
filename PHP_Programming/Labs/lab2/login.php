<!--
    Lab 2 - Bonus
	Author: Mahmoud Mohamed Kamal
	Date:   22-01-2022
    File: login.php
-->

<html>
<title>Main Menu</title>

<body>
    <?php
    $USER = $_POST["username"];
    $PASS = $_POST["password"];
    if ($USER == "mahmoud" && $PASS == "password") {
        echo "$USER is authenticated";
    } else {
        echo "$USER is access denied";
    }
    ?>
    <br>
    <a href="login.html">Back to login</a>
</body>

</html>