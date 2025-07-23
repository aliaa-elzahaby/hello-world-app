package com.aliaa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HelloWorldAppTest {

    @Test
    public void testGreet() {
        HelloWorldApp app = new HelloWorldApp();
        String result = app.greet("Aliaa");
        assertEquals("Hello, Aliaa!", result);
    }
}
