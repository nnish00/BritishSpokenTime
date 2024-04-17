package com.sb.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class TimeServiceTest {

    private final TimeService timeService = new TimeService();

    @Test
    public void testConvertTimeToWords_Midnight() {
        String result = timeService.convertTimeToWords("00:00");
        assertEquals("midnight", result);
    }

    @Test
    public void testConvertTimeToWords_HalfPast() {
        String result = timeService.convertTimeToWords("12:30");
        assertEquals("half past twelve", result);
    }

    @Test
    public void testConvertTimeToWords_QuarterPast() {
        String result = timeService.convertTimeToWords("06:15");
        assertEquals("quarter past six", result);
    }

    @Test
    public void testConvertTimeToWords_QuarterTo() {
        String result = timeService.convertTimeToWords("18:45");
        assertEquals("quarter to seven", result);
    }

    @Test
    public void testConvertTimeToWords_OClock() {
        String result = timeService.convertTimeToWords("08:00");
        assertEquals("eight o'clock", result);
    }

    @Test
    public void testConvertTimeToWords_OtherTimes() {
        String result = timeService.convertTimeToWords("17:23");
        assertEquals("twenty three past five", result);
    }

    @Test
    public void testConvertTimeToWords_Noon() {
        String result = timeService.convertTimeToWords("12:00");
        assertEquals("noon", result);
    }

    @Test
    public void testConvertTimeToWords_MultipleHours() {
        String result = timeService.convertTimeToWords("23:45");
        assertEquals("quarter to twelve", result);
    }

    @Test
    public void testConvertTimeToWords_MultipleMins() {
        String result = timeService.convertTimeToWords("07:07");
        assertEquals("seven past seven", result);
    }

    @Test
    public void testConvertTimeToWords_OtherSpecialTimes() {
        String result = timeService.convertTimeToWords("03:15");
        assertEquals("quarter past three", result);
    }

    @Test
    public void testConvertTimeToWords_MinutesToTheHour() {
        String result = timeService.convertTimeToWords("09:58");
        assertEquals("two to ten", result);
    }

    @Test
    public void testConvertTimeToWords_MinutesPastTheHour() {
        String result = timeService.convertTimeToWords("14:31");
        assertEquals("twenty nine to three", result);
    }

    @Test(expected = NullPointerException.class)
    public void testConvertTimeToWords_NullInput() {
        timeService.convertTimeToWords(null);
    }

    @Test(expected = NumberFormatException.class)
    public void testConvertTimeToWords_InvalidInput() {
        timeService.convertTimeToWords("invalid");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertTimeToWords_EmptyInput() {
        timeService.convertTimeToWords("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertTimeToWords_InvalidTimeFormat() {
        timeService.convertTimeToWords("12-30");
    }

    @Test(expected = IllegalStateException.class)
    public void testConvertTimeToWords_OutOfBoundHour() {
        timeService.convertTimeToWords("25:00");
    }

    @Test(expected = IllegalStateException.class)
    public void testConvertTimeToWords_OutOfBoundMinute() {
        timeService.convertTimeToWords("12:60");
    }

}

