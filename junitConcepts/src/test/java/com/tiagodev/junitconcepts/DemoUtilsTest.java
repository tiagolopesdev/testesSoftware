/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tiagodev.junitconcepts;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

/**
 *
 * @author tiagolopes
 */
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();        
    }

//    @AfterEach
//    void setupAfterEach() {        
//    }

    @Test
    @DisplayName("Test equals and not equals")
    void testEqualsAndNotEquals() {        
        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }

    @Test
    @DisplayName("Test null and not null")
    void testNullAndNotNull() {        
        String strOne = null;
        String strTwo = "Tiago";
        assertNull(demoUtils.checkNull(strOne), "object should be null");
        assertNotNull(demoUtils.checkNull(strTwo), "object should not be null");
    }

}
