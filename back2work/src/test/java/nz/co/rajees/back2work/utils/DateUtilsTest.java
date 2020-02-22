package nz.co.rajees.back2work.utils;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DateUtilsTest {

    @Test
    public void testConvertDateToLocalDateTime() {
        // arrange
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(2010, 10, 10, 8, 20, 4);
        calendar.add(Calendar.MILLISECOND, 127);
        Date dateToConvert = calendar.getTime();

        // act
        LocalDateTime localDateTime = DateUtils.convertDateToLocalDateTime(dateToConvert);

        // assert
        assertThat(localDateTime.get(ChronoField.YEAR), is(equalTo(2010)));
        assertThat(localDateTime.get(ChronoField.MONTH_OF_YEAR), is(equalTo(11)));
        assertThat(localDateTime.get(ChronoField.DAY_OF_MONTH), is(equalTo(10)));
        assertThat(localDateTime.get(ChronoField.HOUR_OF_DAY), is(equalTo(8)));
        assertThat(localDateTime.get(ChronoField.MINUTE_OF_HOUR), is(equalTo(20)));
        assertThat(localDateTime.get(ChronoField.SECOND_OF_MINUTE), is(equalTo(4)));
        assertThat(localDateTime.get(ChronoField.MILLI_OF_SECOND), is(equalTo(127)));

    }

    @Test
    public void testConvertLocalDateTimeToDate() {
        // arrange
        LocalDateTime dateToConvert = LocalDateTime.of(2010, 11, 10, 8, 20, 17, 822000000);

        // act
        Date date = DateUtils.convertLocalDateTimeToDate(dateToConvert);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // assert
        assertThat(calendar.get(Calendar.YEAR), is(equalTo(2010)));
        assertThat(calendar.get(Calendar.MONTH), is(equalTo(10)));
        assertThat(calendar.get(Calendar.DAY_OF_MONTH), is(equalTo(10)));
        assertThat(calendar.get(Calendar.HOUR), is(equalTo(8)));
        assertThat(calendar.get(Calendar.MINUTE), is(equalTo(20)));
        assertThat(calendar.get(Calendar.SECOND), is(equalTo(17)));
        assertThat(calendar.get(Calendar.MILLISECOND), is(equalTo(822)));
    }
}