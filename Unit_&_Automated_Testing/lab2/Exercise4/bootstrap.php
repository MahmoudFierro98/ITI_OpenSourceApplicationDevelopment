/*
 * Unit & Automated Testing - Lab 2 Exercise 4
 * Author: Mahmoud Mohamed Kamal
 * Date:   28-03-1998
 * File:   bootstrap.php
 */
 
<?php
// my app includes
spl_autoload_register(function($class) {
	@include_once(__DIR__ . "/classes/{$class}.php");
});
?>
