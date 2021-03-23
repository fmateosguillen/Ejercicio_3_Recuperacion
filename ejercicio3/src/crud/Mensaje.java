package crud;

public class Mensaje {
    private int id;
    private String contacto;
    private String contenido;

    public Mensaje(int id, String contacto, String contenido) {
        this.id = id;
        this.contacto = contacto;
        this.contenido = contenido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String toString() {
        return "ID: "+this.id+"\nContacto: "+this.contacto+"\n Mensaje: "+this.contenido+"\n";
    }
}
