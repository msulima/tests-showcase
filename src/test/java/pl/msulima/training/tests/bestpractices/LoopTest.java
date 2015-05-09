package pl.msulima.training.tests.bestpractices;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertTrue;
import static pl.msulima.training.tests.bestpractices.SimpleUnitTest.dateTime;

@RunWith(JUnitParamsRunner.class)
public class LoopTest {

    private DateValidator validator = new DateValidator();

    @Test
    public void shouldBeValidWhenStartDateIsBeforeEndDate() {
        // given
        LocalDateTime endDate = dateTime("2015-02-20 15:00");
        for (int i = 16; i <= 19; i++) {
            LocalDateTime startDate = dateTime("2015-02-" + i + " 15:00");

            // when
            boolean result = validator.isValid(startDate, endDate);

            // then
            assertTrue(result);
        }
    }

    @Test
    @Parameters(method = "nullDates")
    public void shouldBeValidWhenAnyDateIsNull(LocalDateTime startDate, LocalDateTime endDate) {
        // when
        boolean result = validator.isValid(startDate, endDate);

        // then
        assertTrue(result);
    }

    private Object nullDates() {
        return $($(null, dateTime("2015-02-19 15:00")),
                $(dateTime("2015-02-19 15:00"), null),
                $(null, null));
    }
}
