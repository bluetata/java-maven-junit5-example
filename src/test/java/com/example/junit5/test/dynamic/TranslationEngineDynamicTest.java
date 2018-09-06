package com.example.junit5.test.dynamic;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 使用Junit 5 dynamic test 进行动态测试
 * @author bluetata / Sekito.Lv@gmail.com</br>
 * @version java-maven-junit5-example version(1.0)</br>
 * @date 09/06/18 15:44</br>
 * @since JDK 1.8</br>
 */
public class TranslationEngineDynamicTest {

    private TranslatorEngine translatorEngine;

    @BeforeEach
    @DisplayName("Before run test case to init resource -> TranslatorEngine")
    public void init() {
        translatorEngine = new TranslatorEngine();
    }

    public void translateDynamicTestsRaw() {

        List<String> inPhrases = new ArrayList<>(Arrays.asList("Hello", "Yes", "No"));
        List<String> outPhrases = new ArrayList<>(Arrays.asList("你好", "是", "否"));
        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for (int i = 0; i < inPhrases.size(); i++) {

            String phr = inPhrases.get(i);
            String outPhr = outPhrases.get(i);

            // create an test execution
            Executable exec = () -> assertEquals(outPhr, translatorEngine.tranlate(phr));

            // create a test display name
            String testName = "Test tranlate " + phr;
            // create dynamic test
            DynamicTest dTest = DynamicTest.dynamicTest(testName, exec);

            // add the dynamic test to collection
            dynamicTests.add(dTest);
        }
    }

    //
    //

    /**
     * @TestFactory method must return a Stream, Collection, Iterable, or Iterator of DynamicTest instances
     * @TestFactory 方法强制限制返回实例为: Stream, Collection, Iterable, or Iterator of DynamicTest.
     *
     * @return Collection 集合
     */
    @Disabled
    // @TestFactory
    public Collection<DynamicTest> translateDynamicTests() {

        List<String> inPhrases =
                new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));
        List<String> outPhrases =
                new ArrayList<>(Arrays.asList("你好", "是", "否", "再见", "晚安", "谢谢"));

        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for (int i = 0; i < inPhrases.size(); i++) {

            String phr = inPhrases.get(i);
            String outPhr = outPhrases.get(i);

            // create an test execution
            Executable exec = () -> assertEquals(outPhr, translatorEngine.tranlate(phr));

            // create a test display name
            String testName = "Test tranlate " + phr;
            // create dynamic test
            DynamicTest dTest = DynamicTest.dynamicTest(testName, exec);

            // add the dynamic test to collection
            dynamicTests.add(dTest);
        }
        return dynamicTests;
    }

    // 返回 Stream 流
    // @Disabled
    @TestFactory
    public Stream<DynamicTest> translateDynamicTestsFromStream() {

        // set all test action to cover 100%
        List<String> inPhrases =
                new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you", "Other", " "));
        List<String> outPhrases =
                new ArrayList<>(Arrays.asList("你好", "是", "否", "再见", "晚安", "谢谢", "Not found", null));

        return inPhrases.stream().map(phrs -> DynamicTest.dynamicTest("Test translate " + phrs, () -> {
            int idx = inPhrases.indexOf(phrs);
            assertEquals(outPhrases.get(idx), translatorEngine.tranlate(phrs));
        }));
    }

    // 返回 Iterable 迭代器
    // @TestFactory
    public Iterable<DynamicTest> translateDynamicTestsFromIterate() {

        List<String> inPhrases =
                new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));
        List<String> outPhrases =
                new ArrayList<>(Arrays.asList("你好", "是", "否", "再见", "晚安", "谢谢"));

        return inPhrases.stream().map(phrs -> DynamicTest.dynamicTest("Test translate " + phrs, () -> {
            int idx = inPhrases.indexOf(phrs);
            assertEquals(outPhrases.get(idx), translatorEngine.tranlate(phrs));
        })).collect(Collectors.toList());
    }

    // 返回 Iterator 迭代器
    @Disabled
    // @TestFactory
    public Iterator<DynamicTest> translateDynamicTestsFromIterator() {

        List<String> inPhrases =
                new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));
        List<String> outPhrases =
                new ArrayList<>(Arrays.asList("你好", "是", "否", "再见", "晚安", "谢谢"));

        return inPhrases.stream().map(phrs -> DynamicTest.dynamicTest("Test translate " + phrs, () -> {
            int idx = inPhrases.indexOf(phrs);
            assertEquals(outPhrases.get(idx), translatorEngine.tranlate(phrs));
        })).iterator();
    }
}
