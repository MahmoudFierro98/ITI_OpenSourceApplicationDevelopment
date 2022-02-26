<!--
    Lab 3 
    Author: Mahmoud Mohamed Kamal
    Date:   26-02-2022
    File:   index.php
-->

<?php
session_start();

require_once("vendor/autoload.php");

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (Login::Authenticate($_POST["username"], $_POST["password"])) {
        $_SESSION["userid"] = 5;
        // header("Location: index.php?page=user");
        $page = "user";
    } else {
        $page = "login";
    }
} else {
    if (!Login::check_login()) {
        $page = "login";
    } else {
        $my_user = new User(correct_username, correct_password, correct_email);
        $pages = array("login", "user");
        $page = (isset($_GET["page"]) && in_array($_GET["page"], $pages)) ? $_GET["page"] : "login";
    }
}
require_once("views/$page.php");
