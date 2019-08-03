package com.assignment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    public static LocalTime convertStringToTime(String s) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HHmm");
        return LocalTime.parse(s, dateTimeFormatter);
    }

    public static LocalDate convertStringToDate(String s) {
        return LocalDate.parse(s);
    }

    public static LocalTime convertStringToTimeForHHmmss(String s) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.parse(s, dateTimeFormatter);
    }

    public static LocalTime convertStringToTimeforHHmmWithColon(String s) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(s, dateTimeFormatter);
    }

    public static LocalDateTime convertTimeAndDateToDateTime(LocalDate date, LocalTime time) {
        return LocalDateTime.of(date, time);
    }

    /*public static long getDefaultEpoch(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }*/
}
