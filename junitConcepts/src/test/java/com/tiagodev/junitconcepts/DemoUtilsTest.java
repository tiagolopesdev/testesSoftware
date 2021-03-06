/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tiagodev.junitconcepts;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("Test DemoUtils")
@TestMethodOrder(MethodOrderer.Random.class)
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
    }

    @Test
    @DisplayName("Multiply")
    void testMultiplay() {
        assertEquals(4, demoUtils.multiply(2, 2), "2*2 must be 4");
    }

    @Test
    @DisplayName("Timeout")
    //@Order(2)
    void testTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            demoUtils.checkTimeout();
        }, "Method should execute in 3 seconds.");
    }

    @Test
    @DisplayName("Throws and does not throws")
    //@Order(1)
    void testThrowsAndDoesNotThrow() {
        assertThrows(Exception.class, () -> {
            demoUtils.throwException(-1);
        }, "Should throw exception");
        assertDoesNotThrow(() -> {
            demoUtils.throwException(9);
        }, "Should not throw exception");
    }

    @Test
    @DisplayName("Equals and not equals")
    //@Order(-2)
    void testEqualsAndNotEquals() {
        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }

    @Test
    @DisplayName("Null and not null")
    //@Order(5)
    void testNullAndNotNull() {
        String strOne = null;
        String strTwo = "Tiago";
        assertNull(demoUtils.checkNull(strOne), "object should be null");
        assertNotNull(demoUtils.checkNull(strTwo), "object should not be null");
    }

    @Test
    @DisplayName("Same and not same")
    void testSameAndNotSame() {
        String str = "luv2code";
        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(),
                "Objects should refer to same object");
        assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer"
                + "to same object");
    }

    @Test
    @DisplayName("True and false")
    void testTrueFalse() {
        int a = 10;
        int b = 5;
        assertTrue(demoUtils.isGreater(a, b), "This should return true");
        assertNotNull(demoUtils.isGreater(b, a), "This should return true");
    }

    @Test
    @DisplayName("Array Equals")
    void testArrayEquals() {
        String[] stringValues = {"A", "B", "C"};
        assertArrayEquals(stringValues, demoUtils.getFirstThreeLettersOfAlphabet(),
                "Arrays should be the same");

    }

    @Test
    @DisplayName("Itarable equals")
    void testItarableEquals() {
        List<String> theList = List.of("luv", "2", "code");
        assertIterableEquals(theList, demoUtils.getAcademyInList(),
                "Expected list should be same as list");
    }

    @Test
    @DisplayName("Lines match")
    void testLinesMatch() {
        List<String> theList = List.of("luv", "2", "code");
        assertLinesMatch(theList, demoUtils.getAcademyInList(),
                "Lines should match");
    }
}
