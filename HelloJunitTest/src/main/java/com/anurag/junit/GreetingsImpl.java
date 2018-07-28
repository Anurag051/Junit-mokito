package com.anurag.junit;

public class GreetingsImpl implements Greetings {
    public String greet(String name) {
        if(name==null || name.length()==0){
           throw new IllegalArgumentException();
        }
        return "Hi "+name;
    }
}
