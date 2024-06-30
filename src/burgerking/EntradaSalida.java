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

    public static String leerString(String texto) {

        Scanner scan = new Scanner(System.in);
        System.out.println(texto);
        String lectura = scan.nextLine();
        lectura = lectura.toLowerCase();

        return lectura;
    }

    public static int leerNro(String texto) {

        Scanner scan = new Scanner(System.in);
        System.out.println(texto);
        int nro = scan.nextInt();

        return nro;
    }

    public static boolean siNo(String texto) {
        String i = leerString(texto);
        while (!i.equals("si") && !i.equals("no")) {
            i = leerString("***Por favor ingreses solo si o no***");
        }
        return i.equals("si");
    }

    public static void mostrarTexto(String texto) {
        System.out.println(texto);
    }

    public static int menuAlta() {

        return EntradaSalida.leerNro(
                "\nALTA DE NUEVO USUARIO\n"
                + "1 - Ingresar Vendedor\n"
                + "2 - Ingresar Cocinero\n"
                + "3 - Ingresar Gerente\n"
                + "4 - Ingresar Inpector\n"
                + "5 - Finalizar Carga");
    }

    public static int menuGerentes() {

        return EntradaSalida.leerNro(
                "\tSISTEMA PARA GERENETES\n"
                + "1 - consultar lista de VENDEDORES\n"
                + "2 - Consultar lista de COCINEROS\n"
                + "3 - Cambiar rol de usuario\n"
                + "4 - Dar de alta un Usuario\n"
                + "0 - Salir");
    }

    
    public static void limpiarPantalla() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
}
