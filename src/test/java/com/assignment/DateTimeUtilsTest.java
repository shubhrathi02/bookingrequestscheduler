package com.assignment;

import junit.framework.TestCase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class DateTimeUtilsTest extends TestCase {

    public void testTimeConverter() {
        String s = "0930";
        LocalTime time = DateTimeUtils.convertStringToTime(s);
        assertThat(time.getHour(), is(equalTo(9)));
        assertThat(time.getMinute(), is(equalTo(30)));
    }

    public void testDateConverter() {
        String s = "2011-03-17";
        LocalDate date = DateTimeUtils.convertStringToDate(s);
        assertThat(date.getYear(), is(equalTo(2011)));
        assertThat(date.getMonthValue(), is(equalTo(3)));
        assertThat(date.getDayOfMonth(), is(equalTo(17)));
    }

    public void testTimeConverterForHHmmss() {
        String s = "17:10:50";
        LocalTime time = DateTimeUtils.convertStringToTimeForHHmmss(s);
        assertThat(time.getHour(), is(equalTo(17)));
        assertThat(time.getMinute(), is(equalTo(10)));
        assertThat(time.getSecond(), is(equalTo(50)));
    }

    public void testTimeConverterForHHMMWithColon() {
        String s = "17:10";
        LocalTime time = DateTimeUtils.convertStringToTimeforHHmmWithColon(s);
        assertThat(time.getHour(), is(equalTo(17)));
        assertThat(time.getMinute(), is(equalTo(10)));
    }

    public void testTimeAndDateToDateTimeConverter() {
        LocalTime time = DateTimeUtils.convertStringToTime("1710");
        LocalDate date = DateTimeUtils.convertStringToDate("2016-05-20");
        LocalDateTime dateTime = DateTimeUtils.convertTimeAndDateToDateTime(date, time);
        assertThat(dateTime.getYear(), is(equalTo(2016)));
        assertThat(dateTime.getMonthValue(), is(equalTo(5)));
        assertThat(dateTime.getDayOfMonth(), is(equalTo(20)));
        assertThat(dateTime.getHour(), is(equalTo(17)));
        assertThat(dateTime.getMinute(), is(equalTo(10)));
    }

    /*public void testGetDefaultEpochs() {
        LocalDateTime dateTime = LocalDateTime.of(2019, 8, 3, 12, 27, 18);
        long epochs = DateTimeUtils.getDefaultEpoch(dateTime);
        assertThat(epochs, is(equalTo(1564835238L)));
    }*/
}
