package com.tiagodev.junitconcepts.TDD;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("FizzBuzz test")
public class FizzBuzzTest {

    FizzBuzz fizzBuzz;

    @BeforeEach
    void setupBeforeEach() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    @Order(1)
    @DisplayName("Divisivel por 3")
    void testForDivisibleByThree() {
        String expected = "Fizz";
        Assertions.assertEquals(expected, fizzBuzz.divisible(3),
                "Número divisivel por 3");
    }

    @Test
    @Order(2)
    @DisplayName("Divisivel por 5")
    void testForDivisivelByFive() {
        String expected = "Buzz";
        Assertions.assertEquals(expected, fizzBuzz.divisible(5),
                "Número divisivel por 5");
    }

    @Test
    @Order(3)
    @DisplayName("Divisivel por 5 e 3")
    void testForDivisibleByThreeAndFive() {
        String expected = "FizzBuzz";
        Assertions.assertEquals(expected, fizzBuzz.divisible(15),
                "Número divisivel por 3 e 5");
    }

    @Test
    @Order(4)
    @DisplayName("Not Divisible by three or five")
    void testNotDivisibleByThreeOrFive() {
        String expected = "1";
        Assertions.assertEquals(expected, fizzBuzz.divisible(1), "Return number");
    }
}
