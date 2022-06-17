/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiagodev.junitconcepts;

import com.tiagodev.junitconcepts.TDD.FizzBuzz;

/**
 *
 * @author tiago
 */
public class MainApp {
    
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(FizzBuzz.divisible(i));
        }
    }
}
