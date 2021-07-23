//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.example.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

public class LocalDateTimeUtils {
    public static final String DATE_TIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMATTER = "yyyy-MM-dd";
    public static final String TIME_FORMATTER = "HH:mm:ss";
    public static final String TIME_ZONE = "GMT+08:00";
    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public LocalDateTimeUtils() {
    }

    public static LocalDateTime convertDate(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static Date convertToDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDateTime parseDateTime(String str) {
        return LocalDateTime.parse(str, dateTimeFormatter);
    }

    public static LocalDate parseDate(String str) {
        return LocalDate.parse(str, dateFormatter);
    }

    public static LocalTime parseTime(String str) {
        return LocalTime.parse(str, timeFormatter);
    }

    public static Long getMilliByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static Long getSecondsByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    public static String formatTime(LocalDateTime time, String pattern) {
        if (time == null) {
            return null;
        } else {
            return StringUtils.isNullOrEmpty(pattern) ? time.format(dateTimeFormatter) : time.format(DateTimeFormatter.ofPattern(pattern));
        }
    }



    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time == null ? null : time.plus(number, field);
    }

    public static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field) {
        return time == null ? null : time.minus(number, field);
    }

    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) {
            return (long)period.getYears();
        } else {
            return field == ChronoUnit.MONTHS ? (long)period.getYears() * 12L + (long)period.getMonths() : field.between(startTime, endTime);
        }
    }

    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }

    public static LocalDateTime getDayEnd(LocalDateTime time) {
        return time.withHour(23).withMinute(59).withSecond(59).withNano(999999999);
    }

    public static LocalDateTime transLocalDateToLocalDateTimeMax(LocalDate localDate) {
        return localDate == null ? null : LocalDateTime.of(localDate, LocalTime.of(23, 59, 59));
    }

    public static LocalDateTime transLocalDateToLocalDateTimeMin(LocalDate localDate) {
        return localDate == null ? null : LocalDateTime.of(localDate, LocalTime.MIN);
    }
}
