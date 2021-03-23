import crud.Mensaje;
import crud.WhatsApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args){
        List<Mensaje> listaMensajes = new ArrayList<>();
        Mensaje m1 = new Mensaje(0, "Pepe", "¡Hola Pepe!");
        Mensaje m2 = new Mensaje(1, "Manolo", "¡Hola Manolo!");
        Mensaje m3 = new Mensaje(2, "Juan", "¡Hola Juan!");

        listaMensajes.add(m1);
        listaMensajes.add(m2);
        listaMensajes.add(m3);

        WhatsApp whatsApp = new WhatsApp(listaMensajes);
        int respuesta = 0;
        int id = 3;
        Scanner sc = new Scanner(System.in);
        System.out.println("¡Bienvenido!");
        do{
            System.out.println("Seleccione una acción:");
            System.out.println("1. Añadir mensaje");
            System.out.println("2. Buscar un mensaje por contacto");
            System.out.println("3. Borrar un mensaje por su id");
            System.out.println("4. Mostrar listado de mensajes");
            System.out.println("5. Modificar un mensaje (Buscándolo por su ID)");
            System.out.println("6. Ordenar una lista alfabéticamente según el contacto");
            System.out.println("0. Salir");
            respuesta = Integer.parseInt(sc.nextLine());
            switch (respuesta){
                case 1:
                    System.out.println("Introduzca el nombre del contacto al que va dirigido el mensaje:");
                    String contacto1 = sc.nextLine();
                    System.out.println("Introduzca el cuerpo del mensaje:");
                    String mensaje1 = sc.nextLine();
                    whatsApp.agregarMensaje(new Mensaje(id, contacto1, mensaje1));
                    id = id+1;
                    break;

                case 2:
                    System.out.println("Introduzca el nombre del contacto:");
                    String contacto2 = sc.nextLine();
                    whatsApp.buscarMensajePorContacto(contacto2);
                    break;

                case 3:
                    System.out.println("Introduzca el ID del mensaje que desea eliminar");
                    int id1 = Integer.parseInt(sc.nextLine());
                    if(whatsApp.mensajeExiste(id1)){
                        whatsApp.borrarMensajePorId(id1);
                    }else{
                        System.out.println("El id proporcionado no corresponde a ningún mensaje de la lista\n");
                    }
                    whatsApp.borrarMensajePorId(id1);
                    break;

                case 4:
                    whatsApp.mostrarMensajes();
                    break;

                case 5:
                    System.out.println("Introduzca el ID del mensaje que quiere editar:");
                    int id2 = Integer.parseInt(sc.nextLine());
                    System.out.println("Introduzca el nuevo cuerpo del mensaje");
                    String mensaje2 = sc.nextLine();
                    whatsApp.modificarMensajePorId(id2, mensaje2);
                    break;

                case 6:
                    whatsApp.ordenarListaAlfabeticamentePorContacto();
                    break;

                case 0:
                    break;

                default: System.out.println("Seleccione una opción válida\n");
            }




        }while(respuesta!=0);
        System.out.println("Gracias por usar WhatsApp");
    }
}
