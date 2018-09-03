package com.example.junit5.test.basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author bluetata / Sekito.Lv@gmail.com</br>
 * @version java-maven-junit5-example version(1.0)</br>
 * @date 09/03/18 11:12</br>
 * @since JDK 1.8</br>
 */
class HelloWorldTest {

    private HelloWorld helloWorld;
    @BeforeEach
    void init() {
        helloWorld = new HelloWorld();
    }

    @Test
    void sayHelloWorld() {
        assertEquals("Hello World", helloWorld.sayHelloWorld());
    }

    @AfterEach
    void tearDown() {
        helloWorld = null;
    }

}