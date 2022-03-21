<!--
    Lab 1
    Author: Mahmoud Mohamed Kamal
    Date:   21-03-2022
    File:   Weather_Interface.php
-->

<?php
interface Weather_Interface {
    public function get_cities();
    public function get_weather($cityid);
    public function get_current_time();  
}