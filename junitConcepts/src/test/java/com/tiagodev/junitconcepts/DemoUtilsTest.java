/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tiagodev.junitconcepts;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author tiagolopes
 */
class DemoUtilsTest {
    
    DemoUtils demoUtils;
    
    @BeforeEach
    void setupBeforeEach(){
        demoUtils = new DemoUtils();
        System.out.println("Executes before the execution of each test method");
    }
    
    @AfterEach
    void setupAfterEach(){
        System.out.println("Execute after each method");
    }
    
    @Test
    void testEqualsAndNotEquals(){                        
        System.out.println("Method equalsAndNotEquals");
        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }
    @Test
    void testNullAndNotNull(){               
        System.out.println("Method nullAndNotNull");
        String strOne = null;
        String strTwo = "Tiago";        
        assertNull(demoUtils.checkNull(strOne), "object should be null");
        assertNotNull(demoUtils.checkNull(strTwo), "object should not be null");
    }
    
}
