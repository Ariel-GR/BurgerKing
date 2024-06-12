/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burgerking;

import java.util.Scanner;

/**
 *
 * @author Ariel
 */
public class EntradaSalida {
    
    public static String leerString(String texto){
    
        Scanner scan = new Scanner(System.in);
        System.out.println(texto);
        String lectura = scan.nextLine();
        lectura = lectura.toLowerCase();
        
        return lectura; 
    }
    
    public static int leerNro(String texto){
    
        Scanner scan = new Scanner(System.in);
        System.out.println(texto);
        int nro = scan.nextInt();
        
        
        return nro; 
    } 
    
    public static boolean siNo(String texto){
        
        /*
        do{
            String i = leerString(texto);
        }while(("si") || !i.equals("no"));*/
        String i = leerString(texto);
        
        
        return i.equals("si");
    }
    
    public static void mostrarTexto(String texto){
        System.out.println(texto);
    }
}
