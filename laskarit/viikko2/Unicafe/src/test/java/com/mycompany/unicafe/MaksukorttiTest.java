package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;
    int alkusaldo = 100;

    @Before
    public void setUp() {
        kortti = new Maksukortti(alkusaldo);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinAlkusaldoOnOikein() {
        assertEquals(alkusaldo, kortti.saldo());
    }
    
    @Test
    public void saldonLatausToimii() {
        int lisays = 100;
        kortti.lataaRahaa(lisays);
        assertEquals(alkusaldo + lisays, kortti.saldo());
    }
    
    @Test
    public void saldonOttaminenRiittavallaMaaralla() {
        boolean tulos = kortti.otaRahaa(alkusaldo);
        assertEquals(true, tulos);
    }
    
    @Test
    public void saldonOttaminenRiittamattomallallaMaaralla() {
        kortti.otaRahaa(alkusaldo + 100);
        assertEquals(alkusaldo, kortti.saldo());
    }
    
    @Test
    public void toStringTesti() {
        assertEquals("saldo: 1.0", kortti.toString());
    }
}
