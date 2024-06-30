package burgerking;

import java.util.ArrayList;

/**
 *
 * @author Nicolas Guinzio & Ariel Risoluto.
 */
public class Cocineros extends Persona {

    public Cocineros(String user, String password) {
        setUser(user);
        setPassword(password);
    }

    @Override
    public boolean trabajar(Sistema sistema) {
        ArrayList<Pedido> pedidos = sistema.getPedidos();
        EntradaSalida.mostrarTexto("Bienvenido Cocinero: " + getUser() + "\n");
        Boolean sesion = true;

        do {
            int eleccion_cocinero = EntradaSalida.leerNro("CONSULTAR PEDIDOS: \n"
                    + "1_INCOMPLETOS\n"
                    + "2_COMPLETOS\n"
                    + "3_TODOS\n"
                    + "4_ACTUALIZAR PEDIDO\n"
                    + "5_CERRAR SESION\n");

            switch (eleccion_cocinero) {
                case 1:
                    sistema.consultarPedidos("INCOMPLETO");
                    break;
                case 2:
                    sistema.consultarPedidos("COMPLETOS");
                    break;
                case 3:
                    sistema.consultarPedidos("TODOS");
                    break;
                case 4:
                    //Aca pongo el algoritmo de actualizar pedido
                    break;
                case 5:
                    sesion = false;
                    break;
                default:
                    EntradaSalida.leerNro("CONSULTAR PEDIDOS: \n"
                    + "1_INCOMPLETOS\n"
                    + "2_COMPLETOS\n"
                    + "3_TODOS\n"
                    + "4_ACTUALIZAR PEDIDO\n"
                    + "5_CERRAR SESION\n");
            }
        } while (sesion);

        return false;
    }

}
