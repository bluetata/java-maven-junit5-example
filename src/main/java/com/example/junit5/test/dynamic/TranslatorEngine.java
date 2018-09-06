package com.example.junit5.test.dynamic;

import org.junit.platform.commons.util.StringUtils;

/**
 * @author bluetata / Sekito.Lv@gmail.com</br>
 * @version java-maven-junit5-example version(1.0)</br>
 * @date 09/06/18 15:44</br>
 * @since JDK 1.8</br>
 */
public class TranslatorEngine {

    public String tranlate(String text) {
        if (StringUtils.isBlank(text)) {
            throw new IllegalArgumentException("Translated text must not be empty.");
        }
        if ("Hello".equalsIgnoreCase(text)) {
            return "你好";

        } else if ("Yes".equalsIgnoreCase(text)) {
            return "是";

        } else if ("No".equalsIgnoreCase(text)) {
            return "否";

        } else if ("Goodbye".equalsIgnoreCase(text)) {
            return "再见";

        } else if ("Good night".equalsIgnoreCase(text)) {
            return "晚安";

        } else if ("Thank you".equalsIgnoreCase(text)) {
            return "谢谢";
        } else {
            return "Not found";
        }
    }

}
