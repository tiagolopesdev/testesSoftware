package com.tiagodev.junitconcepts.TDD;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

    FizzBuzz fizzBuzz;

    @BeforeEach
    void setupBeforeEach() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    @DisplayName("Divisivel por 3")
    void testForDivisibleByThree() {
        String expected = "Fizz";
        Assertions.assertEquals(expected, fizzBuzz.divisibleThree(3), "Número divisivel por 3");
    }
}
