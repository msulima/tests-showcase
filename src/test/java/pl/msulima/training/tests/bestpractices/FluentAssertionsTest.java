package pl.msulima.training.tests.bestpractices;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class FluentAssertionsTest {

    @Test
    public void showoff() {
        assertThat("Quality Excites").startsWith("Quality");
        assertThat("Quality Excites").containsIgnoringCase("excites");

        assertThat(Math.PI).isCloseTo(3.14, within(0.002));

        LocalDateTime qeDate =
                LocalDateTime.parse("2015-05-30T00:00:00");
        assertThat(qeDate).isAfter("1999-12-31T23:59:59");

        assertThat(qeDate).matches(date ->
                date.getDayOfWeek() == DayOfWeek.SATURDAY);
    }
}
