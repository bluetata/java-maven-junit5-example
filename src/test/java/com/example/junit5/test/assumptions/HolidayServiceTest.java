package com.example.junit5.test.assumptions;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * @author bluetata / Sekito.Lv@gmail.com</br>
 * @version simulation-login version(1.0)</br>
 * @date 09/09/18 23:01</br>
 * @since JDK 1.8</br>
 */
class HolidayServiceTest {

    @Test
    void checkHolidayTimeZone() {

        TimeZone tzone = TimeZone.getDefault();
        // Assume that the timezone is China Standard Time
        assumeTrue(tzone.getDisplayName().equals("China Standard Time"));

        // Test IsToTravel method
        HolidayService holidayService = new HolidayService();
        assertTrue(holidayService.IsToTravel());
    }

    @Test
    void checkHolidayLocale() {
        // Assume that the current locale is CHINA
        Locale currentLocale = Locale.getDefault();
        assumeTrue(currentLocale.equals(Locale.CHINA));

        // Test IsToTravel method
        HolidayService holidayService = new HolidayService();
        assertTrue(holidayService.IsToTravel());
    }

    @Test
    public void checkWorkDay() {

        HolidayService holidayService = new HolidayService();
        assumeFalse(holidayService.checkHoliday());

        // Test doSchedule method
        assertTrue(holidayService.checkWorkDay());
    }
}