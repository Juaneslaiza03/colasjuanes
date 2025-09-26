import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class metodos {
    Queue<ObjSuper> cventas = new LinkedList<>();
    Scanner sc = new Scanner(System.in);

    public void principal() {

        metodos m = new metodos();
        int opt = 0;
        Queue<ObjSuper> cola = new LinkedList<>();
        boolean bandera = true;

        while (bandera) {
            System.out.println("-------------BIENVENIDOS-------------------");
            System.out.println("--------ESTE ES NUESTRO MENU---------------");
            System.out.println("1. Ingresar venta");
            System.out.println("2. Despachar venta");
            System.out.println("3. Mostrar pedidos pendientes");
            System.out.println("4. Mostrar Salidas");
            System.out.println("5. Cancelar pedido");
            System.out.println("6. Total vendido");
            System.out.println("7. Salir");
            System.out.println("----------------------------------------------");
            System.out.println("Por favor ingrese una opcion:");
            opt = m.ValidarEnteros(sc);
            sc.nextLine();

            if (opt < 1 || opt > 7) {
                System.out.println("Esta opcion no esta en el menu");
                continue;
            }
            switch (opt) {
                case 1:
                    cola.offer(m.IngresarVenta());
                    break;
                case 2:
                    cola = m.DespacharPedido(cola);
                    break;
                case 3:
                    m.MostrarPendientes(cola);
                    break;
                case 4:
                    m.TurnosAtendidos();
                    break;
                case 5:
                    cola = m.CancelarPedido(cola);
                    break;
                case 6:
                    m.TotalVendido();
                    break;

                default:
                    System.out.println("Hasta luego");
                    break;
            }
        }

    }

    public int ValidarEnteros(Scanner sc) {

        int numero = 0;
        while (!sc.hasNextInt()) {
            System.out.println("Por favor ingrese un numero del 1 al 6");
            sc.next();

        }
        numero = sc.nextInt();
        return numero;

    }

    public String ValidarNombre(Scanner sc) {
        String nombre = "";

        while (true) {
            System.out.println("----------NOMBRE-------------");
            System.out.println("Ingrese el nombre del cliente (solo letras): ");
            nombre = sc.nextLine();

            if (nombre.matches("[a-zA-Z]+")) { // Solo letras
                break; // es válido, salimos del ciclo
            } else {
                System.out.println(" Error: El nombre solo debe contener letras. Intente de nuevo.");

            }
        }
        return nombre;
    }

    public ObjSuper IngresarVenta() {
        Scanner sc = new Scanner(System.in);
        metodos m = new metodos();
        ObjSuper o = new ObjSuper();
       
             
        System.out.println("Ingrese Nombre Cliente");
        o.setNombreUsuario(ValidarNombre(sc));
        System.out.println("---------------MENU--------------");
        System.out.println("1. Verdura ");
        System.out.println("2. Grano");
        System.out.println("3. Carne");
        System.out.println("4. Leche");
        System.out.println("5. Fruta");
        System.out.println("----------------------------------");
        o.setTipo(m.ValidarEnteros(sc));
        System.out.println("Ingrese el precio");

        o.setPrecio(sc.nextDouble());

        return o;

    }

    public Queue<ObjSuper> DespacharPedido(Queue<ObjSuper> co) {
        System.out.println("El siguiente turno es para: " + co.peek().getNombreUsuario());
        cventas.offer(co.remove());
        return co;
    }

    public void MostrarPendientes(Queue<ObjSuper> co) {
        System.out.println("----------TURNOS PENDIENTES-------------");
        System.out.println(" ");
        for (ObjSuper o : co) {
            System.out.println("Nombre : " + o.getNombreUsuario());
            switch (o.getTipo()) {
                case 1:
                    System.out.println("Verdura");
                    break;
                case 2:
                    System.out.println("Grano");
                    break;
                case 3:
                    System.out.println("Carne");
                    break;
                case 4:
                    System.out.println("Leche");
                    break;

                default:
                    System.out.println("Fruta");
                    break;
            }
            System.out.println("Con un precio de: " + o.getPrecio());
            System.out.println("----------------------------------------");
        }
    }

    public void TurnosAtendidos() {
        System.out.println("----------TURNOS ATENDIDOS-------------");
        System.out.println(" ");
        for (ObjSuper o : cventas) {
            System.out.println("Nombre : " + o.getNombreUsuario());
            switch (o.getTipo()) {
                case 1:
                    System.out.println("Verdura");
                    break;
                case 2:
                    System.out.println("Grano");
                    break;
                case 3:
                    System.out.println("Carne");
                    break;
                case 4:
                    System.out.println("Leche");
                    break;

                default:
                    System.out.println("Fruta");
                    break;
            }
            System.out.println("Con un precio de: " + o.getPrecio());
            System.out.println("----------------------------------------");
        }
    }

   

    public void TotalVendido() {
        double suma = 0.0;
        for (ObjSuper o : cventas) { // Recorre solo los pedidos despachados
            suma += o.getPrecio();
        }
        System.out.println("==================================");
        System.out.println("   EL TOTAL VENDIDO ES: " + suma);
        System.out.println("==================================");
    }

    public Queue<ObjSuper> CancelarPedido(Queue<ObjSuper> co) {
        System.out.println("Ingrese el nombre del cliente a cancelar:");
        String nombre = sc.nextLine().toLowerCase();

        Queue<ObjSuper> aux = new LinkedList<>();
        boolean encontrado = false;

        for (ObjSuper o : co) {
            if (!o.getNombreUsuario().toLowerCase().equals(nombre)) {
                aux.offer(o); // lo dejamos en la cola si NO es el cancelado
            } else {
                encontrado = true; // encontramos el pedido a cancelar
                System.out.println("Pedido de " + o.getNombreUsuario() + " cancelado correctamente.");
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró un pedido con ese nombre.");
        }

        return aux; // devolvemos la nueva cola SIN el pedido cancelado
    }

   

}
