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

        List<String> result = listOfNumbers
                .stream()
                .map(numberString -> Integer.valueOf(numberString))
                .filter(number -> number % 2 == 0)
                .map(number -> number.toString())
                .collect(Collectors.toList());

        return result;
    }
}
