package com.darsh.data;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        Greeting greeting = new Greeting();
        String hello = greeting.sayHello();
        String hi = greeting.sayHi();
        String thanks = greeting.sayThanks();
        String welcome = greeting.sayWelcome();
        System.out.println( hello );
        System.out.println( hi );
        System.out.println( thanks );
        System.out.println( welcome );
    }
}
