
package modelo;

/**
 *
 * @author 3rika
 */
public class Nodo {
    Cliente dato;
    Nodo enlace;

    public Nodo(Cliente x) 
    {
        this.dato = x;
        enlace=null;
    }

    public Cliente getDato() 
    {
        return dato;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }


    public Nodo getEnlace() 
    {
        return enlace;
    }

    public void setEnlace(Nodo enlace) 
    {
        this.enlace = enlace;
    }
}
