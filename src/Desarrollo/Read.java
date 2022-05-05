
package Desarrollo;

import java.sql.SQLException;

public class Read {
    public Read() throws SQLException{
        System.out.println("<< CONSULTA DE REGISTROS >>");
        mostrarResultados();
    }
    
    private void mostrarResultados() throws SQLException{
        try{
            ConexionCRUD utilerias = new ConexionCRUD();
            String tabla = "tb_contacto";
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
