/** 
	Lab 10
	Author: Mahmoud Mohamed Kamal
	Date:   1*-01-2022
*/

import java.util.Date;
import java.time.LocalDate;

class DateSucks
{
    public static void main(String args[]) 
    {
        Date date = new Date(12, 12, 12);
        System.out.println(date);
        LocalDate ld1 = LocalDate.ofYearDay(2017, 21);
        System.out.println(ld1);
        LocalDate ld2 = LocalDate.ofYearDay(2017, 90);
        System.out.println(ld2);
        LocalDate ld3 = LocalDate.ofEpochDay(1); 
        System.out.println(ld3);
        LocalDate ld4 = LocalDate.ofEpochDay(90);
        System.out.println(ld4);
    }
}