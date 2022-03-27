/*
 * Unit & Automated Testing - Lab 1
 * Author: Mahmoud Mohamed Kamal
 * Date:   27-03-1998
 * File:   SampleTest.php
 */
 
<?php

//include('../../factorial.php');
     
class SampleTest extends PHPUnit\Framework\TestCase {
	public function test_factorial_0_should_be_1() {
		$this->assertTrue(factorial(0)==1);
	}
	public function test_factorial_1_should_be_1() {
		$this->assertTrue(factorial(1)==1);
	}
	public function test_factorial_5_should_be_120() {
		$this->assertTrue(factorial(5)==120);
	}
	public function test_factorial_n() {
		$n = 5;
		$this->assertTrue(factorial($n)==($n*factorial($n-1)));
	}
	public function test_factorial_Neg_3_should_be_NULL() {
		$this->assertTrue(factorial(-3)==NULL);
	}
	public function test_factorial_1_DOT_5_should_be_NULL() {
		$this->assertTrue(factorial(1.5)==NULL);
	}
	public function test_factorial_false_should_be_NULL() {
		$this->assertTrue(factorial(false)==NULL);
	}
	public function test_factorial_abc_should_be_NULL() {
		$this->assertTrue(factorial("abc")==NULL);
	}
}
?>
