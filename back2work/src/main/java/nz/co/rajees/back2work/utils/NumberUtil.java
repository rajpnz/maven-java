package nz.co.rajees.back2work.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility to help with number crunching
 */
public class NumberUtil {

    /**
     * Extract a list of even numbers from a list of odd and even numbers
     * @param listOfNumbers
     * @return A list of even numbers only
     */
    public static List<String> extractEvenNumbers(List<String> listOfNumbers) {

        // use map. filter, collect strategy
        List<String> result = listOfNumbers
                .stream()
                .map(numberString -> Integer.valueOf(numberString))
                .filter(number -> number % 2 == 0)
                .map(number -> number.toString())
                .collect(Collectors.toList());

        return result;
    }

    /**
     * Find the sum of a list of numbers
     */
    public static int findSum(List<String> listOfNumbers) {

        // use map,  reduce strategy
        return listOfNumbers.stream()
                .mapToInt(number -> Integer.valueOf(number))
                .sum();
//                .reduce(0, Integer::sum);
//                .reduce(0, (x,y) -> x+y);
    }
}
