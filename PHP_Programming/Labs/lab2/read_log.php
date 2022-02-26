<!--
	Lab 2
	Author: Mahmoud Mohamed Kamal
	Date:   22-02-2022
	File:   read_log.php
-->

<?php
session_start();
if (!isset($_SESSION["is_visited"])) {
    echo "First Visit, Hello!";
    $_SESSION["is_visited"] = true;
} else {
    $_SESSION["counter"] = isset($_SESSION["counter"]) ? $_SESSION["counter"] + 1 : 2;
    echo "you visited this page " . $_SESSION["counter"] . " times";
}
echo "<br />";
if (file_exists("log.txt")) {
    $imported_content = file("log.txt");
    echo "<br/>";
    foreach ($imported_content as $ic) {
        $data = explode(",", $ic);
        echo "Visit Date: " . $data[0];
        echo "<br />IP Address: " . $data[1];
        echo "<br />Email: " . $data[2];
        echo "<br />Name: " . $data[3];
        echo "<hr />";
    }
}
