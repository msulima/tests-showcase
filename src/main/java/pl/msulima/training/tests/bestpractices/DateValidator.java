package pl.msulima.training.tests.bestpractices;

import java.time.LocalDateTime;

public class DateValidator {

    public boolean isValid(LocalDateTime startDate, LocalDateTime endDate) {
        return (startDate == null) || (endDate == null) || startDate.isBefore(endDate);
    }
}
