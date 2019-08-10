package nz.co.rajees.back2work.utils;

import com.google.common.collect.Lists;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class NumberUtilTest {

    @Test
    public void extractEvenNumbers() throws Exception {
        // arrange
        List<String> listOfIntegers = Lists.newArrayList("1", "2", "4", "7", "8");

        // act
        List<String> evenNumbers = NumberUtil.extractEvenNumbers(listOfIntegers);

        // assert
        assertThat(evenNumbers, containsInAnyOrder("2", "4", "8"));
    }

    @Test
    public void findSum() throws Exception {
        // arrange
        List<String> listOfIntegers = Lists.newArrayList("1", "2", "4", "7", "8");

        // act
        int sum = NumberUtil.findSum(listOfIntegers);

        // assert
        assertThat(sum, is(equalTo(22)));
    }
}