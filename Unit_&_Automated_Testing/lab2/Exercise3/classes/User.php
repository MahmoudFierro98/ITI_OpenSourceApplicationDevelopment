/*
 * Unit & Automated Testing - Lab 2 Exercise 3
 * Author: Mahmoud Mohamed Kamal
 * Date:   28-03-1998
 * File:   User.php
 */

<?php
class User {
	private $username, $email;
	
	public function __construct($username, $email) {
		$this->username = $username;
		$this->email    = $email;
	}
	
	public function getName(){
    		return $this->username;
  	}
  	
  	public function getEmail(){
    		return $this->email;
  	}
  	
  	public function setName($n){
	   	$this->username = $n;
	}
	
	public function setEmail($e){
	    	$this->email = $e;
	}
	
	public function delete(){
		$this->username = NULL;
		$this->email    = NULL;
	}
}
?>
