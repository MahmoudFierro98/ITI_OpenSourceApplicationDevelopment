/** 
	Lab 10
	Author: Mahmoud Mohamed Kamal
	Date:   1*-01-2022
*/

import java.util.stream.IntStream;

public class IntStreamOperations
{
    public static void main(String[] args)
    {
        int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};
        // Display Orginal values 
        System.out.print("Original values: ");
        IntStream.of(values).forEach(value -> System.out.printf("%d ",value));
        System.out.println();
        // count, min, max, sum and average of the values
        System.out.printf("count: %d%n", IntStream.of(values).count());
        System.out.printf("min: %d%n", IntStream.of(values).min().getAsInt());
        System.out.printf("max: %d%n", IntStream.of(values).max().getAsInt());
        System.out.printf("sum: %d%n", IntStream.of(values).sum());
        System.out.printf("average: %.2f%n", IntStream.of(values).average().getAsDouble());
        // Odd values multiplied by 10 and displayed in sorted order 
        System.out.printf("Even values displayed in sorted order: ");
        IntStream.of(values).filter(value -> value % 2 != 0).map(value -> value * 10).sorted().forEach(value -> System.out.printf("%d ",value));
        // Odd values multiplied by 10 and displayed in sorted order 
        System.out.printf("Odd values multiplied by 10 displayes in sorted order: ");
        IntStream.of(values).filter(value -> value % 2 != 0).map(value -> value * 10).sorted().forEach(value -> System.out.printf("%d ",value));
        // sum ranges of integers from 1 to 10, exlusive
        System.out.printf("sum of integers from 1 to 9 :%d%n",IntStream.range(1,10).sum());
        // sum ranges of integers from 1 to 10, inclusive
        System.out.printf("sum of integers from 1 to 10 :%d%n",IntStream.rangeClosed(1,10).sum());
    }
}