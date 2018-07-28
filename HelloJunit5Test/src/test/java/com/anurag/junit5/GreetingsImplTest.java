package com.anurag.junit5;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//@RunWith(JUnitPlatform.class)
public class GreetingsImplTest {

    Greetings greetings;

    /**
     * Execute before Every Test just like junit 4 @Before
     * if you wat it it execute one use @BeforeAll
     */
    @BeforeEach
    public  void setUp(){
       greetings=new GreetingsImpl();

    }
    @Test
    public void greetShouldReturnValidOutput(){

        String result=greetings.greet("Junit");
        assertNotNull(result);
        assertEquals("Hi Junit",result);

    }
    @Test
    public  void greetShouldThrowExceptionForNull(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            greetings.greet(null);
        });
    }
    @Test
    public  void greetShouldThrowExceptionforBlank(){
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            greetings.greet("");
        });
    }
    /**
     * Execute after Every Test just like junit 4 @After
     * if you wat it it execute one use @AfterAll
     */
    @AfterEach
    public void tearUp(){
        greetings=null;
    }
}
