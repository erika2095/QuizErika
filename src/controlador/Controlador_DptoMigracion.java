
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Metodos;
import vista.FRM_DptoMigracion;

/**
 *
 * @author 3rika
 */
public class Controlador_DptoMigracion implements ActionListener{
    Metodos metodos;
    Metodos clientesAtendidos;
    FRM_DptoMigracion frm_dptoMigracion;
    
    public Controlador_DptoMigracion(FRM_DptoMigracion frm_dptoMigracion)      
    {
        metodos = new Metodos();
        clientesAtendidos = new Metodos();
        this.frm_dptoMigracion = frm_dptoMigracion;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Aceptar"))
        {
            Cliente cliente = new Cliente(frm_dptoMigracion.getCedula(), frm_dptoMigracion.getNombre(),Integer.parseInt(frm_dptoMigracion.getEdad().trim()),frm_dptoMigracion.getPrioridad(), frm_dptoMigracion.getCita());
            if(frm_dptoMigracion.getPrioridad().equalsIgnoreCase("normal"))
            {
                metodos.agregarCliente(cliente);
                frm_dptoMigracion.ResetGUI();
            }
            else
            {
                metodos.agregarPrimerCliente(cliente);
                frm_dptoMigracion.ResetGUI();
            }
        }
        
        if(e.getActionCommand().equals("Cancelar"))
        {
            metodos.eliminar(frm_dptoMigracion.devolverInf());
            frm_dptoMigracion.ResetGUI();
            JOptionPane.showMessageDialog(null, "Se ha eliminado la cita correctamente");
        }
        
        if(e.getActionCommand().equals("Modificar"))
        {
            metodos.modificar(frm_dptoMigracion.devolverInf());
            frm_dptoMigracion.ResetGUI();
            JOptionPane.showMessageDialog(null, "Se ha modificado la cita correctamente");
        }
        
        if(e.getActionCommand().equals("Reportes"))
        {
            JOptionPane.showMessageDialog(null, "Reporte Departamento de Migracion");
            
            String arreglo[] = new String[5];
            clientesAtendidos.ordenarMenorAMayor();
            frm_dptoMigracion.limpiarTabla();
            int promedio = 0;
            int cantPersonas = 0;
            int sumEdades = 0;
            
            for (int i = 0; i < clientesAtendidos.size(); i++)
            {
                arreglo[0] = clientesAtendidos.getCliente(i).getCedula();
                arreglo[1] = clientesAtendidos.getCliente(i).getNombre();
                arreglo[2] = clientesAtendidos.getCliente(i).getEdad()+"";
                arreglo[3] = clientesAtendidos.getCliente(i).getPrioridad();
                arreglo[4] = clientesAtendidos.getCliente(i).getCita();
                cantPersonas = cantPersonas + 1;
                sumEdades = sumEdades + Integer.parseInt(arreglo[2] = clientesAtendidos.getCliente(i).getEdad()+"");
                
                frm_dptoMigracion.colocarFilas(arreglo);
            }
            promedio = sumEdades / cantPersonas;
            frm_dptoMigracion.mostrarEnPantalla("\nPromedio "+promedio+"\nCantidad personas "+cantPersonas);
        }
        
        if(e.getActionCommand().equals("Atendiendo"))
        {
           if(metodos.size()>0)
           {
               frm_dptoMigracion.mostrarEnPantalla( metodos.devolverPrimero().getInformacion());
               clientesAtendidos.agregarCliente(metodos.devolverPrimero());
               metodos.eliminar();
           }
           else
           {
             frm_dptoMigracion.mostrarEnPantalla("No hay clientes en la fila");
           }
        }
        
        if(e.getActionCommand().equals("<"))
        {
            String arreglo[] = new String[5];
            clientesAtendidos.ordenarMenorAMayor();
            frm_dptoMigracion.limpiarTabla();
            for (int i = 0; i < clientesAtendidos.size(); i++)
            {
                arreglo[0] = clientesAtendidos.getCliente(i).getCedula();
                arreglo[1] = clientesAtendidos.getCliente(i).getNombre();
                arreglo[2] = clientesAtendidos.getCliente(i).getEdad()+"";
                arreglo[3] = clientesAtendidos.getCliente(i).getPrioridad();
                arreglo[4] = clientesAtendidos.getCliente(i).getCita();
                frm_dptoMigracion.colocarFilas(arreglo);
            }
        }
        
        if(e.getActionCommand().equals(">"))
        {
            String arreglo[] = new String[5];
            clientesAtendidos.ordenarMayorAMenor();
            frm_dptoMigracion.limpiarTabla();
            for (int i = 0; i < clientesAtendidos.size(); i++)
            {
                arreglo[0] = clientesAtendidos.getCliente(i).getCedula();
                arreglo[1] = clientesAtendidos.getCliente(i).getNombre();
                arreglo[2] = clientesAtendidos.getCliente(i).getEdad()+"";
                arreglo[3] = clientesAtendidos.getCliente(i).getPrioridad();
                arreglo[4] = clientesAtendidos.getCliente(i).getCita();
                frm_dptoMigracion.colocarFilas(arreglo);
            }    
        }
    }
}
