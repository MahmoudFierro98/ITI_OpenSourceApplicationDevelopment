<!--
    Lab 2 - Assignment A
    Author: Mahmoud Mohamed Kamal
    Date:   21-03-2022
    File:   SMS_interface.php
-->

<?php
interface SMS_Interface {
    public function send_bulk($numbers=array());
    public function send($number);      
}


