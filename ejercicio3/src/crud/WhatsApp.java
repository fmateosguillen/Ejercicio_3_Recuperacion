package crud;

import java.rmi.server.RemoteRef;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class WhatsApp {
    private List<Mensaje> listaMensajes;

    public WhatsApp(List<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    public List<Mensaje> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(List<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    @Override
    public String toString() {
        return "WhatsApp{" +
                "listaMensajes=" + listaMensajes +
                '}';
    }

    public void agregarMensaje(Mensaje m){
        this.listaMensajes.add(m);
        System.out.println("Mensaje agregado a la lista correctamente\n");
    }

    public void buscarMensajePorContacto(String contacto){
        Iterator<Mensaje> it = listaMensajes.iterator();
        int contador = 0;
        while (it.hasNext()){
            Mensaje mensaje = it.next();
             if(mensaje.getContacto().toUpperCase().equals((contacto.toUpperCase()))){
                 System.out.println(mensaje.getContenido()+"\n");
             }else{
                 contador++;
             }

             if (contador == listaMensajes.size()){
                 System.out.println("No hay ningún mensaje para este contacto aún\n");
             }
        }
    }

    public void borrarMensajePorId(int id){
        boolean borrado = false;
        Iterator<Mensaje> it = listaMensajes.iterator();
        while (it.hasNext()){
            Mensaje mensaje = it.next();
            if(mensaje.getId() == id){
                it.remove();
                borrado = true;
                System.out.println("Mensaje eliminado correctamente de su lista de mensajes\n");
            }
        }
    }

    public boolean mensajeExiste(int id){
        boolean existe = false;
        Iterator<Mensaje> it = listaMensajes.iterator();
        while (it.hasNext()){
            Mensaje mensaje = it.next();
            if(mensaje.getId() == id){
                existe = true;
            }
        }
        return existe;
    }

    public void mostrarMensajes(){
        Iterator<Mensaje> it = listaMensajes.iterator();
        while (it.hasNext()){
            Mensaje mensaje = it.next();
            System.out.println(mensaje);
        }
    }

    public void modificarMensajePorId(int id, String contenido){
        Iterator<Mensaje> it = listaMensajes.iterator();
        while (it.hasNext()){
            Mensaje mensaje = it.next();
            if(mensaje.getId() == id){
                mensaje.setContenido(contenido);
                System.out.println("Contenido del mensaje modificado correctamente\n");
            }
        }
    }

    public void ordenarListaAlfabeticamentePorContacto(){
        listaMensajes.sort(new Comparator<Mensaje>() {
            @Override
            public int compare(Mensaje o1, Mensaje o2) {
                return o1.getContacto().compareTo(o2.getContacto());
            }
        });
        System.out.println("Lista ordenada correctamente\n");
    }
}
