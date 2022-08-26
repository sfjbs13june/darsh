package com.darsh.data;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class GreetingTest {
    Greeting greeting;

    @Before
    public void setUp(){
        greeting = new Greeting();
    }

    @Test
    public void testHello(){
        String result = greeting.sayHello();
        assertEquals("hello",result);
    }

    @Test
    public void testHi(){
        String result = greeting.sayHi();
        assertEquals("hi",result);
    }

    @Test
    public void testThanks(){
        String result = greeting.sayThanks();
        assertEquals("thanks",result);
    }

    @Test
    public void testWelcome(){
        String result = greeting.sayWelcome();
        assertEquals("welcome",result);
    }
}
