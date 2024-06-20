/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burgerking;

import java.util.Scanner;


/**
 * 
 * @author Nicolas Guinzio & Ariel Risoluto.
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
       String i = leerString(texto);
       while(!i.equals("si") && !i.equals("no")){
            i = leerString("***Por favor ingreses solo si o no***");
       }
        return i.equals("si");
    }
    
    public static void mostrarTexto(String texto){
        System.out.println(texto);
    }
        
}
