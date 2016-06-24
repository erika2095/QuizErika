
package modelo;

/**
 *
 * @author 3rika
 */
public class Metodos {
    
    Cliente cliente;
    Cliente primero = null;
    Lista array;
    int pos;
    
    public  Metodos()
    {
        array=new Lista();
    }
    
    public void agregarCliente(Cliente objeto)
    {
        array.add(objeto);
        System.out.println(objeto.getInformacion());
    }
    
    public void agregarPrimerCliente(Cliente x)
    {
        array.addFirst(x);
        System.out.println(x.getInformacion());
    }

    public Cliente devolverPrimero()
    {
        return array.get(0);
    }
    
    public void eliminar()
    {
        array.remove(pos);
    }
    
    public int size()
    {
       return array.size();
    }

   public void ordenarMayorAMenor()
    {
        int cantidadNodos=array.size();
        Cliente datoTemporal;
        Nodo auxiliar=array.primero;
        for(int contador=0;contador<cantidadNodos;contador++)
        {
            auxiliar=array.primero;
            while(auxiliar.enlace!=null)
            {
                if(auxiliar.dato.getEdad()<auxiliar.enlace.dato.getEdad())
                {
                    datoTemporal=auxiliar.dato;
                    auxiliar.dato=auxiliar.enlace.dato;
                    auxiliar.enlace.dato=datoTemporal;
                }
                auxiliar=auxiliar.enlace;
            }
        }
    }
    public void ordenarMenorAMayor()
    {
        int cantidadNodos=array.size();
        Cliente datoTemporal;
        Nodo auxiliar=array.primero;
        for(int contador=0;contador<cantidadNodos;contador++)
        {
            auxiliar=array.primero;
            while(auxiliar.enlace!=null)
            {
                if(auxiliar.dato.getEdad()>auxiliar.enlace.dato.getEdad())
                {
                    datoTemporal=auxiliar.dato;
                    auxiliar.dato=auxiliar.enlace.dato;
                    auxiliar.enlace.dato=datoTemporal;
                }
                auxiliar=auxiliar.enlace;
            }
        }
    }
    
    public String mostrarInformacion()
    {
        String texto="";
        Cliente aux=primero;
        
        while(aux!=null)
        {
            texto+=aux.getInformacion()+"\n";
            aux=aux.getSiguiente();
        }
        return texto;
    }
    
    public int getCantidadDeClientes()
    {
        Cliente aux=primero;
        int contador=0;
        while(aux!=null)
        {
            contador++;
            aux=aux.getSiguiente();
        }
        return contador;
    }
    
    public void modificar(Cliente datoModificar, Cliente datoNuevo)
    {
        Cliente auxiliar;
        auxiliar=buscarNodo(datoModificar);
        auxiliar=datoNuevo;
    }
    public void modificar(String arreglo[])
    {
        for(int contador=0;contador<array.size();contador++)
        {
            if(array.get(contador).getCedula().equals(arreglo[0]))
            {
                array.get(contador).setNombre(arreglo[1]);
                array.get(contador).setEdad(Integer.parseInt(arreglo[2]));
                array.get(contador).setCita(arreglo[3]);
            }
        }
    }
    public void eliminar(String arreglo[])
    {
        for(int contador=0;contador<array.size();contador++)
        {
            if(array.get(contador).getCedula().equals(arreglo[0]))
            {
                array.remove(contador);
            }
        }
    }
    public Cliente buscarNodo(Cliente datoModificar)
    {
        Cliente auxiliar=primero;
        while(auxiliar!=datoModificar)
        {
            auxiliar=auxiliar.getSiguiente();
        }
        return auxiliar;
    }
    public String mostrarCliente()
    {
        return cliente.getInformacion();
    }
    
     public Cliente getCliente(int posicion)
    {
        return array.get(posicion);
    }
}