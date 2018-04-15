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
public class WordCount {
    
    public static int Count(String a)
    {
        boolean word = true;
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if((word) && (Character.isLetter(a.charAt(i))))
            {
                count +=1;
                word = false;
            }
            else if (a.charAt(i) == ' '){
                word = true;
            }
        }
        return count;
    }
}
