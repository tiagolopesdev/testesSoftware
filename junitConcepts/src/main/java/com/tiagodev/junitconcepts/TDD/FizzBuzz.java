/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiagodev.junitconcepts.TDD;

/**
 *
 * @author tiago
 */
public class FizzBuzz {

    public static String divisible(int i) {
        StringBuilder builder = new StringBuilder();
        if (i % 3 == 0) {
            builder.append("Fizz");
        }
        if (i % 5 == 0) {
            builder.append("Buzz");
        }
        if (builder.length() == 0) {
            builder.append(i);
        }
        return builder.toString();
    }

}
