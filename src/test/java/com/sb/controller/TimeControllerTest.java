package com.sb.controller;

import com.sb.service.TimeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class TimeControllerTest {

    @Mock
    private TimeService timeService;

    private TimeController timeController;

    @Before
    public void setUp() {
        timeController = new TimeController(timeService);
    }

    @Test
    public void testConvertTime_Success() {
        when(timeService.convertTimeToWords("12:00")).thenReturn("twelve o'clock");
        String result = timeController.convertTime("12:00");
        verify(timeService).convertTimeToWords("12:00");
        assertEquals("twelve o'clock", result);
    }

    @Test
    public void testConvertTime_InvalidInput() {
        when(timeService.convertTimeToWords("invalid")).thenReturn(null);
        String result = timeController.convertTime("invalid");
        verify(timeService).convertTimeToWords("invalid");
        assertNull(result);
    }

    @Test
    public void testConvertTime_EmptyInput() {
        String result = timeController.convertTime("");
        assertNull(result);
    }
}

