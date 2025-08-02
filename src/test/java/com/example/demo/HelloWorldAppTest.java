package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HelloWorldAppTest {

    @Test
    void testSayHello() {
        HelloWorldApp app = new HelloWorldApp();
        assertEquals("Hello VoIS!", app.sayHello());
    }
}
