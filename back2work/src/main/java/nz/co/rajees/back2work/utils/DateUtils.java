package nz.co.rajees.back2work.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Utility for converting between {@link Date} and {@link java.time.LocalDate} or {@link LocalDateTime}
 *
 * @see @see <a href="https://www.baeldung.com/java-date-to-localdate-and-localdatetime">Baeldung Dates</a>
 * @see @see <a href="https://github.com/eugenp/tutorials/tree/master/core-java-modules/core-java-datetime-conversion">
 *     Baeldung Dates. GitHub source code</a>
 */
public class DateUtils {

    private DateUtils() {
        // utils class that will never be instantiated
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime = convertDateToLocalDateTime(new Date());
        //LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(localDateTime));
        System.out.println(localDateTime);
    }

    public static LocalDateTime convertDateToLocalDateTime(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static Date convertLocalDateTimeToDate(LocalDateTime dateToConvert) {
        Instant instant = dateToConvert.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }
}
