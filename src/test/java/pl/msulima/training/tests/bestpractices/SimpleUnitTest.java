package pl.msulima.training.tests.bestpractices;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertTrue;

public class SimpleUnitTest {

    private DateValidator validator = new DateValidator();

    // bad
    @Test
    public void testShouldWork() {
        assertTrue(validator.isValid(
                dateTime("2015-02-19 15:00"),
                dateTime("2015-02-20 15:00")));
    }

    // good
    @Test
    public void shouldBeValidWhenStartDateIsBeforeEndDate() {
        // given
        LocalDateTime startDate = dateTime("2015-02-19 15:00");
        LocalDateTime endDate = dateTime("2015-02-20 15:00");

        // when
        boolean result = validator.isValid(startDate, endDate);

        // then
        assertTrue(result);
    }

    public static LocalDateTime dateTime(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
