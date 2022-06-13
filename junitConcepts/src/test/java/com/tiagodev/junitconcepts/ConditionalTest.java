/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiagodev.junitconcepts;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

/**
 *
 * @author tiago
 */
public class ConditionalTest {

    @Test
    @Disabled("Teste usando disable")  
    void testForDesable() {

    }

    @Test
    @EnabledOnOs(OS.WINDOWS)    
    void testSystemWindows() {

    }

    @Test
    @EnabledOnOs(OS.LINUX)    
    void testSystemLinux() {

    }

    @Test
    @EnabledOnOs({OS.WINDOWS, OS.MAC})    
    void testSystemWindowsAndMac() {

    }

}
