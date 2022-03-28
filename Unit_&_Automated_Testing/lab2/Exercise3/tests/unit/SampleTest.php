/*
 * Unit & Automated Testing - Lab 2 Exercise 3
 * Author: Mahmoud Mohamed Kamal
 * Date:   28-03-1998
 * File:   SampleTest.php
 */
 
<?php    
class SampleTest extends PHPUnit\Framework\TestCase {
	private static $user;

        public static function setUpBeforeClass() : void{
                self::$user = new User('Mahmoud','mahmoud@email.com');
        }
	public function test_name(){
		$this->assertTrue(self::$user->getName()==='Mahmoud');
	}
	public function test_email(){
                $this->assertTrue(self::$user->getEmail()==='mahmoud@email.com');
        }
	public function test_name_Samy(){
                self::$user->setName('samy');
                $this->assertTrue(self::$user->getName()==='samy');
        }
        public function test_email_Samy(){
                self::$user->setEmail('samy@gmail.com');
                $this->assertTrue(self::$user->getEmail()==='samy@gmail.com');
        }
        public static function tearDownAfterClass() : void{
                self::$user->delete();
        }
}
?>
