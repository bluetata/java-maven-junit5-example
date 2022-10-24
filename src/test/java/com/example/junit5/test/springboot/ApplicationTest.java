package com.example.junit5.test.springboot;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author bluetata / Sekito.Lv@gmail.com</br>
 * @version java-maven-junit5-example version(1.0)</br>
 * @date 09/04/18 15:53</br>
 * @since JDK 1.8</br>
 */
@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Run Spring Boot Test Case")
    public void testGetControllerContent(){
        try {
            String message = this.restTemplate.getForObject("/junit5controller", String.class);
            assertEquals("JUnit5 and Spring Boot Example.", message);
        } catch (Exception ex) {
            ex.printStackTrace();
            Assertions.fail("Fail Run <testGetControllerContent>: ", ex);
        }
    }
}