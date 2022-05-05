
package Ejercicios;

import java.sql.SQLException;
import java.util.Scanner;

//Gerardo Misael Monroy Moza

public class Update {
    Update() throws SQLException{
        Scanner leer = new Scanner(System.in);
        Estudiante est = new Estudiante();
        ConexionCRUD utilerias = new ConexionCRUD();
        System.out.println("<< ACTUALIZAR REGISTROS >>");
        
        System.out.println("Ingresar el id del estudiante a modificar: ");
        est.setIdEstudiante(leer.nextInt());
        
        String tablaBuscar = "tb_estudiante";
        String camposBuscar = "id_estudiante, carnet_estudiante, nom_estudiante, ape_estudiante, edad_estudiante";
        String condicionBuscar = "id_estudiante = " + est.getIdEstudiante();
        utilerias.desplegarRegistros(tablaBuscar, camposBuscar, condicionBuscar);
        
        System.out.println("Carnet del alumno: ");
        est.setCarnetEstudiante(leer.next());
        
        System.out.println("Nombre del alumno: ");
        est.setNombreEstudiante(leer.next());
        
        System.out.println("Apellidos del estudiante: ");
        est.setApellidoEstudiante(leer.next());
        
        System.out.println("Edad del estudiante: ");
        est.setEdadEstudiante(Integer.parseInt(leer.next()));
        
        String tabla = "tb_estudiante";
        String camposValoresNuevos = "carnet_estudiante = '" + est.getCarnetEstudiante() + "', nom_estudiante = '" + est.getNombreEstudiante() + "', ape_estudiante = '" + est.getApellidoEstudiante() + "', edad_estudiante = " + est.getEdadEstudiante();
        utilerias.actualizarEliminarRegistro(tabla, camposValoresNuevos, condicionBuscar);
        
        System.out.println("Modificado correctamente!");
        
        MenuPrincipal.desplegarMenu();
    }
}
