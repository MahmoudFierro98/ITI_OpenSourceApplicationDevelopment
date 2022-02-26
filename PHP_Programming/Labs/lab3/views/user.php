<!--
    Lab 3 
    Author: Mahmoud Mohamed Kamal
    Date:   26-02-2022
    File:   user.php
-->

<?php
echo "<center>  User Profile Page   </center>";
//var_dump($my_user);

$counter = file("log.txt");
echo "<h2>Counted Unique Visitors:</h2>".$counter[0];