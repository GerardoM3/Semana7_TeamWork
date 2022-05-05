
package Ejercicios;

import java.sql.SQLException;

//Marjorie Beatriz Ramírez Morales

public class Read {
    public Read() throws SQLException{
        System.out.println("<< CONSULTA DE REGISTROS >>");
        mostrarResultado();
    }
    
    private void mostrarResultado() throws SQLException{
        try{
            ConexionCRUD utilerias = new ConexionCRUD();
            String tabla = "tb_estudiante";
            String camposTabla = "*";
            String condicionBusqueda = "";
            utilerias.desplegarRegistros(tabla, camposTabla, condicionBusqueda);
        }catch(SQLException ex){
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        }finally{
            MenuPrincipal.desplegarMenu();
        }
    }
}
