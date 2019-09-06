package com.mkacunha.sample;

public class App {

    public static void main(String[] args) {
        var numbers = new NumberService().findAll();
        numbers.forEachRemaining(number -> System.out.println(number.getValue()));
    }
}
