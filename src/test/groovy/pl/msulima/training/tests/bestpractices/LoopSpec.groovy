package pl.msulima.training.tests.bestpractices

import spock.lang.Specification

import static pl.msulima.training.tests.bestpractices.SimpleUnitTest.dateTime

class LoopSpec extends Specification {

    def validator = new DateValidator()

    def "be valid when any of dates is null"() {
        expect:
        validator.isValid(startDate, endDate)

        where:
        startDate                    | endDate
        null                         | null
        dateTime("2015-02-20 15:00") | null
        null                         | dateTime("2015-02-20 15:00")
    }
}
