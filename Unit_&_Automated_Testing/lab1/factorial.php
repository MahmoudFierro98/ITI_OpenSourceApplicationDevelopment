/*
 * Unit & Automated Testing - Lab 1
 * Author: Mahmoud Mohamed Kamal
 * Date:   27-03-1998
 * File:   factorial.php
 */

<?php
	function factorial($num)
	{
		$result;
		if((is_int($num)) && ($num >= 0)) {
			if(($num == 0) || ($num == 1))
				$result = 1;
			else
				$result = $num * factorial($num - 1);
			return $result;
		}
	}
?>
