package com.tiagodev.junitconcepts.TDD;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
        Assertions.assertEquals(expected, fizzBuzz.divisible(1),
                "Return number");
    }

    @Order(5)
    @ParameterizedTest(name = "[{index}] @ValueSource: {arguments}")
    @ValueSource(ints = {1, 4, 8, 9})
    void testWithValueSource(int arguments) {
        assertTrue(arguments > 0 && arguments < 10);
    }

    @Order(6)
    @ParameterizedTest(name = "[{index}] @CsvSource: {arguments}")
    @CsvSource({
        "apple,         1",
        "banana,        2",
        "'lemon, lime', 8",
        "strawberry,    7"
    })
    void testWithCsvSource(String fruit, String rank) {
        Assertions.assertNotNull(fruit);
        Assertions.assertNotEquals(0, rank);
    }

    @Order(7)
    @ParameterizedTest(name = "[{0}] : expected: {1}")
    @CsvSource({
        "1,1",
        "2,2",
        "3,Fizz",
        "4,4",
        "5,Buzz",
        "6,Fizz",
        "7,7"
    })
    void testWithCsvSource(int value, String expected) {
        Assertions.assertEquals(expected, fizzBuzz.divisible(value));
    }

    @Order(9)
    @ParameterizedTest(name = "Small [{0}] : expected: {1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    void testSmallDataFile(int value, String expected){
        Assertions.assertEquals(expected, fizzBuzz.divisible(value));
    }
    
    @Order(10)
    @ParameterizedTest(name = "Medium [{0}] : expected: {1}")    
    @CsvFileSource(resources = "/medium-test-data.csv")
    void testMediumDataFile(int value, String expected){
        Assertions.assertEquals(expected, fizzBuzz.divisible(value));
    }
    
    @Order(11)
    @ParameterizedTest(name = "Large [{0}] : expected: {1}")
    @CsvFileSource(resources = "/large-test-data.csv")
    void testLargeDataFile(int value, String expected){
        Assertions.assertEquals(expected, fizzBuzz.divisible(value));
    }

}
