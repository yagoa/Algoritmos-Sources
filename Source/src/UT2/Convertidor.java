/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2;

/**
 *
 * @author yago
 */
public class Convertidor {
    
    public String invertir (String s)
    {
        StringBuilder acumulador = new StringBuilder();
        if (s== null)
            return "";
        for (int i=s.length()-1;i>=0;i--)
        {
            acumulador.append(s.charAt(i));
        }   
        return acumulador.toString().toUpperCase();
    }
    
    public String convertir (String texto){
        texto = texto.toUpperCase();
        StringBuilder numeros = new StringBuilder();
        for (int i=0;i<= texto.length()-1;i++){
            char caracter = texto.charAt(i);
            switch(caracter)
            {
                case 'A':
                case 'B':
                case 'C':
                    numeros.append("2");
                    break;
                case 'D':
                case 'E':
                case 'F':
                    numeros.append("3");
                    break;
                case 'G':
                case 'H':
                case 'I':
                    numeros.append("4");
                    break;
                case 'J':
                case 'K':
                case 'L':
                    numeros.append("5");
                    break;
                case 'M':
                case 'N':
                case 'O':
                    numeros.append("6");
                    break;
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                    numeros.append("7");
                    break;
                case 'T':
                case 'U':
                case 'V':
                    numeros.append("8");
                    break;
                case '.':
                    numeros.append("1");
                    break;
                case ' ':
                    numeros.append("0");
                    break;
                default:
                    numeros.append("9");                                      
            }
            
        }
        return numeros.toString();
    }
}
