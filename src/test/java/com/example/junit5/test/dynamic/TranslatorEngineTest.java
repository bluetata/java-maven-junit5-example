package com.example.junit5.test.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 非动态测试示例, 需要对每个branch创建测试用例, 并进行测试
 * @author bluetata / Sekito.Lv@gmail.com</br>
 * @version java-maven-junit5-example version(1.0)</br>
 * @date 09/06/18 15:44</br>
 * @since JDK 1.8</br>
 */
class TranslatorEngineTest {

    private TranslatorEngine translatorEngine;
    @BeforeEach
    @DisplayName("Before run test case to init resource -> TranslatorEngine")
    void init() {
        translatorEngine = new TranslatorEngine();
    }

    @Test
    public void testTranlsateHello() {
        assertEquals("你好", translatorEngine.tranlate("Hello"));
    }

    @Test
    public void testTranlsateYes() {
        assertEquals("是", translatorEngine.tranlate("Yes"));
    }

    @Test
    public void testTranlsateNo() {
        assertEquals("否", translatorEngine.tranlate("No"));
    }

    //... other test case
}