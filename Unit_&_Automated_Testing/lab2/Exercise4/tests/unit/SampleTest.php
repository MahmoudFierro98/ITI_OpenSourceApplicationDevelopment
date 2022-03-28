/*
 * Unit & Automated Testing - Lab 2 Exercise 4
 * Author: Mahmoud Mohamed Kamal
 * Date:   28-03-1998
 * File:   SampleTest.php
 */
 
<?php    
class SampleTest extends PHPUnit\Framework\TestCase {
	private static $user;

        public static function setUpBeforeClass() : void{
                self::$user = new User('Mahmoud', 1234567890, 'mahmoud@email.com');
        }
	public function test_name(){
		$this->assertTrue(self::$user->getUsername()==='Mahmoud');
	}
	public function test_password(){
                $this->assertTrue(self::$user->getPassword()===1234567890);
        }
	public function test_email(){
                $this->assertTrue(self::$user->getEmail()==='mahmoud@email.com');
        }
	public function test_name_Kamal(){
                self::$user->setUsername('Kamal');
                $this->assertTrue(self::$user->getUsername()==='Kamal');
        }
	public function test_password_Kamal(){
                self::$user->setPassword(1234);
                $this->assertTrue(self::$user->getPassword()===1234);
        }
        public function test_email_Kamal(){
                self::$user->setEmail('kamal@email.com');
                $this->assertTrue(self::$user->getEmail()==='kamal@email.com');
        }
        public static function tearDownAfterClass() : void{
                self::$user->delete();
        }
}
?>
