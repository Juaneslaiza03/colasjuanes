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
            System.out.println("5. Salir");
            System.out.println("----------------------------------------------");

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

    /*public String Validaretras(Scanner sc){
       String letra ="";
      
       while (!sc.hasNext()) {
        System.out.println("Por favor ingrese el nombre del pedido");
        sc.next();
       }
       letra=sc.nextLine();
       return letra;
    }*/

    public ObjSuper IngresarVenta(){
        Scanner sc = new Scanner(System.in);
        metodos m =new metodos();
        ObjSuper o = new ObjSuper();
        System.out.println("Ingrese Nombre Cliente");
        o.setNombreUsuario(sc.next());
    

        return null;
    }

}
