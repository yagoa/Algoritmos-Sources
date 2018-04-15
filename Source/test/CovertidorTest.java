/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import UT2.Convertidor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yago
 */
public class CovertidorTest {
    
    @Test
    public void EsPalabra() {
        Convertidor c = new Convertidor();
        Assert.assertTrue(c.invertir("ABC").equals("CBA"));

    }

    @Test
    public void PalabraNull() {
        Convertidor c = new Convertidor();
        Assert.assertTrue(c.invertir(null).equals(""));
    }

    @Test
    public void PalabrVacia() {
        Convertidor c = new Convertidor();
        Assert.assertTrue(c.invertir("").equals(""));
    }

    @Test
    public void EsMayuscula() {
        Convertidor c = new Convertidor();
        Assert.assertTrue(c.convertir("abcd").equals("2223"));
    }
    
}
