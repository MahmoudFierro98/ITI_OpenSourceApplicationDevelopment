<!--
    Lab 2 - Assignment B
    Author: Mahmoud Mohamed Kamal
    Date:   21-03-2022
    File:   index.php
-->

<?php

session_start();

require_once("vendor/autoload.php");
// use Illuminate\Database\Capsule\Manager as dB;

$db = new MySQLHandler();
$db->connect();

// $db = new dB();
//         $db->addConnection([
//         "driver" => _driver_,
//         "host" => _host_,
//         "database" => _database_,
//         "username" => _username_,
//         "password" => _password_
//     ]);
//     $db->setAsGlobal();
//     $db->bootEloquent();

$api = new MyAPI($db);
