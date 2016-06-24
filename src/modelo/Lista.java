
package modelo;

/**
 *
 * @author 3rika
 */
public class Lista {
    
    protected Nodo primero, cola;
    Nodo nuevo;
    int tamano; 
    
    public Lista() 
    {
        this.primero = null;
        tamano=0; 
    }
    
    public void add(Cliente x)
    {
        nuevo=new Nodo(x);
        Nodo temporal=primero;
        
        if(temporal==null)
        {
            primero=nuevo;
            cola=nuevo;
        }
        else
        {
            cola.setEnlace(nuevo);
            cola=nuevo;
        }
        tamano++;   
    }
    
    public void visualizar()
    {
        Nodo n;
        int k=0;
        n=primero;
        
        while(n !=null)
        {
            System.out.println(n.dato+" ");
            n=n.enlace;
            k++;
            System.out.println((k % 15 != 0 ? " " : "\n" ));
        }
    }
    
    
    public int size()
    {
        return tamano;
    }

    
    public void remove(int posicion)
    {
        Nodo temporal=primero;
        for (int i = 0; i < tamano; i++) 
        {
            if (i==posicion-1)
            {
                temporal.setEnlace(temporal.getEnlace().getEnlace());
                temporal.getEnlace().setEnlace(null);
                tamano--;
                break;
            }
            else if(posicion==0)
            {
                primero=temporal.getEnlace();
                temporal.setEnlace(null);
                tamano--;
                break;
            }
            temporal=temporal.getEnlace();
        }
    }
    
    
    public Cliente get(int posicion)
    {
        Nodo temporal=primero;
        
        for (int i = 0; i < tamano; i++) 
        {
            if (i==posicion) 
                break;
            temporal=temporal.getEnlace();
        }
        return temporal.getDato();
    }
    
    public Nodo getNodo (int posicion)
    {
        Nodo temporal=primero;
        
        for (int i = 0; i < tamano; i++) 
        {
            if (i==posicion) 
                break;
            temporal=temporal.getEnlace();
        }
        return temporal;
    }
    
    
    public void addFirst(Cliente valor) 
    {
        Nodo temporal=primero;
        Nodo nuevoElemento=new Nodo(valor);
        
        if(tamano==0)
        {
            primero=nuevoElemento;
            cola = nuevoElemento;
        }
        else
        {
            nuevoElemento.setEnlace(primero);
            primero=nuevoElemento;
        }
         tamano++; 
    }
    
    public void set(int posicion, Nodo valor)
    {
        Nodo temporal = primero;
        for (int i = 0; i < tamano; i++) 
        {
            if (i==posicion)
            {
                if(posicion==0)
                {
                    valor.enlace = temporal.enlace;
                    primero = valor;
                    temporal.enlace = null;
                }
                else    
                {
                    valor.enlace = temporal.enlace;
                    Nodo aux = getNodo(i-1);
                    aux.enlace = valor;
                    temporal.enlace = null;
                }
                break;
            }
            temporal=temporal.getEnlace();
        }
    }
}