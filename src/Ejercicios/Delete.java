
package Ejercicios;

import java.sql.SQLException;
import java.util.Scanner;
 
// Morena Guadalupe Peña Flores
public class Delete {
    
    Delete() throws SQLException {
        Scanner leer = new Scanner(System.in);
        ConexionCRUD utilerias = new ConexionCRUD();
        System.out.println("<< ELIMINAR REGISTRO >> ");
        
        System.out.println("Ingresar el id del registro: ");
        String idEstudianteEliminar = leer.next();
        
        String tabla = "tb_estudiante";
        String campos = "*";
        String condicion = "id_estudiante = " + idEstudianteEliminar;
        utilerias.desplegarRegistros(tabla, campos, condicion);
        
        System.out.println("Presionar << Y >> para confirmar");
        String confirmarBorrar = leer.next().toUpperCase();
        
        if ("Y". equals(confirmarBorrar)){
            
            String valoresCamposNuevos = "";
            
            utilerias.actualizarEliminarRegistro(tabla, valoresCamposNuevos, condicion);
            System.out.println("Registro borrado satisfactoriamente!");
        }
        
        MenuPrincipal.desplegarMenu();
        
    }
    
}
