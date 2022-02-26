<!--
    Lab 3 
    Author: Mahmoud Mohamed Kamal
    Date:   26-02-2022
    File:   Login.php
-->

<?php

class Login
{
    static function check_login()
    {
        if (isset($_SESSION["userid"]) && is_numeric($_SESSION["userid"])) {
            return true;
        } elseif (isset($_COOKIE["remeber_me"]) && $_COOKIE["remeber_me"] == correct_token) {
            $_SESSION["userid"] = 5;
            return true;
        } else {
            return false;
        }
    }

    static function Authenticate($entered_username, $entered_password)
    {
        $remeber_me = true;
        if ($entered_username == correct_username && sha1($entered_password) == correct_password) {
            if ($remeber_me) {
                self::Remember($entered_username);
                $remeber_me = false;
            }
            return true;
        } else {
            return false;
        }
    }

    static function Remember($entered_username)
    {
        setcookie("remeber_me", "123456789abcdefghijklmnopqrst123456789jsjcnsavnsdnkamal", 0);
        if (!empty($_POST["rememberme"])) {
            setcookie("member_login", $entered_username, time() + (10 * 365 * 24 * 60 * 60));
        } else {
            if (isset($_COOKIE["member_login"])) {
                setcookie("member_login", "");
            }
        }
        if (!isset($_SESSION["is_visited"])) {
            $counter = file("log.txt");
            $counter = $counter[0] + 1;
            $fp = fopen("log.txt", "w+");
            fwrite($fp, $counter);
            fclose($fp);
            $_SESSION["is_visited"] = true;
        }
    }
}
