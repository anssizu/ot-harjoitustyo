/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anselmusheino
 */
public class KassapaateTest {
    
    private Kassapaate kp;
    
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kp = new Kassapaate();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void alkuarvotOikein() {
        assertEquals(100000, kp.kassassaRahaa());
        assertEquals(0, kp.edullisiaLounaitaMyyty());
        assertEquals(0, kp.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullisenKateisosoto() {
        
        // riittävä saldo
        int kateista = 1000;
        int hinta = 240;
        int kassassaAluksi = kp.kassassaRahaa();
        int vaihtoraha = kp.syoEdullisesti(kateista);
        assertEquals(kateista - hinta, vaihtoraha);
        assertEquals(1, kp.edullisiaLounaitaMyyty());
        assertEquals(kassassaAluksi + hinta, kp.kassassaRahaa());
        
        // riittämätön saldo
        kateista = 100;
        kassassaAluksi = kp.kassassaRahaa();
        vaihtoraha = kp.syoEdullisesti(kateista);
        assertEquals(kateista, vaihtoraha);
        assertEquals(1, kp.edullisiaLounaitaMyyty());
        assertEquals(kassassaAluksi, kp.kassassaRahaa());
    }
    
    @Test
    public void maukkaanKateisosoto() {
        
        // riittävä saldo
        int kateista = 1000;
        int hinta = 400;
        int kassassaAluksi = kp.kassassaRahaa();
        int vaihtoraha = kp.syoMaukkaasti(kateista);
        assertEquals(kateista - hinta, vaihtoraha);
        assertEquals(1, kp.maukkaitaLounaitaMyyty());
        assertEquals(kassassaAluksi + hinta, kp.kassassaRahaa());
        
        // riittämätön saldo
        kateista = 100;
        kassassaAluksi = kp.kassassaRahaa();
        vaihtoraha = kp.syoMaukkaasti(kateista);
        assertEquals(kateista, vaihtoraha);
        assertEquals(1, kp.maukkaitaLounaitaMyyty());
        assertEquals(kassassaAluksi, kp.kassassaRahaa());
    }
    
    @Test
    public void edullisenKorttiosto() {
        
        // riittävä saldo
        int alkusaldo = 1000;
        int lounaanHinta = 240;
        Maksukortti kortti = new Maksukortti(alkusaldo);
        kp.syoEdullisesti(kortti);
        assertEquals(alkusaldo - lounaanHinta, kortti.saldo());
        assertEquals(1, kp.edullisiaLounaitaMyyty());
        
        // riittämätön saldo
        alkusaldo = 100;
        kortti = new Maksukortti(alkusaldo);
        kp.syoEdullisesti(kortti);
        assertEquals(alkusaldo, kortti.saldo());
        assertEquals(1, kp.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukkaanKorttiosto() {
        
        // riittävä saldo
        int alkusaldo = 1000;
        int lounaanHinta = 400;
        Maksukortti kortti = new Maksukortti(alkusaldo);
        kp.syoMaukkaasti(kortti);
        assertEquals(alkusaldo - lounaanHinta, kortti.saldo());
        assertEquals(1, kp.maukkaitaLounaitaMyyty());
        
        // riittämätön saldo
        alkusaldo = 100;
        kortti = new Maksukortti(alkusaldo);
        kp.syoMaukkaasti(kortti);
        assertEquals(alkusaldo, kortti.saldo());
        assertEquals(1, kp.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kortinSaldolatausPositiivisella() {
        
        int kassassaAluksi = kp.kassassaRahaa();
        int saldolataus = 1000;
        Maksukortti kortti = new Maksukortti(0);
        kp.lataaRahaaKortille(kortti, saldolataus);
        assertEquals(saldolataus, kortti.saldo());
        assertEquals(kassassaAluksi + saldolataus, kp.kassassaRahaa());
    }
    
    @Test
    public void kortinSaldolatausNegatiivisella() {
        
        int kassassaAluksi = kp.kassassaRahaa();
        int saldolataus = -1000;
        Maksukortti kortti = new Maksukortti(0);
        kp.lataaRahaaKortille(kortti, saldolataus);
        assertEquals(0, kortti.saldo());
        assertEquals(kassassaAluksi, kp.kassassaRahaa());
    }
}
