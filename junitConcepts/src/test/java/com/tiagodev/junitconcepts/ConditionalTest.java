/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiagodev.junitconcepts;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

/**
 *
 * @author tiago
 */
@DisplayName("Classe de teste condicional")
public class ConditionalTest {

    @Test
    @Disabled("Teste usando disable")
    @DisplayName("Metodo desabilitado")
    void testForDesable() {

    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    @DisplayName("Metodo somente para Windows")
    void testSystemWindows() {

    }

    @Test
    @EnabledOnOs(OS.LINUX)
    @DisplayName("Metodo somente para Linux")
    void testSystemLinux() {

    }

    @Test
    @EnabledOnOs({OS.WINDOWS, OS.MAC})
    @DisplayName("Metodo somente Windows e Mac")
    void testSystemWindowsAndMac() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    @DisplayName("Metodo somente para Java 11")
    void testOnlyForJava11() {

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_17)
    @DisplayName("Metodo min java_11 max java_17")
    void testOnlyForJavaRange() {

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_10)
    @DisplayName("Metodo java minimo java_10")
    void testOnlyForJavaRangeMin() {

    }
}
