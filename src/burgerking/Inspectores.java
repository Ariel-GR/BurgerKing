package burgerking;

/**
 *
 * @author Nicolas Guinzio & Ariel Risoluto.
 */
public class Inspectores extends Persona {

    public Inspectores(String user, String password) {
        setUser(user);
        setPassword(password);
    }

    @Override
    public boolean trabajar(Sistema sistema) {
        EntradaSalida.mostrarTexto("Bienvenido Inspector: " + getUser() + "\n");

        int op;

        while ((op = EntradaSalida.menuInspector()) != 0) {
            switch (op) {

                case 1:
                    EntradaSalida.limpiarPantalla();
                    EntradaSalida.mostrarTexto("\tlista ADMINITRADORES\n");
                    sistema.listaPorRoles("burgerking.Administrador");
                    EntradaSalida.mostrarTexto("\tlista GERENTES\n");
                    sistema.listaPorRoles("burgerking.Gerentes");
                    EntradaSalida.mostrarTexto("\tlista COCINEROS\n");
                    sistema.listaPorRoles("burgerking.Cocineros");
                    EntradaSalida.mostrarTexto("\tlista VENDEDORES\n");
                    sistema.listaPorRoles("burgerking.Vendedor");
                    EntradaSalida.mostrarTexto("\tlista INSPECTORES\n");
                    sistema.listaPorRoles("burgerking.Inspectores");
                    break;
                case 2:

                    sistema.obtenerListadoVentas();
                    break;
                case 3:
                    sistema.obtenerListadoPedidosCompletos();
                    if (EntradaSalida.siNo("Desea ver cada uno de los TICKETS? si/no")) {
                        sistema.consultarPedidos("COMPLETO");
                    }

                    break;

            }
        }

        return false;
    }

}
