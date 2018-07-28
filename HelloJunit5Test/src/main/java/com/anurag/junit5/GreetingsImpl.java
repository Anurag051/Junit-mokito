package com.anurag.junit5;

public class GreetingsImpl implements Greetings {
    public String greet(String name) {
        if(name==null || name.length()==0){
           throw new IllegalArgumentException();
        }
        return "Hi "+name;
    }
}
