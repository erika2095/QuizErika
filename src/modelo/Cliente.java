
package modelo;

/**
 *
 * @author 3rika
 */
public class Cliente {
    
    private String cedula;
    private String nombre;
    private int edad;
    private String cita;
    private String prioridad;
    private Cliente siguiente;

    public Cliente(String nombre, int edad, String prioridad, Cliente siguiente) {
        this.nombre = nombre;
        this.edad = edad;
        this.prioridad = prioridad;
        this.siguiente = siguiente;
    }
    
    
    public Cliente(String cedula, String nombre, int edad, String prioridad, String cita) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.prioridad = prioridad;
        this.cita = cita;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCita() {
        return cita;
    }

    public void setCita(String cita) {
        this.cita = cita;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Cliente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Cliente siguiente) {
        this.siguiente = siguiente;
    }
    
    public String getInformacion()
    {
        return "\nCedula: " +cedula+"\nNombre: "+nombre+"\nEdad: "+edad+"\nPrioridad: "+prioridad+"\nCita: "+cita;
    }
}
