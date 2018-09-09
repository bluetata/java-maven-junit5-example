package com.example.junit5.test.assertions;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

/**
 * * assertions method and description.
 *
 * +-- 1. Checks that two primitives/objects are equal. / 判断两个对象或两个原始类型是否相等
 * +-- void assertEquals(boolean expected, boolean actual)
 *
 * +-- 2. Checks that a condition is true.  / 判断给定的布尔值是否为 true
 * +-- void assertTrue(boolean condition)
 *
 * +-- 3. Checks that a condition is false. / 判断给定的布尔值是否为 false
 * +-- void assertFalse(boolean condition)
 *
 * +-- 4. Checks that an object isn't null. / 判断给定的对象引用是否不为 null
 * +-- void assertNotNull(Object object)
 *
 * +-- 5. Checks that an object is null. / 判断给定的对象引用是否为 null
 * +-- void assertNull(Object object)
 *
 * +-- 6. The assertSame() method tests if two object references point to the same object.
 *        判断两个对象引用是否指向同一个对象
 * +-- void assertSame(object1, object2)
 *
 * +-- 7. The assertNotSame() method tests if two object references do not point to the same object.
 *        判断两个对象引用是否指向不同的对象
 * +-- void assertNotSame(object1, object2)
 *
 * +-- 8. The assertArrayEquals() method will test whether two arrays are equal to each other.
 *        判断两个对象或原始类型的数组是否相等
 * +-- void assertArrayEquals(expectedArray, resultArray);
 *
 * @author bluetata / Sekito.Lv@gmail.com</br>
 * @version java-maven-junit5-example version(1.0)</br>
 * @date 09/07/18 11:44</br>
 * @since JDK 1.8</br>
 */
@RunWith(JUnitPlatform.class)
class StringUtilsTest {

    @Test
    public void testConvertToDoubleWithNullArgument() {
        // Test case with the age is null
        String age = null;
        Double actual = StringUtils.convertToDouble(age);

        assertNull(actual, "The actual is not null");
        // Java 8 Style
        assertNull(actual, () -> "The actual is not null");
    }

    @Test
    public void testConvertToDoubleThrowException() {
        // Test with the age is a non numeric string
        String age = "N/A";
        assertThrows(NumberFormatException.class, () -> {
            StringUtils.convertToDouble(age);
        });

        assertThrows(NumberFormatException.class, () -> {
            StringUtils.convertToDouble(age);
        });
    }

    @Test
    public void testIsNullOrBlank() {
        // Test the case that the input is NULL
        String input = null;

        assertTrue(StringUtils.isNullOrBlank(input));
        // Java 8 Lambdas Style
        assertTrue(StringUtils.isNullOrBlank(input), () -> "The string is not null or blank");

        // Test case with the input is empty
        input = " ";
        assertTrue(StringUtils.isNullOrBlank(input));

        // Test case with the input is not empty
        input = "abc";

        assertFalse(StringUtils.isNullOrBlank(input));

    }

    @Test
    public void testGetDefaultIfNull() {
        // Test case with input string is null
        String str = null;
        String defaultStr = "abc";

        String actual = StringUtils.getDefaultIfNull(str, defaultStr);
        assertSame(defaultStr, actual);
        // Java 8 Lambdas Style
        assertSame(defaultStr, actual, () -> "Expected ouput is not same with actual");

        // Test case with input string is not null
        str = "def";

        actual = StringUtils.getDefaultIfNull(str, defaultStr);
        assertNotSame(defaultStr, actual);
        // Java 8 Lambdas Style
        assertNotSame(defaultStr, actual, () -> "Expected ouput is same with actual");

        // Test case with input string is empty
        str = "";
        actual = StringUtils.getDefaultIfNull(str, defaultStr);
        if (actual.equals(defaultStr)) {
            fail("The actual should be empty");

            // Java 8 Lambdas Style
            fail(() -> "The actual should be empty");
        }
    }

    @Test
    public void testConcatWithRegularInput() {
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "!";
        String expect = str1 + str2 + str3;
        String actual = StringUtils.concat(str1, str2, str3);
        assertEquals(expect, actual);
    }

    @Test
    public void testConcatWithNullInput() {
        String str1 = "Hello";
        String str2 = "World";
        String str3 = null;
        String expect = str1 + str2;
        String actual = StringUtils.concat(str1, str2, str3);
        assertEquals(expect, actual);
    }
}