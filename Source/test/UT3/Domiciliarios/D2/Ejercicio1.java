/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3.Domiciliarios.D2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yago
 */
public class Ejercicio1 {
    
    public Ejercicio1() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void Ejercicio1()
    {
        IArbolBB arbol = new TArbolBB();
       String[] claves = GenericFileManager.readFile("../Claves.txt");
        for(String clave : claves)
        {
            IElementoAB elemento = new TElementoAB(clave,clave);
            arbol.insertar(elemento);
        }
    }

}
