package com.anurag.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GreetingsImplTest {
    Greetings greetings;
    @Before
    public  void setUp(){
       greetings=new GreetingsImpl();

    }
    @Test
    public void greetShouldReturnValidOutput(){

        String result=greetings.greet("Junit");
        assertNotNull(result);
        assertEquals("Hi Junit",result);

    }
    @Test(expected = IllegalArgumentException.class)
    public  void greetShouldThrowExceptionForNull(){
        greetings.greet(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public  void greetShouldThrowExceptionforBlank(){
        greetings.greet("");
    }
    @After
    public void tearUp(){
        greetings=null;
    }
}
