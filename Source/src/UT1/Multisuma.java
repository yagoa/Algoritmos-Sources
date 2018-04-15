/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT1;

/**
 *
 * @author yago
 */
public class Multisuma {
    
    double a;
    double b;
    double c;
    
    public Multisuma (double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
            
    public void multisumarlo(){
        System.out.println(a*b+c);       
    }
}
