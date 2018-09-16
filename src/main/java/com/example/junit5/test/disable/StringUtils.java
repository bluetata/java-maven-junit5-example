package com.example.junit5.test.disable;

/**
 * @author bluetata / Sekito.Lv@gmail.com</br>
 * @version java-maven-junit5-example version(1.0)</br>
 * @date 09/06/18 15:44</br>
 * @since JDK 1.8</br>
 */
public final class StringUtils {

    public static boolean isNullOrBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String getDefaultIfNull(final String str, final String defaultStr) {
        return str == null ? defaultStr : str;
    }

    public static Double convertToDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static String concat(String... strs) {
        String retVal = null;
        if (strs != null && strs.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (String str : strs) {
                if (str != null) {
                    sb.append(str);
                }
            }
            retVal = sb.toString();
        }
        return retVal;
    }

}

