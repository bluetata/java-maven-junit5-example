package com.example.junit5.test.assumptions;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * JUnit 5 中的假定条件（assumptions）类似于断言，不同之处在于不满足的断言会使得测试方法失败，
 * 而不满足的假定条件只会使得测试方法的执行终止。假定条件可以看成是测试方法执行的前提，当该前提不满足时，
 * 就没有继续执行的必要。在下列例子中 assumeTrue 和 assumFalse 确保给定的条件为 true 或 false，
 * 不满足条件会使得测试执行终止。assumingThat 的参数是表示条件的布尔值和对应的 Executable 接口的实现对象。
 * 只有条件满足时，Executable 对象才会被执行；当条件不满足时，测试执行并不会终止。
 *
 * @author bluetata / Sekito.Lv@gmail.com</br>
 * @version java-maven-junit5-example version(1.0)</br>
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