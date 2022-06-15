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
        Assertions.assertEquals(expected, fizzBuzz.divisible(3),
                "Número divisivel por 3");
    }

    @Test
    @DisplayName("Divisivel por 5")
    void testForDivisivelByFive() {
        String expected = "Buzz";
        Assertions.assertEquals(expected, fizzBuzz.divisible(5),
                "Número divisivel por 5");
    }

    @Test
    @DisplayName("Divisivel por 5 e 3")
    void testForDivisibleByThreeAndFive() {
        String expected = "FizzBuzz";
        Assertions.assertEquals(expected, fizzBuzz.divisible(15),
                "Número divisivel por 3 e 5");
    }

}
