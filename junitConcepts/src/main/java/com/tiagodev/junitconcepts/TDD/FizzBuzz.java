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
        if (i % 3 == 0  && i % 5 == 0) {
            return "FizzBuzz";                        
        } else if (i % 5 == 0){
            return "Buzz";            
        } else if (i % 3 == 0){
            return "Fizz";
        }
        return null;
    }

}
